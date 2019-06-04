package com.codecool.web.servlet;

import com.codecool.web.dao.TaskThreeDao;
import com.codecool.web.service.TaskThreeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet("/TaskThreeServlet")
public class TaskThreeServlet extends AbstractServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (Connection connection = getConnection(req.getServletContext())) {
            TaskThreeDao taskThreeDao = new TaskThreeDao(connection);
            TaskThreeService taskThreeService = new TaskThreeService(taskThreeDao);
            req.setAttribute("data", taskThreeService.loadUnfilteredTaskThreeData());

        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
        req.getRequestDispatcher("task_three.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (Connection connection = getConnection(req.getServletContext())) {
            TaskThreeDao taskThreeDao = new TaskThreeDao(connection);
            TaskThreeService taskThreeService = new TaskThreeService(taskThreeDao);
            String companyName = req.getParameter("company");
            req.setAttribute("data", taskThreeService.loadFilteredTaskThreeData(companyName));

        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
        req.getRequestDispatcher("task_three.jsp").forward(req, resp);
    }
}
