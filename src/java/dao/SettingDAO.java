package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import entity.Setting;
import util.DBConnection;

public class SettingDAO {

    public List<Setting> getAll() {
        List<Setting> list = new ArrayList<>();
        String sql = "SELECT * FROM settings";
        try (Connection conn = DBConnection.getConnection();
             Statement  st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                Setting s = new Setting(
                    rs.getInt("id"),
                    rs.getString("key"),
                    rs.getString("value")
                );
                list.add(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
