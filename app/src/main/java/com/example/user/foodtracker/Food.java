package com.example.user.foodtracker;

/**
 * Created by user on 12/11/2016.
 */

public class Food {

//    private int id?;
    private String name;
    private int calories;
//    private int mealId?;

    public Food(String name, int calories) {
        this.name = name;
        this.calories = calories;
    }

    public String getName() {
        return this.name;
    }

    public int getCalories() {
        return this.calories;
    }

}
