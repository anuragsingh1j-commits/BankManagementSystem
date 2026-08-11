package dao;

import model.Transaction;
import java.util.List;

public interface TransactionDAO {

    //boolean addTransaction(Transaction transaction);
boolean addTransaction(model.Transaction transaction);
    List<Transaction> getTransactionsByAccount(int accountNumber);
}
