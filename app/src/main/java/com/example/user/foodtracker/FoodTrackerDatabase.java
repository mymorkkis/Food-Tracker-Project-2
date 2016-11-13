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
    public static final String COL_1 = "ID";
    public static final String COL_1 = "NAME";
    public static final String COL_1 = "TYPE";
    public static final String COL_1 = "CALORIES";



    public FoodTrackerDatabase(Context context) {
        super(context, DATABASE_NAME, null, 1);
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table " + TABLE_NAME +
                "(ID INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT, TYPE TEXT, CALORIES INTEGER)" );
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(sqLiteDatabase);
    }
}
