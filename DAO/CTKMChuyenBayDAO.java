package DAO;

import database.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import DAL.CTKMChuyenBay;

public class CTKMChuyenBayDAO {

    // 1. ĐỌC
    public ArrayList<CTKMChuyenBay> docTatCa() {
        ArrayList<CTKMChuyenBay> list = new ArrayList<>();
        String sql = "SELECT * FROM CTKM_CHUYENBAY"; 
        try (Connection con = DBConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(sql);
             ResultSet rs = pst.executeQuery()) {
            while (rs.next()) {
                CTKMChuyenBay ct = new CTKMChuyenBay();
                ct.setMaCTKM(rs.getString("maCTKM"));
                ct.setMaCB(rs.getString("maCB"));
                ct.setGiaTriKM(rs.getDouble("giaTriKM"));
                list.add(ct);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    // 2. THÊM
    public boolean them(CTKMChuyenBay ct) {
        String sql = "INSERT INTO CTKM_CHUYENBAY (maCTKM, maCB, giaTriKM) VALUES (?, ?, ?)";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setString(1, ct.getMaCTKM());
            pst.setString(2, ct.getMaCB());
            pst.setDouble(3, ct.getGiaTriKM());
            return pst.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    // 3. XÓA
    public boolean xoa(String maCTKM, String maCB) {
        String sql = "DELETE FROM CTKM_CHUYENBAY WHERE maCTKM = ? AND maCB = ?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setString(1, maCTKM);
            pst.setString(2, maCB);
            return pst.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    // 4. SỬA
    public boolean sua(CTKMChuyenBay ct) {
        String sql = "UPDATE CTKM_CHUYENBAY SET giaTriKM = ? WHERE maCTKM = ? AND maCB = ?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setDouble(1, ct.getGiaTriKM());
            pst.setString(2, ct.getMaCTKM());
            pst.setString(3, ct.getMaCB());
            return pst.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    // 5. TÌM THEO MÃ
    public CTKMChuyenBay timTheoMa(String maCTKM, String maCB) {
        String sql = "SELECT * FROM CTKM_CHUYENBAY WHERE maCTKM = ? AND maCB = ?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setString(1, maCTKM);
            pst.setString(2, maCB);
            ResultSet rs = pst.executeQuery();
            
            if (rs.next()) {
                CTKMChuyenBay ct = new CTKMChuyenBay();
                ct.setMaCTKM(rs.getString("maCTKM"));
                ct.setMaCB(rs.getString("maCB"));
                ct.setGiaTriKM(rs.getDouble("giaTriKM"));
                return ct;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}