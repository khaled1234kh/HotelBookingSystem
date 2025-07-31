# 🚀 NetBeans 25 Setup Guide

## How to Open and Run in Apache NetBeans 25

### 📂 **Step 1: Open Project in NetBeans**

1. **Launch Apache NetBeans 25**
2. **File** → **Open Project** (or `Ctrl+Shift+O`)
3. **Navigate to**: `C:\Users\MSI\Desktop\HotelBookingSystem`
4. **Select the folder** `HotelBookingSystem`
5. **Click "Open Project"**

✅ NetBeans will automatically recognize it as a Java project!

### ⚙️ **Step 2: Verify Project Settings** (Usually not needed)

If you want to double-check settings:
1. **Right-click** on "HotelBookingSystem" in Projects panel
2. **Select "Properties"**
3. **Check "Run" category**:
   - Main Class: `HotelBookingApp` ✅
   - Working Directory: `${basedir}` ✅

### ▶️ **Step 3: Run the Application**

**Quick Method**: Press `F6` or click the green **Run** button

**Alternative Methods**:
- **Run** → **Run Project** from menu
- **Right-click project** → **Run**
- **Right-click** `HotelBookingApp.java` → **Run File**

### 🎯 **What You'll See:**

The application will open with **3 tabs**:

#### **1. Rooms Tab**
- Table showing all 7 sample rooms
- Room numbers, types, prices, and availability status
- Refresh button to update data

#### **2. Bookings Tab**
- Table showing current bookings
- Booking details with customer info
- Cancel booking functionality

#### **3. New Booking Tab**
- Professional form for creating reservations
- Customer information section
- Booking details section
- Make Booking and Clear Form buttons

---

## 🔧 **If You Have Any Issues:**

### **Problem: Project Not Opening**
**Solution**: Make sure you select the `HotelBookingSystem` folder, not individual files.

### **Problem: Main Class Not Found**
**Solution**: 
1. Right-click project → Properties
2. Run category → Browse button
3. Select `HotelBookingApp`

### **Problem: Compilation Errors**
**Solution**: 
1. Right-click project → Clean and Build
2. Or Build → Clean and Build Project

---

## 🎉 **Test the Application:**

### **Create a Booking:**
1. Go to "New Booking" tab
2. Enter: 
   - Name: "Test User"
   - Email: "test@email.com"
   - Phone: "555-1234"
3. Select room type: "Standard"
4. Click "Make Booking"
5. See success message with Booking ID!

### **View the Booking:**
1. Go to "Bookings" tab
2. See your new booking in the table
3. Notice the room is now "Occupied" in Rooms tab

### **Cancel the Booking:**
1. Select the booking in Bookings tab
2. Click "Cancel Booking"
3. Confirm cancellation
4. See the room become "Available" again

---

## 💻 **NetBeans Features You Can Use:**

### **Debugging:**
- Set breakpoints by clicking line numbers
- Press `F5` to debug instead of `F6` to run

### **Code Editing:**
- `Ctrl+Space` for code completion
- `Ctrl+Shift+I` to fix imports
- `Alt+Shift+F` to format code

### **Building:**
- `Shift+F11` to clean and build
- `F11` to just build
- JAR file created in `dist/` folder

---

## 🏆 **This Project is Perfect for NetBeans Because:**

✅ **Standard Java SE Project** - No special setup needed
✅ **Single Main Class** - Easy to run
✅ **No External Dependencies** - Just pure Java Swing
✅ **Proper Project Structure** - nbproject folder configured
✅ **Clean Code** - Easy to read and understand
✅ **Full GUI Functionality** - Complete user interface
✅ **Error-Free Compilation** - Runs immediately

---

## 📱 **What the Application Does:**

- **Hotel Room Management** with 3 room types
- **Customer Registration** with validation
- **Booking Creation** with real-time availability
- **Booking Cancellation** with confirmation
- **Data Consistency** across all views
- **Professional GUI** with tables and forms

**Everything works out of the box - just press F6 in NetBeans and start using it!** 🎊

---

## 🎯 **Quick Start Summary:**

1. **Open NetBeans 25**
2. **Open Project** → Select `HotelBookingSystem` folder
3. **Press F6** to run
4. **Test the booking system** with the 3 tabs
5. **Enjoy your fully functional Hotel Booking System!** 🏨

**It's that simple!** ✨ 