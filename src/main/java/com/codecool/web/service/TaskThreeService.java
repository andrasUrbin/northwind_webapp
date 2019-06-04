package com.codecool.web.service;

import com.codecool.web.dao.TaskThreeDao;
import com.codecool.web.model.TaskThree;

import java.sql.SQLException;
import java.util.List;

public class TaskThreeService {

    private TaskThreeDao taskThreeDao;

    public TaskThreeService(TaskThreeDao taskThreeDao) {
        this.taskThreeDao = taskThreeDao;
    }

    public List<TaskThree> loadUnfilteredTaskThreeData() throws SQLException {
        return taskThreeDao.loadUnfilteredData();
    }

    public List<TaskThree> loadFilteredTaskThreeData(String companyName) throws SQLException {
        return taskThreeDao.loadFilteredData(companyName);
    }
}

