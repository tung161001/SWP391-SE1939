/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Database connection utility class for MySQL
 * @author thang
 */
public class connection {
    // Database connection parameters for direct connection
    private static final String HOST = "localhost";
    private static final String PORT = "3306";
    private static final String DBNAME = "SWP391";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "123456";

    // JDBC URL for MySQL
    private static final String CONNECTION_URL = "jdbc:mysql://" + HOST + ":" + PORT + "/" + DBNAME;
    
    // Logger
    private static final Logger LOGGER = Logger.getLogger(connection.class.getName());
    
    
    /**
     * Get a direct connection to the database without using connection pool
     * This is a fallback method when connection pool is not available
     * @return Connection object
     */
    public static Connection getConnection() {
        try {
            // Register the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Create and return a connection
            return DriverManager.getConnection(CONNECTION_URL, USERNAME, PASSWORD);
        } catch (ClassNotFoundException | SQLException ex) {
            LOGGER.log(Level.SEVERE, "Error connecting to database directly", ex);
            return null;
        }
    }
    
    /**
     * Close all database resources safely
     * @param conn Connection object
     * @param ps PreparedStatement object
     * @param rs ResultSet object
     */
    public static void closeResources(Connection conn, PreparedStatement ps, ResultSet rs) {
        try {
            if (rs != null && !rs.isClosed()) {
                rs.close();
            }
            if (ps != null && !ps.isClosed()) {
                ps.close();
            }
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        } catch (SQLException ex) {
            LOGGER.log(Level.WARNING, "Error closing database resources", ex);
        }
    }
    
    /**
     * Test the database connection
     * @return true if connection is successful, false otherwise
     */
    public static boolean testConnection() {
        Connection conn = null;
        try {
            conn = getConnection();
            return conn != null;
        } finally {
            closeResources(conn, null, null);
        }
    }
}
