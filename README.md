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
