package com.example.quranapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class surahList extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TextView t = findViewById(R.id.textView2);
        setContentView(R.layout.activity_surah_list);
        ListView surahListView = findViewById(R.id.surahList);
        DBHelper dbHelper  = new DBHelper(surahList.this);
        ArrayList<surahModel>  s =  dbHelper.getAllSurahs();
        surahAdapter adapter = new surahAdapter(this, s);
        t.setText(String.valueOf(s.size())+"");
        surahListView.setAdapter(adapter);
        // convert integer to string

    }
}