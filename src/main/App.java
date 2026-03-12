package main;

import model.*;
import service.*;
import java.util.*;

public class App {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        VehicleRentalService rentalService = new VehicleRentalService();
        while(true){
            System.out.println("====Vehical Rental System====");
            System.out.println("1. Admin Login");
            System.out.println("2. Customer Login");
            System.out.println("3. Exit");
            System.out.print("Enter role: ");
            int role = sc.nextInt();
            sc.nextLine();

            if(role==1){
                System.out.println("Admin Login");
                System.out.print("Enter username: ");
                String username = sc.nextLine();
                System.out.print("Enter password: ");
                String password = sc.nextLine();

                if(rentalService.adminLogin(username, password)){
                    int choice;
                    do{
                        System.out.println("====Admin Menu====");
                        System.out.println("1. Add Vehicle");
                        System.out.println("2. View Vehicles");
                        System.out.println("3. View Available Vehicles");
                        System.out.println("4. View Bookings");
                        System.out.println("5. View Payments");
                        System.out.println("6. View Customers");
                        System.out.println("7. Exit");
                        System.out.print("Enter your choice: ");
                        choice = sc.nextInt();
                        sc.nextLine();

                        switch(choice){
                            case 1:
                                System.out.print("Enter Vehicle ID: ");
                                int v_id = sc.nextInt();
                                sc.nextLine();
                                System.out.print("Enter Vehicle Type: ");
                                String type = sc.nextLine();
                                System.out.print("Enter Registration Number: ");
                                String reg_num = sc.nextLine();
                                System.out.print("Enter Model: ");
                                String model = sc.nextLine();
                                System.out.print("Enter Brand: ");
                                String brand = sc.nextLine();
                                System.out.print("Enter Price per day: ");
                                double price_per_day = sc.nextDouble();
                                sc.nextLine();

                                Vehicle v = new Vehicle(v_id, type, reg_num, model, brand, price_per_day, true);
                                rentalService.addVehicles(v);
                                break;
                            case 2:
                                rentalService.viewVehicles();
                                break;
                            case 3:
                                rentalService.viewAvailableVehicles();
                                break;
                            case 4:
                                rentalService.viewBookings();
                                break;
                            case 5:
                                rentalService.viewPayments();
                                break;
                            case 6:
                                rentalService.viewCustomers();
                                break;
                            case 7:
                                System.out.println("Exiting admin menu. Goodbye!");
                                break;
                            default:
                                System.out.println("Invalid choice! Please try again.");
                        }
                    }while(choice!=7);
                }else {
                    System.out.println("Invalid admin credentials! Please try again.");
                }
        }
            else if(role==2){
                while(true){
                    System.out.println("======Customer Menu======");
                    System.out.println("1. Add Customer");
                    System.out.println("2. View Available Vehicles");
                    System.out.println("3. Book Vehicle");
                    System.out.println("4. Return Vehicle");
                    System.out.println("5. Make Payment");
                    System.out.println("6. View Your Bookings");
                    System.out.println("7. View Payments");
                    System.out.println("8. Exit");
                    System.out.println("Enter your choice: ");
                    int choice = sc.nextInt();
                    sc.nextLine();
                    switch(choice){
                        case 1: 
                            System.out.print("Enter Customer ID: ");
                            int c_id = sc.nextInt();
                            sc.nextLine();
                            System.out.print("Enter Name: ");
                            String name = sc.nextLine();
                            System.out.print("Enter Email: ");
                            String email = sc.nextLine();
                            System.out.print("Enter Phone Number: ");
                            String phone = sc.nextLine();
                            System.out.print("Enter License Number: ");
                            String license_num = sc.nextLine();

                            Customer c = new Customer(c_id, name, email, phone, license_num);
                            rentalService.registerCustomer(c);
                            break;
                        case 2:
                            rentalService.viewAvailableVehicles();
                            break;
                        case 3:
                            System.out.print("Enter Customer ID: ");
                            int customer_id = sc.nextInt();
                            sc.nextLine();
                            System.out.print("Enter Vehicle ID: ");
                            int vehicle_id = sc.nextInt();
                            sc.nextLine();
                            System.out.print("Enter Start Date (YYYY-MM-DD): ");
                            String start_date = sc.nextLine();
                            System.out.print("Enter End Date (YYYY-MM-DD): ");
                            String end_date = sc.nextLine();
                            System.out.print("Enter Rental Days: ");
                            int rental_days = sc.nextInt();
                            sc.nextLine();

                            Booking b = new Booking(0, customer_id, vehicle_id, start_date, end_date, 0.0, true,rental_days);
                            rentalService.bookVehicles(b);
                            break;
                        case 4:
                            System.out.print("Enter Booking ID to return vehicle: ");
                            int booking_id = sc.nextInt();
                            sc.nextLine();
                            rentalService.returnVehicle(booking_id);
                            break;
                        case 5:
                            System.out.print("Enter Booking ID to make payment: ");
                            int booking_id_payment = sc.nextInt();
                            sc.nextLine();

                            Booking foundBooking = null;
                            for(Booking booking : rentalService.getBookings()){
                                if(booking.getB_id() == booking_id_payment){
                                    foundBooking = booking;
                                    break;
                               }
                           }
                           if(foundBooking == null){
                                System.out.println("Booking with ID: " + booking_id_payment + " not found! Please check your booking ID and try again.");
                                break;
                        }
                            System.out.print("Enter Payment Date (YYYY-MM-DD): ");
                            String payment_date = sc.nextLine();
                            System.out.print("Enter Payment Method(UPI/Cash/Card): ");
                            String payment_method = sc.nextLine();

                            double amount = foundBooking.getTotal_price();
                            Payment p = new Payment(0, foundBooking, payment_date,amount, payment_method, "SUCCESS");
                            rentalService.makePayment(p);
                            break;
                        case 6:
                            rentalService.viewBookings();
                            break;
                        case 7:
                            rentalService.viewPayments();
                            break;
                        case 8:
                          System.out.println("Thank you for using the Vehicle Rental System!  Exiting you nowwww!!!");
                            sc.close();
                            return;
                        default:
                        System.out.println("Invalid choice! Please try again.");
                    }
                }
            }
            else if(role==3){
                    System.out.println("Exiting!!!");
                    break;
                }
    }
}
}
