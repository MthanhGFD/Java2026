package database;

import config.DatabaseConfig;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static Connection connection;

    public static Connection getConnection() {
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/quanlychuyenbay";
            String user = "root";
            String password = "123456";

            Connection conn = DriverManager.getConnection(url, user, password);

            System.out.println("Kết nối thành công");
            return conn;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("🔒 Đã đóng kết nối database");
            }
        } catch (SQLException e) {
            System.err.println("❌ Lỗi khi đóng kết nối: " + e.getMessage());
        }
    }
}