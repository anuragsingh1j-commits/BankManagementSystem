package dao;

import model.Account;
import java.util.List;

public interface AccountDAO {

    boolean createAccount(Account account);

    Account getAccount(int accountNumber);

    List<Account> getAllAccounts();

    boolean updateBalance(int accountNumber, double balance);

    boolean deleteAccount(int accountNumber);
}