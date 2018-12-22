package com.suleman.computer;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edtComputerName;
    EditText edtComputerType;
    Button btnAdd;
    Button btnMove;
    Button btnDelete;
    DatabaseHelper databaseHelper = new DatabaseHelper(this);
    SQLiteDatabase sqLiteDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtComputerName = (EditText)findViewById(R.id.edtComputerName);
        edtComputerType = (EditText)findViewById(R.id.edtComputerType);
        btnAdd = (Button)findViewById(R.id.btnAdd);
        btnMove = (Button)findViewById(R.id.btnMove);
        btnDelete = (Button)findViewById(R.id.btnDelete);
         sqLiteDatabase  = databaseHelper.getWritableDatabase();

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContentValues contentValues = new ContentValues();
                contentValues.put(DatabaseHelper.COMPUTER_NAME,edtComputerName.getText().toString());
                contentValues.put(DatabaseHelper.COMPUTER_TYPE,edtComputerType.getText().toString());
                long rowId = sqLiteDatabase.insert(DatabaseHelper.TABLE_NAME,null,contentValues);
                Toast.makeText(MainActivity.this,"Inserted Row id is "+rowId,Toast.LENGTH_SHORT).show();
            }
        });
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseHelper.deleteEntries(sqLiteDatabase);
                Toast.makeText(MainActivity.this,"All Entries Deleted From db",Toast.LENGTH_SHORT).show();
            }
        });
        btnMove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,SecondActivity.class));
            }
        });
    }
}
