package com.example.user.foodtracker;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by user on 13/11/2016.
 */

public class InputMealActivity extends AppCompatActivity {

    FoodTrackerDatabase mFoodTrackerDatabase;
    EditText mEditName, mEditType, mEditCalories;
    Button mBtnAddMeal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_meal);
        mFoodTrackerDatabase = new FoodTrackerDatabase(this);

        //casting
        mEditName = (EditText)findViewById(R.id.text_to_save_name);
        mEditType = (EditText)findViewById(R.id.text_to_save_type);
        mEditCalories = (EditText)findViewById(R.id.text_to_save_calories);
        mBtnAddMeal = (Button)findViewById(R.id.button_input_meal);
        AddMeal();
    }

    public void AddMeal() {
        mBtnAddMeal.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        boolean isInsterted = mFoodTrackerDatabase.insertData(
                                mEditName.getText().toString(), mEditType.getText().toString(),
                                mEditCalories.getText().toString());
                        if(isInsterted == true) {
                            Toast.makeText(InputMealActivity.this,
                                    "Meal Inserted!", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            Toast.makeText(InputMealActivity.this,
                                    "WARNING! Meal Not Inserted", Toast.LENGTH_LONG).show();
                        }
                    }
                }
        );
    }

}
