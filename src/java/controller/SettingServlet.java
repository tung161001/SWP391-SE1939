package controller;

import dao.SettingDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import entity.Setting;
import java.io.IOException;
import java.util.List;

@WebServlet("/settings")
public class SettingServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        SettingDAO dao = new SettingDAO();
        List<Setting> settings = dao.getAll();
        request.setAttribute("settings", settings);
        request.getRequestDispatcher("/settingList.jsp").forward(request, response);
    }
}
