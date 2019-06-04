package com.codecool.web.model;

public class TaskFive {

    private String companyName;
    private String productName;
    private double unitPrice;

    public TaskFive(String companyName, String productName, double unitPrice) {
        this.companyName = companyName;
        this.productName = productName;
        this.unitPrice = unitPrice;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getProductName() {
        return productName;
    }

    public double getUnitPrice() {
        return unitPrice;
    }
}
