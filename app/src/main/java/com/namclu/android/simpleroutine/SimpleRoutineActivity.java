package com.namclu.android.simpleroutine;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.namclu.android.simpleroutine.data.RoutineDbHelper;
import com.namclu.android.simpleroutine.data.RoutinesContract.RoutineEntry;

public class SimpleRoutineActivity extends AppCompatActivity {

    // Declare variable
    private RoutineDbHelper mDbHelper;
    private SQLiteDatabase mSQLiteDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Init variable

        // Add values to database

    }

    // Add a Routine to SimpleRoutine database
    public void insertRoutine() {

        // Get a writable database reference
        mSQLiteDatabase = mDbHelper.getWritableDatabase();

        // Create ContentValues object for a routine
        ContentValues values = new ContentValues();

        values.put(RoutineEntry.COLUMN_ROUTINE_NAME, "Make bed");
        values.put(RoutineEntry.COLUMN_ROUTINE_DATE, "01 May, 2017");
        values.put(RoutineEntry.COLUMN_ROUTINE_FREQUENCY, RoutineEntry.FREQUENCY_DAILY);
        values.put(RoutineEntry.COLUMN_ROUTINE_COMPLETED, RoutineEntry.COMPLETED_NO);
        values.put(RoutineEntry.COLUMN_ROUTINE_STREAK, 5);

        // Insert a new row into database, returning ID of that new row
        long newRowId = mSQLiteDatabase.insert(RoutineEntry.TABLE_NAME, null, values);
    }

    public void displayDatabase() {

        // Access database by instantiating a subclass of SQLiteOpenHelper
        mDbHelper = new RoutineDbHelper(this);

        // Get a readable database reference
        mSQLiteDatabase = mDbHelper.getReadableDatabase();

        // Get a Cursor that contains all rows from the pets table.
        Cursor cursor = mSQLiteDatabase.query(RoutineEntry.TABLE_NAME,
                null,
                null,
                null,
                null,
                null,
                null
        );

        // Get the index of each column
        int idColumnIndex = cursor.getColumnIndex(RoutineEntry._ID);
        int nameColumnIndex = cursor.getColumnIndex(RoutineEntry.COLUMN_ROUTINE_NAME);
        int dateColumnIndex = cursor.getColumnIndex(RoutineEntry.COLUMN_ROUTINE_DATE);
        int frequencyColumnIndex = cursor.getColumnIndex(RoutineEntry.COLUMN_ROUTINE_FREQUENCY);
        int completedColumnIndex = cursor.getColumnIndex(RoutineEntry.COLUMN_ROUTINE_COMPLETED);
        int streakColumnIndex = cursor.getColumnIndex(RoutineEntry.COLUMN_ROUTINE_STREAK);
    }
}
