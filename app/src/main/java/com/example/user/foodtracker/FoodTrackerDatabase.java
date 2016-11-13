package com.example.user.foodtracker;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by user on 13/11/2016.
 */

public class FoodTrackerDatabase extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "food_tracker.db";
    public static final String TABLE_NAME = "meals";
    public static final String COL_1 = "id";
    public static final String COL_1 = "name";
    public static final String COL_1 = "type";
    public static final String COL_1 = "calories";



    public FoodTrackerDatabase(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
