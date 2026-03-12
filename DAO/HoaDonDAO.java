package DAO;

import model.HoaDon;
import java.sql.*;
import java.util.ArrayList;

import database.DBConnection;

public class HoaDonDAO {
    
    public ArrayList<HoaDon> selectAll() {
        ArrayList<HoaDon> ds = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "SELECT * FROM HoaDon";
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                HoaDon hd = new HoaDon(
                    rs.getString("maHoaDon"),
                    rs.getString("maKhachHang"),
                    rs.getInt("tongSoVeDat"),
                    rs.getDouble("tongTienVe"),
                    rs.getString("maChuyenBay"),
                    rs.getString("ngayDat"),
                    rs.getString("maKhuyenMai"),
                    rs.getDouble("giaSauKhiGiam"),
                    rs.getString("ghiChu")
                );
                ds.add(hd);
            }
        } catch (SQLException e) {
            System.out.println("Loi selectAll HoaDon: " + e.getMessage());
        }
        return ds;
    }

    public boolean insert(HoaDon hd) {
        String sql = "INSERT INTO HoaDon VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setString(1, hd.getMaHoaDon());
            pst.setString(2, hd.getMaKhachHang());
            pst.setInt(3, hd.getTongSoVeDat());
            pst.setDouble(4, hd.getTongTienVe());
            pst.setString(5, hd.getMaChuyenBay());
            pst.setString(6, hd.getNgayDat());
            pst.setString(7, hd.getMaKhuyenMai());
            pst.setDouble(8, hd.getGiaSauKhiGiam());
            pst.setString(9, hd.getGhiChu());
            return pst.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Loi insert HoaDon: " + e.getMessage());
            return false;
        }
    }

    public boolean delete(String maHD) {
        String sql = "DELETE FROM HoaDon WHERE maHoaDon = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setString(1, maHD);
            return pst.executeUpdate() > 0;
        } catch (SQLException e) {
            return false;
        }
    }
}