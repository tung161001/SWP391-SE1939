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
                String sql = "select u.id,u.username,u.address,u.email,u.full_name,u.role_id,u.status,"
                        + "r.name as role_name from user as u left join role as r on r.id = u.role_id ";
                ps = conn.prepareStatement(sql);
                rs = ps.executeQuery();

                while (rs.next()) {
                    User user = new User();
                    user.setId(rs.getInt("id"));
                    user.setUsername(rs.getString("username"));
                    user.setFullName(rs.getString("full_name"));
                    user.setEmail(rs.getString("email"));
                    user.setRole(new Role(rs.getInt("role_id"),rs.getString("role_name")));
                    user.setActive(rs.getBoolean("status"));
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
                String sql = "select u.id,u.username,u.address,u.email,u.full_name,u.role_id,u.status,"
                        + "r.name as role_name from user as u left join role as r on r.id = u.role_id WHERE u.id = ?";
                ps = conn.prepareStatement(sql);
                ps.setInt(1, id);
                rs = ps.executeQuery();

                if (rs.next()) {
                    user = new User();
                    user.setId(rs.getInt("id"));
                    user.setUsername(rs.getString("username"));
                    user.setFullName(rs.getString("full_name"));
                    user.setEmail(rs.getString("email"));
                    user.setRole(new Role(rs.getInt("role_id"),rs.getString("role_name")));
                    user.setActive(rs.getBoolean("active"));
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
