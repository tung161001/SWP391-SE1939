package dao;

import entity.Role;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Data Access Object for Role entity
 */
public class RoleDAO {
    
    private static final Logger LOGGER = Logger.getLogger(RoleDAO.class.getName());
    
    /**
     * Get all roles from the database
     * @return List of roles
     */
    public List<Role> getAllRoles() {
        List<Role> roles = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try {
            conn = connection.getConnection();
            if (conn != null) {
                String sql = "SELECT * FROM role";
                ps = conn.prepareStatement(sql);
                rs = ps.executeQuery();
                
                while (rs.next()) {
                    Role role = new Role();
                    role.setId(rs.getInt("id"));
                    role.setName(rs.getString("name"));
                    roles.add(role);
                }
            }
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Error fetching roles", ex);
        } finally {
            connection.closeResources(conn, ps, rs);
        }
        
        return roles;
    }
    
    /**
     * Get role by ID from the database
     * @param id Role ID
     * @return Role object if found, null otherwise
     */
    public Role getRoleById(int id) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Role role = null;
        
        try {
            conn = connection.getConnection();
            if (conn != null) {
                String sql = "SELECT * FROM role WHERE id = ?";
                ps = conn.prepareStatement(sql);
                ps.setInt(1, id);
                rs = ps.executeQuery();
                
                if (rs.next()) {
                    role = new Role();
                    role.setId(rs.getInt("id"));
                    role.setName(rs.getString("name"));
                }
            }
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Error fetching role by ID", ex);
        } finally {
            connection.closeResources(conn, ps, rs);
        }
    
        return role;
    }
    
    /**
     * Get role by name from the database
     * @param name Role name
     * @return Role object if found, null otherwise
     */
    public Role getRoleByName(String name) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Role role = null;
        
        try {
            conn = connection.getConnection();
            if (conn != null) {
                String sql = "SELECT * FROM role WHERE name = ?";
                ps = conn.prepareStatement(sql);
                ps.setString(1, name);
                rs = ps.executeQuery();
                
                if (rs.next()) {
                    role = new Role();
                    role.setId(rs.getInt("id"));
                    role.setName(rs.getString("name"));
                }
            }
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Error fetching role by name", ex);
        } finally {
            connection.closeResources(conn, ps, rs);
        }
    
        return role;
    }
    
    /**
     * Insert a new role into the database
     * @param role Role object to insert
     * @return true if successful, false otherwise
     */
    public boolean insertRole(Role role) {
        Connection conn = null;
        PreparedStatement ps = null;
        
        try {
            conn = connection.getConnection();
            if (conn != null) {
                String sql = "INSERT INTO role (name) VALUES (?)";
                ps = conn.prepareStatement(sql);
                ps.setString(1, role.getName());
                
                int rowsAffected = ps.executeUpdate();
                return rowsAffected > 0;
            }
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Error inserting role", ex);
        } finally {
            connection.closeResources(conn, ps, null);
        }
        
        return false;
    }
    
    /**
     * Update an existing role in the database
     * @param role Role object with updated values
     * @return true if successful, false otherwise
     */
    public boolean updateRole(Role role) {
        Connection conn = null;
        PreparedStatement ps = null;
        
        try {
            conn = connection.getConnection();
            if (conn != null) {
                String sql = "UPDATE role SET name = ? WHERE id = ?";
                ps = conn.prepareStatement(sql);
                ps.setString(1, role.getName());
                ps.setInt(2, role.getId());
                
                int rowsAffected = ps.executeUpdate();
                return rowsAffected > 0;
            }
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Error updating role", ex);
        } finally {
            connection.closeResources(conn, ps, null);
        }
        
        return false;
    }
    
    /**
     * Delete a role from the database
     * @param id ID of the role to delete
     * @return true if successful, false otherwise
     */
    public boolean deleteRole(int id) {
        Connection conn = null;
        PreparedStatement ps = null;
        
        try {
            conn = connection.getConnection();
            if (conn != null) {
                String sql = "DELETE FROM role WHERE id = ?";
                ps = conn.prepareStatement(sql);
                ps.setInt(1, id);
                
                int rowsAffected = ps.executeUpdate();
                return rowsAffected > 0;
            }
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Error deleting role", ex);
        } finally {
            connection.closeResources(conn, ps, null);
        }
        
        return false;
    }
} 