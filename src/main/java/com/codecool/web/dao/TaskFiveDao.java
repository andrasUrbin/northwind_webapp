package com.codecool.web.dao;

import com.codecool.web.model.TaskFive;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TaskFiveDao extends AbstractDao {

    public TaskFiveDao(Connection connection) {
        super(connection);
    }

    public List<TaskFive> loadUnfilteredData() throws SQLException {
        List<TaskFive> taskFiveList = new ArrayList<>();
        String sql = "SELECT suppliers.company_name, products.product_name, products.unit_price " +
            "FROM products " +
            "JOIN suppliers " +
            "ON suppliers.supplier_id = products.supplier_id " +
            "JOIN (SELECT products.supplier_id, MAX(products.unit_price) AS max_unit FROM products " +
            "GROUP BY products.supplier_id) AS temp_values ON products.supplier_id = temp_values.supplier_id AND products.unit_price = temp_values.max_unit " +
            "ORDER BY unit_price DESC;";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                TaskFive task = new TaskFive(
                    resultSet.getString("company_name"),
                    resultSet.getString("product_name"),
                    resultSet.getDouble("unit_price"));
                taskFiveList.add(task);
            }
        }
        return taskFiveList;
    }

    public List<TaskFive> loadFilteredData(String companyName) throws SQLException {
        List<TaskFive> taskFiveList = new ArrayList<>();
        String sql = "SELECT suppliers.company_name, products.product_name, products.unit_price " +
            "FROM products " +
            "JOIN suppliers " +
            "ON suppliers.supplier_id = products.supplier_id " +
            "JOIN (SELECT products.supplier_id, MAX(products.unit_price) AS max_unit FROM products " +
            "GROUP BY products.supplier_id) AS temp_values ON products.supplier_id = temp_values.supplier_id AND products.unit_price = temp_values.max_unit " +
            "WHERE company_name LIKE ? " +
            "ORDER BY unit_price DESC;";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, "%" + companyName + "%");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                TaskFive task = new TaskFive(
                    resultSet.getString("company_name"),
                    resultSet.getString("product_name"),
                    resultSet.getDouble("unit_price"));
                taskFiveList.add(task);
            }

        } return taskFiveList;

    }
}
