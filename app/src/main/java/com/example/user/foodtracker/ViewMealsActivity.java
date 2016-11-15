package com.example.user.foodtracker;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by user on 13/11/2016.
 */

public class ViewMealsActivity extends AppCompatActivity {

    FoodTrackerDatabase mFoodTrackerDatabase;
    Button mBtnViewAllMeals, mBtnCountMeals;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_meals);
        mFoodTrackerDatabase = new FoodTrackerDatabase(this);

        mBtnViewAllMeals = (Button)findViewById(R.id.button_view_meals);


        mBtnViewAllMeals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                ArrayList<Meal> results = mFoodTrackerDatabase.getAllMeals();
                StringBuffer buffer = new StringBuffer();
                for (Meal result : results) {
                            buffer.append("Name :" + result.getName() + "\n");
                            buffer.append("Type :" + result.getType() + "\n");
                            buffer.append("Calories :" + result.getCalories() + "\n\n");
                        }
                        showMessage("Previous Meals", buffer.toString());
            }
        });

        mBtnCountMeals = (Button)findViewById(R.id.button_count_meals);

        mBtnCountMeals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int count = mFoodTrackerDatabase.countAllMeals();
                Toast.makeText(ViewMealsActivity.this,
                       "You've eaten " + count + " meals!", Toast.LENGTH_LONG).show();
            }
        });
    }

    public void showMessage(String title, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }



    //    public void viewAllMeals() {
//        mBtnViewAllMeals.setOnClickListener(
//                new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        Cursor result = mFoodTrackerDatabase.getMeals();
//                        if (result.getCount() == 0) {
//                            showMessage("ERROR", "No Data Found");
//                            return;
//                        }
//                        StringBuffer buffer = new StringBuffer();
//                        while (result.moveToNext()) {
//                            buffer.append("Name :" + result.getString(1) + "\n");
//                            buffer.append("Type :" + result.getString(2) + "\n");
//                            buffer.append("Calories :" + result.getString(3) + "\n\n");
//
//                        }
//                        showMessage("Previous Meals", buffer.toString());
//                    }
//                }
//        );
//    }



}
