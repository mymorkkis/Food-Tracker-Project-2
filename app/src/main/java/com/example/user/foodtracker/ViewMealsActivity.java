package com.example.user.foodtracker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import java.util.ArrayList;

/**
 * Created by user on 13/11/2016.
 */

public class ViewMealsActivity extends AppCompatActivity {

    FoodTrackerDatabase mFoodTrackerDatabase;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.activity_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_input_meal_link) {
            Intent intentInput = new Intent(ViewMealsActivity.this, InputMealActivity.class);
            startActivity(intentInput);
            return true;
        }
        if (item.getItemId() == R.id.action_view_meals_link) {
            Intent intentShow = new Intent(ViewMealsActivity.this, ViewMealsActivity.class);
            startActivity(intentShow);
            return true;
        }
        if (item.getItemId() == R.id.action_search_meals_link) {
            Intent intentShow = new Intent(ViewMealsActivity.this, SearchMealsActivity.class);
            startActivity(intentShow);
            return true;
        }
        if (item.getItemId() == R.id.action_edit_meals_link) {
            Intent intentEdit = new Intent(ViewMealsActivity.this, EditMealsActivity.class);
            startActivity(intentEdit);
            return true;
        }
        if (item.getItemId() == R.id.action_delete_meals_link) {
            Intent intentEdit = new Intent(ViewMealsActivity.this, DeleteMealsActivity.class);
            startActivity(intentEdit);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_meals);
        mFoodTrackerDatabase = new FoodTrackerDatabase(this);

        ArrayList<Meal> results = mFoodTrackerDatabase.getAllMeals();
        StringBuffer buffer = new StringBuffer();
        for (Meal result : results) {
            buffer.append("Name: " + result.getName() + "\n");
            buffer.append("Type: " + result.getType() + "\n");
            buffer.append("Calories: " + result.getCalories() + "\n");
            buffer.append("Date: " + result.getDate() + "\n\n");

        }
        showMessage("Previous Meals", buffer.toString());

    }

    public void showMessage(String title, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }

}
