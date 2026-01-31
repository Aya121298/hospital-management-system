# Hospital Management System

[![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)](https://www.oracle.com/java/)
[![MySQL](https://img.shields.io/badge/MySQL-005C84?style=for-the-badge&logo=mysql&logoColor=white)](https://www.mysql.com/)
[![Swing](https://img.shields.io/badge/Swing-UI-green?style=for-the-badge)](https://docs.oracle.com/javase/tutorial/uiswing/)

> A comprehensive desktop application for managing hospital operations including patient records, doctor appointments, diagnoses, and prescriptions built with Java Swing and MySQL.

![Hospital Management System](images/banner.png)

---

## 📋 Table of Contents

- [Overview](#overview)
- [Features](#features)
- [Screenshots](#screenshots)
- [Technologies Used](#technologies-used)
- [System Architecture](#system-architecture)
- [Database Schema](#database-schema)
- [Installation](#installation)
- [Usage](#usage)
- [User Roles](#user-roles)
- [Future Enhancements](#future-enhancements)
- [Contributing](#contributing)
- [License](#license)
- [Contact](#contact)

---

## 🎯 Overview

The **Hospital Management System** is a desktop application designed to streamline hospital operations and improve healthcare service delivery. Built using Java Swing for the GUI and MySQL for database management, this system provides a complete solution for managing patients, doctors, appointments, and medical records.

### Key Highlights

- 🏥 **Comprehensive Management**: Handles patients, doctors, appointments, and medical records
- 👥 **Multi-User Support**: Different access levels for doctors, receptionists, and patients
- 🔐 **Secure Authentication**: User login system with role-based access control
- 💾 **Persistent Storage**: MySQL database for reliable data management
- 🖥️ **User-Friendly Interface**: Intuitive GUI built with Java Swing

---

## ✨ Features

### 1. User Management
- ✅ User registration and authentication
- ✅ Role-based access (Doctor, Receptionist, Patient)
- ✅ Secure password handling
- ✅ User profile management

### 2. Patient Management
- ✅ Add new patient records
- ✅ Edit existing patient information
- ✅ Remove patient records
- ✅ Search and filter patients
- ✅ View patient medical history
- ✅ Store diagnosis and prescription information

### 3. Doctor Management
- ✅ Add doctor profiles
- ✅ Update doctor information
- ✅ Assign doctors to rooms
- ✅ Manage doctor contact information
- ✅ View doctor schedules

### 4. Appointment Management
- ✅ Schedule appointments
- ✅ Assign patients to doctors
- ✅ Room allocation
- ✅ Appointment tracking
- ✅ Edit and cancel appointments
- ✅ Search appointments by patient name

### 5. Diagnosis & Prescription
- ✅ Record patient diagnoses
- ✅ Create prescriptions
- ✅ Update medical records
- ✅ Track treatment history

### 6. Reporting
- ✅ Generate patient reports
- ✅ View appointment history
- ✅ Track doctor-patient relationships

---

## 📸 Screenshots

### Login Screen
![Login Screen](screenshots/login.png)

### Main Dashboard
![Main Dashboard](screenshots/dashboard.png)

### Patient Management
![Patient Management](screenshots/patient_management.png)

### Appointment Scheduling
![Appointment System](screenshots/appointments.png)

### Diagnosis & Prescription
![Diagnosis Form](screenshots/diagnosis.png)

---

## 🛠️ Technologies Used

### Frontend
- **Java Swing**: GUI framework for desktop application
- **NetBeans Form Designer**: Visual form designer for UI components

### Backend
- **Java SE**: Core Java for application logic
- **JDBC**: Database connectivity
- **MySQL Connector/J**: MySQL driver for Java

### Database
- **MySQL**: Relational database management system

### Tools
- **Apache NetBeans**: Integrated Development Environment (IDE)
- **MySQL Workbench**: Database design and management

---

## 🏗️ System Architecture

```
┌─────────────────────────────────────────┐
│         Presentation Layer              │
│  (Java Swing GUI Forms)                 │
│  - Login Form                           │
│  - Main Form                            │
│  - Patient Management Forms             │
│  - Appointment Forms                    │
│  - Diagnosis Forms                      │
└────────────────┬────────────────────────┘
                 │
┌────────────────▼────────────────────────┐
│         Business Logic Layer            │
│  (Java Classes)                         │
│  - Patients.java                        │
│  - Doctors.java                         │
│  - Appointments.java                    │
│  - create_user.java                     │
│  - DiagANDpres.java                     │
└────────────────┬────────────────────────┘
                 │
┌────────────────▼────────────────────────┐
│         Data Access Layer               │
│  - MyConnection.java (JDBC)             │
└────────────────┬────────────────────────┘
                 │
┌────────────────▼────────────────────────┐
│         Database Layer                  │
│  (MySQL Database)                       │
│  - Tables: patient, doctor,             │
│    appointment, create_user, etc.       │
└─────────────────────────────────────────┘
```

---

## 🗄️ Database Schema

### Main Tables

#### 1. **patient** Table
```sql
CREATE TABLE patient (
    ID INT PRIMARY KEY AUTO_INCREMENT,
    `Full Name` VARCHAR(100),
    `Phone.no` VARCHAR(20),
    `E-mail` VARCHAR(100),
    Complain TEXT,
    Diagnosis TEXT,
    Prescription TEXT
);
```

#### 2. **specification** (Doctors) Table
```sql
CREATE TABLE specification (
    ID INT PRIMARY KEY AUTO_INCREMENT,
    `Doctor Name` VARCHAR(100),
    `Phone Number` VARCHAR(20),
    `Room Number` VARCHAR(10)
);
```

#### 3. **appointment** Table
```sql
CREATE TABLE appointment (
    `Appointment no.` INT PRIMARY KEY AUTO_INCREMENT,
    `Doctor Name` VARCHAR(100),
    `Patient Name` VARCHAR(100),
    `Room no.` INT,
    FOREIGN KEY (`Doctor Name`) REFERENCES specification(ID) ON DELETE CASCADE,
    FOREIGN KEY (`Patient Name`) REFERENCES patient(ID) ON DELETE CASCADE
);
```

#### 4. **create_user** Table
```sql
CREATE TABLE create_user (
    ID INT PRIMARY KEY AUTO_INCREMENT,
    `Full Name` VARCHAR(100),
    Username VARCHAR(50) UNIQUE,
    Password VARCHAR(100),
    Type ENUM('Doctor', 'Receptionist', 'Patient')
);
```

---

## 🚀 Installation

### Prerequisites

Before you begin, ensure you have the following installed:
- ✅ **Java Development Kit (JDK) 8 or higher**
  - Download from: https://www.oracle.com/java/technologies/downloads/
- ✅ **MySQL Server 5.7 or higher**
  - Download from: https://dev.mysql.com/downloads/
- ✅ **Apache NetBeans IDE** (recommended) or any Java IDE
  - Download from: https://netbeans.apache.org/download/
- ✅ **MySQL Connector/J** (JDBC Driver)
  - Download from: https://dev.mysql.com/downloads/connector/j/

### Step 1: Clone the Repository

```bash
git clone https://github.com/YOUR_USERNAME/hospital-management-system.git
cd hospital-management-system
```

### Step 2: Set Up MySQL Database

1. **Start MySQL Server**
   ```bash
   # On Windows
   net start MySQL80
   
   # On macOS/Linux
   sudo service mysql start
   ```

2. **Create Database**
   ```bash
   mysql -u root -p
   ```

3. **Run the following SQL commands:**
   ```sql
   CREATE DATABASE hospital_db;
   USE hospital_db;
   
   -- Run the SQL script provided in database/schema.sql
   SOURCE database/schema.sql;
   ```

   Or manually create tables using the schema in [Database Schema](#database-schema)

### Step 3: Configure Database Connection

1. **Locate** `MyConnection.java` in the `src/hospitalmanagement/` folder

2. **Update the database credentials:**
   ```java
   public class MyConnection {
       private String url = "jdbc:mysql://localhost:3306/hospital_db";
       private String username = "root";  // Change to your MySQL username
       private String password = "your_password";  // Change to your MySQL password
       
       // Rest of the code...
   }
   ```

### Step 4: Add MySQL Connector to Project

#### Using NetBeans:
1. Right-click on **Libraries** in the project tree
2. Select **Add JAR/Folder**
3. Navigate to where you downloaded `mysql-connector-j-x.x.x.jar`
4. Select and add it

#### Using Command Line:
```bash
# Place mysql-connector-j.jar in lib/ folder
cp path/to/mysql-connector-j-x.x.x.jar lib/
```

### Step 5: Build and Run

#### Using NetBeans:
1. Open the project in NetBeans
2. Right-click on the project
3. Select **Clean and Build**
4. Right-click again and select **Run**

#### Using Command Line:
```bash
# Compile
javac -cp "lib/*" -d build/classes src/hospitalmanagement/*.java

# Run
java -cp "build/classes:lib/*" hospitalmanagement.Hospital_Front_Form
```

---

## 💻 Usage

### First Time Setup

1. **Launch the application**
   - Run `Hospital_Front_Form.java`

2. **Create a user account**
   - Click **"Signup"**
   - Enter your details
   - Select user type (Doctor/Receptionist/Patient)
   - Create username and password

3. **Login**
   - Click **"Login"**
   - Enter your credentials
   - Select your user type
   - Click **"Enter"**

### Using the System

#### For Receptionists:

1. **Add New Patients**
   - Navigate to Patient Management
   - Click "Add Patient"
   - Fill in patient details
   - Save

2. **Schedule Appointments**
   - Go to Appointment Management
   - Select patient and doctor
   - Assign room
   - Schedule appointment

#### For Doctors:

1. **View Patient Information**
   - Access patient records
   - Review medical history

2. **Add Diagnosis and Prescription**
   - Open patient record
   - Enter diagnosis
   - Write prescription
   - Save changes

#### For Patients:

1. **View Appointments**
   - Check scheduled appointments
   - View assigned doctor
   - See room number

2. **Update Personal Information**
   - Edit contact details
   - Update complaints

---

## 👥 User Roles

### 1. **Receptionist**
- Manage patient registration
- Schedule appointments
- View all appointments
- Manage doctor information

### 2. **Doctor**
- View assigned patients
- Add diagnoses and prescriptions
- Review patient medical history
- Manage appointment schedule

### 3. **Patient**
- View personal information
- Check appointments
- View diagnoses and prescriptions
- Update contact information

---

## 📦 Project Structure

```
hospital-management-system/
│
├── src/
│   └── hospitalmanagement/
│       ├── Appointments.java              # Appointment management
│       ├── Appoinyment_Table.java         # Appointment viewing
│       ├── create_user.java               # User registration
│       ├── DiagANDpres.java               # Diagnosis & prescription logic
│       ├── Diagnosis_prescription.java    # Diagnosis form UI
│       ├── Doctors.java                   # Doctor management
│       ├── Fllin.java                     # Patient form filling
│       ├── Hospital_Front_Form.java       # Landing page
│       ├── HospitalManagement.java        # Main application entry
│       ├── Login.java                     # Login form
│       ├── MainForm.java                  # Main dashboard
│       ├── ManageAppointments.java        # Appointment management UI
│       ├── MyConnection.java              # Database connection (YOU NEED TO CREATE THIS)
│       ├── Patients.java                  # Patient management (YOU NEED TO CREATE THIS)
│       ├── User_Creation.java             # User creation form (YOU NEED TO CREATE THIS)
│       │
│       └── *.form                         # NetBeans form files
│
├── lib/
│   └── mysql-connector-j-x.x.x.jar        # MySQL JDBC driver
│
├── database/
│   └── schema.sql                         # Database schema
│
├── images/
│   ├── banner.png
│   └── logo.png
│
├── screenshots/
│   ├── login.png
│   ├── dashboard.png
│   └── ...
│
├── README.md
├── LICENSE
└── .gitignore
```

---

## 🔮 Future Enhancements

- [ ] **Advanced Search**: Implement full-text search for patients and appointments
- [ ] **Analytics Dashboard**: Add statistics and charts for hospital metrics
- [ ] **Email Notifications**: Send appointment reminders to patients
- [ ] **PDF Reports**: Generate printable patient reports and prescriptions
- [ ] **Multi-Language Support**: Add internationalization
- [ ] **Backup & Restore**: Automated database backup functionality
- [ ] **Billing System**: Integrate patient billing and payment tracking
- [ ] **Medical History Timeline**: Visual timeline of patient treatments
- [ ] **Web Interface**: Develop a web-based version using Spring Boot
- [ ] **Mobile App**: Create Android/iOS companion apps
- [ ] **Cloud Integration**: Deploy on cloud with AWS/Azure
- [ ] **Role Permissions**: Granular permission system
- [ ] **Audit Logging**: Track all system changes for compliance

---

## 🤝 Contributing

Contributions are welcome! Please feel free to submit a Pull Request.

### How to Contribute

1. **Fork the repository**
   ```bash
   # Click the "Fork" button on GitHub
   ```

2. **Clone your fork**
   ```bash
   git clone https://github.com/YOUR_USERNAME/hospital-management-system.git
   ```

3. **Create a feature branch**
   ```bash
   git checkout -b feature/AmazingFeature
   ```

4. **Make your changes and commit**
   ```bash
   git commit -m "Add some AmazingFeature"
   ```

5. **Push to your fork**
   ```bash
   git push origin feature/AmazingFeature
   ```

6. **Open a Pull Request**

### Contribution Guidelines

- Follow Java naming conventions
- Add comments to your code
- Update README if adding new features
- Test your changes thoroughly
- Follow the existing code style

---

## 📝 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

---

## 👤 Contact

**Aya Abdel Moniem**

- 📧 Email: Aya.abdelmoniem.afattah@gmail.com
- 💼 LinkedIn: [linkedin.com/in/aya-abdel-moniem-737552214](https://linkedin.com/in/aya-abdel-moniem-737552214)
- 🐙 GitHub: [@YOUR_USERNAME](https://github.com/YOUR_USERNAME)
- 🌐 Portfolio: [Your Portfolio Website]

---

## 🙏 Acknowledgments

- **NetBeans IDE** for the powerful development environment
- **MySQL** for reliable database management
- **Java Swing** for GUI components
- **The British University in Egypt** for academic support

---

## 📊 Project Status

![GitHub last commit](https://img.shields.io/github/last-commit/YOUR_USERNAME/hospital-management-system)
![GitHub issues](https://img.shields.io/github/issues/YOUR_USERNAME/hospital-management-system)
![GitHub stars](https://img.shields.io/github/stars/YOUR_USERNAME/hospital-management-system)
![GitHub forks](https://img.shields.io/github/forks/YOUR_USERNAME/hospital-management-system)

---

## ⚠️ Disclaimer

This is an educational project developed for learning purposes. While it demonstrates key concepts of hospital management systems, it should not be used in production medical environments without proper security audits, compliance checks, and professional validation.

**For Medical Use**: Consult with healthcare IT professionals and ensure compliance with HIPAA, GDPR, or other relevant healthcare data regulations in your region.

---

<p align="center">
  <strong>Made with ❤️ by Aya Abdel Moniem</strong>
</p>

<p align="center">
  <sub>A comprehensive hospital management solution for modern healthcare</sub>
</p>
