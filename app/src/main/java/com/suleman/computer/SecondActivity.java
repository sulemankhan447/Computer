package com.suleman.computer;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class SecondActivity extends AppCompatActivity {
    DatabaseHelper databaseHelper = new DatabaseHelper(this);
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        SQLiteDatabase sqLiteDatabase = databaseHelper.getWritableDatabase();
        Cursor todoCursor = sqLiteDatabase.rawQuery(DatabaseHelper.SELECT_DATA,null);
        TodoCursorAdapter todoCursorAdapter =  new TodoCursorAdapter(this,todoCursor);
        listView = (ListView)findViewById(R.id.listView);
        listView.setAdapter(todoCursorAdapter);;
        todoCursorAdapter.changeCursor(todoCursor);
    }
}
