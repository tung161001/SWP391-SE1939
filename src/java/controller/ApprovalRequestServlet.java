package dao;

import entity.ApprovalRequest;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * DAO để truy vấn bảng approval_requests từ MySQL
 */
public class ApprovalRequestDAO {
    // URL JDBC (có thể thêm ?useSSL=false&serverTimezone=UTC&useUnicode=true&characterEncoding=UTF-8 nếu cần)
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/materials_db"
                                          + "?useSSL=false&serverTimezone=UTC&useUnicode=true&characterEncoding=UTF-8";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASS = "123456";

    /**
     * Lấy toàn bộ danh sách ApprovalRequest từ DB
     */
    public List<ApprovalRequest> getAllRequests() {
        List<ApprovalRequest> list = new ArrayList<>();
        // Câu lệnh SQL rõ ràng chỉ lấy đúng các cột cần thiết
        String sql = "SELECT id, request_type, approval_status, comments FROM approval_requests";

        // 1. Nạp driver MySQL
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
            // Nếu không nạp được driver thì trả về list rỗng
            return list;
        }

        // 2. Mở kết nối và thực thi truy vấn trong try-with-resources
        try (
            Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASS);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
        ) {
            // Duyệt ResultSet và thêm vào list
            while (rs.next()) {
                ApprovalRequest req = new ApprovalRequest(
                    rs.getInt("id"),
                    rs.getString("request_type"),
                    rs.getString("approval_status"),
                    rs.getString("comments")
                );
                list.add(req);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            // Nếu có lỗi SQL thì in stack trace và trả về list hiện tại (có thể đang rỗng)
        }

        return list;
    }
}
