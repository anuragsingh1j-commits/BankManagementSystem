package service;

import dao.AccountDAO;
import daoimpl.AccountDAOImpl;
import model.Account;

import java.util.List;

public class AccountService {

    private final AccountDAO accountDAO;

    public AccountService() {
        accountDAO = new AccountDAOImpl();
    }

    public boolean createAccount(Account account) {
        return accountDAO.createAccount(account);
    }

    public Account getAccount(int accountNumber) {
        return accountDAO.getAccount(accountNumber);
    }

    public List<Account> getAllAccounts() {
        return accountDAO.getAllAccounts();
    }

    public boolean updateBalance(int accountNumber, double balance) {
        return accountDAO.updateBalance(accountNumber, balance);
    }

    public boolean deleteAccount(int accountNumber) {
        return accountDAO.deleteAccount(accountNumber);
    }

    public boolean deposit(int accountNumber, double amount) {

    Account account = accountDAO.getAccount(accountNumber);

    if (account == null) {
        System.out.println("Account not found.");
        return false;
    }

    double newBalance = account.getBalance() + amount;

    return accountDAO.updateBalance(accountNumber, newBalance);
}

   public boolean withdraw(int accountNumber, double amount) {

    Account account = accountDAO.getAccount(accountNumber);

    if (account == null) {
        System.out.println("Account not found.");
        return false;
    }

    if (amount <= 0) {
        System.out.println("Invalid amount.");
        return false;
    }

    if (account.getBalance() < amount) {
        System.out.println("Insufficient Balance.");
        return false;
    }

    double newBalance = account.getBalance() - amount;

    return accountDAO.updateBalance(accountNumber, newBalance);
}
}