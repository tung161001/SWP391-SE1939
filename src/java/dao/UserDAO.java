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
                    user.setUsername(rs.getString("Email"));
                    user.setFullName(rs.getString("FullName"));
                    user.setEmail(rs.getString("Email"));
                    user.setRole(new Role(rs.getInt("RoleID"), rs.getString("RoleName")));
                    user.setActive(rs.getBoolean("Status"));
                    users.add(user);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, "Error fetching users", ex);
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
                    user.setUsername(rs.getString("Email"));
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
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, "Error fetching user by ID", ex);
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
                    user.setUsername(rs.getString("Email"));
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
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, "Error fetching user by ID", ex);
        } finally {
            connection.closeResources(conn, ps, rs);
        }

        return user;
    }
}
