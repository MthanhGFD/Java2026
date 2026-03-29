package DAO;

import model.MayBay;
import java.sql.*;
import java.util.ArrayList;
import database.DBConnection;

public class MayBayDAO {
    
    // 1. ĐỌC TẤT CẢ
    public ArrayList<MayBay> docTatCa() {
        ArrayList<MayBay> ds = new ArrayList<>();
        String sql = "SELECT * FROM MayBay";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql);
             ResultSet rs = pst.executeQuery()) {
            
            while (rs.next()) {
                ds.add(new MayBay(
                    rs.getString("maMayBay"), 
                    rs.getString("maHangHangKhong"), 
                    rs.getString("tenMayBay"), 
                    rs.getInt("soGhe")
                ));
            }
        } catch (SQLException e) { 
            System.out.println("Lỗi load danh sách MayBay: " + e.getMessage());
            e.printStackTrace(); 
        }
        return ds;
    }

    // 2. THÊM
    public boolean them(MayBay mb) {
        String sql = "INSERT INTO MayBay (maMayBay, maHangHangKhong, tenMayBay, soGhe) VALUES (?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {
            
            pst.setString(1, mb.getMaMayBay());
            pst.setString(2, mb.getMaHangHangKhong());
            pst.setString(3, mb.getTenMayBay());
            pst.setInt(4, mb.getSoGhe());
            
            return pst.executeUpdate() > 0;
        } catch (SQLException e) { 
            System.out.println("Lỗi thêm MayBay: " + e.getMessage());
            return false; 
        }
    }

    // 3. SỬA (Cập nhật hãng, tên máy bay và số ghế)
    public boolean sua(MayBay mb) {
        String sql = "UPDATE MayBay SET maHangHangKhong=?, tenMayBay=?, soGhe=? WHERE maMayBay=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {
            
            pst.setString(1, mb.getMaHangHangKhong());
            pst.setString(2, mb.getTenMayBay());
            pst.setInt(3, mb.getSoGhe());
            pst.setString(4, mb.getMaMayBay()); // Khóa chính ở cuối
            
            return pst.executeUpdate() > 0;
        } catch (SQLException e) { 
            System.out.println("Lỗi sửa MayBay: " + e.getMessage());
            return false; 
        }
    }

    // 4. XÓA
    public boolean xoa(String maMayBay) {
        String sql = "DELETE FROM MayBay WHERE maMayBay = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {
            
            pst.setString(1, maMayBay);
            return pst.executeUpdate() > 0;
        } catch (SQLException e) { 
            System.out.println("Lỗi xóa MayBay: " + e.getMessage());
            return false; 
        }
    }

    // 5. TÌM THEO MÃ
    public MayBay timTheoMa(String maMayBay) {
        String sql = "SELECT * FROM MayBay WHERE maMayBay = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {
            
            pst.setString(1, maMayBay);
            ResultSet rs = pst.executeQuery();
            
            if (rs.next()) {
                return new MayBay(
                    rs.getString("maMayBay"), 
                    rs.getString("maHangHangKhong"), 
                    rs.getString("tenMayBay"), 
                    rs.getInt("soGhe")
                );
            }
        } catch (SQLException e) { 
            System.out.println("Lỗi tìm kiếm MayBay: " + e.getMessage());
        }
        return null; // Không tìm thấy thì trả về null
    }
}