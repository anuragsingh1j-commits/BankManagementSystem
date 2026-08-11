package model;

public class SavingsAccount extends Account {

    public SavingsAccount() {
    }

    public SavingsAccount(int accountNumber,
                          int customerId,
                          double balance) {

        super(accountNumber,
                customerId,
                "Savings",
                balance);
    }

    @Override
    public boolean withdraw(double amount) {

        if (amount > balance) {
            return false;
        }

        balance -= amount;
        return true;
    }
}