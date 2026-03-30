package DAO;

import java.sql.*;
import java.util.ArrayList;

import DAL.ChiTietHoaDon;
import database.DBConnection;

public class ChiTietHoaDonDAO {

    // 1. LẤY TẤT CẢ
    public ArrayList<ChiTietHoaDon> docTatCa() {
        ArrayList<ChiTietHoaDon> ds = new ArrayList<>();
        String sql = "SELECT * FROM ChiTietHoaDon";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql);
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                ds.add(new ChiTietHoaDon(
                    rs.getString("maHoaDon"),
                    rs.getString("maKhachHang"),
                    rs.getString("maVe"),
                    rs.getDouble("giaVe"),
                    rs.getDouble("giaVeGiam")
                ));
            }

        } catch (SQLException e) {
            System.out.println("Lỗi đọc ChiTietHoaDon: " + e.getMessage());
        }

        return ds;
    }

    // 2. THÊM
    public boolean them(ChiTietHoaDon ct) {
        String sql = "INSERT INTO ChiTietHoaDon (maHoaDon, maKhachHang, maVe, giaVe, giaVeGiam) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {

            pst.setString(1, ct.getMaHoaDon());
            pst.setString(2, ct.getMaKhachHang());
            pst.setString(3, ct.getMaVe());
            pst.setDouble(4, ct.getGiaVe());
            pst.setDouble(5, ct.getGiaVeGiam());

            return pst.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Lỗi thêm ChiTietHoaDon: " + e.getMessage());
            return false;
        }
    }

    // 3. XÓA
    public boolean xoa(String maHoaDon) {
        String sql = "DELETE FROM ChiTietHoaDon WHERE maHoaDon = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {

            pst.setString(1, maHoaDon);
            return pst.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Lỗi xóa ChiTietHoaDon: " + e.getMessage());
        }

        return false;
    }

    // 4. SỬA
    public boolean sua(ChiTietHoaDon ct) {
        String sql = "UPDATE ChiTietHoaDon SET maKhachHang=?, maVe=?, giaVe=?, giaVeGiam=? WHERE maHoaDon=?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {

            pst.setString(1, ct.getMaKhachHang());
            pst.setString(2, ct.getMaVe());
            pst.setDouble(3, ct.getGiaVe());
            pst.setDouble(4, ct.getGiaVeGiam());
            pst.setString(5, ct.getMaHoaDon());

            return pst.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Lỗi sửa ChiTietHoaDon: " + e.getMessage());
            return false;
        }
    }

    // 5. TÌM THEO MÃ
    public ChiTietHoaDon timMa(String maHoaDon) {
        String sql = "SELECT * FROM ChiTietHoaDon WHERE maHoaDon = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {

            pst.setString(1, maHoaDon);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                return new ChiTietHoaDon(
                    rs.getString("maHoaDon"),
                    rs.getString("maKhachHang"),
                    rs.getString("maVe"),
                    rs.getDouble("giaVe"),
                    rs.getDouble("giaVeGiam")
                );
            }

        } catch (SQLException e) {
            System.out.println("Lỗi tìm ChiTietHoaDon: " + e.getMessage());
        }

        return null;
    }
}