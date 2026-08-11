# 🏦 Bank Management System

A console-based **Bank Management System** developed in Java using **JDBC and MySQL**.

This project demonstrates **Object-Oriented Programming (OOP), DAO Pattern, Service Layer Architecture, Exception Handling, Input Validation, Logging, and MySQL database integration**.

---

## 📌 Features

### 👤 Customer Management

- Add Customer
- Search Customer
- View All Customers
- Delete Customer

### 🏦 Account Management

- Create Savings Account
- Create Current Account
- Search Account
- View All Accounts
- Check Balance
- Delete Account

### 💰 Banking Operations

- Deposit Money
- Withdraw Money
- Transfer Money

### 📜 Transaction Management

- View Transaction History
- Automatic Transaction Recording

### 🛠️ Additional Features

- Input Validation
- Professional Console UI
- Exception Handling
- Application Logging
- Dashboard
- Menu-Driven Application

---

## 🛠️ Technologies Used

| Technology | Purpose |
|---|---|
| Java 21 | Application Development |
| JDBC | Database Connectivity |
| MySQL | Database Management |
| MySQL Workbench | Database Administration |
| VS Code | Development |
| Git & GitHub | Version Control |

---

## 📂 Project Structure

```text
BankManagementSystem/
│
├── database/
│   └── DBConnection.java
│
├── dao/
│   ├── AccountDAO.java
│   ├── CustomerDAO.java
│   └── TransactionDAO.java
│
├── daoimpl/
│   ├── AccountDAOImpl.java
│   ├── CustomerDAOImpl.java
│   └── TransactionDAOImpl.java
│
├── model/
│   ├── Account.java
│   ├── SavingsAccount.java
│   ├── CurrentAccount.java
│   ├── Customer.java
│   └── Transaction.java
│
├── service/
│   ├── AccountService.java
│   ├── CustomerService.java
│   ├── DepositService.java
│   ├── WithdrawService.java
│   ├── TransferService.java
│   └── TransactionService.java
│
├── util/
│   ├── ConsoleUI.java
│   ├── InputValidator.java
│   └── LoggerUtil.java
│
├── exception/
│   ├── AccountNotFoundException.java
│   ├── InvalidAmountException.java
│   └── InsufficientBalanceException.java
│
└── Main.java

🗄️ Database

The application uses MySQL for storing customer, account, and transaction information.

Database Name
bankdb
Tables
customers
accounts
transactions
⚙️ Database Configuration

Open:

database/DBConnection.java

Update the database credentials according to your MySQL configuration:

private static final String URL =
        "jdbc:mysql://localhost:3306/bankdb";

private static final String USER =
        "root";

private static final String PASSWORD =
        "YOUR_PASSWORD";

Make sure that:

MySQL Server is running.
The bankdb database exists.
Required tables have been created.
MySQL Connector/J is included in the project.
Your username and password are correct.
🚀 How to Run
1. Clone the Repository
git clone https://github.com/anuragsingh1j/BankManagementSystem.git
2. Open the Project

Open the project in:

VS Code
IntelliJ IDEA
Eclipse
3. Configure MySQL

Create the required database and tables in MySQL Workbench.

Database:

bankdb
4. Configure Database Connection

Update the credentials in:

DBConnection.java
5. Add MySQL Connector

Make sure the MySQL JDBC Connector is available in the project's classpath.

6. Run the Application

Run:

Main.java
🖥️ Application Modules

The application provides a menu-driven console interface with modules such as:

🏠 Home Screen

Provides access to all major banking operations.

👤 Customer Management

Manage customer records.

🏦 Account Management

Create and manage different types of bank accounts.

💰 Deposit

Deposit money into a customer's account.

💸 Withdraw

Withdraw money after validating the available balance.

🔄 Transfer

Transfer money between accounts.

📜 Transaction History

View previously recorded transactions.

📚 OOP Concepts Used

The project applies the four major principles of Object-Oriented Programming:

🔹 Encapsulation

Data and related methods are grouped within classes while controlling access through appropriate access modifiers.

🔹 Abstraction

Interfaces and service classes abstract implementation details from the main application.

🔹 Inheritance

Specialized account types inherit common functionality from the base Account class.

Example:

Account
├── SavingsAccount
└── CurrentAccount
🔹 Polymorphism

Different account types can be handled through their common Account reference while providing specialized behavior.

🏗️ Design Patterns
DAO Pattern

The Data Access Object (DAO) pattern separates database operations from business logic.

DAO
│
├── AccountDAO
├── CustomerDAO
└── TransactionDAO

Implementation classes handle the actual database operations.

Service Layer Pattern

Business logic is separated into service classes such as:

AccountService
CustomerService
DepositService
WithdrawService
TransferService
TransactionService

This makes the application more modular and maintainable.

🔒 Exception Handling

The application uses custom exceptions to handle common banking errors.

AccountNotFoundException

Used when an account cannot be found.

InvalidAmountException

Used when an invalid amount is entered.

InsufficientBalanceException

Used when the account does not have sufficient balance for a withdrawal or transfer.

✔️ Input Validation

The application validates user input before processing operations.

Validation includes:

Integer validation
Email validation
Phone number validation
Positive amount validation
Account information validation

This helps prevent invalid data from entering the system.

📋 Logging

The application includes logging functionality to record important application events.

Logs are stored in:

bank.log

Logging can help with debugging, monitoring, and tracking application activity.

📸 Screenshots

Add screenshots of the application to showcase the project.

Recommended screenshots:

screenshots/
│
├── home-screen.png
├── customer-menu.png
├── account-menu.png
├── deposit.png
├── withdraw.png
├── transfer.png
└── transaction-history.png

Example:

![Home Screen](screenshots/home-screen.png)
🎯 Learning Outcomes

This project provides practical experience with:

Java programming
Object-Oriented Programming
Inheritance
Polymorphism
Encapsulation
Abstraction
JDBC
MySQL
CRUD operations
DAO architecture
Service Layer architecture
Custom exception handling
Input validation
Logging
Git and GitHub
Modular application development
🔮 Future Enhancements

Possible future improvements include:

🔐 Login and Authentication
💳 Interest Calculation
🏦 Loan Management
🏧 ATM Module
🌐 Internet Banking
🚀 Spring Boot REST API
🖥️ JavaFX GUI
📄 PDF Bank Statement Generation
📱 Mobile Application
🔔 Transaction Notifications
👨‍💻 Author

Anurag Singh

B.Tech Computer Science Engineering

Java Developer

📄 License

This project is developed for learning, academic, and portfolio purposes.
