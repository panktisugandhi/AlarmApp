package com.example.pankti.task11alarmmanagerwithdatabase;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private DataBase db;
    private ListView listView;
    private Button button;
    private SQLiteDatabase dataBase;
    private ArrayList<String> id = new ArrayList<String>();
    private ArrayList<String> name = new ArrayList<String>();
    private ArrayList<String> date = new ArrayList<String>();
    private ArrayList<String> time = new ArrayList<String>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = getIntent();
        db = new DataBase(this);
        listView = (ListView) findViewById(R.id.listview);
        button = (Button) findViewById(R.id.btnadd);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inbtn = new Intent(MainActivity.this, AddAlarm.class);
                startActivity(inbtn);
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {

                Intent idata = new Intent(getApplicationContext(), MainActivity.class);
                idata.putExtra("Name", name.get(arg2));
                idata.putExtra("Date", date.get(arg2));
                idata.putExtra("Time", time.get(arg2));
                idata.putExtra("ID", id.get(arg2));
                startActivity(idata);
                displayData();
            }
        });

    }
    private void displayData() {
        dataBase = db.getWritableDatabase();
        Cursor mCursor = dataBase.rawQuery("SELECT * FROM " + DataBase.TABLE_NAME, null);

        id.clear();
        name.clear();
        date.clear();
        time.clear();
        if (mCursor.moveToFirst()) {
            do {
                id.add(mCursor.getString(mCursor.getColumnIndex(DataBase.KEY_ID)));
                name.add(mCursor.getString(mCursor.getColumnIndex(DataBase.KEY_ENAME)));
                date.add(mCursor.getString(mCursor.getColumnIndex(DataBase.KEY_DATE)));
                time.add(mCursor.getString(mCursor.getColumnIndex(DataBase.KEY_TIME)));
            } while (mCursor.moveToNext());
        }
        AlarmAdapter disadpt = new AlarmAdapter(MainActivity.this,id,name,date,time);
        listView.setAdapter(disadpt);
        mCursor.close();
    }

}
