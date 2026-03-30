package DAO;

import java.sql.*;
import java.util.ArrayList;

import DAL.KhachHang;
import database.DBConnection;

public class KhachHangDAO {
    
    // 1. ĐỌC TẤT CẢ
    public ArrayList<KhachHang> docTatCa() {
        ArrayList<KhachHang> ds = new ArrayList<>();
        String sql = "SELECT * FROM KhachHang";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql);
             ResultSet rs = pst.executeQuery()) {
            
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
        } catch (SQLException e) { 
            System.out.println("Lỗi load danh sách KhachHang: " + e.getMessage());
            e.printStackTrace(); 
        }
        return ds;
    }

    // 2. THÊM (Đã liệt kê tên cột cho an toàn)
    public boolean them(KhachHang kh) {
        String sql = "INSERT INTO KhachHang (maKhachHang, ho, ten, ngaySinh, soDienThoai, email) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {
            
            pst.setString(1, kh.getMaKhachHang());
            pst.setString(2, kh.getHo());
            pst.setString(3, kh.getTen());
            pst.setString(4, kh.getNgaySinh());
            pst.setString(5, kh.getSoDienThoai());
            pst.setString(6, kh.getEmail());
            
            return pst.executeUpdate() > 0;
        } catch (SQLException e) { 
            System.out.println("Lỗi thêm KhachHang: " + e.getMessage());
            return false; 
        }
    }

    // 3. SỬA
    public boolean sua(KhachHang kh) {
        String sql = "UPDATE KhachHang SET ho=?, ten=?, ngaySinh=?, soDienThoai=?, email=? WHERE maKhachHang=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {
            
            pst.setString(1, kh.getHo());
            pst.setString(2, kh.getTen());
            pst.setString(3, kh.getNgaySinh());
            pst.setString(4, kh.getSoDienThoai());
            pst.setString(5, kh.getEmail());
            pst.setString(6, kh.getMaKhachHang());
            
            return pst.executeUpdate() > 0;
        } catch (SQLException e) { 
            System.out.println("Lỗi sửa KhachHang: " + e.getMessage());
            return false; 
        }
    }

    // 4. XÓA
    public boolean xoa(String maKH) {
        String sql = "DELETE FROM KhachHang WHERE maKhachHang = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {
            
            pst.setString(1, maKH);
            
            return pst.executeUpdate() > 0;
        } catch (SQLException e) { 
            System.out.println("Lỗi xóa KhachHang: " + e.getMessage());
            return false; 
        }
    }

    // 5. TÌM THEO MÃ
    public KhachHang timTheoMa(String maKH) {
        String sql = "SELECT * FROM KhachHang WHERE maKhachHang = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {
            
            pst.setString(1, maKH);
            ResultSet rs = pst.executeQuery();
            
            if (rs.next()) {
                return new KhachHang(
                    rs.getString("maKhachHang"),
                    rs.getString("ho"),
                    rs.getString("ten"),
                    rs.getString("ngaySinh"),
                    rs.getString("soDienThoai"),
                    rs.getString("email")
                );
            }
        } catch (SQLException e) { 
            System.out.println("Lỗi tìm kiếm KhachHang: " + e.getMessage());
        }
        return null;
    }
}