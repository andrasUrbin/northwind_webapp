package com.codecool.web.servlet;

import com.codecool.web.dao.TaskOneDao;
import com.codecool.web.service.TaskOneService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet("/TaskOneServlet")
public class TaskOneServlet extends AbstractServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (Connection connection = getConnection(req.getServletContext())) {
            TaskOneDao taskOneDao = new TaskOneDao(connection);
            TaskOneService taskOneService = new TaskOneService(taskOneDao);
            req.setAttribute("data", taskOneService.loadUnfilteredTaskOneData());

        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
        req.getRequestDispatcher("task_one.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (Connection connection = getConnection(req.getServletContext())) {
            TaskOneDao taskOneDao = new TaskOneDao(connection);
            TaskOneService taskOneService = new TaskOneService(taskOneDao);
            String companyName = req.getParameter("company");
            req.setAttribute("data", taskOneService.loadFilteredTaskOneData(companyName));

        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
        req.getRequestDispatcher("task_one.jsp").forward(req, resp);
    }

}
