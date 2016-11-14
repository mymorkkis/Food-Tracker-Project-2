package com.example.user.foodtracker;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by user on 13/11/2016.
 */

public class FoodTrackerDatabase extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "food_tracker.db";
    public static final String TABLE_NAME = "meals";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "NAME";
    public static final String COL_3 = "TYPE";
    public static final String COL_4 = "CALORIES";



    public FoodTrackerDatabase(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase myDatabase) {
        myDatabase.execSQL("create table " + TABLE_NAME +
                "(ID INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT, TYPE TEXT, CALORIES INTEGER)" );
    }

    @Override
    public void onUpgrade(SQLiteDatabase myDatabase, int oldVersion, int newVersion) {
        myDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(myDatabase);
    }

    public boolean insertData(String name, String type, String calories) {
        SQLiteDatabase mMyDatabase = this.getReadableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2, name);
        contentValues.put(COL_3, type);
        contentValues.put(COL_4, calories);
        long result = mMyDatabase.insert(TABLE_NAME, null, contentValues);
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    public Cursor getAllData() {
        SQLiteDatabase mMyDatabase = this.getReadableDatabase();
        Cursor result = mMyDatabase.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        return result;
    }

}
