package com.example.user.foodtracker;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by user on 12/11/2016.
 */

public class FoodTest {

    Food foodItem;
    Food foodItem2;
    Food foodItem3;

    @Before
    public void before() {
        foodItem = new Food("White Rice", 300);
        foodItem2 = new Food("Black Beans", 450);
        foodItem3 = new Food("Banana", 175);
    }

    @Test
    public void testGetFoodName() {
        assertEquals("White Rice", foodItem.getName());
    }

    @Test
    public void testGetFoodCalories() {
        assertEquals(450, foodItem2.getCalories());
    }

}
