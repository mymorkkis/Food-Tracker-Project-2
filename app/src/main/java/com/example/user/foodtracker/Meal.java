package com.example.user.foodtracker;


import java.util.ArrayList;

/**
 * Created by user on 12/11/2016.
 */

public class Meal {

//    private int id;
    private String name;
    private MealType type;
    private ArrayList<Food> foodItems;

    public Meal(String name, MealType type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return this.name;
    }

    public Enum getType() {
        return this.type;
    }
}
