package com.example.user.foodtracker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import java.util.ArrayList;

/**
 * Created by user on 13/11/2016.
 */

public class FoodTracker extends AppCompatActivity {

    FoodTrackerDatabase mFoodTrackerDatabase;
    TextView mTextView;

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
        if (item.getItemId() == R.id.action_search_meals_link) {
            Intent intentShow = new Intent(FoodTracker.this, SearchMealsActivity.class);
            startActivity(intentShow);
            return true;
        }
        if (item.getItemId() == R.id.action_edit_meals_link) {
            Intent intentEdit = new Intent(FoodTracker.this, EditMealsActivity.class);
            startActivity(intentEdit);
            return true;
        }
        if (item.getItemId() == R.id.action_delete_meals_link) {
            Intent intentEdit = new Intent(FoodTracker.this, DeleteMealsActivity.class);
            startActivity(intentEdit);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mFoodTrackerDatabase = new FoodTrackerDatabase(this);
        mTextView = (TextView) findViewById(R.id.text_show_calories);
        mTextView.setText(getAllCalories());

    }

    public String getAllCalories() {
        int counter = 0;
        ArrayList<Meal> allMeals = mFoodTrackerDatabase.getAllMeals();
        for (Meal meal : allMeals) {
            counter += meal.getCalories();
        }
        String calorieTotal = "You have eaten a total of " + String.valueOf(counter)
                + " calories since the dawn of this app!";
        return calorieTotal;
    }
}
