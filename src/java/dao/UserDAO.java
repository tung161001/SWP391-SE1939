package dao;

import entity.Role;
import entity.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserDAO {

    private static final Logger LOGGER = Logger.getLogger(UserDAO.class.getName());

    /**
     * Get all users from the database
     *
     * @return List of users
     */
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = connection.getConnection();
            if (conn != null) {
                String sql = "select u.UserID,u.Address,u.Email,u.FullName,u.RoleID,u.Status,r.RoleName as RoleName "
                        + "from User as u left join Role as r on r.RoleID = u.RoleID";
                ps = conn.prepareStatement(sql);
                rs = ps.executeQuery();

                while (rs.next()) {
                    User user = new User();
                    user.setId(rs.getInt("UserID"));
                    user.setAddress(rs.getString("Address"));
                    user.setFullName(rs.getString("FullName"));
                    user.setEmail(rs.getString("Email"));
                    user.setRole(new Role(rs.getInt("RoleID"), rs.getString("RoleName")));
                    user.setActive(rs.getBoolean("Status"));
                    users.add(user);
                }
            }
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Error fetching users", ex);
        } finally {
            connection.closeResources(conn, ps, rs);
        }

        return users;
    }

    /**
     * Get user by ID from the database
     *
     * @param id User ID
     * @return User object if found, null otherwise
     */
    public User getUserById(int id) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        User user = null;

        try {
            conn = connection.getConnection();
            if (conn != null) {
                String sql = "select u.UserID,u.Address,u.Email,u.FullName,u.RoleID,u.Status,r.RoleName as "
                        + "RoleName from User as u left join Role as r on r.RoleID = u.RoleID where u.UserID = ?";
                ps = conn.prepareStatement(sql);
                ps.setInt(1, id);
                rs = ps.executeQuery();

                if (rs.next()) {
                    user = new User();
                    user.setId(rs.getInt("UserID"));
                    user.setAddress(rs.getString("Address"));
                    user.setFullName(rs.getString("FullName"));
                    user.setEmail(rs.getString("Email"));
                    user.setRole(new Role(rs.getInt("RoleID"), rs.getString("RoleName")));
                    user.setActive(rs.getBoolean("Status"));
                }
            } else {
                // If connection fails, try to get from sample data
                return null;
            }
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Error fetching user by ID", ex);
        } finally {
            connection.closeResources(conn, ps, rs);
        }

        return user;
    }

    public User getUserByPasswordUsername(String username, String password) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        User user = null;

        try {
            conn = connection.getConnection();
            if (conn != null) {
                String sql = "select u.UserID,u.Address,u.Email,u.FullName,u.RoleID,u.Status,r.RoleName as "
                        + "RoleName from User as u left join Role as r on r.RoleID = u.RoleID where u.Email = ? and u.Password = ?";
                ps = conn.prepareStatement(sql);
                ps.setString(1, username);
                ps.setString(2, password);

                rs = ps.executeQuery();

                if (rs.next()) {
                    user = new User();
                    user.setId(rs.getInt("UserID"));
                    user.setAddress(rs.getString("Address"));
                    user.setFullName(rs.getString("FullName"));
                    user.setEmail(rs.getString("Email"));
                    user.setRole(new Role(rs.getInt("RoleID"), rs.getString("RoleName")));
                    user.setActive(rs.getBoolean("Status"));
                }
            } else {
                // If connection fails, try to get from sample data
                return null;
            }
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Error fetching user by ID", ex);
        } finally {
            connection.closeResources(conn, ps, rs);
        }

        return user;
    }

    /**
     * Delete a user from the database
     * @param userId ID of the user to delete
     * @return true if successful, false otherwise
     */
    public boolean deleteUser(int userId) {
        Connection conn = null;
        PreparedStatement ps = null;
        
        try {
            conn = connection.getConnection();
            if (conn != null) {
                String sql = "DELETE FROM User WHERE UserID = ?";
                ps = conn.prepareStatement(sql);
                ps.setInt(1, userId);
                
                int rowsAffected = ps.executeUpdate();
                return rowsAffected > 0;
            }
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Error deleting user with ID: " + userId, ex);
        } finally {
            connection.closeResources(conn, ps, null);
        }
        
        return false;
    }

    /**
     * Update a user in the database
     * @param user The user object with updated information
     * @return true if successful, false otherwise
     */
    public boolean updateUser(User user) {
        Connection conn = null;
        PreparedStatement ps = null;
        
        try {
            conn = connection.getConnection();
            if (conn != null) {
                String sql = "UPDATE User SET FullName = ?, Email = ?, Address = ?, RoleID = ?, Status = ? WHERE UserID = ?";
                ps = conn.prepareStatement(sql);
                ps.setString(1, user.getFullName());
                ps.setString(2, user.getEmail());
                ps.setString(3, user.getAddress());
                ps.setInt(4, user.getRole().getId());
                ps.setBoolean(5, user.isActive());
                ps.setInt(6, user.getId());
                
                int rowsAffected = ps.executeUpdate();
                return rowsAffected > 0;
            }
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Error updating user with ID: " + user.getId(), ex);
        } finally {
            connection.closeResources(conn, ps, null);
        }
        
        return false;
    }

    /**
     * Insert a new user into the database
     * @param user The user object to insert
     * @param password The password for the new user
     * @return true if successful, false otherwise
     */
    public boolean insertUser(User user, String password) {
        Connection conn = null;
        PreparedStatement ps = null;
        
        try {
            conn = connection.getConnection();
            if (conn != null) {
                String sql = "INSERT INTO User (FullName, Email, Address, RoleID, Status, Password) VALUES (?, ?, ?, ?, ?, ?)";
                ps = conn.prepareStatement(sql);
                ps.setString(1, user.getFullName());
                ps.setString(2, user.getEmail());
                ps.setString(3, user.getAddress());
                ps.setInt(4, user.getRole().getId());
                ps.setBoolean(5, user.isActive());
                ps.setString(6, password);
                
                int rowsAffected = ps.executeUpdate();
                return rowsAffected > 0;
            }
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Error inserting new user", ex);
        } finally {
            connection.closeResources(conn, ps, null);
        }
        
        return false;
    }
}
