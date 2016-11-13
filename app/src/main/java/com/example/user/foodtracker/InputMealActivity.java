package com.example.user.foodtracker;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by user on 13/11/2016.
 */

public class InputMealActivity extends AppCompatActivity {

    FoodTrackerDatabase foodTrackerDatabase;
    EditText editName, editType, editCalories;
    Button btnAddMeal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_meal);
        foodTrackerDatabase = new FoodTrackerDatabase(this);

        //casting
        editName = (EditText)findViewById(R.id.text_to_save_name);
        editType = (EditText)findViewById(R.id.text_to_save_type);
        editCalories = (EditText)findViewById(R.id.text_to_save_calories);
        btnAddMeal = (Button)findViewById(R.id.button_input_meal);
    }

    public void AddData() {
    }

}
