package controller;

import dao.MaterialDAO;
import entity.Material;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/materials")
public class MaterialServlet extends HttpServlet {

    private MaterialDAO materialDAO;

    @Override
    public void init() {
        materialDAO = new MaterialDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Material> materials = materialDAO.getAll();
        request.setAttribute("materials", materials);
        request.getRequestDispatcher("jsp/createMaterial.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String code = request.getParameter("code");
        String unit = request.getParameter("unit");
        double price = Double.parseDouble(request.getParameter("price"));

        Material material = new Material(0, name, code, unit, price);
        materialDAO.insert(material);

        response.sendRedirect("materials"); // Refresh danh sách sau khi thêm
    }
}
