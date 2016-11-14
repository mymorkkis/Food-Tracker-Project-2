package com.example.user.foodtracker;

import java.util.ArrayList;

/**
 * Created by user on 14/11/2016.
 */

public class Meals {

    private int mId;
    private String mName;
    private String mType;
    private int mCalories;

//    public Meals(String mName, String mType, int mCalories) {
//        super();
//        this.mName = mName;
//        this.mType = mType;
//        this.mCalories = mCalories;
//    }

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
