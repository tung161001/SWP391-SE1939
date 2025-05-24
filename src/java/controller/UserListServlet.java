package controller;

import dao.UserDAO;
import entity.User;
import java.io.IOException;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import utils.cookieUtil;

@WebServlet(name = "UserListServlet", urlPatterns = {"/users"})
public class UserListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UserDAO userDAO = new UserDAO(); 
        
        // Get current user
        cookieUtil cookie = new cookieUtil();
        String currentUserID = cookie.getCookie(request, cookie.user);
        User user = null;
        if(currentUserID != null){
            user = userDAO.getUserById(Integer.parseInt(currentUserID));
            request.setAttribute("user", user);
        }
        if(user == null){
            request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request, response);
            return;
        }
        
        // Get all users from the DAO
        List<User> userList = userDAO.getAllUsers();
        
        // Set the user list as a request attribute
        request.setAttribute("userList", userList);
               
        // Forward to the JSP page
        request.getRequestDispatcher("WEB-INF/views/user-list.jsp").forward(request, response);
    }
} 