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
    private static final String[] COLUMNS = {KEY_ID,KEY_NAME,KEY_TYPE,KEY_CALORIES};

    public FoodTrackerDatabase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_MEALS_TABLE = "CREATE TABLE meals ( " +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "name TEXT, "+
                "type TEXT, " +
                "calories INTEGER)";

        db.execSQL(CREATE_MEALS_TABLE);
    }
//check this later
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS meals");

        this.onCreate(db);
    }

    public void addMeal(Meal meal){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, meal.getName());
        values.put(KEY_TYPE, meal.getType());
        values.put(KEY_CALORIES, meal.getCalories());

        db.insert(TABLE_NAME, null, values);

        db.close();
    }

    public Meal getMeal(int id){

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor =
                db.query(TABLE_NAME, COLUMNS, " id = ?", new String[] { String.valueOf(id) },
                        null, null, null, null);

        if (cursor != null)
            cursor.moveToFirst();

        Meal meal = new Meal((Integer.parseInt(cursor.getString(0))),
                cursor.getString(0), cursor.getString(2), (Integer.parseInt(cursor.getString(3))));

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



//    public static final String DATABASE_NAME = "food_tracker.db";
//    public static final String TABLE_NAME = "meals";
//    public static final String COL_1 = "ID";
//    public static final String COL_2 = "NAME";
//    public static final String COL_3 = "TYPE";
//    public static final String COL_4 = "CALORIES";
//
//
//
//    public FoodTrackerDatabase(Context context) {
//        super(context, DATABASE_NAME, null, 1);
//    }
//
//    @Override
//    public void onCreate(SQLiteDatabase myDatabase) {
//        myDatabase.execSQL("create table " + TABLE_NAME +
//                "(ID INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT, TYPE TEXT, CALORIES INTEGER)" );
//    }
//
//    @Override
//    public void onUpgrade(SQLiteDatabase myDatabase, int oldVersion, int newVersion) {
//        myDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
//        onCreate(myDatabase);
//    }
//
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
//
//    public Cursor getAllData() {
//        SQLiteDatabase mMyDatabase = this.getReadableDatabase();
//        Cursor result = mMyDatabase.rawQuery("SELECT * FROM " + TABLE_NAME +
//                " ORDER BY ID DESC", null);
//        return result;
//    }
//
////    public Cursor getTotalCalories() {
////        SQLiteDatabase mMyDatabase = this.getReadableDatabase();
////        Cursor resultCalories = mMyDatabase.rawQuery("SELECT SUM(CALORIES) FROM " + TABLE_NAME,
////                null);
////        return resultCalories;
////    }
//
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
