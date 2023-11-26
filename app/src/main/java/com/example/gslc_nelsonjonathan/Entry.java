package com.example.gslc_nelsonjonathan;

public abstract class Entry {
    private String name;
    private int amount;
    private double calories;

    public Entry(String name, int amount, double calories) {
        this.name = name;
        this.amount = amount;
        this.calories = calories * amount;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public void setCalories(double calories) {
        this.calories = this.amount * calories;
    }

    public double getCalories() {
        return calories;
    }

    public abstract String getDetails();
}
