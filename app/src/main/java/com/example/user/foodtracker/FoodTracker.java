package com.example.user.foodtracker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

/**
 * Created by user on 13/11/2016.
 */

public class FoodTracker extends AppCompatActivity {

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.activity_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_input_meal_link) {
            Intent intentInput = new Intent(FoodTracker.this, InputMealActivity.class);
            startActivity(intentInput);
            return true;
        }
        if (item.getItemId() == R.id.action_view_meals_link) {
            Intent intentShow = new Intent(FoodTracker.this, ViewMealsActivity.class);
            startActivity(intentShow);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
