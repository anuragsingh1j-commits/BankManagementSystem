package model;

public class CurrentAccount extends Account {

    public CurrentAccount() {
    }

    public CurrentAccount(int accountNumber,
                          int customerId,
                          double balance) {

        super(accountNumber,
                customerId,
                "Current",
                balance);
    }

    @Override
    public boolean withdraw(double amount) {

        balance -= amount;
        return true;
    }
}