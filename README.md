# 🚗 Car Rental Management System

A professional desktop-based Car Rental Management System developed using Java Swing and Object-Oriented Programming principles. The application enables efficient vehicle rental operations, inventory management, rental tracking, customer handling, and data persistence through a modern graphical user interface.

The system provides an enterprise-style dashboard with real-time statistics, rental history management, file-based data storage, and report export functionality.

---

# 🌟 Features

## 🔐 Secure Login System

* User Login Interface
* Authentication Validation
* Professional Welcome Dashboard

---

## 🚘 Vehicle Management

### ➕ Add Car

Add new vehicles to the rental inventory.

Fields:

* Car ID
* Brand
* Model
* Price Per Day

---

### 📋 View Cars

Display all available and rented vehicles.

Features:

* Car ID
* Brand
* Model
* Rental Price
* Availability Status

---

### 🔍 Search Car

Quickly search vehicles using Car ID.

---

### 🗑 Delete Car

Remove vehicles from inventory.

---

## 📅 Rental Operations

### 🚗 Rent Car

Allows customers to rent available vehicles.

Features:

* Customer Name
* Vehicle Selection
* Rental Days
* Rental Price Calculation

---

### ↩ Return Car

Process vehicle returns and update availability status automatically.

---

## 📊 Dashboard Analytics

Professional dashboard displaying:

* Total Cars
* Available Cars
* Rented Cars
* Admin Overview

Additional Features:

* Live Date
* Live Clock
* Enterprise Sidebar Navigation

---

## 📜 Rental History

Track all rental activities.

Stores:

* Customer Name
* Vehicle Information
* Rental Duration

---

## 📁 Data Persistence

The system automatically stores vehicle information using Java Serialization.

Benefits:

* Data remains after application restart
* Automatic save functionality
* Automatic load functionality

---

## 📄 Export Rental History

Generate rental history reports.

Output File:

```text
RentalHistory.txt
```

Contains:

* Customer Details
* Vehicle Details
* Rental Duration

---

# 🏗 Tech Stack

## Frontend

* Java Swing
* AWT

## Backend Logic

* Core Java
* OOP Concepts
* Collections Framework

## Data Storage

* Java Serialization
* File Handling

---

# 📂 Project Structure

```text
CarRentalManagementSystem
│
├── src
│   ├── Main.java
│   ├── DataStore.java
│   ├── SaveData.java
│   ├── Car.java
│   ├── Customer.java
│   ├── Rental.java
│   ├── CarRentalSystem.java
│   │
│   ├── LoginFrame.java
│   ├── DashboardFrame.java
│   ├── AddCarFrame.java
│   ├── ViewCarsFrame.java
│   ├── RentCarFrame.java
│   ├── ReturnCarFrame.java
│   ├── SearchCarFrame.java
│   ├── DeleteCarFrame.java
│   ├── RentalHistoryFrame.java
│   ├── StatisticsFrame.java
│   └── ExportHistoryFrame.java
│
├── data
│   ├── cars.dat
│   └── RentalHistory.txt
│
├── screenshots
│
├── README.md
├── LICENSE
└── .gitignore
```

---

# ⚙️ Installation

## Clone Repository

```bash
git clone https://github.com/YOUR_USERNAME/Car-Rental-Management-System.git
```

## Navigate to Source Folder

```bash
cd "Car-Rental-Management-System/src"
```

## Compile Project

```bash
javac *.java
```

## Run Application

```bash
java Main
```

---

# 🔄 Workflow

```text
Login
   ↓
Dashboard
   ↓
Add/View/Search Cars
   ↓
Rent Car
   ↓
Return Car
   ↓
Rental History
   ↓
Export History
   ↓
Automatic Data Save

```

# 🚀 Future Enhancements

## Database Integration

* MySQL Integration
* JDBC Connectivity

## Advanced Features

* PDF Report Generation
* Email Notifications
* User Roles & Permissions
* Online Booking System
* Cloud Database Support

## Analytics

* Revenue Tracking
* Monthly Reports
* Customer Insights

---

# 🎓 Learning Outcomes

This project demonstrates:

* Java Swing GUI Development
* Object-Oriented Programming
* Event Driven Programming
* Java Collections Framework
* File Handling
* Serialization
* Data Persistence
* Desktop Application Development
* Software Design Principles

---

# 👨‍💻 Developer

Om Vyas

Email: omvyas876@gmail.com

GitHub: https://github.com/YOUR_USERNAME

LinkedIn: https://www.linkedin.com/in/om-vyas-62526a344/

---

# 📄 License

This project is licensed under the MIT License.

---

# ⭐ Support

If you found this project useful:

⭐ Star the repository

🍴 Fork the project

📢 Share it with others

Built with Java, Swing, OOP, File Handling and Serialization.
