package com.codecool.web.dao;

import com.codecool.web.model.TaskThree;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TaskThreeDao extends AbstractDao {

    public TaskThreeDao(Connection connection) {
        super(connection);
    }

    public List<TaskThree> loadUnfilteredData() throws SQLException {
        List<TaskThree> taskThreeList = new ArrayList<>();
        String sql = "SELECT company_name AS Company " +
            "FROM suppliers " +
            "INNER JOIN products " +
            "ON suppliers.supplier_id = products.supplier_id " +
            "GROUP BY company_name " +
            "HAVING COUNT(products.product_name) = 5 " +
            "ORDER BY COUNT(products.product_name) DESC;";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                TaskThree task = new TaskThree(
                    resultSet.getString("company"));
                taskThreeList.add(task);
            }
        }
        return taskThreeList;
    }

    public List<TaskThree> loadFilteredData(String companyName) throws SQLException {
        List<TaskThree> taskThreeList = new ArrayList<>();
        String sql = "SELECT company_name AS Company " +
            "FROM suppliers " +
            "INNER JOIN products " +
            "ON suppliers.supplier_id = products.supplier_id " +
            "WHERE company_name LIKE ? " +
            "GROUP BY company_name " +
            "HAVING COUNT(products.product_name) = 5 " +
            "ORDER BY COUNT(products.product_name) DESC;";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, "%" + companyName + "%");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                TaskThree task = new TaskThree(
                    resultSet.getString("company"));
                taskThreeList.add(task);
            }

        } return taskThreeList;

    }
}
