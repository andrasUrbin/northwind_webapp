package com.codecool.web.service;

import com.codecool.web.dao.TaskTwoDao;
import com.codecool.web.model.TaskTwo;

import java.sql.SQLException;
import java.util.List;

public class TaskTwoService {

    private TaskTwoDao taskTwoDao;

    public TaskTwoService(TaskTwoDao taskTwoDao) {
        this.taskTwoDao = taskTwoDao;
    }

    public List<TaskTwo> loadUnfilteredTaskTwoData() throws SQLException {
        return taskTwoDao.loadUnfilteredData();
    }

    public List<TaskTwo> loadFilteredTaskTwoData(String companyName) throws SQLException {
        return taskTwoDao.loadFilteredData(companyName);
    }
}
