package com.codecool.web.model;

public class TaskOne {

    private String productName;
    private String companyName;

    public TaskOne(String productName, String companyName) {
        super();
        this.productName = productName;
        this.companyName = companyName;
    }

    public String getProductName() {
        return productName;
    }

    public String getCompanyName() {
        return companyName;
    }
}
