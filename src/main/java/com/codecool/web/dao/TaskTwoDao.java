package com.codecool.web.dao;

import com.codecool.web.model.TaskTwo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TaskTwoDao extends AbstractDao {

    public TaskTwoDao(Connection connection) {
        super(connection);
    }

    public List<TaskTwo> loadUnfilteredData() throws SQLException {
        List<TaskTwo> taskTwoList = new ArrayList<>();
        String sql = "SELECT company_name AS Company, " +
            "COUNT(*) AS NumberOfProducts " +
            "FROM suppliers " +
            "INNER JOIN products " +
            "ON suppliers.supplier_id = products.supplier_id " +
            "GROUP BY company_name " +
            "ORDER BY numberofproducts DESC;";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                TaskTwo task = new TaskTwo(
                    resultSet.getString("company"),
                    resultSet.getInt("number_of_products"));
                    taskTwoList.add(task);
            }
        }
        return taskTwoList;
    }

    public List<TaskTwo> loadFilteredData(String companyName) throws SQLException {
        List<TaskTwo> taskTwoList = new ArrayList<>();
        String sql = "SELECT company_name AS Company, " +
            "COUNT(*) AS NumberOfProducts " +
            "FROM suppliers " +
            "INNER JOIN products " +
            "ON suppliers.supplier_id = products.supplier_id " +
            "WHERE company_name LIKE ? " +
            "GROUP BY company_name " +
            "ORDER BY numberofproducts DESC;";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, "%" + companyName + "%");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                TaskTwo task = new TaskTwo(
                    resultSet.getString("company"),
                    resultSet.getInt("numberofproducts"));
                taskTwoList.add(task);
            }

        } return taskTwoList;

    }
}
