//
//
//import java.lang.reflect.Array;
//import java.util.ArrayList;
//
///**
// * Created by user on 12/11/2016.
// */
//
//public class Meal {
//
////    private int id?;
//    private String mName;
//    private MealType mType;
//    private ArrayList<Food> mFoodItems;
////    private FoodTrackerDatabase mFoodTrackerDatabase;
//
//    public Meal(String mName, MealType mType) {
//        this.mName = mName;
//        this.mType = mType;
//        mFoodItems = new ArrayList<>();
//    }
//
//    public String getName() {
//        return this.mName;
//    }
//
//    public Enum getType() {
//        return this.mType;
//    }
//
//    public boolean addFoodItem(Food foodItem) {
//        mFoodItems.add(foodItem);
//        return true;
//    }
//
//    public int foodItemsCount() {
//        return mFoodItems.size();
//    }
//
//    public int totalMealCalories() {
//        int counter = 0;
//        for ( Food item : mFoodItems ) {
//            counter += item.getCalories();
//        }
//        return counter;
//    }
//
//    public void insertData() {
//
//    }
//
//}

package com.example.user.foodtracker;

import java.util.ArrayList;

/**
 * Created by user on 14/11/2016.
 */

public class Meal {

    private int mId;
    private String mName;
    private String mType;
    private int mCalories;

//    public Meal(int id, String name, String type, int calories) {
//        super();
//        this.mId = id;
//        this.mName = name;
//        this.mType = type;
//        this.mCalories = calories;
//    }

    public Meal() {

    }

    public Meal(int id, String name, String type, int calories) {
//        super();
        this.mId = id;
        this.mName = name;
        this.mType = type;
        this.mCalories = calories;
    }

    public Meal(String name, String type, int calories) {
//        super();
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
