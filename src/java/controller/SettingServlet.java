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

    private SettingDAO settingDAO;

    @Override
    public void init() {
        settingDAO = new SettingDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Setting> settings = settingDAO.getAll();
        request.setAttribute("settings", settings);
        request.getRequestDispatcher("/settingList.jsp").forward(request, response);
    }
}
