package demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connecting {
    public static Connection getConnect() {
        Connection connection = null;
        String url = "jdbc:mysql://localhost:3306/customer_db";
        String user = "root";
        String password = "Nihalnm*072005"; 
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Database connected successfully.");
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL Driver not found.");
        } catch (SQLException se) {
            System.out.println("Database connection failed. Check your credentials and DB name.");
        }
        return connection;
    }
}