package com.codecool.web.dao;

import com.codecool.web.model.TaskFour;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TaskFourDao extends AbstractDao {

    public TaskFourDao(Connection connection) {
        super(connection);
    }

    public List<TaskFour> loadUnfilteredData() throws SQLException {
        List<TaskFour> taskFourList = new ArrayList<>();
        String sql = "SELECT company_name AS company, ARRAY_AGG(orders.order_id) AS order_id " +
            "FROM customers " +
            "LEFT JOIN orders " +
            "ON customers.customer_id = orders.customer_id " +
            "GROUP BY company_name " +
            "ORDER BY company_name ASC; ";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                TaskFour task = new TaskFour(
                    resultSet.getString("company"),
                    (Short[]) resultSet.getArray("order_id").getArray());
                taskFourList.add(task);
            }
        }
        return taskFourList;
    }

    public List<TaskFour> loadFilteredData(String companyName) throws SQLException {
        List<TaskFour> taskFourList = new ArrayList<>();
        String sql = "SELECT company_name AS company, ARRAY_AGG(orders.order_id) AS order_id " +
            "FROM customers " +
            "LEFT JOIN orders " +
            "ON customers.customer_id = orders.customer_id " +
            "WHERE company_name LIKE ? " +
            "GROUP BY company_name " +
            "ORDER BY company_name ASC; ";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, "%" + companyName + "%");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                TaskFour task = new TaskFour(
                    resultSet.getString("company"),
                    (Short[]) resultSet.getArray("order_id").getArray());
                taskFourList.add(task);
            }

        } return taskFourList;

    }
}
