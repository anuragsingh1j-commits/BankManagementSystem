
package service;

import database.DBConnection;
import model.Account;
import model.Transaction;

import java.sql.Connection;

public class TransferService {

    private final AccountService accountService;
    private final TransactionService transactionService;

    public TransferService() {
        accountService = new AccountService();
        transactionService = new TransactionService();
    }

    public boolean transfer(int fromAccount, int toAccount, double amount) {

        if (amount <= 0) {
            System.out.println("Invalid amount.");
            return false;
        }

        if (fromAccount == toAccount) {
            System.out.println("Source and destination accounts cannot be the same.");
            return false;
        }

        Account sender = accountService.getAccount(fromAccount);
        Account receiver = accountService.getAccount(toAccount);

        if (sender == null || receiver == null) {
            System.out.println("Invalid account number.");
            return false;
        }

        if (sender.getBalance() < amount) {
            System.out.println("Insufficient balance.");
            return false;
        }

        try (Connection connection = DBConnection.getConnection()) {

            connection.setAutoCommit(false);

            boolean debit = accountService.updateBalance(
                    fromAccount,
                    sender.getBalance() - amount
            );

            boolean credit = accountService.updateBalance(
                    toAccount,
                    receiver.getBalance() + amount
            );

            if (!debit || !credit) {
                connection.rollback();
                System.out.println("Transfer failed.");
                return false;
            }

            transactionService.addTransaction(
                    new Transaction(0, fromAccount, "Transfer Debit", amount, null)
            );

            transactionService.addTransaction(
                    new Transaction(0, toAccount, "Transfer Credit", amount, null)
            );

            connection.commit();

            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
