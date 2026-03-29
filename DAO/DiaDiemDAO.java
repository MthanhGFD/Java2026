package DAO;

import model.DiaDiem;
import database.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DiaDiemDAO {

    // 1. ĐỌC TẤT CẢ DỮ LIỆU
    public ArrayList<DiaDiem> docTatCa() {
        ArrayList<DiaDiem> list = new ArrayList<>();
        String sql = "SELECT * FROM DiaDiem"; // Sửa tên bảng nếu MySQL của bạn đặt khác
        
        try (Connection con = DBConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(sql);
             ResultSet rs = pst.executeQuery()) {
            
            while (rs.next()) {
                DiaDiem dd = new DiaDiem();
                dd.setMaDiaDiem(rs.getString("maDiaDiem"));
                dd.setTenDiaDiem(rs.getString("tenDiaDiem"));
                // Bổ sung lấy dữ liệu Quốc Gia từ CSDL
                dd.setQuocGia(rs.getString("QuocGia")); 
                list.add(dd);
            }
        } catch (Exception e) {
            System.out.println("Lỗi load danh sách Địa Điểm: " + e.getMessage());
            e.printStackTrace();
        }
        return list;
    }

    // 2. THÊM
    public boolean them(DiaDiem dd) {
        String sql = "INSERT INTO DiaDiem (maDiaDiem, tenDiaDiem, QuocGia) VALUES (?, ?, ?)";
        
        try (Connection con = DBConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {
            
            pst.setString(1, dd.getMaDiaDiem());
            pst.setString(2, dd.getTenDiaDiem());
            pst.setString(3, dd.getQuocGia()); 
            
            return pst.executeUpdate() > 0;
        } catch (Exception e) {
            System.out.println("Lỗi thêm Địa Điểm: " + e.getMessage());
            e.printStackTrace();
        }
        return false;
    }

    // 3. SỬA
    public boolean sua(DiaDiem dd) {
        String sql = "UPDATE DiaDiem SET tenDiaDiem = ?, QuocGia = ? WHERE maDiaDiem = ?";
        
        try (Connection con = DBConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {
            
            pst.setString(1, dd.getTenDiaDiem());
            pst.setString(2, dd.getQuocGia()); 
            pst.setString(3, dd.getMaDiaDiem()); 
            
            return pst.executeUpdate() > 0;
        } catch (Exception e) {
            System.out.println("Lỗi sửa Địa Điểm: " + e.getMessage());
            e.printStackTrace();
        }
        return false;
    }

    // 4. XÓA
    public boolean xoa(String maDiaDiem) {
        String sql = "DELETE FROM DiaDiem WHERE maDiaDiem = ?";
        
        try (Connection con = DBConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {
            
            pst.setString(1, maDiaDiem);
            
            return pst.executeUpdate() > 0;
        } catch (Exception e) {
            System.out.println("Lỗi xóa Địa Điểm: " + e.getMessage());
            e.printStackTrace();
        }
        return false;
    }

    // 5. TÌM THEO MÃ
    public DiaDiem timTheoMa(String maDiaDiem) {
        String sql = "SELECT * FROM DiaDiem WHERE maDiaDiem = ?";
        
        try (Connection con = DBConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {
            
            pst.setString(1, maDiaDiem);
            ResultSet rs = pst.executeQuery();
            
            if (rs.next()) {
                DiaDiem dd = new DiaDiem();
                dd.setMaDiaDiem(rs.getString("maDiaDiem"));
                dd.setTenDiaDiem(rs.getString("tenDiaDiem"));
                dd.setQuocGia(rs.getString("QuocGia")); 
                return dd;
            }
        } catch (Exception e) {
            System.out.println("Lỗi tìm kiếm Địa Điểm: " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }
}