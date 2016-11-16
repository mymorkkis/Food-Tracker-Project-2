package com.example.user.foodtracker;

/**
 * Created by user on 14/11/2016.
 */

public class Meal {

    private int mId;
    private String mName;
    private String mType;
    private int mCalories;
    private String mDate;

    public Meal() {

    }

    public Meal(int id, String name, String type, int calories, String date) {
        this.mId = id;
        this.mName = name;
        this.mType = type;
        this.mCalories = calories;
        this.mDate = date;
    }

    public Meal(String name, String type, int calories, String date) {
        this.mName = name;
        this.mType = type;
        this.mCalories = calories;
        this.mDate = date;
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

    public void setDate(String date) {
        this.mDate = date;
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

    public String getDate() {
        return this.mDate;
    }

}
