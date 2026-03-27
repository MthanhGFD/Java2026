package DAO;

import model.DiaDiem;
import java.sql.*;
import java.util.ArrayList;

import database.DBConnection;

public class DiaDiemDAO {
    public ArrayList<DiaDiem> selectAll() {
        ArrayList<DiaDiem> ds = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "SELECT * FROM DiaDiem";
            ResultSet rs = conn.createStatement().executeQuery(sql);
            while (rs.next()) {
                ds.add(new DiaDiem(rs.getString("maDiaDiem"), rs.getString("tenDiaDiem"), rs.getString("QuocGia")));
            }
        } catch (SQLException e) { System.out.println("Loi DiaDiemDAO: " + e.getMessage()); }
        return ds;
    }
}