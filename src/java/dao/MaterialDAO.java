package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import entity.Material;
import util.DBConnection;

public class MaterialDAO {

    public void insert(Material material) {
        String sql = "INSERT INTO materials (name, code, unit, price) VALUES (?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, material.getName());
            ps.setString(2, material.getCode());
            ps.setString(3, material.getUnit());
            ps.setDouble(4, material.getPrice());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Material> getAll() {
        List<Material> list = new ArrayList<>();
        String sql = "SELECT * FROM materials";
        try (Connection conn = DBConnection.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                Material m = new Material(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("code"),
                    rs.getString("unit"),
                    rs.getDouble("price")
                );
                list.add(m);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
