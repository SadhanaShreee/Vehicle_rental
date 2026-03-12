## Problem Statement

The Vehicle Rental Management System manages the rental of vehicles such as cars and bikes. Customers can register, search available vehicles, and book vehicles for a specific time period. Admins manage vehicle details, pricing, and availability.

The system tracks customers, vehicles, bookings, payments, and rental duration. A vehicle can have multiple bookings over time, but only one active booking at a time.

## Folder Structure

The workspace contains two folders by default, where:

- `src`: the folder to maintain sources
- `lib`: the folder to maintain dependencies

## Features

> Secure admin login with username and password.

> Add new vehicles to the system.

> View all registered vehicles.

> View only available vehicles.

> View all vehicle bookings made by customers.

> View all payment records.

> View registered customer details.

> Customer Features

> Customer Registration

> Register a new customer with personal and license details.

> Vehicle Browsing

> View available vehicles for rent.

> Vehicle Booking

> Book a vehicle by providing rental dates.

> Automatic price calculation based on rental days.

> Vehicle Return

> Vehicle availability automatically updates.

> Payment Processing

> Make payment for completed bookings.

> Supports payment methods like UPI, Cash, Card.

> View all bookings made by the customer.

> Payment History

## Methods Used
```
adminLogin()

addVehicles()

viewVehicles()

viewAvailableVehicles()

registerCustomer()

bookVehicles()

returnVehicle()

makePayment()

viewBookings()

viewPayments()

viewCustomers()
```


## Technolgies Used

Java (Core Java)

Object-Oriented Programming (OOP)

Java Collections Framework (HashMap, ArrayList)

Console-based menu system


## Example Menu
```
MAIN MENU
1. Admin Login
2. Customer Login
3. Exit

ADMIN MENU
1. Add Vehicle
2. View Vehicles
3. View Available Vehicles
4. View Bookings
5. View Payments
6. View Customers
7. Exit

CUSTOMER MENU
1. Add Customer
2. View Available Vehicles
3. Book Vehicle
4. Return Vehicle
5. Make Payment
6. View Your Bookings
7. View Payments
8. Exit
```
