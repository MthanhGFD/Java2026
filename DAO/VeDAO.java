package DAO;

import model.Ve;
import database.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class VeDAO {

    // 1. Đọc dữ liệu (Lấy danh sách tất cả Vé)
    public ArrayList<Ve> docTatCa() {
        ArrayList<Ve> list = new ArrayList<>();
        String sql = "SELECT * FROM Ve"; // Sửa lại tên bảng nếu MySQL của bạn đặt khác (VD: ve_may_bay)
        
        try (Connection con = DBConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(sql);
             ResultSet rs = pst.executeQuery()) {
            
            while (rs.next()) {
                Ve ve = new Ve();
                // Tên trong ngoặc kép phải khớp y hệt với tên cột trong CSDL
                ve.setMaVe(rs.getString("MaVe"));
                ve.setMaChuyenBay(rs.getString("MaChuyenBay"));
                ve.setMaGhe(rs.getString("MaGhe"));
                ve.setGiaVe(rs.getDouble("GiaVe")); // Lấy kiểu double cho Giá vé
                ve.setLoaiVe(rs.getString("LoaiVe"));
                
                list.add(ve);
            }
        } catch (Exception e) {
            System.out.println("Lỗi load danh sách Vé: " + e.getMessage());
            e.printStackTrace();
        }
        return list;
    }

    // 2. Thêm Vé mới
    public boolean them(Ve ve) {
        String sql = "INSERT INTO Ve (MaVe, MaChuyenBay, MaGhe, GiaVe, LoaiVe) VALUES (?, ?, ?, ?, ?)";
        
        try (Connection con = DBConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {
            
            pst.setString(1, ve.getMaVe());
            pst.setString(2, ve.getMaChuyenBay());
            pst.setString(3, ve.getMaGhe());
            pst.setDouble(4, ve.getGiaVe()); // Truyền kiểu double
            pst.setString(5, ve.getLoaiVe());
            
            return pst.executeUpdate() > 0;
        } catch (Exception e) {
            System.out.println("Lỗi thêm Vé: " + e.getMessage());
            e.printStackTrace();
        }
        return false;
    }

    // 3. Cập nhật (Sửa) thông tin Vé
    public boolean sua(Ve ve) {
        String sql = "UPDATE Ve SET MaChuyenBay = ?, MaGhe = ?, GiaVe = ?, LoaiVe = ? WHERE MaVe = ?";
        
        try (Connection con = DBConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {
            
            pst.setString(1, ve.getMaChuyenBay());
            pst.setString(2, ve.getMaGhe());
            pst.setDouble(3, ve.getGiaVe());
            pst.setString(4, ve.getLoaiVe());
            pst.setString(5, ve.getMaVe()); // Khóa chính đẩy xuống dấu ? cuối cùng
            
            return pst.executeUpdate() > 0;
        } catch (Exception e) {
            System.out.println("Lỗi sửa Vé: " + e.getMessage());
            e.printStackTrace();
        }
        return false;
    }

    // 4. Xóa Vé
    public boolean xoa(String maVe) {
        String sql = "DELETE FROM Ve WHERE MaVe = ?";
        
        try (Connection con = DBConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {
            
            pst.setString(1, maVe);
            
            return pst.executeUpdate() > 0;
        } catch (Exception e) {
            System.out.println("Lỗi xóa h: " + e.getMessage());
            e.printStackTrace();
        }
        return false;
    }
}