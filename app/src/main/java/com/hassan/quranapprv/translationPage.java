package com.hassan.quranapprv;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class translationPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_translation_page);
        DBHelper dbHelper  = new DBHelper(translationPage.this);
        ListView ayatList = findViewById(R.id.translatedAyats);
        Intent i = this.getIntent();
        int tId = i.getIntExtra("tId",0);
        int sId = i.getIntExtra("sId",0);
        ArrayList<translationModel> s =  dbHelper.getTranslation(sId,tId);
        ayatAdapter adapter = new ayatAdapter(translationPage.this,s);
        ayatList.setAdapter(adapter);
    }
}