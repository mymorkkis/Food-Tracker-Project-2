package com.example.user.foodtracker;


import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by user on 12/11/2016.
 */

public class Meal {

//    private int id?;
    private String mName;
    private MealType mType;
    private ArrayList<Food> mFoodItems;

    public Meal(String mName, MealType mType) {
        this.mName = mName;
        this.mType = mType;
        mFoodItems = new ArrayList<>();
    }

    public String getName() {
        return this.mName;
    }

    public Enum getType() {
        return this.mType;
    }

    public boolean addFoodItem(Food foodItem) {
        mFoodItems.add(foodItem);
        return true;
    }

    public int foodItemsCount() {
        return mFoodItems.size();
    }

    public int totalMealCalories() {
        int counter = 0;
        for ( Food item : mFoodItems ) {
            counter += item.getCalories();
        }
        return counter;
    }
}
