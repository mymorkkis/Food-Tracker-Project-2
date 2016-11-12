package com.example.user.foodtracker;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by user on 12/11/2016.
 */

public class MealTest {

    Meal meal;

    @Before
    public void before() {
        meal = new Meal("Fish & Chips", MealType.LUNCH);
    }

    @Test
    public void testGetMealName() {
        assertEquals("Fish & Chips", meal.getName());
    }

    @Test
    public void testGetMealType() {
        assertEquals(MealType.LUNCH, meal.getType());
    }
}
