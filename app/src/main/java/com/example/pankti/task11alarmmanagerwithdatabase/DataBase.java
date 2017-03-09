package com.example.pankti.task11alarmmanagerwithdatabase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


class DataBase extends SQLiteOpenHelper {
    static String DATABASE_NAME="alarmdata";
    public static final String TABLE_NAME="alarm";
    public static final String KEY_ENAME="name";
    public static final String KEY_DATE="date";
    public static final String KEY_TIME="time";
    public static final String KEY_ID="id";
    public DataBase(Context context) {
        super(context, DATABASE_NAME, null, 1);
}
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE="CREATE TABLE "+TABLE_NAME+" ("+KEY_ID+" INTEGER PRIMARY KEY, "+KEY_ENAME+" TEXT, "+KEY_DATE+" TEXT, "+KEY_TIME+" TEXT)";
        db.execSQL(CREATE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);

    }

}

