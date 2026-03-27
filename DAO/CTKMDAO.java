package DAO;

import model.CTKM;
import java.sql.*;
import java.util.ArrayList;

import database.DBConnection;

public class CTKMDAO {
    public ArrayList<CTKM> selectAll() {
        ArrayList<CTKM> ds = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "SELECT * FROM CTKM";
            ResultSet rs = conn.createStatement().executeQuery(sql);
            while (rs.next()) {
                ds.add(new CTKM(rs.getString("maCTKM"), rs.getString("tenCTKM"), 
                               rs.getString("ngayBD"), rs.getString("ngayKT"), rs.getString("noiDung")));
            }
        } catch (SQLException e) { System.out.println("Loi CTKMDAO: " + e.getMessage()); }
        return ds;
    }

    public boolean insert(CTKM ct) {
        String sql = "INSERT INTO CTKM VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setString(1, ct.getMaCTKM());
            pst.setString(2, ct.getTenCTKM());
            pst.setString(3, ct.getNgayBD());
            pst.setString(4, ct.getNgayKT());
            pst.setString(5, ct.getNoiDung());
            return pst.executeUpdate() > 0;
        } catch (SQLException e) { return false; }
    }
}