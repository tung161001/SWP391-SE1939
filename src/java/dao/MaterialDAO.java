package dao;

import entity.Material;
import java.sql.*;
import java.util.*;

public class MaterialDAO {
    private Connection conn;

    public MaterialDAO(Connection conn) {
        this.conn = conn;
    }

    public void create(Material m) throws SQLException {
        String sql = "INSERT INTO materials(name, code, unit, price, category) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, m.getName());
            ps.setString(2, m.getCode());
            ps.setString(3, m.getUnit());
            ps.setDouble(4, m.getPrice());
            ps.setString(5, m.getCategory());
            ps.executeUpdate();
        }
    }

    public List<Material> getAllMaterials() throws SQLException {
        List<Material> list = new ArrayList<>();
        String sql = "SELECT * FROM materials";
        try (PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Material m = new Material(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("code"),
                    rs.getString("unit"),
                    rs.getDouble("price"),
                    rs.getString("category")
                );
                list.add(m);
            }
        }
        return list;
    }

    public List<Material> filterByCategory(String category) throws SQLException {
        List<Material> list = new ArrayList<>();
        String sql = "SELECT * FROM materials WHERE category = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, category);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Material m = new Material(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("code"),
                        rs.getString("unit"),
                        rs.getDouble("price"),
                        rs.getString("category")
                    );
                    list.add(m);
                }
            }
        }
        return list;
    }
}
