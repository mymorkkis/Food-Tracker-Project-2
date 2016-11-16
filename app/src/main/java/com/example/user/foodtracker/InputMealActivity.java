package com.example.user.foodtracker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

/**
 * Created by user on 13/11/2016.
 */

public class InputMealActivity extends AppCompatActivity {

    FoodTrackerDatabase mFoodTrackerDatabase;
    Meal meal;
    EditText mEditName, mEditCalories, mEditDate;
    Spinner mSpinnerType;
    Button mBtnAddMeal;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.activity_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_input_meal_link) {
            Intent intentInput = new Intent(InputMealActivity.this, InputMealActivity.class);
            startActivity(intentInput);
            return true;
        }
        if (item.getItemId() == R.id.action_view_meals_link) {
            Intent intentShow = new Intent(InputMealActivity.this, ViewMealsActivity.class);
            startActivity(intentShow);
            return true;
        }
        if (item.getItemId() == R.id.action_search_meals_link) {
            Intent intentShow = new Intent(InputMealActivity.this, SearchMealsActivity.class);
            startActivity(intentShow);
            return true;
        }
        if (item.getItemId() == R.id.action_edit_meals_link) {
            Intent intentEdit = new Intent(InputMealActivity.this, EditMealsActivity.class);
            startActivity(intentEdit);
            return true;
        }
        if (item.getItemId() == R.id.action_delete_meals_link) {
            Intent intentEdit = new Intent(InputMealActivity.this, DeleteMealsActivity.class);
            startActivity(intentEdit);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_meal);
        mFoodTrackerDatabase = new FoodTrackerDatabase(this);

        mEditName = (EditText) findViewById(R.id.text_to_save_name);
        mSpinnerType = (Spinner) findViewById(R.id.spinner_meal_type);
        mEditCalories = (EditText) findViewById(R.id.text_to_save_calories);
        mEditDate = (EditText) findViewById(R.id.text_to_save_date);
        mBtnAddMeal = (Button) findViewById(R.id.button_input_meal);

        String[] mealTypes = new String[]{"Breakfast", "Lunch", "Dinner", "Snack", "Drink"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this, android.R.layout.simple_spinner_dropdown_item, mealTypes);
        mSpinnerType.setAdapter(adapter);

        mBtnAddMeal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String choice = mSpinnerType.getSelectedItem().toString();
                int calories = Integer.parseInt(mEditCalories.getText().toString());
                meal = new Meal(mEditName.getText().toString(), choice, calories,
                        mEditDate.getText().toString());
                boolean isInsterted = mFoodTrackerDatabase.addMeal(meal);
                if(isInsterted == true) {
                    Toast.makeText(InputMealActivity.this,
                            "Meal Inserted!", Toast.LENGTH_SHORT).show();
                    Intent intentInput = new Intent(InputMealActivity.this, InputMealActivity.class);
                    startActivity(intentInput);
                }
                else {
                    Toast.makeText(InputMealActivity.this,
                            "WARNING! Meal Not Inserted", Toast.LENGTH_LONG).show();
                }
            }
        });

    }

}
