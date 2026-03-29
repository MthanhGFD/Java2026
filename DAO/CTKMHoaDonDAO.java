package DAO;

import model.CTKMHoaDon; 
import database.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class CTKMHoaDonDAO {

    // 1. ĐỌC TẤT CẢ
    public ArrayList<CTKMHoaDon> docTatCa() {
        ArrayList<CTKMHoaDon> list = new ArrayList<>();
        String sql = "SELECT * FROM CTKM_HOADON"; 
        try (Connection con = DBConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(sql);
             ResultSet rs = pst.executeQuery()) {
            while (rs.next()) {
                CTKMHoaDon ct = new CTKMHoaDon();
                ct.setMaCTKM(rs.getString("maCTKM"));
                ct.setMaHD(rs.getString("maHD"));
                ct.setGiaTriKM(rs.getDouble("giaTriKM"));
                list.add(ct);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    // 2. THÊM
    public boolean them(CTKMHoaDon ct) {
        String sql = "INSERT INTO CTKM_HOADON (maCTKM, maHD, giaTriKM) VALUES (?, ?, ?)";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setString(1, ct.getMaCTKM());
            pst.setString(2, ct.getMaHD());
            pst.setDouble(3, ct.getGiaTriKM());
            return pst.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    // 3. XÓA (Dựa vào 2 khóa chính)
    public boolean xoa(String maCTKM, String maHD) {
        String sql = "DELETE FROM CTKM_HOADON WHERE maCTKM = ? AND maHD = ?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setString(1, maCTKM);
            pst.setString(2, maHD);
            return pst.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    // 4. SỬA (Cập nhật giá trị khuyến mãi cho hóa đơn đó)
    public boolean sua(CTKMHoaDon ct) {
        String sql = "UPDATE CTKM_HOADON SET giaTriKM = ? WHERE maCTKM = ? AND maHD = ?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setDouble(1, ct.getGiaTriKM());
            pst.setString(2, ct.getMaCTKM());
            pst.setString(3, ct.getMaHD());
            return pst.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    // 5. TÌM THEO MÃ
    public CTKMHoaDon timTheoMa(String maCTKM, String maHD) {
        String sql = "SELECT * FROM CTKM_HOADON WHERE maCTKM = ? AND maHD = ?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setString(1, maCTKM);
            pst.setString(2, maHD);
            ResultSet rs = pst.executeQuery();
            
            if (rs.next()) {
                CTKMHoaDon ct = new CTKMHoaDon();
                ct.setMaCTKM(rs.getString("maCTKM"));
                ct.setMaHD(rs.getString("maHD"));
                ct.setGiaTriKM(rs.getDouble("giaTriKM"));
                return ct;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}