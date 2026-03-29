package DAO;

import model.SanBay;
import java.sql.*;
import java.util.ArrayList;
import database.DBConnection;

public class SanBayDAO {
    
    // 1. ĐỌC TẤT CẢ
    public ArrayList<SanBay> docTatCa() {
        ArrayList<SanBay> ds = new ArrayList<>();
        String sql = "SELECT * FROM SanBay";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql);
             ResultSet rs = pst.executeQuery()) {
            
            while (rs.next()) {
                ds.add(new SanBay(
                    rs.getString("maSanBay"), 
                    rs.getString("maDiaDiem"), 
                    rs.getString("tenSanBay")
                ));
            }
        } catch (SQLException e) {
            System.out.println("Lỗi load danh sách SanBay: " + e.getMessage());
        }
        return ds;
    }

    // 2. THÊM (Đã sửa lỗi gọi sai tên hàm và thêm liệt kê cột an toàn)
    public boolean them(SanBay sb) {
        String sql = "INSERT INTO SanBay (maSanBay, maDiaDiem, tenSanBay) VALUES (?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {
            
            pst.setString(1, sb.getMaSanBay());
            pst.setString(2, sb.getMaDiaDiem());
            pst.setString(3, sb.getTenSanBay()); // Đã sửa từ getTenChuyenBay() thành getTenSanBay()
            
            return pst.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Lỗi thêm SanBay: " + e.getMessage());
            return false;
        }
    }

    // 3. SỬA (Cập nhật mã địa điểm và tên sân bay)
    public boolean sua(SanBay sb) {
        String sql = "UPDATE SanBay SET maDiaDiem=?, tenSanBay=? WHERE maSanBay=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {
            
            pst.setString(1, sb.getMaDiaDiem());
            pst.setString(2, sb.getTenSanBay());
            pst.setString(3, sb.getMaSanBay());
            
            return pst.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Lỗi sửa SanBay: " + e.getMessage());
            return false;
        }
    }

    // 4. XÓA
    public boolean xoa(String maSanBay) {
        String sql = "DELETE FROM SanBay WHERE maSanBay = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {
            
            pst.setString(1, maSanBay);
            return pst.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Lỗi xóa SanBay: " + e.getMessage());
            return false;
        }
    }

    // 5. TÌM THEO MÃ
    public SanBay timTheoMa(String maSanBay) {
        String sql = "SELECT * FROM SanBay WHERE maSanBay = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {
            
            pst.setString(1, maSanBay);
            ResultSet rs = pst.executeQuery();
            
            if (rs.next()) {
                return new SanBay(
                    rs.getString("maSanBay"), 
                    rs.getString("maDiaDiem"), 
                    rs.getString("tenSanBay")
                );
            }
        } catch (SQLException e) {
            System.out.println("Lỗi tìm kiếm SanBay: " + e.getMessage());
        }
        return null;
    }
}