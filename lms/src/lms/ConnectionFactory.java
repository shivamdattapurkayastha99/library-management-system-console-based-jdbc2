package lms;

import java.sql.*;

public class ConnectionFactory {

    public static Connection con;

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
             con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library2?useSSL=false", "root", "root");

        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return con;

    }
}
