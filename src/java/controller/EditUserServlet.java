package controller;

import dao.RoleDAO;
import dao.UserDAO;
import entity.Role;
import entity.User;
import java.io.IOException;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "EditUserServlet", urlPatterns = {"/EditUser"})
public class EditUserServlet extends HttpServlet {

    /**
     * Handles the HTTP GET method to display the edit user form.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Get the user ID from the request
        String userIdParam = request.getParameter("userId");
        
        if (userIdParam != null && !userIdParam.isEmpty()) {
            try {
                int userId = Integer.parseInt(userIdParam);
                
                // Get the user by ID
                UserDAO userDAO = new UserDAO();
                User user = userDAO.getUserById(userId);
                
                if (user != null) {
                    // Get all roles for the dropdown
                    RoleDAO roleDAO = new RoleDAO();
                    List<Role> roles = roleDAO.getAllRoles();
                    
                    // Set attributes for the JSP
                    request.setAttribute("user", user);
                    request.setAttribute("roles", roles);
                    
                    // Forward to the edit user JSP
                    request.getRequestDispatcher("WEB-INF/views/edit-user.jsp").forward(request, response);
                    return;
                } else {
                    request.getSession().setAttribute("error", "User not found");
                }
            } catch (NumberFormatException e) {
                request.getSession().setAttribute("error", "Invalid user ID format");
            }
        } else {
            request.getSession().setAttribute("error", "User ID is required");
        }
        
        // Redirect back to the user list if there was an error
        response.sendRedirect("users");
    }
    
    /**
     * Handles the HTTP POST method to process the edit user form submission.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Get parameters from the form
        String userIdParam = request.getParameter("userId");
        String fullName = request.getParameter("fullName");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String roleIdParam = request.getParameter("roleId");
        String statusParam = request.getParameter("status");
        
        // Validate required fields
        if (userIdParam == null || userIdParam.isEmpty() ||
            fullName == null || fullName.isEmpty() ||
            email == null || email.isEmpty() ||
            address == null || address.isEmpty() ||
            roleIdParam == null || roleIdParam.isEmpty()) {
            
            request.getSession().setAttribute("error", "All fields are required");
            response.sendRedirect("EditUser?userId=" + userIdParam);
            return;
        }
        
        try {
            // Parse ID values
            int userId = Integer.parseInt(userIdParam);
            int roleId = Integer.parseInt(roleIdParam);
            boolean status = "1".equals(statusParam);
            
            // Get the role
            RoleDAO roleDAO = new RoleDAO();
            Role role = roleDAO.getRoleById(roleId);
            
            if (role == null) {
                request.getSession().setAttribute("error", "Selected role not found");
                response.sendRedirect("EditUser?userId=" + userId);
                return;
            }
            
            // Create and populate the user object
            User user = new User();
            user.setId(userId);
            user.setFullName(fullName);
            user.setEmail(email);
            user.setAddress(address);
            user.setRole(role);
            user.setActive(status);
            
            // Update the user
            UserDAO userDAO = new UserDAO();
            boolean updated = userDAO.updateUser(user);
            
            if (updated) {
                request.getSession().setAttribute("message", "User updated successfully");
                response.sendRedirect("users");
            } else {
                request.getSession().setAttribute("error", "Failed to update user");
                response.sendRedirect("EditUser?userId=" + userId);
            }
        } catch (NumberFormatException e) {
            request.getSession().setAttribute("error", "Invalid ID format");
            response.sendRedirect("users");
        }
    }
} 