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

    @Before
    public void before() {
        meal = new Meal("Rice & Beans", "Lunch", 655, "13/07/1999");
    }

    @Test
    public void testGetMealName() {
        assertEquals("Rice & Beans", meal.getName());
    }

    @Test
    public void testGetMealType() {
        assertEquals("Lunch", meal.getType());
    }

    @Test
    public void testGetCalories() {
        assertEquals(655, meal.getCalories());
    }

    @Test
    public void testTotalCaloriesForMeal() {
       assertEquals("13/07/1999", meal.getDate());
    }

}
