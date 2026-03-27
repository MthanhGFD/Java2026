package DAO;

import model.HangHangKhong;
import java.sql.*;
import java.util.ArrayList;

import database.DBConnection;

public class HangHangKhongDAO {
    public ArrayList<HangHangKhong> selectAll() {
        ArrayList<HangHangKhong> ds = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "SELECT * FROM HangHangKhong";
            ResultSet rs = conn.createStatement().executeQuery(sql);
            while (rs.next()) {
                ds.add(new HangHangKhong(rs.getString("maHangHK"), rs.getString("tenHangHK"), rs.getString("quocGia")));
            }
        } catch (SQLException e) { System.out.println("Loi HangHKDAO: " + e.getMessage()); }
        return ds;
    }
}