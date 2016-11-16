package com.example.user.foodtracker;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by user on 13/11/2016.
 */

public class FoodTrackerDatabase extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "food_tracker.db";
    private static final String TABLE_NAME = "meals";
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_TYPE = "type";
    private static final String KEY_CALORIES = "calories";
    private static final String KEY_DATE = "date";
    private static final String[] COLUMNS = {KEY_ID,KEY_NAME,KEY_TYPE,KEY_CALORIES,KEY_DATE};

    public FoodTrackerDatabase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_MEALS_TABLE = "CREATE TABLE meals ( " +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "name TEXT, " +
                "type TEXT, " +
                "calories INTEGER, " +
                "date TEXT)";

        db.execSQL(CREATE_MEALS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS meals");

        this.onCreate(db);
    }

//    public void addMeal(Meal meal){
//        SQLiteDatabase db = this.getWritableDatabase();
//
//        ContentValues values = new ContentValues();
//        values.put(KEY_NAME, meal.getName());
//        values.put(KEY_TYPE, meal.getType());
//        values.put(KEY_CALORIES, meal.getCalories());
//
//        db.insert(TABLE_NAME, null, values);
//
//        db.close();
//    }

    public boolean addMeal(Meal meal){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, meal.getName());
        values.put(KEY_TYPE, meal.getType());
        values.put(KEY_CALORIES, meal.getCalories());
        values.put(KEY_DATE, meal.getDate());

        long result = db.insert(TABLE_NAME, null, values);

        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

//    public boolean insertData(String name, String type, String calories) {
//        SQLiteDatabase mMyDatabase = this.getReadableDatabase();
//        ContentValues contentValues = new ContentValues();
//        contentValues.put(COL_2, name);
//        contentValues.put(COL_3, type);
//        contentValues.put(COL_4, calories);
//        long result = mMyDatabase.insert(TABLE_NAME, null, contentValues);
//        if (result == -1) {
//            return false;
//        } else {
//            return true;
//
//        }
//    }

//    public Meal getLatestEntry() {
//        String query = "SELECT * FROM " + TABLE_NAME + " WHERE id = MAX(id)";
//
//        SQLiteDatabase db = this.getWritableDatabase();
//        Cursor cursor = db.rawQuery(query, null);
//
//        Meal meal = null;
//        meal = new Meal();
//        meal.setId(Integer.parseInt(cursor.getString(0)));
//        meal.setName(cursor.getString(1));
//        meal.setType(cursor.getString(2));
//        meal.setCalories(Integer.parseInt(cursor.getString(3)));
//
//        return meal;
//    }

    public Meal getMeal(int id){

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor =
                db.query(TABLE_NAME, COLUMNS, " id = ?", new String[] { String.valueOf(id) },
                        null, null, null, null);

        if (cursor != null)
            cursor.moveToFirst();

        Meal meal = new Meal((Integer.parseInt(cursor.getString(0))),
                cursor.getString(0), cursor.getString(2),
                (Integer.parseInt(cursor.getString(3))), cursor.getString(4));

        return meal;
    }

    public ArrayList<Meal> getAllMeals() {
        ArrayList<Meal> allMeals = new ArrayList<>();

        String query = "SELECT  * FROM " + TABLE_NAME + " ORDER BY ID DESC";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        Meal meal = null;
        if (cursor.moveToFirst()) {
            do {
                meal = new Meal();
                meal.setId(Integer.parseInt(cursor.getString(0)));
                meal.setName(cursor.getString(1));
                meal.setType(cursor.getString(2));
                meal.setCalories(Integer.parseInt(cursor.getString(3)));
                meal.setDate(cursor.getString(4));

                allMeals.add(meal);
            } while (cursor.moveToNext());
        }
        return allMeals;
    }

    public int countAllMeals() {
        String countQuery = "SELECT * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();

        return cursor.getCount();
    }

    public int updateMeal(Meal meal) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, meal.getName());
        values.put(KEY_TYPE, meal.getType());
        values.put(KEY_CALORIES, meal.getCalories());
        values.put(KEY_DATE, meal.getDate());

        return db.update(TABLE_NAME, values, KEY_ID + " = ?",
                new String[] {String.valueOf(meal.getId())});
    }

    public void deleteMeal(Meal meal) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME, KEY_ID + " = ?",
                new String[] { String.valueOf(meal.getId())});
        db.close();
    }

    public void deleteAllMeals() {
        SQLiteDatabase db = this.getReadableDatabase();
        db.delete(TABLE_NAME, null, null);
        db.close();
    }

//
//    public Cursor getTotalCalories() {
//        SQLiteDatabase mMyDatabase = this.getReadableDatabase();
//        Cursor resultCalories = mMyDatabase.rawQuery("SELECT SUM(CALORIES) FROM " + TABLE_NAME,
//                null);
//        return resultCalories;
//    }

////    public boolean updateLastMeal(String id, String name, String type, String calories) {
////        SQLiteDatabase foodTrackerDatabase = this.getWritableDatabase();
////        ContentValues contentValues = new ContentValues();
////        contentValues.put(COL_1, id);
////        contentValues.put(COL_2, name);
////        contentValues.put(COL_3, type);
////        contentValues.put(COL_4, calories);
////        foodTrackerDatabase.update(TABLE_NAME, contentValues, "ID = (SELECT MAX(ID))", new String[]{id});
////        return true;
////    }

}
