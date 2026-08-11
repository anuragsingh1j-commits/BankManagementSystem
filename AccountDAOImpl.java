package daoimpl;

import dao.AccountDAO;
import database.DBConnection;
import model.Account;
import model.CurrentAccount;
import model.SavingsAccount;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AccountDAOImpl implements AccountDAO {

    @Override
    public boolean createAccount(Account account) {

        String sql = "INSERT INTO accounts(customer_id, account_type, balance) VALUES (?, ?, ?)";

        try (
                Connection connection = DBConnection.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql)
        ) {

            ps.setInt(1, account.getCustomerId());
            ps.setString(2, account.getAccountType());
            ps.setDouble(3, account.getBalance());

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public Account getAccount(int accountNumber) {

        String sql = "SELECT * FROM accounts WHERE account_number=?";

        try (
                Connection connection = DBConnection.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql)
        ) {

            ps.setInt(1, accountNumber);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                String type = rs.getString("account_type");

                if (type.equalsIgnoreCase("Savings")) {

                    return new SavingsAccount(
                            rs.getInt("account_number"),
                            rs.getInt("customer_id"),
                            rs.getDouble("balance"));

                } else {

                    return new CurrentAccount(
                            rs.getInt("account_number"),
                            rs.getInt("customer_id"),
                            rs.getDouble("balance"));
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<Account> getAllAccounts() {

        List<Account> list = new ArrayList<>();

        String sql = "SELECT * FROM accounts";

        try (
                Connection connection = DBConnection.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql)
        ) {

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                String type = rs.getString("account_type");

                if (type.equalsIgnoreCase("Savings")) {

                    list.add(new SavingsAccount(
                            rs.getInt("account_number"),
                            rs.getInt("customer_id"),
                            rs.getDouble("balance")));

                } else {

                    list.add(new CurrentAccount(
                            rs.getInt("account_number"),
                            rs.getInt("customer_id"),
                            rs.getDouble("balance")));
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public boolean updateBalance(int accountNumber, double balance) {

        String sql = "UPDATE accounts SET balance=? WHERE account_number=?";

        try (
                Connection connection = DBConnection.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql)
        ) {

            ps.setDouble(1, balance);
            ps.setInt(2, accountNumber);

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean deleteAccount(int accountNumber) {

        String sql = "DELETE FROM accounts WHERE account_number=?";

        try (
                Connection connection = DBConnection.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql)
        ) {

            ps.setInt(1, accountNumber);

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
}