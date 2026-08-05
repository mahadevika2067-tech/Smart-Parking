# Problem Statement

## 1. Title
Smart Parking & Slot Booking Platform

## 2. Domain
Transportation / Smart City

## 3. Who is the user?
1. Vehicle Owners (Users)
2. Parking Lot Managers (Admins)

## 4. What problem are we solving?
Finding an available parking space in crowded areas is difficult and time-consuming. Drivers often waste fuel and time searching for parking slots. Parking lot managers also face challenges in managing slot availability efficiently. This platform helps users reserve parking spaces online and allows administrators to manage parking operations effectively.

## 5. Proposed Solution
The application allows users to register, search for nearby parking areas, check available slots, reserve a parking space, make online payments, and receive booking confirmation. Administrators can manage parking locations, parking slots, bookings, and monitor occupancy through a dashboard.

## 6. Core Entities / Database Tables
1. Users
2. Parking Lots
3. Parking Slots
4. Bookings
5. Payments
6. Vehicles

## 7. User Roles & Permissions
Admin
- Manage parking lots
- Manage parking slots
- View bookings
- View reports

User
- Register/Login
- Search parking
- Book parking slot
- Make payment
- Cancel booking

## 8. Success Criteria
Users should be able to search, reserve, and confirm a parking slot in less than one minute.

## 9. Out of Scope
- Automatic gate control
- Live GPS tracking
- Hardware sensor integration

## 10. Chosen Track
Java (Spring Boot)