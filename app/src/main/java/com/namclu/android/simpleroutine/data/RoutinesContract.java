package com.namclu.android.simpleroutine.data;

import android.provider.BaseColumns;

/**
 * Created by namlu on 5/17/2017.
 *
 * Database schema for a Routines table
 */

public class RoutinesContract {

    // To prevent someone from accidentally instantiating the contract class,
    // give it an empty constructor.
    private RoutinesContract() {

    }

    // Inner class that defines the table contents
    public static abstract class RoutineEntry implements BaseColumns {

        /*
         * Column headers
         * */
        // Name of the db table for routines
        public static final String TABLE_NAME = "routines";

        // Unique ID for pet, Type: INTEGER
        public static final String _ID = BaseColumns._ID;

        // Name of the routine, Type: STRING
        public static final String COLUMN_ROUTINE_NAME = "routine";

        // Date when the routine occurs, Type: STRING
        public static final String COLUMN_ROUTINE_DATE = "date";

        // How often the routine occurs, Type: STRING
        public static final String COLUMN_ROUTINE_FREQUENCY = "frequency";

        // Has routine been completed?, Type: INTEGER
        public static final String COLUMN_ROUTINE_COMPLETED = "completed";

        // Days in a row routine has been completed, Type: INTEGER
        public static final String COLUMN_ROUTINE_STREAK = "streak";

        /*
         * Possible values for columns FREQUENCY and COMPLETED
         * */
        // Possible values for COLUMN_ROUTINE_FREQUENCY
        public static final String FREQUENCY_DAILY = "daily";
        public static final String FREQUENCY_WEEKLY = "weekly";
        public static final String FREQUENCY_BIWEEKLY = "biweekly";

        // Possible values for COLUMN_ROUTINE_COMPLETED
        public static final int COMPLETED_NO = 0;
        public static final int COMPLETED_YES = 1;
    }
}
