package com.example.user.foodtracker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by user on 15/11/2016.
 */

public class DeleteMealsActivity extends AppCompatActivity {


    FoodTrackerDatabase mFoodTrackerDatabase;
    Button mBtnDeleteAllMeals;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.activity_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_input_meal_link) {
            Intent intentInput = new Intent(DeleteMealsActivity.this, InputMealActivity.class);
            startActivity(intentInput);
            return true;
        }
        if (item.getItemId() == R.id.action_view_meals_link) {
            Intent intentShow = new Intent(DeleteMealsActivity.this, ViewMealsActivity.class);
            startActivity(intentShow);
            return true;
        }
        if (item.getItemId() == R.id.action_search_meals_link) {
            Intent intentShow = new Intent(DeleteMealsActivity.this, SearchMealsActivity.class);
            startActivity(intentShow);
            return true;
        }
        if (item.getItemId() == R.id.action_edit_meals_link) {
            Intent intentEdit = new Intent(DeleteMealsActivity.this, EditMealsActivity.class);
            startActivity(intentEdit);
            return true;
        }
        if (item.getItemId() == R.id.action_delete_meals_link) {
            Intent intentEdit = new Intent(DeleteMealsActivity.this, DeleteMealsActivity.class);
            startActivity(intentEdit);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_meal);
        mFoodTrackerDatabase = new FoodTrackerDatabase(this);
        Toast.makeText(DeleteMealsActivity.this,
                "WARNING! You will lose all of your information if you click that button!!!",
                Toast.LENGTH_LONG).show();

        mBtnDeleteAllMeals = (Button) findViewById(R.id.button_delete_all_meals);


        mBtnDeleteAllMeals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mFoodTrackerDatabase.deleteAllMeals();
                Toast.makeText(DeleteMealsActivity.this,
                        "Today is the first day of the rest of your life!", Toast.LENGTH_LONG).show();

                Intent intentInput = new Intent(DeleteMealsActivity.this, FoodTrackerMainActivity.class);
                startActivity(intentInput);
            }
        });
    }

}
