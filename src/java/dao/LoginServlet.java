

package controller;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.sql.*;

public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String remember = request.getParameter("rememberMe");

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:8080//", "root", "password");

            PreparedStatement ps = conn.prepareStatement("SELECT * FROM users WHERE email=? AND password=?");
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                HttpSession session = request.getSession();
                session.setAttribute("user", email);

                // Ghi nhớ đăng nhập bằng cookie
                if ("on".equals(remember)) {
                    Cookie c1 = new Cookie("email", email);
                    Cookie c2 = new Cookie("password", password);
                    c1.setMaxAge(60*60*24*7); // 7 ngày
                    c2.setMaxAge(60*60*24*7);
                    response.addCookie(c1);
                    response.addCookie(c2);
                }

                response.sendRedirect("dashboard.jsp");
            } else {
                request.setAttribute("message", "Invalid email or password!");
                RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
                rd.forward(request, response);
            }

            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("message", "Server error!");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }
}
