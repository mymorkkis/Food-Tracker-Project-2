package com.example.user.foodtracker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by user on 16/11/2016.
 */

public class SearchMealsActivity extends AppCompatActivity {

    FoodTrackerDatabase mFoodTrackerDatabase;
    ListView mListView;
//    Button mBtnViewAllMeals, mBtnCountMeals;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.activity_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_input_meal_link) {
            Intent intentInput = new Intent(SearchMealsActivity.this, InputMealActivity.class);
            startActivity(intentInput);
            return true;
        }
        if (item.getItemId() == R.id.action_view_meals_link) {
            Intent intentShow = new Intent(SearchMealsActivity.this, ViewMealsActivity.class);
            startActivity(intentShow);
            return true;
        }
        if (item.getItemId() == R.id.action_search_meals_link) {
            Intent intentShow = new Intent(SearchMealsActivity.this, SearchMealsActivity.class);
            startActivity(intentShow);
            return true;
        }
        if (item.getItemId() == R.id.action_edit_meals_link) {
            Intent intentEdit = new Intent(SearchMealsActivity.this, EditMealsActivity.class);
            startActivity(intentEdit);
            return true;
        }
        if (item.getItemId() == R.id.action_delete_meals_link) {
            Intent intentEdit = new Intent(SearchMealsActivity.this, DeleteMealsActivity.class);
            startActivity(intentEdit);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_meals);
        mFoodTrackerDatabase = new FoodTrackerDatabase(this);

        mListView = (ListView)findViewById(R.id.search_meals);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, getAllItemsAsString());

        mListView.setAdapter(adapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selected = (String)mListView.getItemAtPosition(position);
                Intent intentInput = new Intent(SearchMealsActivity.this, EditMealsActivity.class);
//                intentInput.putExtra("item", selected);
                startActivity(intentInput);
            }
        });

    }

    public ArrayList<String> getAllItemsAsString() {
        ArrayList<Meal> allMeals = mFoodTrackerDatabase.getAllMeals();
        ArrayList<String> allItems = new ArrayList<>();

        for (Meal meal : allMeals) {
            allItems.add(meal.getName() + " / " + meal.getType() + " / " +
                    String.valueOf(meal.getCalories()) + " kcal / " + meal.getDate());
        }
        return allItems;
    }


}
