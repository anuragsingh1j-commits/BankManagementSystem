package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static final String URL = "jdbc:mysql://localhost:3306/bankdb";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "kajal11";

    public static Connection getConnection() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            System.out.println("==================================");
            System.out.println(" Connected to MySQL Successfully!");
            System.out.println("==================================");

            return connection;

        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver Not Found!");
            e.printStackTrace();

        } catch (SQLException e) {
            System.out.println("Database Connection Failed!");
            e.printStackTrace();
        }

        return null;
    }
}