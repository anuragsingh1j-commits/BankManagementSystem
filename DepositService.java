
package service;

import model.Transaction;

public class DepositService {

    private final AccountService accountService;
    private final TransactionService transactionService;

    public DepositService() {
        accountService = new AccountService();
        transactionService = new TransactionService();
    }

    public boolean deposit(int accountNumber, double amount) {

        if (amount <= 0) {
            System.out.println("Invalid amount.");
            return false;
        }

        boolean updated = accountService.deposit(accountNumber, amount);

        if (!updated) {
            return false;
        }

        Transaction transaction = new Transaction(
                0,
                accountNumber,
                "Deposit",
                amount,
                null
        );

        transactionService.addTransaction(transaction);

        return true;
    }
}