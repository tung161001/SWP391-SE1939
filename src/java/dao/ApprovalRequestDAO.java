/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.util.List;

/**
 *
 * @author Doan PC
 */
public class ApprovalRequestDAO {
    private final String JDBC_URL = "jdbc:mysql://localhost:3306/materials_db";
    private final String JDBC_USER = "root";
    private final String JDBC_PASS = "your_password";

    public List<ApprovalRequest> getAllRequests() {
        List<ApprovalRequest> list = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASS);

            String sql = "SELECT * FROM approval_requests";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                ApprovalRequest req = new ApprovalRequest(
                    rs.getInt("id"),
                    rs.getString("request_type"),
                    rs.getString("approval_status"),
                    rs.getString("comments")
                );
                list.add(req);
            }

            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
