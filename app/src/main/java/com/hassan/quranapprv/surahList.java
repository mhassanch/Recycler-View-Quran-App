package com.hassan.quranapprv;

import android.os.Build;
import android.os.Bundle;
import android.widget.ListView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class surahList extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_surah_list);
        ListView surahListView = findViewById(R.id.surahList);
        DBHelper dbHelper  = new DBHelper(surahList.this);
        ArrayList<surahModel>  s =  dbHelper.getAllSurahs();
        surahAdapter adapter = new surahAdapter(this, s);
        surahListView.setAdapter(adapter);

        // convert integer to string

    }
}