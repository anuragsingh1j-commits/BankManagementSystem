package daoimpl;

import dao.TransactionDAO;
import database.DBConnection;
import model.Transaction;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TransactionDAOImpl implements TransactionDAO {

    @Override
    public boolean addTransaction(Transaction transaction) {

        String sql = """
                INSERT INTO transactions
                (account_number, transaction_type, amount)
                VALUES (?, ?, ?)
                """;

        try (
                Connection connection = DBConnection.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql)
        ) {

            ps.setInt(1, transaction.getAccountNumber());
            ps.setString(2, transaction.getTransactionType());
            ps.setDouble(3, transaction.getAmount());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public List<Transaction> getTransactionsByAccount(int accountNumber) {

        List<Transaction> transactions = new ArrayList<>();

        String sql = """
                SELECT *
                FROM transactions
                WHERE account_number = ?
                ORDER BY transaction_date DESC
                """;

        try (
                Connection connection = DBConnection.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql)
        ) {

            ps.setInt(1, accountNumber);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Transaction transaction = new Transaction(
                        rs.getInt("transaction_id"),
                        rs.getInt("account_number"),
                        rs.getString("transaction_type"),
                        rs.getDouble("amount"),
                        rs.getTimestamp("transaction_date")
                );

                transactions.add(transaction);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return transactions;
    }
}