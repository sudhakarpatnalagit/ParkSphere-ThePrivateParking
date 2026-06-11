# ParkSphere-ThePrivateParking

ParkSphere is a role-based smart parking management system developed using Java, Servlets, JSP, JDBC, MySQL, and Bootstrap. The system streamlines parking operations by enabling users to reserve parking slots, employees to manage vehicle entry/exit through OTP verification, and administrators to oversee users, employees, locations, bookings, and transactions.

## ✨ Features

### 👤 User Module

* User Registration & Login
* Secure Session Management
* Automatic Parking Slot Allocation
* Vehicle Booking
* Entry OTP Generation
* Checkout Request
* Exit OTP Generation
* Transaction History
* Wallet Balance Display
* Booking Status Tracking

### 👨‍💼 Employee Module

* Employee Login
* Entry OTP Verification
* Exit OTP Verification
* Vehicle Check-In Management
* Vehicle Check-Out Management

### 🛠️ Admin Module

* Admin Login
* User Management

  * View Users
  * Block/Activate Users
  * Update User Details
* Employee Management

  * Add Employees
  * Update Employees
  * Delete Employees
* Location Management

  * Add Parking Locations
  * View Locations
  * Delete Locations
* Booking Monitoring
* Transaction Monitoring

## 🔐 OTP-Based Parking Workflow

1. User books a parking slot.
2. System generates Entry OTP.
3. Employee verifies Entry OTP.
4. Vehicle enters parking area.
5. User requests checkout.
6. System calculates parking charges and generates Exit OTP.
7. Employee verifies Exit OTP.
8. Transaction is recorded and slot becomes available again.

## 🏗️ Technology Stack

### Backend

* Java
* Servlets
* JSP
* JDBC

### Frontend

* HTML5
* CSS3
* Bootstrap 5
* JavaScript

### Database

* MySQL

### Server

* Apache Tomcat 9

## 🗄️ Database Modules

* Admins
* Users
* Employees
* Parking Locations
* Parking Slots
* Bookings
* Transactions

## 📊 Key Highlights

* Role-Based Access Control (RBAC)
* OTP-Based Entry and Exit Verification
* Automated Slot Management
* Parking Fee Calculation Engine
* Transaction Tracking
* Responsive Bootstrap UI
* MVC Architecture
* JDBC DAO Pattern Implementation

## 🚀 Future Enhancements

* Online Payments Integration
* QR Code Based Entry/Exit
* Real-Time Slot Availability Dashboard
* Email/SMS OTP Notifications
* Analytics and Revenue Reports
* Mobile Application Support

## 👨‍💻 Developed By

Sudhakar Patnala
Java Full Stack Project
