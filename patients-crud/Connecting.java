package demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connecting {
    public static Connection getConnect(){
        Connection connection=null;
        String url="jdbc:mysql://localhost:3306/nitte2026";
        String user="root";
        String password="Nihalnm*072005";
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection=DriverManager.getConnection(url, user, password);
            System.out.println("connected");
            // connection=DriverManager.getConnection(
            //     "jdbc:mysql://localhost:3306/nitte2026",
            //     "root",
            //     "Nihalnm*072005"
            //);
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
        catch(SQLException se){
            System.out.println("database connection failed");
        }
        return connection;
    }
}