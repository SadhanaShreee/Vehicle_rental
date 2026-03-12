package service;
import model.*;
import java.util.*;
public class VehicleRentalService {

    Map<Integer, Customer> customers = new HashMap<>();
    Map<Integer, Vehicle> vehicles = new HashMap<>();
    List<Booking> bookings = new ArrayList<>();
    public List<Booking> getBookings() {
        return bookings;
    }

    List<Payment> payments = new ArrayList<>();
// register customer so check if they already exist or not, if not then add to the system
    public void registerCustomer(Customer c){
        if(customers.containsKey(c.getC_id())){
            System.out.println("Customer already exists with ID: " + c.getC_id());
        } else {
            customers.put(c.getC_id(), c);
            System.out.println("Customer registered successfully with ID: " + c.getC_id());
        }
    }
//view customers so check if there are any customers registered or not, if not then ask to register, if yes then show the details of all the customers
    public void viewCustomers(){
        if(customers.isEmpty()){
            System.out.println("No customers registered....Go and register now!");
        }else{
            for(Customer c : customers.values()){
                System.out.println("Customer ID: "+ c.getC_id()+ " , Name: "+ c.getC_name() + " , Email: "+ c.getC_email() + " , Phone: "+ c.getC_phone() + " , License Number: "+ c.getLicensenum());
            }
        }
    }
    // add vehicles so check if they already exist or not, if not then add to the system
    public void addVehicles(Vehicle v){
        if(vehicles.containsKey(v.getV_id())){
            System.out.println("Vehicle already exists with ID: " + v.getV_id());
        } else {
            vehicles.put(v.getV_id(), v);
            System.out.println("Vehicle added successfully with ID: " + v.getV_id());
        }
    }
// view vehicles so check if there are any vehicles added or not, if not then ask to add, if yes then show the details of all the vehicles
    public void viewVehicles(){
        if(vehicles.isEmpty()){
            System.out.println("No vehicles available....Go and add some vehicles now!");
        }else{
            for(Vehicle v : vehicles.values()){
                System.out.println("Vehicle ID: "+ v.getV_id()+ " , Type: "+ v.getType() + " , Registration Number: "+ v.getRegistration_num() + " , Model: "+ v.getModel() + " , Brand: "+ v.getBrand() + " , Price per day: "+ v.getPrice_per_day() + " , Available: "+ v.isIs_available());
            }
        }
    }
// view available vehicles so check if there are any vehicles added or not, if not then ask to add, if yes then show the details of all the available vehicles
    public void viewAvailableVehicles(){

        boolean found = false; //initally false because we have not found any available vehicle yet

        for(Vehicle v : vehicles.values()){ //loop through all the vehicles in the system
            if(v.isIs_available()){ //check if the vehicle is available or not, if available then show the details of the vehicle
                System.out.println("Vehicle ID: "+ v.getV_id()+ " , Type: "+ v.getType() + " , Registration Number: "+ v.getRegistration_num() + " , Model: "+ v.getModel() + " , Brand: "+ v.getBrand() + " , Price per day: "+ v.getPrice_per_day());
                found = true; //if we found at least one available vehicle then we set found to true
            }
        }
        if(!found){
            System.out.println("No vehicles available at the moment....Please come back & check later!");
        } //if we did not find any available vehicle then we show the message that no vehicles are available at the moment
    }

    public void bookVehicles(Booking b){

        if(!customers.containsKey(b.getC_id())){
            System.out.println("Customer with ID: " + b.getC_id() + " does not exist. Please register the customer first.");
            return;
        }
        if(!vehicles.containsKey(b.getV_id())){
            System.out.println("Vehicle with ID: " + b.getV_id() + " does not exist. Please add the vehicle first.");
            return;
        }
        //auto generate booking id by gettung size of the list

        b.setB_id(bookings.size()+1);

//get vehicle for which we are gonna book
        Vehicle v = vehicles.get(b.getV_id());

        if(!v.isIs_available()){ //if not available then cannot book the vehicle and show the message that vehicle is not available for booking
            System.out.println("Vehicle with ID: " + b.getV_id() + " is not available for booking. Please choose another vehicle.");
            return;
        }
//else calculate the total price for the booking and set the total price as rental days * price per day
        double totalPrice = b.getRental_days() * v.getPrice_per_day();
        b.setTotal_price(totalPrice); //then set the total price for the booking
        bookings.add(b); //add the booking to the list of bookings
        v.setIs_available(false); //once booked make available status of the vehicle to false because it is now booked and not available for booking until the booking is cancelled or completed
        System.out.println("Vehicle with ID: " + b.getV_id() + " has been booked successfully for Customer ID: " + b.getC_id());
        System.out.println("Total Price: " + totalPrice);
    }

    public void viewAllVehicles(){
        for(Vehicle v : vehicles.values()){
            System.out.println("Vehicle ID: "+ v.getV_id()+ " , Type: "+ v.getType() + " , Registration Number: "+ v.getRegistration_num() + " , Model: "+ v.getModel() + " , Brand: "+ v.getBrand() + " , Price per day: "+ v.getPrice_per_day() + " , Available: "+ v.isIs_available());
        }
    }

    public void returnVehicle(int b_id){

        for(Booking b : bookings){
            if(b.getB_id() == b_id){
                b.setIs_active(false);

                Vehicle v = vehicles.get(b.getV_id());
                v.setIs_available(true);
                System.out.println("Vehicle returned successfully for Booking ID: " + b_id);
            }
        }
        System.out.println("Booking not found with ID: " + b_id);
    }

    public void makePayment(Payment p){
        p.setP_id(payments.size()+1); //auto generate payment id by getting size of the list
        payments.add(p);
        System.out.println("Payment made successfully!");
    }

    public void viewPayments(){

        if(payments.isEmpty()){
        System.out.println("No payments found.");
        return;
    }
        for(Payment p : payments){
            System.out.println("Payment ID: "+ p.getP_id() + " , Booking ID: "+ p.getB().getB_id() + " , Payment Date: "+ p.getPayment_date() + " , Amount: "+ p.getAmount() + " , Payment Method: "+ p.getPayment_method() + " , Payment Status: "+ p.getPayment_status());
        }
    }

    public void viewBookings(){
        if(bookings.isEmpty()){
            System.out.println("No bookings found.");
            return;
        }
        for(Booking b : bookings){
            System.out.println("Booking ID: "+ b.getB_id() + " , Customer ID: "+ b.getC_id() + " , Vehicle ID: "+ b.getV_id() + " , Start Date: "+ b.getStart_date() + " , End Date: "+ b.getEnd_date() + " , Total Price: "+ b.getTotal_price() + " , Active: "+ b.isIs_active());
        }
    }

    public boolean adminLogin(String username, String password){
        if(username.equals("admin") && password.equals("admin123")){
            System.out.println("Admin login successful!");
            return true;
        } else {
            System.out.println("Invalid admin credentials. Please try again.");
            return false;
        }
    }
}


