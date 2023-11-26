package com.example.gslc_nelsonjonathan;

public class FoodEntry extends Entry {
    public FoodEntry(String name, int amount, double calories) {
        super(name, amount, calories);
    }

    @Override
    public String getDetails() {
        return super.getName() + " - " + super.getCalories() + " calories" + super.getAmount() + " Amount";
    }

    @Override
    public String toString() {
        return getDetails();
    }
}
