package com.hassan.quranapprv;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class translationMain extends AppCompatActivity {
    TextView heading;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_translation_main);
        ListView l = findViewById(R.id.surahList);
        heading = findViewById(R.id.theading);
        Intent i = this.getIntent();
        int translation = i.getIntExtra("translationId",0);
        if(translation == 1){
            heading.setText("Translation by Fatah Muhammad Jalandhry");
        }
        else if(translation == 2){
            heading.setText("Translation by Mehmood-ul-Hassan");
        }
        else if(translation == 3){
            heading.setText("Translation by Dr Mohsin Khan");
        }
        else if(translation == 4){
            heading.setText("Translation by Mufti Taqi Usmani");
        }
        DBHelper dbHelper  = new DBHelper(translationMain.this);
        ArrayList<surahModel>  s =  dbHelper.getAllSurahs();
        surahNameAdapter surahNameAdapter =new surahNameAdapter(this,s,translation);
        l.setAdapter(surahNameAdapter);
    }
}