package model;

import java.sql.Timestamp;

public class Transaction {

    private int transactionId;
    private int accountNumber;
    private String transactionType;
    private double amount;
    private Timestamp transactionDate;

    public Transaction() {
    }

    public Transaction(int transactionId,
                       int accountNumber,
                       String transactionType,
                       double amount,
                       Timestamp transactionDate) {

        this.transactionId = transactionId;
        this.accountNumber = accountNumber;
        this.transactionType = transactionType;
        this.amount = amount;
        this.transactionDate = transactionDate;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public double getAmount() {
        return amount;
    }

    public Timestamp getTransactionDate() {
        return transactionDate;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "transactionId=" + transactionId +
                ", accountNumber=" + accountNumber +
                ", transactionType='" + transactionType + '\'' +
                ", amount=" + amount +
                ", transactionDate=" + transactionDate +
                '}';
    }
}
