package fr.wildcodeschool.roomreservation;

import android.provider.BaseColumns;

/**
 * Created by wilder on 31/03/18.
 */

public class DBContact {
    public static class PersonEntry implements BaseColumns {
        public static final String TABLE_NAME = "Person";
        public static final String COLUMN_NAME_LASTNAME = "lastname";
        public static final String COLUMN_NAME_FIRSTNAME = "firstname";
    }
    public static class RoomEntry implements BaseColumns {
        public static final String TABLE_NAME = "Room";
        public static final String COLUMN_NAME = "name";
    }
}
