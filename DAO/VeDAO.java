package DAO;

import model.Ve;
import java.sql.*;
import java.util.ArrayList;

import database.DBConnection;

public class VeDAO {
    public ArrayList<Ve> selectAll() {
        ArrayList<Ve> ds = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "SELECT * FROM Ve";
            ResultSet rs = conn.createStatement().executeQuery(sql);
            while (rs.next()) {
                ds.add(new Ve(rs.getString("MaVe"), rs.getString("MaChuyenBay"), 
                              rs.getString("MaGhe"), rs.getDouble("GiaVe"), rs.getString("LoaiVe")));
            }
        } catch (SQLException e) {
            System.out.println("Loi selectAll Ve: " + e.getMessage());
        }
        return ds;
    }
}