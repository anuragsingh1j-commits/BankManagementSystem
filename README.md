🏦 Bank Management System
A console-based Bank Management System developed in Java using JDBC and MySQL. This project demonstrates Object-Oriented Programming (OOP), DAO Pattern, Service Layer Architecture, Exception Handling, Input Validation, Logging, and MySQL database integration.

📌 Features
👤 Customer Management
Add Customer
Search Customer
View All Customers
Delete Customer

🏦 Account Management
Create Savings Account
Create Current Account
Search Account
View All Accounts
Check Balance
Delete Account

💰 Banking Operations
Deposit Money
Withdraw Money
Transfer Money

📜 Transaction Management
Transaction History
Automatic Transaction Recording
🛠 Additional Features
Input Validation
Professional Console UI
Exception Handling
Logging
Dashboard
Menu-Driven Application

🛠 Technologies Used
Java 21
JDBC
MySQL
MySQL Workbench
VS Code
Git & GitHub

📂 Project Structure
BankManagementSystem
│
├── database
│   └── DBConnection.java
│
├── dao
│   ├── AccountDAO.java
│   ├── CustomerDAO.java
│   └── TransactionDAO.java
│
├── daoimpl
│   ├── AccountDAOImpl.java
│   ├── CustomerDAOImpl.java
│   └── TransactionDAOImpl.java
│
├── model
│   ├── Account.java
│   ├── SavingsAccount.java
│   ├── CurrentAccount.java
│   ├── Customer.java
│   └── Transaction.java
│
├── service
│   ├── AccountService.java
│   ├── CustomerService.java
│   ├── DepositService.java
│   ├── WithdrawService.java
│   ├── TransferService.java
│   └── TransactionService.java
│
├── util
│   ├── ConsoleUI.java
│   ├── InputValidator.java
│   └── LoggerUtil.java
│
├── exception
│   ├── AccountNotFoundException.java
│   ├── InvalidAmountException.java
│   └── InsufficientBalanceException.java
│
└── Main.java

🗄 Database
Database Name

bankdb
Tables

customers
accounts
transactions

⚙ Database Configuration

Update your DBConnection.java

private static final String URL =
"jdbc:mysql://localhost:3306/bankdb";

private static final String USER = "root";

private static final String PASSWORD = "YOUR_PASSWORD";

🚀 How to Run
Clone Repository
git clone https://github.com/anuragsingh1j/BankManagementSystem.git
Open Project
Open the project in VS Code or Eclipse.

Configure Database
Create the MySQL database and tables.

Run
Execute

Main.java

Examples:

Home Screen
Customer Menu
Account Menu
Deposit
Withdraw
Transfer
Transaction History

📚 OOP Concepts Used
Abstraction
Inheritance
Polymorphism
Encapsulation

🏗 Design Patterns
DAO Pattern
Service Layer Pattern

🔒 Exception Handling
Custom Exceptions

AccountNotFoundException
InvalidAmountException
InsufficientBalanceException
✔ Input Validation
Integer Validation
Email Validation
Phone Validation
Positive Amount Validation


📋 Logging
Application logs are stored in
bank.log

🔮 Future Enhancements
Login Authentication
Interest Calculation
Loan Management
ATM Module
Internet Banking
Spring Boot REST API
JavaFX GUI
PDF Statement Generation

👨‍💻 Author

**Anurag Singh**

B.Tech Computer Science Engineering

Java Developer

📄 License
This project is developed for learning, academic, and portfolio purposes.
