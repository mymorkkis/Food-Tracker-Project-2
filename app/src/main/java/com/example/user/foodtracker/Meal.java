package com.example.user.foodtracker;

/**
 * Created by user on 14/11/2016.
 */

public class Meal {

    private int mId;
    private String mName;
    private String mType;
    private int mCalories;

    public Meal() {

    }

    public Meal(int id, String name, String type, int calories) {
        this.mId = id;
        this.mName = name;
        this.mType = type;
        this.mCalories = calories;
    }

    public Meal(String name, String type, int calories) {
        this.mName = name;
        this.mType = type;
        this.mCalories = calories;
    }

    public void setId(int id) {
        this.mId = id;
    }

    public void setName(String name) {
        this.mName = name;
    }

    public void setType(String type) {
        this.mType = type;
    }

    public void setCalories(int calories) {
        this.mCalories = calories;
    }

    public int getId() {
        return this.mId;
    }

    public String getName() {
        return this.mName;
    }

    public String getType() {
        return this.mType;
    }

    public int getCalories() {
        return this.mCalories;
    }


    @Override
    public String toString() {
        return "Meals [id=" + mId +", name=" + mName +
                ", type=" + mType + ", calories=" + mCalories + "]";
    }
}
