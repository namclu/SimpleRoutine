package com.namclu.android.simpleroutine;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.namclu.android.simpleroutine.data.RoutineDbHelper;
import com.namclu.android.simpleroutine.data.RoutinesContract.RoutineEntry;

public class SimpleRoutineActivity extends AppCompatActivity {

    private static final String TAG = SimpleRoutineActivity.class.getSimpleName();

    // Declare variable
    private RoutineDbHelper mDbHelper;
    private SQLiteDatabase mSQLiteDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Access database by instantiating a subclass of SQLiteOpenHelper
        mDbHelper = new RoutineDbHelper(this);

        // Add values to database
        insertRoutine();

        // Display values from database
        displayDatabase();
    }

    // Add a Routine to SimpleRoutine database
    public void insertRoutine() {

        // Get a writable database reference
        mSQLiteDatabase = mDbHelper.getWritableDatabase();

        // Create ContentValues object for a routine
        ContentValues values = new ContentValues();

        /* Routine #1 */
        values.put(RoutineEntry.COLUMN_ROUTINE_NAME, "Make bed");
        values.put(RoutineEntry.COLUMN_ROUTINE_DATE, "01 May, 2017");
        values.put(RoutineEntry.COLUMN_ROUTINE_FREQUENCY, RoutineEntry.FREQUENCY_DAILY);
        values.put(RoutineEntry.COLUMN_ROUTINE_COMPLETED, RoutineEntry.COMPLETED_NO);
        values.put(RoutineEntry.COLUMN_ROUTINE_STREAK, 5);

        // Insert a new row into database, returning ID of that new row
        long newRowId = mSQLiteDatabase.insert(RoutineEntry.TABLE_NAME, null, values);

        /* Routine #2 */
        values.put(RoutineEntry.COLUMN_ROUTINE_NAME, "Exercise");
        values.put(RoutineEntry.COLUMN_ROUTINE_DATE, "03 May, 2017");
        values.put(RoutineEntry.COLUMN_ROUTINE_FREQUENCY, RoutineEntry.FREQUENCY_WEEKLY);
        values.put(RoutineEntry.COLUMN_ROUTINE_COMPLETED, RoutineEntry.COMPLETED_YES);
        values.put(RoutineEntry.COLUMN_ROUTINE_STREAK, 2);

        // Insert a new row into database, returning ID of that new row
        newRowId = mSQLiteDatabase.insert(RoutineEntry.TABLE_NAME, null, values);

        /* Routine #3 */
        values.put(RoutineEntry.COLUMN_ROUTINE_NAME, "Coding");
        values.put(RoutineEntry.COLUMN_ROUTINE_DATE, "20 April, 2017");
        values.put(RoutineEntry.COLUMN_ROUTINE_FREQUENCY, RoutineEntry.FREQUENCY_BIWEEKLY);
        values.put(RoutineEntry.COLUMN_ROUTINE_COMPLETED, RoutineEntry.COMPLETED_YES);
        values.put(RoutineEntry.COLUMN_ROUTINE_STREAK, 15);

        // Insert a new row into database, returning ID of that new row
        newRowId = mSQLiteDatabase.insert(RoutineEntry.TABLE_NAME, null, values);
    }

    // Display the database
    public void displayDatabase() {

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

        try {
            // Get the index of each column
            int idColumnIndex = cursor.getColumnIndex(RoutineEntry._ID);
            int nameColumnIndex = cursor.getColumnIndex(RoutineEntry.COLUMN_ROUTINE_NAME);
            int dateColumnIndex = cursor.getColumnIndex(RoutineEntry.COLUMN_ROUTINE_DATE);
            int frequencyColumnIndex = cursor.getColumnIndex(RoutineEntry.COLUMN_ROUTINE_FREQUENCY);
            int completedColumnIndex = cursor.getColumnIndex(RoutineEntry.COLUMN_ROUTINE_COMPLETED);
            int streakColumnIndex = cursor.getColumnIndex(RoutineEntry.COLUMN_ROUTINE_STREAK);

            // Get heading info
            Log.v(TAG, RoutineEntry._ID + " | " +
                    RoutineEntry.COLUMN_ROUTINE_NAME + " | " +
                    RoutineEntry.COLUMN_ROUTINE_DATE + " | " +
                    RoutineEntry.COLUMN_ROUTINE_FREQUENCY + " | " +
                    RoutineEntry.COLUMN_ROUTINE_COMPLETED + " | " +
                    RoutineEntry.COLUMN_ROUTINE_STREAK + "\n\n");

            // Get database info
            while (cursor.moveToNext()) {
                Log.v(TAG, cursor.getInt(idColumnIndex) + " | " +
                        cursor.getString(nameColumnIndex) + " | " +
                        cursor.getString(dateColumnIndex) + " | " +
                        cursor.getString(frequencyColumnIndex) + " | " +
                        cursor.getString(completedColumnIndex) + " | " +
                        cursor.getInt(streakColumnIndex) + "\n");
            }
        } finally {
            // Close the cursor when you're done reading from it.
            cursor.close();
        }
    }
}
