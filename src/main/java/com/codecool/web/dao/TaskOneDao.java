package com.codecool.web.dao;

import com.codecool.web.model.TaskOne;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TaskOneDao extends AbstractDao {

    public TaskOneDao(Connection connection) {
        super(connection);
    }

    public List<TaskOne> loadUnfilteredData() throws SQLException {
        List<TaskOne> taskOneList = new ArrayList<>();
        String sql = "SELECT products.product_name AS Product, " +
            "suppliers.company_name AS Company " +
            "FROM products " +
            "INNER JOIN suppliers " +
            "ON products.supplier_id=suppliers.supplier_id " +
            "ORDER BY 1, 2;";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                TaskOne task = new TaskOne(
                    resultSet.getString("product"),
                    resultSet.getString("company"));
                taskOneList.add(task);
            }
        }
        return taskOneList;
    }

    public List<TaskOne> loadFilteredData(String companyName) throws SQLException {
        List<TaskOne> taskOneList = new ArrayList<>();
        String sql = "SELECT products.product_name AS Product, " +
            "suppliers.company_name AS Company " +
            "FROM products " +
            "inner JOIN suppliers " +
            "ON products.supplier_id=suppliers.supplier_id " +
            "WHERE company_name LIKE ? " +
            "ORDER BY 1, 2;";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, "%" + companyName + "%");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                TaskOne task = new TaskOne(
                    resultSet.getString("product"),
                    resultSet.getString("company"));
                taskOneList.add(task);
            }

        } return taskOneList;

    }
}
