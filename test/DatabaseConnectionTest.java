package test;

import config.DatabaseConfig;
import database.DBConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class DatabaseConnectionTest {
    public static void main(String[] args) {
        System.out.println("🧪 ĐANG KIỂM TRA KẾT NỐI DATABASE...");
        System.out.println("=====================================");

        // Test configuration loading
        System.out.println("📋 Cấu hình database:");
        System.out.println("  - Driver: " + DatabaseConfig.getDriver());
        System.out.println("  - URL: " + DatabaseConfig.getUrl());
        System.out.println("  - User: " + DatabaseConfig.getUser());
        System.out.println();

        // Test connection
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            conn = DBConnection.getConnection();
            if (conn != null) {
                System.out.println("✅ Kết nối database thành công!");

                // Test query
                stmt = conn.createStatement();
                rs = stmt.executeQuery("SELECT COUNT(*) as total FROM KhachHang");

                if (rs.next()) {
                    int total = rs.getInt("total");
                    System.out.println("📊 Số lượng khách hàng trong database: " + total);
                }

                System.out.println("✅ Query test thành công!");
            } else {
                System.out.println("❌ Kết nối database thất bại!");
                System.out.println("💡 Kiểm tra:");
                System.out.println("  - MySQL server có đang chạy không?");
                System.out.println("  - Database 'quanlychuyenbay' có tồn tại không?");
                System.out.println("  - Thông tin đăng nhập có đúng không?");
            }

        } catch (Exception e) {
            System.out.println("❌ Lỗi: " + e.getMessage());
            e.printStackTrace();
        } finally {
            // Close resources
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                DBConnection.closeConnection();
            } catch (Exception e) {
                System.err.println("Lỗi khi đóng kết nối: " + e.getMessage());
            }
        }

        System.out.println("=====================================");
        System.out.println("🏁 Hoàn thành kiểm tra!");
    }
}