package service;

import dao.TransactionDAO;
import daoimpl.TransactionDAOImpl;
import model.Transaction;

import java.util.List;

public class TransactionService {

    private final TransactionDAO transactionDAO;

    public TransactionService() {
        transactionDAO = new TransactionDAOImpl();
    }

    public boolean addTransaction(Transaction transaction) {
        return transactionDAO.addTransaction(transaction);
    }

    public List<Transaction> getTransactions(int accountNumber) {
        return transactionDAO.getTransactionsByAccount(accountNumber);
    }
}
