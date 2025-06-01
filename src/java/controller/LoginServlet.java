package controller;

import dao.UserDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import entity.User;
import utils.cookieUtil;


@WebServlet(urlPatterns = {"/login"})

public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Forward to the JSP page
        request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String remember = request.getParameter("rememberMe");
        cookieUtil cookie = new cookieUtil();

        if ("on".equals(remember)) {
            Cookie c1 = new Cookie("email", email);
            Cookie c2 = new Cookie("password", password);
            c1.setMaxAge(60 * 60 * 24 * 7); // 7 ngày
            c2.setMaxAge(60 * 60 * 24 * 7);
            response.addCookie(c1);
            response.addCookie(c2);
        }

        User user = new UserDAO().getUserByPasswordUsername(email, password);
        if(user != null){
            cookie.setCookie(response, cookie.user, String.valueOf(user.getId()));
            request.getRequestDispatcher("index.jsp").forward(request, response);
            return;
        }
        request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request, response);
    }
}
