
package dao;

import com.sun.jdi.connect.spi.Connection;
import jakarta.security.auth.message.callback.PrivateKeyCallback.Request;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Doan PC
 */
public class ApprovalRequestDAO {
    private final String jdbcURL = "jdbc:mysql://localhost:3306/approval_system";
    private final String jdbcUsername = "root";
    private final String jdbcPassword = "123456";

    private Connection connect() throws SQLException {
        return DBConnection.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
    }

    public List<Request> getAllRequests() {
        List<Request> list = new ArrayList<>();
        String sql = "SELECT * FROM requests";

        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                list.add(new Request(
                    rs.getInt("id"),
                    rs.getString("request_type"),
                    rs.getString("approval_status"),
                    rs.getString("comments")
                ) {});
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public void approveRequest(int id) {
        String sql = "UPDATE requests SET approval_status = 'Approved' WHERE id = ?";
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
