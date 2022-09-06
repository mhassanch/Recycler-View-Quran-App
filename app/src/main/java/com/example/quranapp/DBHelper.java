package com.example.quranapp;


import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;
import android.widget.Toast;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;


public class DBHelper extends SQLiteAssetHelper {
    private static String DbName = "databases/quran_database.db";
    private static String DbPath = "/data/data/com.example.quranapp/databases/";
    private Context context;
    private SQLiteDatabase aDB;


    public DBHelper(Context c){
        super(c,DbName,null,4);
        this.context = c;
    }/*
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        createDatabase();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS tsurah");
        onCreate(db);
    }
*/
    public void createDatabase(){
        try {
            // Open your local db as the input stream


            InputStream myInput = context.getAssets().open("databases/quran_database.db");



            // Path to the just created empty db
            String outFileName = "/data/data/com.example.quranapp/databases/";
            //String outFileName = Context.getFilesDir().getPath();
            OutputStream myOutput = new FileOutputStream(outFileName);

            // transfer bytes from the inputfile to the outputfile
            byte[] buffer = new byte[1024];
            int length;
            while ((length = myInput.read(buffer)) > 0) {
                myOutput.write(buffer, 0, length);
            }

            // Close the streams
            myOutput.flush();
            myOutput.close();
            myInput.close();

        } catch (Exception e) {

            Log.e("db cannot copy", e.toString());

        }
    }

    public ArrayList<surahModel> getAllSurahs(){
        ArrayList<surahModel> surah = new ArrayList<>();
        try{
            SQLiteDatabase db = this.getReadableDatabase();
            Cursor cursor = db.rawQuery("SELECT * FROM tsurah",null);

            //db.rawQuery("SELECT name FROM sqlite_master WHERE type='table' AND name='tsurah';",null);
            // moving our cursor to first position.
            if (cursor.moveToFirst()) {
                do {

                    surah.add(new surahModel(cursor.getInt(1), cursor.getString(2),cursor.getString(3),cursor.getString(4),cursor.getString(5) ));
                } while (cursor.moveToNext());

            }

            cursor.close();
        }
        catch (Exception e){
            Toast.makeText(context,"table not access",Toast.LENGTH_LONG).show();
        }


        return surah;
    }
}
