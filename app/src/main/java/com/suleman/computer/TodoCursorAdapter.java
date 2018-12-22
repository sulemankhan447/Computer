package com.suleman.computer;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

public class TodoCursorAdapter extends CursorAdapter {
    public TodoCursorAdapter(Context context,Cursor cursor){
        super(context,cursor,0);
    }
    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
            return LayoutInflater.from(context).inflate(R.layout.row,parent,false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView tvComputerName = (TextView)view.findViewById(R.id.tvComputerName);
        TextView tvComputerType = (TextView)view.findViewById(R.id.tvComputerType);
        String computerName = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.COMPUTER_NAME));
        String computerType = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.COMPUTER_TYPE));
        String id = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.ID));
        tvComputerName.setText(computerName);
        tvComputerType.setText(computerType);
    }
}
