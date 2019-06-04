package com.codecool.web.servlet;

import com.codecool.web.dao.TaskFiveDao;
import com.codecool.web.service.TaskFiveService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet("/TaskFiveServlet")
public class TaskFiveServlet extends AbstractServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (Connection connection = getConnection(req.getServletContext())) {
            TaskFiveDao taskFiveDao = new TaskFiveDao(connection);
            TaskFiveService taskFiveService = new TaskFiveService(taskFiveDao);
            req.setAttribute("data", taskFiveService.loadUnfilteredTaskFiveData());

        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
        req.getRequestDispatcher("task_five.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (Connection connection = getConnection(req.getServletContext())) {
            TaskFiveDao taskFiveDao = new TaskFiveDao(connection);
            TaskFiveService taskFiveService = new TaskFiveService(taskFiveDao);
            String companyName = req.getParameter("company");
            req.setAttribute("data", taskFiveService.loadFilteredTaskFiveData(companyName));

        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
        req.getRequestDispatcher("task_five.jsp").forward(req, resp);
    }
}
