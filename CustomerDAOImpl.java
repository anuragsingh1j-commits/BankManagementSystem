package daoimpl;

import dao.CustomerDAO;
import database.DBConnection;
import model.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAOImpl implements CustomerDAO {

    @Override
public boolean addCustomer(Customer customer) {

    String sql = "INSERT INTO customers(full_name, phone, email, address) VALUES (?, ?, ?, ?)";

    try (
            Connection connection = DBConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)
    ) {

        preparedStatement.setString(1, customer.getFullName());
        preparedStatement.setString(2, customer.getPhone());
        preparedStatement.setString(3, customer.getEmail());
        preparedStatement.setString(4, customer.getAddress());

        return preparedStatement.executeUpdate() > 0;

    } catch (Exception e) {
        e.printStackTrace();
    }

    return false;
}

   @Override
public Customer getCustomerById(int customerId) {

    String sql = "SELECT * FROM customers WHERE customer_id = ?";

    try (
            Connection connection = DBConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)
    ) {

        preparedStatement.setInt(1, customerId);

        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            return new Customer(
                    resultSet.getInt("customer_id"),
                    resultSet.getString("full_name"),
                    resultSet.getString("phone"),
                    resultSet.getString("email"),
                    resultSet.getString("address")
            );
        }

    } catch (Exception e) {
        e.printStackTrace();
    }

    return null;
}

    @Override
public List<Customer> getAllCustomers() {

    List<Customer> customers = new ArrayList<>();

    String sql = "SELECT * FROM customers";

    try (
            Connection connection = DBConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)
    ) {

        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {

            customers.add(new Customer(
                    resultSet.getInt("customer_id"),
                    resultSet.getString("full_name"),
                    resultSet.getString("phone"),
                    resultSet.getString("email"),
                    resultSet.getString("address")
            ));
        }

    } catch (Exception e) {
        e.printStackTrace();
    }

    return customers;
}


   @Override
public boolean updateCustomer(Customer customer) {

    String sql = """
            UPDATE customers
            SET full_name = ?, phone = ?, email = ?, address = ?
            WHERE customer_id = ?
            """;

    try (
            Connection connection = DBConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)
    ) {

        preparedStatement.setString(1, customer.getFullName());
        preparedStatement.setString(2, customer.getPhone());
        preparedStatement.setString(3, customer.getEmail());
        preparedStatement.setString(4, customer.getAddress());
        preparedStatement.setInt(5, customer.getCustomerId());

        return preparedStatement.executeUpdate() > 0;

    } catch (Exception e) {
        e.printStackTrace();
    }

    return false;
}

@Override
public boolean deleteCustomer(int customerId) {

    String sql = "DELETE FROM customers WHERE customer_id = ?";

    try (
            Connection connection = DBConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)
    ) {

        preparedStatement.setInt(1, customerId);

        return preparedStatement.executeUpdate() > 0;

    } catch (Exception e) {
        e.printStackTrace();
    }

    return false;
}

}