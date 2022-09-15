package com.hassan.quranapprv;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class surahRVAdapter extends RecyclerView.Adapter<surahRVAdapter.MyVH> {

    List<surahModel> surahList;
    public surahRVAdapter(List<surahModel> sList) {
        this.surahList = sList;
    }

    @NonNull
    @Override
    public surahRVAdapter.MyVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.surahlistitem, parent, false);
        return new MyVH(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull surahRVAdapter.MyVH holder, int position) {
        holder.data=surahList.get(position);
        holder.surahE.setText(holder.data.getSurahNameE());
        holder.surahU.setText(holder.data.getSurahNameU());
        holder.surahV.setText(String.valueOf(holder.data.getSurahID()));
        holder.nazoolV.setText(holder.data.getNazool());
        holder.surahIntro.setText(holder.data.getSurahIntro());
    }

    @Override
    public int getItemCount() {
        return surahList.size();
    }


    public class MyVH extends RecyclerView.ViewHolder {
        TextView surahE;
        TextView surahU;
        TextView surahV;
        TextView nazoolV;
        TextView surahIntro;

        surahModel data;
        public MyVH(@NonNull View itemView) {
            super(itemView);
            surahE = itemView.findViewById(R.id.surahE);
            surahU = itemView.findViewById(R.id.surahU);
            surahV = itemView.findViewById(R.id.surahV);
            nazoolV = itemView.findViewById(R.id.nazoolV);
            surahIntro = itemView.findViewById(R.id.surahIntro);
        }
    }
}
