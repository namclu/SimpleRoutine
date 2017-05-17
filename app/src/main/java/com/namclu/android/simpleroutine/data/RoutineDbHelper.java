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
            "CREATE TABLE " + RoutineEntry.TABLE_NAME + "(" +
                    RoutineEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    RoutineEntry.COLUMN_ROUTINE_NAME + " TEXT NOT NULL, " +
                    RoutineEntry.COLUMN_ROUTINE_DATE + " STRING, " +
                    RoutineEntry.COLUMN_ROUTINE_FREQUENCY + " STRING NOT NULL, " +
                    RoutineEntry.COLUMN_ROUTINE_COMPLETED + " INTEGER NOT NULL DEFAULT 0, " +
                    RoutineEntry.COLUMN_ROUTINE_STREAK + " INTEGER DEFAULT 0);";

    public RoutineDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    /**
     * Called when the database is created for the first time.
     */
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SQL_CREATE_ROUTINES_TABLE);
    }

    /**
     * Called when the database needs to be upgraded.
     */
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
