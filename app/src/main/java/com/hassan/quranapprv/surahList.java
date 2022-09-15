package com.hassan.quranapprv;


import android.os.Build;
import android.os.Bundle;
import android.widget.ListView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class surahList extends AppCompatActivity {

    RecyclerView rv;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_surah_list);
        ListView surahListView = findViewById(R.id.surahList);
        DBHelper dbHelper  = new DBHelper(surahList.this);
        ArrayList<surahModel>  s =  dbHelper.getAllSurahs();
        /*surahAdapter adapter = new surahAdapter(this, s);
        surahListView.setAdapter(adapter);*/
        rv = findViewById(R.id.surahRV);
        rv.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(surahList.this,
                LinearLayoutManager.HORIZONTAL,
                true);
        rv.setLayoutManager(layoutManager);

        adapter = new surahRVAdapter(s) ;
        rv.setAdapter(adapter);

        // convert integer to string

    }
}