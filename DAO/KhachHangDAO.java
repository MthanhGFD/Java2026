package DAO;

import model.KhachHang;
import java.sql.*;
import java.util.ArrayList;

import database.DBConnection;

public class KhachHangDAO {
    // Lấy toàn bộ danh sách từ DB (Thay cho docFile)
    public ArrayList<KhachHang> selectAll() {
        ArrayList<KhachHang> ds = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "SELECT * FROM KhachHang";
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                KhachHang kh = new KhachHang(
                    rs.getString("maKhachHang"),
                    rs.getString("ho"),
                    rs.getString("ten"),
                    rs.getString("ngaySinh"),
                    rs.getString("soDienThoai"),
                    rs.getString("email")
                );
                ds.add(kh);
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return ds;
    }

    // Thêm vào DB (Thay cho logic mảng trong hàm them)
    public boolean insert(KhachHang kh) {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "INSERT INTO KhachHang VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, kh.getMaKhachHang());
            pst.setString(2, kh.getHo());
            pst.setString(3, kh.getTen());
            pst.setString(4, kh.getNgaySinh());
            pst.setString(5, kh.getSoDienThoai());
            pst.setString(6, kh.getEmail());
            return pst.executeUpdate() > 0;
        } catch (SQLException e) { return false; }
    }
    
    // Tương tự viết cho update(KhachHang kh) và delete(String ma)
}