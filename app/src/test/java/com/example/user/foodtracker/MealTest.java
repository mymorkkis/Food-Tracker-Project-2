package com.example.user.foodtracker;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.Assert.assertEquals;

/**
 * Created by user on 12/11/2016.
 */

public class MealTest {

    Meal meal;
    Food foodItem;
    Food foodItem2;
    Food foodItem3;

    @Before
    public void before() {
        meal = new Meal("Fish & Chips", MealType.LUNCH);
        foodItem = new Food("White Rice", 300);
        foodItem2 = new Food("Black Beans", 450);
        foodItem3 = new Food("Banana", 175);
    }

    @Test
    public void testGetMealName() {
        assertEquals("Fish & Chips", meal.getName());
    }

    @Test
    public void testGetMealType() {
        assertEquals(MealType.LUNCH, meal.getType());
    }

//    @Test
//    public void testGetFoodItems() {
//        assertEquals(, meal.getFoodItems());
//    }

    @Test
    public void testFoodInputToMeal() {
        meal.addFoodItem(foodItem);
        assertEquals(1, meal.foodItemsCount());
    }
}
