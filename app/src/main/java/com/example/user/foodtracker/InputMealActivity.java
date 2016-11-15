package com.example.user.foodtracker;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
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
    EditText mEditName, mEditType, mEditCalories;
    Spinner mSpinnerType;
    Button mBtnAddMeal, mBtnEditLastMeal;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_meal);
        mFoodTrackerDatabase = new FoodTrackerDatabase(this);

        //casting
        mEditName = (EditText) findViewById(R.id.text_to_save_name);
//        mEditType = (EditText)findViewById(R.id.text_to_save_type);
        mSpinnerType = (Spinner) findViewById(R.id.spinner_meal_type);
        mEditCalories = (EditText) findViewById(R.id.text_to_save_calories);
        mBtnAddMeal = (Button) findViewById(R.id.button_input_meal);
        mBtnEditLastMeal = (Button) findViewById(R.id.button_edit_meal);

        String[] mealTypes = new String[]{"Breakfast", "Lunch", "Dinner", "Snack", "Drink"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this, android.R.layout.simple_spinner_dropdown_item, mealTypes);
        mSpinnerType.setAdapter(adapter);

        mBtnAddMeal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String choice = mSpinnerType.getSelectedItem().toString();
                int calories = Integer.parseInt(mEditCalories.getText().toString());
                meal = new Meal(mEditName.getText().toString(), choice, calories);
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

//        mBtnEditLastMeal.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Meal lastMeal = mFoodTrackerDatabase.getLatestEntry();
//                mEditName.setText(lastMeal.getName());
//                mEditCalories.setText(lastMeal.getCalories());
//            }
//        });

    }

}
