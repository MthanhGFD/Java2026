package DAO;

import database.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseDAO<T> {
    protected Connection getConnection() throws SQLException {
        return DBConnection.getConnection();
    }

    protected void closeResources(AutoCloseable... resources) {
        for (AutoCloseable resource : resources) {
            if (resource != null) {
                try {
                    resource.close();
                } catch (Exception e) {
                    System.err.println("Lỗi khi đóng resource: " + e.getMessage());
                }
            }
        }
    }

    protected int executeUpdate(String sql, Object... params) {
        Connection conn = null;
        PreparedStatement pst = null;
        try {
            conn = getConnection();
            pst = conn.prepareStatement(sql);
            setParameters(pst, params);
            return pst.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Lỗi executeUpdate: " + e.getMessage());
            return 0;
        } finally {
            closeResources(pst);
        }
    }

    protected ResultSet executeQuery(String sql, Object... params) {
        try {
            Connection conn = getConnection();
            PreparedStatement pst = conn.prepareStatement(sql);
            setParameters(pst, params);
            return pst.executeQuery();
        } catch (SQLException e) {
            System.err.println("Lỗi executeQuery: " + e.getMessage());
            return null;
        }
    }

    private void setParameters(PreparedStatement pst, Object... params) throws SQLException {
        for (int i = 0; i < params.length; i++) {
            pst.setObject(i + 1, params[i]);
        }
    }

    public abstract List<T> selectAll();
    public abstract boolean insert(T entity);
    public abstract boolean update(T entity);
    public abstract boolean delete(String id);
    public abstract T findById(String id);
}