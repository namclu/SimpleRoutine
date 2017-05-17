package com.namclu.android.simpleroutine.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.namclu.android.simpleroutine.data.RoutinesContract.RoutineEntry;

/**
 * Created by namlu on 5/17/2017.
 */

public class RoutineDbHelper extends SQLiteOpenHelper {

    private static final String TAG = RoutineDbHelper.class.getSimpleName();
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "habit_tracker.db";

    // String that contains the SQL statement to create the routineS table
    private static final String SQL_CREATE_ROUTINES_TABLE =
            "CREATE TABLE " + RoutineEntry.TABLE_NAME + "(" + ")";



    public RoutineDbHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
