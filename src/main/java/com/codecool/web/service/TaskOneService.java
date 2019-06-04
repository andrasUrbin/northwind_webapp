package com.codecool.web.service;

import com.codecool.web.dao.TaskOneDao;
import com.codecool.web.model.TaskOne;

import java.sql.SQLException;
import java.util.List;

public class TaskOneService {

    private TaskOneDao taskOneDao;

    public TaskOneService(TaskOneDao taskOneDao) {
        this.taskOneDao = taskOneDao;
    }

    public List<TaskOne> loadUnfilteredTaskOneData() throws SQLException {
        return taskOneDao.loadUnfilteredData();
    }

    public List<TaskOne> loadFilteredTaskOneData(String companyName) throws SQLException {
        return taskOneDao.loadFilteredData(companyName);
    }
}
