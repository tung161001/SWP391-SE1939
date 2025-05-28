package controller;

import dao.MaterialDAO;
import entity.Material;
import utils.DBUtil;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.sql.Connection;
import java.util.List;

@WebServlet(name = "MaterialServlet", urlPatterns = {"/MaterialServlet"})
public class MaterialServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        try (Connection conn = DBUtil.getConnection()) {
            MaterialDAO dao = new MaterialDAO(conn);
            List<Material> list = dao.getAllMaterials();
            request.setAttribute("materials", list);
            request.getRequestDispatcher("materials.jsp").forward(request, response);
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String action = request.getParameter("action");
        try (Connection conn = DBUtil.getConnection()) {
            MaterialDAO dao = new MaterialDAO(conn);

            if ("create".equals(action)) {
                Material m = new Material();
                m.setName(request.getParameter("name"));
                m.setCode(request.getParameter("code"));
                m.setUnit(request.getParameter("unit"));
                m.setPrice(Double.parseDouble(request.getParameter("price")));
                m.setCategory(request.getParameter("category"));

                dao.create(m);
                response.sendRedirect("MaterialServlet");
            } else if ("filter".equals(action)) {
                String category = request.getParameter("category");
                List<Material> list = dao.filterByCategory(category);
                request.setAttribute("materials", list);
                request.getRequestDispatcher("materials.jsp").forward(request, response);
            }
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}
