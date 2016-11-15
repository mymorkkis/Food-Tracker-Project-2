package com.example.user.foodtracker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by user on 15/11/2016.
 */

public class DeleteMealsActivity extends AppCompatActivity {


    FoodTrackerDatabase mFoodTrackerDatabase;
    Button mBtnDeleteAllMeals;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_meal);
        mFoodTrackerDatabase = new FoodTrackerDatabase(this);
        Toast.makeText(DeleteMealsActivity.this,
                "WARNING! You will lose all of your information if you delete all meals",
                Toast.LENGTH_LONG).show();

        mBtnDeleteAllMeals = (Button) findViewById(R.id.button_delete_all_meals);


        mBtnDeleteAllMeals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mFoodTrackerDatabase.deleteAllMeals();
                Toast.makeText(DeleteMealsActivity.this,
                        "All Meals Deleted!", Toast.LENGTH_SHORT).show();

                Intent intentInput = new Intent(DeleteMealsActivity.this, FoodTracker.class);

                startActivity(intentInput);
            }
        });
    }

}
