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

@WebServlet(name = "AddUserServlet", urlPatterns = {"/AddUser"})
public class AddUserServlet extends HttpServlet {

    /**
     * Handles the HTTP GET method to display the add user form.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Get all roles for the dropdown
        RoleDAO roleDAO = new RoleDAO();
        List<Role> roles = roleDAO.getAllRoles();
        
        // Set attributes for the JSP
        request.setAttribute("roles", roles);
        
        // Forward to the add user JSP
        request.getRequestDispatcher("WEB-INF/views/add-user.jsp").forward(request, response);
    }
    
    /**
     * Handles the HTTP POST method to process the add user form submission.
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
        String fullName = request.getParameter("fullName");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirmPassword");
        String roleIdParam = request.getParameter("roleId");
        String statusParam = request.getParameter("status");
        
        // Validate required fields
        if (fullName == null || fullName.isEmpty() ||
            email == null || email.isEmpty() ||
            address == null || address.isEmpty() ||
            password == null || password.isEmpty() ||
            confirmPassword == null || confirmPassword.isEmpty() ||
            roleIdParam == null || roleIdParam.isEmpty()) {
            
            request.getSession().setAttribute("error", "All fields are required");
            response.sendRedirect("AddUser");
            return;
        }
        
        // Validate password match
        if (!password.equals(confirmPassword)) {
            request.getSession().setAttribute("error", "Passwords do not match");
            response.sendRedirect("AddUser");
            return;
        }
        
        try {
            // Parse ID values
            int roleId = Integer.parseInt(roleIdParam);
            boolean status = "1".equals(statusParam);
            
            // Get the role
            RoleDAO roleDAO = new RoleDAO();
            Role role = roleDAO.getRoleById(roleId);
            
            if (role == null) {
                request.getSession().setAttribute("error", "Selected role not found");
                response.sendRedirect("AddUser");
                return;
            }
            
            // Create and populate the user object
            User user = new User();
            user.setFullName(fullName);
            user.setEmail(email);
            user.setAddress(address);
            user.setRole(role);
            user.setActive(status);
            
            // Add the user
            UserDAO userDAO = new UserDAO();
            boolean inserted = userDAO.insertUser(user, password);
            
            if (inserted) {
                request.getSession().setAttribute("message", "User added successfully");
                response.sendRedirect("users");
            } else {
                request.getSession().setAttribute("error", "Failed to add user");
                response.sendRedirect("AddUser");
            }
        } catch (NumberFormatException e) {
            request.getSession().setAttribute("error", "Invalid role ID format");
            response.sendRedirect("AddUser");
        }
    }
} 