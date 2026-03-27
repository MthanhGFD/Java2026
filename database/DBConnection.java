package database;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    public static Connection getConnection() {
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/quanlychuyenbay";
            String user = "root";
            String password = "123456";

            Connection conn = DriverManager.getConnection(url, user, password);

            System.out.println("Thanh cong");
            return conn;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}