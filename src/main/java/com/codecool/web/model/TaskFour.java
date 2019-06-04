package com.codecool.web.model;

public class TaskFour{

    private String companyName;
    private Short[] orderIds;

    public TaskFour(String companyName, Short[] orderIds) {
        this.companyName = companyName;
        this.orderIds = orderIds;
    }

    public String getCompanyName() {
        return companyName;
    }

    public Short[] getOrderIds() {
        return orderIds;
    }
}
