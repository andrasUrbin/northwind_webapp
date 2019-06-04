package com.codecool.web.servlet;

import com.codecool.web.dao.TaskFourDao;
import com.codecool.web.service.TaskFourService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet("/TaskFourServlet")
public class TaskFourServlet extends AbstractServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (Connection connection = getConnection(req.getServletContext())) {
            TaskFourDao taskFourDao = new TaskFourDao(connection);
            TaskFourService taskFourService = new TaskFourService(taskFourDao);
            req.setAttribute("data", taskFourService.loadUnfilteredTaskFourData());

        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
        req.getRequestDispatcher("task_four.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (Connection connection = getConnection(req.getServletContext())) {
            TaskFourDao taskFourDao = new TaskFourDao(connection);
            TaskFourService taskFourService = new TaskFourService(taskFourDao);
            String companyName = req.getParameter("company");
            req.setAttribute("data", taskFourService.loadFilteredTaskFourData(companyName));

        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
        req.getRequestDispatcher("task_four.jsp").forward(req, resp);
    }
}
