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
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, m.getName());
        ps.setString(2, m.getCode());
        ps.setString(3, m.getUnit());
        ps.setDouble(4, m.getPrice());
        ps.setString(5, m.getCategory());
        ps.executeUpdate();
    }

    public List<Material> filterByCategory(String category) throws SQLException {
        String sql = "SELECT * FROM materials WHERE category=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, category);
        ResultSet rs = ps.executeQuery();

        List<Material> list = new ArrayList<>();
        while (rs.next()) {
            Material m = new Material();
            m.setId(rs.getInt("id"));
            m.setName(rs.getString("name"));
            m.setCode(rs.getString("code"));
            m.setUnit(rs.getString("unit"));
            m.setPrice(rs.getDouble("price"));
            m.setCategory(rs.getString("category"));
            list.add(m);
        }
        return list;
    }
}
