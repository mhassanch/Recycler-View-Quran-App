package com.example.quranapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class DBHelper extends SQLiteOpenHelper {
    String DbName;
    String DbPath;
    Context context;

    public DBHelper(@Nullable Context context,String name) {
        super(context, name, null, 1);

        this.context = context;
        DbName = "quran_database.db";
        DbPath = "/data/data/" + context.getPackageName() +"/databases/";
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void CheckDatabase(){
        try{
            String path = DbPath + DbName;
            SQLiteDatabase.openDatabase(path,null,0);
        }catch (Exception e){
            this.getReadableDatabase();
            CopyDatabase();
        }
    }

    public void CopyDatabase(){
        try{
            InputStream io = context.getAssets().open(DbName);
            String outfilenme = DbPath + DbName;
            OutputStream outputStream = new FileOutputStream(outfilenme);
            int length;
            byte[] buffer = new byte[1024];
            while ((length = io.read(buffer)) > 0){
                outputStream.write(buffer,length,0);
            }
            io.close();
            outputStream.flush();
            outputStream.close();
        }catch(Exception e){}
    }

    public void OpenDatabase(){
        String path = DbPath + DbName;
        SQLiteDatabase.openDatabase(path,null,0);
    }

}
