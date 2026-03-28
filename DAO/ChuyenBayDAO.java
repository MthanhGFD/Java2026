package DAO;

import model.ChuyenBay;
import java.sql.*;
import java.util.ArrayList;

public class ChuyenBayDAO {
    public ArrayList<ChuyenBay> selectAll() {
        ArrayList<ChuyenBay> ds = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "SELECT * FROM ChuyenBay";
            ResultSet rs = conn.createStatement().executeQuery(sql);
            while (rs.next()) {
                ds.add(new ChuyenBay(
                    rs.getString("maChuyenBay"), rs.getString("maMayBay"),
                    rs.getString("maHangHangKhong"), rs.getString("maSanBayDi"),
                    rs.getString("maSanBayDen"), rs.getString("NgayBay"),
                    rs.getString("GioBay"), rs.getString("GioDen"),
                    rs.getInt("TongSoVe"), rs.getInt("SoVeDaBan")
                ));
            }
        } catch (SQLException e) { System.out.println("Loi selectAll ChuyenBay: " + e.getMessage()); }
        return ds;
    }

    public boolean insert(ChuyenBay cb) {
        String sql = "INSERT INTO ChuyenBay VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
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
        } catch (SQLException e) { return false; }
    }
}