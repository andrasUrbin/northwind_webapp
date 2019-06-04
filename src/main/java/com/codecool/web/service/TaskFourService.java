package com.codecool.web.service;

import com.codecool.web.dao.TaskFourDao;
import com.codecool.web.model.TaskFour;

import java.sql.SQLException;
import java.util.List;

public class TaskFourService {

    private TaskFourDao taskFourDao;

    public TaskFourService(TaskFourDao taskFourDao) {
        this.taskFourDao = taskFourDao;
    }

    public List<TaskFour> loadUnfilteredTaskFourData() throws SQLException {
        return taskFourDao.loadUnfilteredData();
    }

    public List<TaskFour> loadFilteredTaskFourData(String companyName) throws SQLException {
        return taskFourDao.loadFilteredData(companyName);
    }
}

