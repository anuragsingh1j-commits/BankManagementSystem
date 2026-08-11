package model;

public abstract class Account {

    protected int accountNumber;
    protected int customerId;
    protected String accountType;
    protected double balance;

    public Account() {
    }

    public Account(int accountNumber,
                   int customerId,
                   String accountType,
                   double balance) {

        this.accountNumber = accountNumber;
        this.customerId = customerId;
        this.accountType = accountType;
        this.balance = balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public int getCustomerId() {
        return customerId;
    }

    public String getAccountType() {
        return accountType;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public abstract boolean withdraw(double amount);
}
