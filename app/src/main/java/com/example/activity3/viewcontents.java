package com.example.activity3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class viewcontents extends AppCompatActivity {

    DBHelper mydb;
    ListView my_list;
    Button b_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewcontents);

        my_list = findViewById(R.id.list);
        b_btn = findViewById(R.id.back_btn);
        mydb = new DBHelper(this);
        ArrayList<String> thelist = new ArrayList<>();
        Cursor data = mydb.getlist();
        if(data.getCount() == 0)
        {
            Toast.makeText(this, "the db is empty", Toast.LENGTH_SHORT).show();
        }
        else
        {
            while(data.moveToNext())
            {
                thelist.add(data.getString(1));
                ListAdapter listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,thelist);
                my_list.setAdapter(listAdapter);
            }

        }

        b_btn.setOnClickListener(view->{
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        });


    }
}