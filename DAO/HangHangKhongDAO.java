package DAO;

import model.HangHangKhong;
import database.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class HangHangKhongDAO {

    // 1. ĐỌC TẤT CẢ
    public ArrayList<HangHangKhong> docTatCa() {
        ArrayList<HangHangKhong> list = new ArrayList<>();
        String sql = "SELECT * FROM HangHangKhong"; 
        try (Connection con = DBConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(sql);
             ResultSet rs = pst.executeQuery()) {
            
            while (rs.next()) {
                HangHangKhong hhk = new HangHangKhong();
                hhk.setMaHangHK(rs.getString("maHangHK"));
                hhk.setTenHangHK(rs.getString("tenHangHK"));
                hhk.setQuocGia(rs.getString("quocGia"));
                list.add(hhk);
            }
        } catch (Exception e) {
            System.out.println("Lỗi load danh sách Hãng HK: " + e.getMessage());
            e.printStackTrace();
        }
        return list;
    }

    // 2. THÊM
    public boolean them(HangHangKhong hhk) {
        String sql = "INSERT INTO HangHangKhong (maHangHK, tenHangHK, quocGia) VALUES (?, ?, ?)";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {
            
            pst.setString(1, hhk.getMaHangHK());
            pst.setString(2, hhk.getTenHangHK());
            pst.setString(3, hhk.getQuocGia());
            
            return pst.executeUpdate() > 0;
        } catch (Exception e) {
            System.out.println("Lỗi thêm Hãng HK: " + e.getMessage());
            e.printStackTrace();
        }
        return false;
    }

    // 3. SỬA
    public boolean sua(HangHangKhong hhk) {
        String sql = "UPDATE HangHangKhong SET tenHangHK = ?, quocGia = ? WHERE maHangHK = ?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {
            
            pst.setString(1, hhk.getTenHangHK());
            pst.setString(2, hhk.getQuocGia());
            pst.setString(3, hhk.getMaHangHK());
            
            return pst.executeUpdate() > 0;
        } catch (Exception e) {
            System.out.println("Lỗi sửa Hãng HK: " + e.getMessage());
            e.printStackTrace();
        }
        return false;
    }

    // 4. XÓA
    public boolean xoa(String maHangHK) {
        String sql = "DELETE FROM HangHangKhong WHERE maHangHK = ?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {
            
            pst.setString(1, maHangHK);
            
            return pst.executeUpdate() > 0;
        } catch (Exception e) {
            System.out.println("Lỗi xóa Hãng HK: " + e.getMessage());
            e.printStackTrace();
        }
        return false;
    }

    // 5. TÌM THEO MÃ
    public HangHangKhong timTheoMa(String maHangHK) {
        String sql = "SELECT * FROM HangHangKhong WHERE maHangHK = ?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {
            
            pst.setString(1, maHangHK);
            ResultSet rs = pst.executeQuery();
            
            if (rs.next()) {
                HangHangKhong hhk = new HangHangKhong();
                hhk.setMaHangHK(rs.getString("maHangHK"));
                hhk.setTenHangHK(rs.getString("tenHangHK"));
                hhk.setQuocGia(rs.getString("quocGia"));
                return hhk;
            }
        } catch (Exception e) {
            System.out.println("Lỗi tìm kiếm Hãng HK: " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }
}