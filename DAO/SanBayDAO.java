package DAO;

import model.SanBay;
import java.sql.*;
import java.util.ArrayList;

import database.DBConnection;

public class SanBayDAO {
    public ArrayList<SanBay> selectAll() {
        ArrayList<SanBay> ds = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "SELECT * FROM SanBay";
            ResultSet rs = conn.createStatement().executeQuery(sql);
            while (rs.next()) {
                ds.add(new SanBay(rs.getString("maSanBay"), rs.getString("maDiaDiem"), rs.getString("tenSanBay")));
            }
        } catch (SQLException e) {
            System.out.println("Loi selectAll SanBay: " + e.getMessage());
        }
        return ds;
    }

    public boolean insert(SanBay sb) {
        String sql = "INSERT INTO SanBay VALUES (?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setString(1, sb.getMaSanBay());
            pst.setString(2, sb.getMaDiaDiem());
            pst.setString(3, sb.getTenChuyenBay()); 
            return pst.executeUpdate() > 0;
        } catch (SQLException e) {
            return false;
        }
    }
}