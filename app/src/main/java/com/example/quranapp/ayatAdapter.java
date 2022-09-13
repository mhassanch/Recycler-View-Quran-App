package com.example.quranapp;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class ayatAdapter extends ArrayAdapter {
    private final Activity Context;
    private final ArrayList<translationModel> ayatList;
    public ayatAdapter( Activity context, ArrayList<translationModel> ayatList) {
        super(context, R.layout.ayat_single, ayatList);
        Context = context;
        this.ayatList = ayatList;
    }

    public View getView(int position, View view, ViewGroup parent){
        LayoutInflater inflator = Context.getLayoutInflater();
        View Single = inflator.inflate(R.layout.ayat_single,null,true);
        TextView v =Single.findViewById(R.id.arabic);
        TextView v1 =Single.findViewById(R.id.translationV);
        v.setText(ayatList.get(position).getArabic_Text());
        v1.setText(ayatList.get(position).getTranslation());
        return Single;
    }
}
