package DAO;

import model.MayBay;
import java.sql.*;
import java.util.ArrayList;

import database.DBConnection;

public class MayBayDAO {
    public ArrayList<MayBay> selectAll() {
        ArrayList<MayBay> ds = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "SELECT * FROM MayBay";
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                ds.add(new MayBay(rs.getString("maMayBay"), rs.getString("maHangHangKhong"), 
                                  rs.getString("tenMayBay"), rs.getInt("soGhe")));
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return ds;
    }

    public boolean insert(MayBay mb) {
        String sql = "INSERT INTO MayBay VALUES (?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setString(1, mb.getMaMayBay());
            pst.setString(2, mb.getMaHangHangKhong());
            pst.setString(3, mb.getTenMayBay());
            pst.setInt(4, mb.getSoGhe());
            return pst.executeUpdate() > 0;
        } catch (SQLException e) { return false; }
    }
    // có thể viết thêm update và delete tương tự
}