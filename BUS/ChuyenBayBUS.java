package BUS;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import database.DBConnection;
import DAL.ChuyenBay;

public class ChuyenBayBUS {
    public ChuyenBay timChuyenBay(String maCB) throws Exception {
        if (maCB == null || maCB.trim().isEmpty()) {
            throw new Exception("Mã chuyến bay không được để trống!");
        }

        ChuyenBay cb = null;
        Connection conn = DBConnection.getConnection();
        
        String sql = "SELECT * FROM chuyenbay WHERE maChuyenBay = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, maCB.trim());
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            cb = new ChuyenBay();
            cb.setMaChuyenBay(rs.getString("maChuyenBay"));
            cb.setMaMayBay(rs.getString("maMayBay"));
            cb.setMaHangHangKhong(rs.getString("maHangHangKhong"));
            cb.setMaSanBayDi(rs.getString("maSanBayDi"));
            cb.setMaSanBayDen(rs.getString("maSanBayDen"));
            cb.setNgayBay(rs.getString("NgayBay"));
            cb.setGioBay(rs.getString("GioBay"));
            cb.setGioDen(rs.getString("GioDen"));
            cb.setTongSoVe(rs.getInt("TongSoVe"));
            cb.setSoVeDaBan(rs.getInt("SoVeDaBan"));
            cb.setSoVeConLai(rs.getInt("SoVeConLai"));
            cb.setTienVeThuVe(rs.getLong("TienVeThuVe"));
        }
        conn.close();
        
        return cb; 
    }
    public String suaChuyenBay(ChuyenBay cb) {
        // 1. Kiểm tra nghiệp vụ
        if (cb.getMaChuyenBay().isEmpty()) return "Lỗi: Không tìm thấy mã chuyến bay!";
        if (cb.getTongSoVe() < cb.getSoVeDaBan()) return "Lỗi: Tổng số vé không được nhỏ hơn số vé đã bán!";

        // 2. Thực thi cập nhật
        try {
            Connection conn = DBConnection.getConnection();
            String sql = "UPDATE chuyenbay SET maMayBay=?, maHangHangKhong=?, maSanBayDi=?, maSanBayDen=?, NgayBay=?, GioBay=?, GioDen=?, TongSoVe=?, SoVeDaBan=?, SoVeConLai=?, TienVeThuVe=? WHERE maChuyenBay=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            
            ps.setString(1, cb.getMaMayBay());
            ps.setString(2, cb.getMaHangHangKhong());
            ps.setString(3, cb.getMaSanBayDi());
            ps.setString(4, cb.getMaSanBayDen());
            ps.setString(5, cb.getNgayBay());
            ps.setString(6, cb.getGioBay());
            ps.setString(7, cb.getGioDen());
            ps.setInt(8, cb.getTongSoVe());
            ps.setInt(9, cb.getSoVeDaBan());
            ps.setInt(10, cb.getSoVeConLai());
            ps.setLong(11, cb.getTienVeThuVe());
            ps.setString(12, cb.getMaChuyenBay());

            int row = ps.executeUpdate();
            conn.close();
            return row > 0 ? "Thành công" : "Lỗi: Cập nhật thất bại!";
        } catch (Exception e) {
            return "Lỗi hệ thống: " + e.getMessage();
        }
    }
    public String themChuyenBay(ChuyenBay cb) {
        if (cb.getMaChuyenBay().isEmpty()) return "Mã chuyến bay không được để trống!";
        
        // Kiểm tra logic số lượng vé
        if (cb.getTongSoVe() < 0) return "Tổng số vé không thể là số âm!";
        
        try {
            Connection conn = DBConnection.getConnection();
            String sql = "INSERT INTO chuyenbay VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, cb.getMaChuyenBay());
            ps.setString(2, cb.getMaMayBay());
            ps.setString(3, cb.getMaHangHangKhong());
            ps.setString(4, cb.getMaSanBayDi());
            ps.setString(5, cb.getMaSanBayDen());
            ps.setString(6, cb.getNgayBay());
            ps.setString(7, cb.getGioBay());
            ps.setString(8, cb.getGioDen());
            ps.setInt(9, cb.getTongSoVe());
            ps.setInt(10, cb.getSoVeDaBan());
            ps.setInt(11, cb.getSoVeConLai());
            ps.setLong(12, cb.getTienVeThuVe());

            int res = ps.executeUpdate();
            conn.close();
            return res > 0 ? "Thành công" : "Thêm thất bại!";
        } catch (Exception e) {
            return "Lỗi: " + e.getMessage();
        }
    }

    // 2. HÀM XÓA CHUYẾN BAY
    public String xoaChuyenBay(String maCB) {
        if (maCB == null || maCB.isEmpty()) return "Vui lòng chọn chuyến bay để xóa!";

        try {
            Connection conn = DBConnection.getConnection();
            String sql = "DELETE FROM chuyenbay WHERE maChuyenBay = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, maCB);

            int res = ps.executeUpdate();
            conn.close();
            return res > 0 ? "Thành công" : "Không tìm thấy mã chuyến bay để xóa!";
        } catch (java.sql.SQLIntegrityConstraintViolationException e) {
            return "Lỗi: Không thể xóa chuyến bay này vì đã có vé được bán (Ràng buộc dữ liệu)!";
        } catch (Exception e) {
            return "Lỗi hệ thống: " + e.getMessage();
        }
    }
    
}