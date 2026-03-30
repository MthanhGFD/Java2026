package DAO;

import java.sql.*;
import java.util.ArrayList;

import DAL.ChuyenBay;
import database.DBConnection;

public class ChuyenBayDAO {

    // 1. LẤY DANH SÁCH
    public ArrayList<ChuyenBay> docTatCa() {
        ArrayList<ChuyenBay> ds = new ArrayList<>();
        String sql = "SELECT * FROM ChuyenBay";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql);
             ResultSet rs = pst.executeQuery()) {
            
            while (rs.next()) {
                ds.add(new ChuyenBay(
                    rs.getString("maChuyenBay"), rs.getString("maMayBay"),
                    rs.getString("maHangHangKhong"), rs.getString("maSanBayDi"),
                    rs.getString("maSanBayDen"), rs.getString("NgayBay"),
                    rs.getString("GioBay"), rs.getString("GioDen"),
                    rs.getInt("TongSoVe"), rs.getInt("SoVeDaBan")
                ));
            }
        } catch (SQLException e) { 
            System.out.println("Lỗi selectAll ChuyenBay: " + e.getMessage()); 
        }
        return ds;
    }

    // 2. THÊM CHUYẾN BAY
    public boolean them(ChuyenBay cb) {
        String sql = "INSERT INTO ChuyenBay (maChuyenBay, maMayBay, maHangHangKhong, maSanBayDi, maSanBayDen, NgayBay, GioBay, GioDen, TongSoVe, SoVeDaBan) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {
            
            pst.setString(1, cb.getMaChuyenBay());
            pst.setString(2, cb.getMaMayBay());
            pst.setString(3, cb.getMaHangHangKhong());
            pst.setString(4, cb.getMaSanBayDi());
            pst.setString(5, cb.getMaSanBayDen());
            pst.setString(6, cb.getNgayBay());
            pst.setString(7, cb.getGioBay());
            pst.setString(8, cb.getGioDen());
            pst.setInt(9, cb.getTongSoVe());
            pst.setInt(10, cb.getSoVeDaBan());
            
            return pst.executeUpdate() > 0;
        } catch (SQLException e) { 
            System.out.println("Lỗi thêm ChuyenBay: " + e.getMessage());
            return false; 
        }
    }

    // 3. XÓA CHUYẾN BAY
    public boolean xoa(String maCB) {
        String sql = "DELETE FROM ChuyenBay WHERE maChuyenBay = ?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {
            
            pst.setString(1, maCB);
            return pst.executeUpdate() > 0;
        } catch (Exception e) {
            System.out.println("Lỗi xóa ChuyenBay: " + e.getMessage());
        }
        return false;
    }

    // 4. SỬA CHUYẾN BAY
    public boolean sua(ChuyenBay cb) {
        String sql = "UPDATE ChuyenBay SET maMayBay=?, maHangHangKhong=?, maSanBayDi=?, maSanBayDen=?, NgayBay=?, GioBay=?, GioDen=?, TongSoVe=?, SoVeDaBan=? WHERE maChuyenBay=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {
            
            pst.setString(1, cb.getMaMayBay());
            pst.setString(2, cb.getMaHangHangKhong());
            pst.setString(3, cb.getMaSanBayDi());
            pst.setString(4, cb.getMaSanBayDen());
            pst.setString(5, cb.getNgayBay());
            pst.setString(6, cb.getGioBay());
            pst.setString(7, cb.getGioDen());
            pst.setInt(8, cb.getTongSoVe());
            pst.setInt(9, cb.getSoVeDaBan());
            pst.setString(10, cb.getMaChuyenBay());
            
            return pst.executeUpdate() > 0;
        } catch (SQLException e) { 
            System.out.println("Lỗi sửa ChuyenBay: " + e.getMessage());
            return false; 
        }
    }

    // 5. TÌM KIẾM CHUYẾN BAY
    public ChuyenBay timMa(String maCB) {
        String sql = "SELECT * FROM ChuyenBay WHERE maChuyenBay = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {
            
            pst.setString(1, maCB);
            ResultSet rs = pst.executeQuery();
            
            if (rs.next()) {
                return new ChuyenBay(
                    rs.getString("maChuyenBay"), rs.getString("maMayBay"),
                    rs.getString("maHangHangKhong"), rs.getString("maSanBayDi"),
                    rs.getString("maSanBayDen"), rs.getString("NgayBay"),
                    rs.getString("GioBay"), rs.getString("GioDen"),
                    rs.getInt("TongSoVe"), rs.getInt("SoVeDaBan")
                );
            }
        } catch (SQLException e) { 
            System.out.println("Lỗi tìm kiếm ChuyenBay: " + e.getMessage()); 
        }
        return null;
    }
    public ArrayList<Object[]> thongKeHanhKhach() {
    ArrayList<Object[]> list = new ArrayList<>();
    String sql = "SELECT cb.maChuyenBay, cb.maSanBayDi, cb.maSanBayDen, cb.ngayBay, COUNT(ve.maVe) as soKhach " +
                 "FROM ChuyenBay cb LEFT JOIN Ve ve ON cb.maChuyenBay = ve.maChuyenBay " +
                 "GROUP BY cb.maChuyenBay";
    try (Connection con = DBConnection.getConnection();
         PreparedStatement pst = con.prepareStatement(sql);
         ResultSet rs = pst.executeQuery()) {
        while (rs.next()) {
            list.add(new Object[]{
                rs.getString("maChuyenBay"),
                rs.getString("maSanBayDi"),
                rs.getString("maSanBayDen"),
                rs.getString("ngayBay"),
                rs.getInt("soKhach")
            });
        }
    } catch (Exception e) { e.printStackTrace(); }
    return list;
}
}