package com.Db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {
    private static Connection conn;
    
    public static Connection getConn() throws SQLException {
        if (conn == null || conn.isClosed()) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/enotes", "root", "Vishwas@456");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                throw new SQLException("Failed to load MySQL JDBC driver.");
            } catch (SQLException e) {
                e.printStackTrace();
                throw e;
            }
        }
        return conn;
    }
}
