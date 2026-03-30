package DAO;

import java.sql.*;
import java.util.ArrayList;

import DAL.HoaDon;
import database.DBConnection;

public class HoaDonDAO {
    
    // 1. ĐỌC TẤT CẢ
    public ArrayList<HoaDon> docTatCa() {
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
            System.out.println("Lỗi load danh sách HoaDon: " + e.getMessage());
        }
        return ds;
    }

    // 2. THÊM (Đã liệt kê rõ tên cột để an toàn hơn)
    public boolean them(HoaDon hd) {
        String sql = "INSERT INTO HoaDon (maHoaDon, maKhachHang, tongSoVeDat, tongTienVe, maChuyenBay, ngayDat, maKhuyenMai, giaSauKhiGiam, ghiChu) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
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
            System.out.println("Lỗi thêm HoaDon: " + e.getMessage());
            return false;
        }
    }

    // 3. SỬA (Cập nhật 8 trường, dựa vào khóa chính maHoaDon)
    public boolean sua(HoaDon hd) {
        String sql = "UPDATE HoaDon SET maKhachHang=?, tongSoVeDat=?, tongTienVe=?, maChuyenBay=?, ngayDat=?, maKhuyenMai=?, giaSauKhiGiam=?, ghiChu=? WHERE maHoaDon=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {
            
            pst.setString(1, hd.getMaKhachHang());
            pst.setInt(2, hd.getTongSoVeDat());
            pst.setDouble(3, hd.getTongTienVe());
            pst.setString(4, hd.getMaChuyenBay());
            pst.setString(5, hd.getNgayDat());
            pst.setString(6, hd.getMaKhuyenMai());
            pst.setDouble(7, hd.getGiaSauKhiGiam());
            pst.setString(8, hd.getGhiChu());
            // Mã Hóa Đơn nằm ở dấu ? cuối cùng (số 9)
            pst.setString(9, hd.getMaHoaDon());
            
            return pst.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Lỗi sửa HoaDon: " + e.getMessage());
            return false;
        }
    }

    // 4. XÓA
    public boolean xoa(String maHD) {
        String sql = "DELETE FROM HoaDon WHERE maHoaDon = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {
            
            pst.setString(1, maHD);
            return pst.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Lỗi xóa HoaDon: " + e.getMessage());
            return false;
        }
    }

    // 5. TÌM THEO MÃ
    public HoaDon timTheoMa(String maHD) {
        String sql = "SELECT * FROM HoaDon WHERE maHoaDon = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {
            
            pst.setString(1, maHD);
            ResultSet rs = pst.executeQuery();
            
            if (rs.next()) {
                return new HoaDon(
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
            }
        } catch (SQLException e) {
            System.out.println("Lỗi tìm kiếm HoaDon: " + e.getMessage());
        }
        return null;
    }
}