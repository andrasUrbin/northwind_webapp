package com.codecool.web.service;

import com.codecool.web.dao.TaskFiveDao;
import com.codecool.web.model.TaskFive;

import java.sql.SQLException;
import java.util.List;

public class TaskFiveService {

    private TaskFiveDao taskFiveDao;

    public TaskFiveService(TaskFiveDao taskFiveDao) {
        this.taskFiveDao = taskFiveDao;
    }

    public List<TaskFive> loadUnfilteredTaskFiveData() throws SQLException {
        return taskFiveDao.loadUnfilteredData();
    }

    public List<TaskFive> loadFilteredTaskFiveData(String companyName) throws SQLException {
        return taskFiveDao.loadFilteredData(companyName);
    }
}
