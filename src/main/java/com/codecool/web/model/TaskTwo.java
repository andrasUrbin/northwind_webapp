package com.codecool.web.model;

public class TaskTwo {

    private String companyName;
    private int numberOfProducts;

    public TaskTwo(String companyName, int numberOfProducts) {
        this.companyName = companyName;
        this.numberOfProducts = numberOfProducts;
    }

    public String getCompanyName() {
        return companyName;
    }

    public int getNumberOfProducts() {
        return numberOfProducts;
    }
}
