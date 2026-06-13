package demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;

public class API {
    private Connection connection;

    public API() {
        connection = Connecting.getConnect();
        if (connection == null) {
            System.out.println("Warning: Connection is null.");
        }
    }

    //Adding a new customer
    public void addCustomer(String customerId, String customerName, String dob, long contactNo) {
        String query = "INSERT INTO Customer (CustomerID, CustomerName, DOB, ContactNo) VALUES (?, ?, ?, ?)";
        
        try (PreparedStatement state = connection.prepareStatement(query)) {
            state.setString(1, customerId);
            state.setString(2, customerName);
            state.setDate(3, Date.valueOf(dob)); 
            state.setLong(4, contactNo);
            
            int rowsAffected = state.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Success: Customer '" + customerName + "' added to the database.");
            } else {
                System.out.println("Failed to add customer.");
            }
        } catch (SQLException e) {
            System.out.println("SQL Error: Make sure the CustomerID is unique.");
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            System.out.println("Date format error: Ensure DOB is in YYYY-MM-DD format.");
        }
    }

    // Fetch customers who share the same DOB
    public void fetchCustomersWithSharedDOB() {
        String query = "SELECT * FROM Customer WHERE DOB IN (SELECT DOB FROM Customer GROUP BY DOB HAVING COUNT(*) > 1) ORDER BY DOB";
        
        try (PreparedStatement state = connection.prepareStatement(query);
             ResultSet rs = state.executeQuery()) {
             
            boolean hasRecords = false;
            System.out.println("\n--- Customers Sharing a Date of Birth ---");
            
            while (rs.next()) {
                hasRecords = true;
                System.out.println(
                    "DOB: " + rs.getDate("DOB") + 
                    " | ID: " + rs.getString("CustomerID") + 
                    " | Name: " + rs.getString("CustomerName") + 
                    " | Contact: " + rs.getLong("ContactNo")
                );
            }
            
            if (!hasRecords) {
                System.out.println("No customers currently share a Date of Birth.");
            }
            System.out.println("-----------------------------------------");
            
        } catch (SQLException e) {
            System.out.println("Error fetching shared DOBs.");
            e.printStackTrace();
        }
    }
}