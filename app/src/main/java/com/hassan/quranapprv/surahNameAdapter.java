package com.hassan.quranapprv;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class surahNameAdapter extends ArrayAdapter {
    private final Activity Context;
    private final ArrayList<surahModel> surrahNames;
    private final int tId;

    public surahNameAdapter(Activity context, ArrayList<surahModel> surrahNames, int tId) {
        super(context,R.layout.surahname,surrahNames);
        Context = context;
        this.surrahNames = surrahNames;
        this.tId = tId;
    }

    public View getView(int position, View view, ViewGroup parent){
        LayoutInflater inflator = Context.getLayoutInflater();
        View Single = inflator.inflate(R.layout.surahname,null,true);
        TextView v =Single.findViewById(R.id.sNameT);
        TextView v1 = Single.findViewById(R.id.sIDT);
        TextView v2 = Single.findViewById(R.id.sNameET);
        v.setText(surrahNames.get(position).getSurahNameU());
        v1.setText(String.valueOf(surrahNames.get(position).getSurahID()));
        v2.setText(surrahNames.get(position).getSurahNameE());
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Context, translationPage.class);
                intent.putExtra("tId",tId);
                intent.putExtra("sId",surrahNames.get(position).getSurahID());
                Context.startActivity(intent);
            }
        });

        return Single;
    }
}
