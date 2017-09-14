package com.cars.models.viewModels;

public class CustomerSalesViewModel {

    private String name;

    private int boughtCarsCount;

    private double totalSpentMoney;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBoughtCarsCount() {
        return boughtCarsCount;
    }

    public void setBoughtCarsCount(int boughtCarsCount) {
        this.boughtCarsCount = boughtCarsCount;
    }

    public double getTotalSpentMoney() {
        return totalSpentMoney;
    }

    public void setTotalSpentMoney(double totalSpentMoney) {
        this.totalSpentMoney = totalSpentMoney;
    }
}
