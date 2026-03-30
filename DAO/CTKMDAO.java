package DAO;

import database.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import DAL.CTKM;

public class CTKMDAO {

    // 1. ĐỌC
    public ArrayList<CTKM> docTatCa() {
        ArrayList<CTKM> list = new ArrayList<>();
        String sql = "SELECT * FROM CTKM";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(sql);
             ResultSet rs = pst.executeQuery()) {
            while (rs.next()) {
                CTKM ct = new CTKM();
                ct.setMaCTKM(rs.getString("maCTKM"));
                ct.setTenCTKM(rs.getString("tenCTKM"));
                ct.setNgayBD(rs.getString("ngayBD"));
                ct.setNgayKT(rs.getString("ngayKT"));
                ct.setNoiDung(rs.getString("noiDung"));
                list.add(ct);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    // 2. THÊM
    public boolean them(CTKM ct) {
        String sql = "INSERT INTO CTKM (maCTKM, tenCTKM, ngayBD, ngayKT, noiDung) VALUES (?, ?, ?, ?, ?)";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setString(1, ct.getMaCTKM());
            pst.setString(2, ct.getTenCTKM());
            pst.setString(3, ct.getNgayBD());
            pst.setString(4, ct.getNgayKT());
            pst.setString(5, ct.getNoiDung());
            return pst.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    // 3. XÓA
    public boolean xoa(String maCTKM) {
        String sql = "DELETE FROM CTKM WHERE maCTKM = ?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setString(1, maCTKM);
            return pst.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    // 4. SỬA
    public boolean sua(CTKM ct) {
        String sql = "UPDATE CTKM SET tenCTKM=?, ngayBD=?, ngayKT=?, noiDung=? WHERE maCTKM=?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setString(1, ct.getTenCTKM());
            pst.setString(2, ct.getNgayBD());
            pst.setString(3, ct.getNgayKT());
            pst.setString(4, ct.getNoiDung());
            pst.setString(5, ct.getMaCTKM());
            return pst.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    // 5. TÌM THEO MÃ 
    public CTKM timTheoMa(String maCTKM) {
        String sql = "SELECT * FROM CTKM WHERE maCTKM = ?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setString(1, maCTKM);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                CTKM ct = new CTKM();
                ct.setMaCTKM(rs.getString("maCTKM"));
                ct.setTenCTKM(rs.getString("tenCTKM"));
                ct.setNgayBD(rs.getString("ngayBD"));
                ct.setNgayKT(rs.getString("ngayKT"));
                ct.setNoiDung(rs.getString("noiDung"));
                return ct;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}