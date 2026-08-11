package service;

import model.Transaction;

public class WithdrawService {

    private final AccountService accountService;
    private final TransactionService transactionService;

    public WithdrawService() {
        accountService = new AccountService();
        transactionService = new TransactionService();
    }

    public boolean withdraw(int accountNumber, double amount) {

        boolean success = accountService.withdraw(accountNumber, amount);

        if (!success) {
            return false;
        }

        Transaction transaction = new Transaction(
                0,
                accountNumber,
                "Withdraw",
                amount,
                null
        );

        transactionService.addTransaction(transaction);

        return true;
    }
}
