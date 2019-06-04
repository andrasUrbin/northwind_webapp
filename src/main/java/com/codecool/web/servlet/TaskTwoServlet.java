package com.codecool.web.servlet;

import com.codecool.web.dao.TaskTwoDao;
import com.codecool.web.service.TaskTwoService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet("/TaskTwoServlet")
public class TaskTwoServlet extends AbstractServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (Connection connection = getConnection(req.getServletContext())) {
            TaskTwoDao taskTwoDao = new TaskTwoDao(connection);
            TaskTwoService taskTwoService = new TaskTwoService(taskTwoDao);
            req.setAttribute("data", taskTwoService.loadUnfilteredTaskTwoData());

        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
        req.getRequestDispatcher("task_two.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (Connection connection = getConnection(req.getServletContext())) {
            TaskTwoDao taskTwoDao = new TaskTwoDao(connection);
            TaskTwoService taskTwoService = new TaskTwoService(taskTwoDao);
            String companyName = req.getParameter("company");
            req.setAttribute("data", taskTwoService.loadFilteredTaskTwoData(companyName));

        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
        req.getRequestDispatcher("task_two.jsp").forward(req, resp);
    }
}
