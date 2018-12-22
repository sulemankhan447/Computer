package com.suleman.computer;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "company.db";
    public static final String TABLE_NAME = "computer";
    public static final String ID = "_id";
    public static final String COMPUTER_NAME = "computer_name";
    public static final String COMPUTER_TYPE = "computer_type";
    public static final String CREATE_TABLE =
            "CREATE TABLE "+ TABLE_NAME+"("+ID+" INTEGER PRIMARY KEY,"+COMPUTER_NAME
            +" TEXT,"+COMPUTER_TYPE +" TEXT"+")";

    public static final String SELECT_DATA = "SELECT _id,"
            +COMPUTER_NAME+"," +COMPUTER_TYPE+" FROM "+TABLE_NAME;

    public DatabaseHelper(Context context) {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }
    public static void deleteEntries(SQLiteDatabase db){
        db.execSQL("DELETE FROM "+TABLE_NAME);

    }
}
