package DAO;

import model.ChiTietHoaDon;
import java.sql.*;
import java.util.ArrayList;

import database.DBConnection;

public class ChiTietHoaDonDAO {

    public ArrayList<ChiTietHoaDon> selectAll() {
        ArrayList<ChiTietHoaDon> ds = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "SELECT * FROM ChiTietHoaDon";
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                ChiTietHoaDon cthd = new ChiTietHoaDon(
                    rs.getString("maHoaDon"),
                    rs.getString("maKhachHang"),
                    rs.getString("maVe"),
                    rs.getDouble("giaVe"),
                    rs.getDouble("giaVeGiam")
                );
                ds.add(cthd);
            }
        } catch (SQLException e) {
            System.out.println("Loi selectAll ChiTietHoaDon: " + e.getMessage());
        }
        return ds;
    }

    public boolean insert(ChiTietHoaDon cthd) {
        String sql = "INSERT INTO ChiTietHoaDon (maHoaDon, maKhachHang, maVe, giaVe, giaVeGiam) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setString(1, cthd.getMaHoaDon());
            pst.setString(2, cthd.getMaKhachHang());
            pst.setString(3, cthd.getMaVe());
            pst.setDouble(4, cthd.getGiaVe());
            pst.setDouble(5, cthd.getGiaVeGiam());
            return pst.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Loi insert ChiTietHoaDon: " + e.getMessage());
            return false;
        }
    }

    public boolean deleteByHoaDon(String maHD) {
        String sql = "DELETE FROM ChiTietHoaDon WHERE maHoaDon = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setString(1, maHD);
            return pst.executeUpdate() > 0;
        } catch (SQLException e) {
            return false;
        }
    }
}