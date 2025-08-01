# Simple Hotel Booking System

A simple but fully functional Hotel Booking System built with Java Swing GUI, designed to work perfectly with Apache NetBeans 25.

## 🖼️ Application Overview
<img width="1919" height="1021" alt="image" src="https://github.com/user-attachments/assets/ae03858c-df43-47f1-93d6-5c0120a339f0" />



## ✅ Features

### Room Management
- **3 Room Types**: Standard ($89.99), Deluxe ($149.99), Suite ($299.99)
- **7 Sample Rooms** pre-loaded for testing
- **Real-time Availability** tracking

### Booking System
- **Customer Information** collection (name, email, phone)
- **Room Selection** by type
- **Date Selection** (check-in/check-out)
- **Guest Count** selection
- **Payment Method** selection

### Management Functions
- **View All Rooms** with status (Available/Occupied)
- **View All Bookings** with complete details
- **Cancel Bookings** with confirmation
- **Real-time Updates** across all tabs

## 🖥️ GUI Features

### Simple 3-Tab Interface
1. **Rooms Tab** - View all rooms and their status
2. **Bookings Tab** - Manage existing bookings
3. **New Booking Tab** - Create new reservations

### Java Swing Components Used
- **JFrame** - Main window
- **JTabbedPane** - Tab interface
- **JTable** - Data display tables
- **JTextField** - Text input fields
- **JComboBox** - Dropdown selections
- **JSpinner** - Number selection
- **JButton** - Action buttons
- **GridBagLayout** - Professional form layout
- **BorderLayout** - Panel organization

## 🚀 How to Run

### Option 1: Apache NetBeans 25 (Recommended)
1. Open NetBeans 25
2. **File** → **Open Project**
3. Navigate to `C:\Users\MSI\Desktop\HotelBookingSystem`
4. Select the project folder
5. **Right-click project** → **Run** (or press F6)

### Option 2: Double-click Run Script
- Double-click `run.bat` in the project folder

### Option 3: Command Line
```bash
cd C:\Users\MSI\Desktop\HotelBookingSystem
javac -d build src\HotelBookingApp.java
java -cp build HotelBookingApp
```

## 📋 How to Use the Application

### Making a New Booking
1. Go to **"New Booking"** tab
2. Fill in customer information:
   - Full Name (required)
   - Email (required)
   - Phone number
3. Select booking details:
   - Room Type (Standard/Deluxe/Suite)
   - Check-in Date
   - Check-out Date
   - Number of Guests
   - Payment Method
4. Click **"Make Booking"**
5. View confirmation with Booking ID and total cost

### Viewing Rooms
1. Go to **"Rooms"** tab
2. See all rooms with:
   - Room Number
   - Type
   - Price per Night
   - Status (Available/Occupied)

### Managing Bookings
1. Go to **"Bookings"** tab
2. View all current bookings
3. Select a booking and click **"Cancel Booking"** to cancel
4. Cancelled rooms automatically become available again

## 🏗️ Project Structure

```
HotelBookingSystem/
├── src/
│   └── HotelBookingApp.java    # Main application (single file)
├── nbproject/                  # NetBeans configuration
│   ├── project.properties
│   ├── project.xml
│   └── build-impl.xml
├── build.xml                   # Ant build script
├── run.bat                     # Quick run script
└── README.md                   # This file
```

## 💻 Technical Details

### Architecture
- **Single-file application** for simplicity
- **MVC pattern** within one file
- **Object-oriented design** with separate classes
- **Event-driven GUI** with action listeners

### Classes
- **HotelBookingApp** - Main GUI application
- **Room** - Room data model
- **Customer** - Customer information
- **Booking** - Booking details and logic

### Data Storage
- **In-memory storage** using ArrayLists
- **Sample data** loaded on startup
- **Real-time updates** across all GUI components

## ✅ Why This Works Well

### Simple but Complete
- **All required features** implemented
- **Easy to understand** code structure
- **No external dependencies**
- **Guaranteed NetBeans compatibility**

### User-Friendly GUI
- **Clean tabbed interface**
- **Intuitive form layout**
- **Clear error messages**
- **Immediate visual feedback**

### Fully Functional
- **Real booking creation** and cancellation
- **Room availability** tracking
- **Data consistency** across all views
- **Professional form validation**

## 🎯 Perfect for NetBeans 25

- ✅ **Standard Java project** structure
- ✅ **Proper nbproject** configuration
- ✅ **Main class** properly set
- ✅ **No compilation errors**
- ✅ **Runs immediately** with F6
- ✅ **All GUI features** working

* **Email:** [khaledabdulla@gmail.com](mailto:khaledabdulla@gmail.com)
* **GitHub:** [github.com/khaled1234kh](https://github.com/khaled1234kh)
* **LinkedIn:** [linkedin.com/in/khaled-mohamed-22a22a325](https://linkedin.com/in/khaled-mohamed-22a22a325)
