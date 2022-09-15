package com.hassan.quranapprv;


import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.util.ArrayList;

public class DBHelper extends SQLiteAssetHelper {
    public static final String DBNAME = "quran_database.db";
    public static final int DBVERSION = 1;
    public static final String TNAME = "tsurah";

    public DBHelper(Context context) {
        super(context, DBNAME, null, DBVERSION);
    }

    //function to get data(recitation) from database
    public String[] getArabic() {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursorCourses = db.rawQuery("SELECT Arabic_Text FROM tayah", null);

        int i = 0;
        String[] data = new String[6348];
        if (cursorCourses.moveToFirst()) {

            do {
                data[i] = (
                        cursorCourses.getString(0)
                );
                i++;
            } while (cursorCourses.moveToNext());
        }
        cursorCourses.close();
        return data;
    }

    public String[] gettingUrduFMJ() {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursorCourses = db.rawQuery("SELECT Fateh_Muhammad_Jalandhari FROM tayah", null);

        int i = 0;
        String[] data = new String[6348];
        if (cursorCourses.moveToFirst()) {

            do {
                data[i] = (
                        cursorCourses.getString(0)
                );
                i++;
            } while (cursorCourses.moveToNext());
        }
        cursorCourses.close();
        return data;
    }

    public String[] gettingEnglishMTU() {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursorCourses = db.rawQuery("SELECT Mufti_Taqi_Usmani FROM tayah", null);

        int i = 0;
        String[] data = new String[6348];
        if (cursorCourses.moveToFirst()) {

            do {
                data[i] = (
                        cursorCourses.getString(0)
                );
                i++;
            } while (cursorCourses.moveToNext());
        }
        cursorCourses.close();
        return data;
    }

    public ArrayList<surahModel> getAllSurahs() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM tsurah", null);
        int i = 0;
        ArrayList<surahModel> surah = new ArrayList<surahModel>();
        if (cursor.moveToFirst()) {
            do {
                surahModel s = new surahModel(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4));
                i++;
                surah.add(s);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return surah;
    }

    public ArrayList<translationModel> getTranslation(int surahNo, int tId) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM tayah WHERE SuraID = " + surahNo, null);
        ArrayList<translationModel> translation = new ArrayList<translationModel>();
        if (cursor.moveToFirst()) {
            do {
                if(tId == 1)
                {
                    translationModel t = new translationModel(cursor.getInt(2), cursor.getString(3),cursor.getString(4));
                    translation.add(t);
                }
                else if(tId == 2)
                {
                    translationModel t = new translationModel(cursor.getInt(2), cursor.getString(3),cursor.getString(5));
                    translation.add(t);
                }
                else if(tId == 3)
                {
                    translationModel t = new translationModel(cursor.getInt(2), cursor.getString(3),cursor.getString(6));
                    translation.add(t);
                }
                else if(tId == 4)
                {
                    translationModel t = new translationModel(cursor.getInt(2), cursor.getString(3),cursor.getString(7));
                    translation.add(t);
                }

            } while (cursor.moveToNext());
        }
        cursor.close();
        return translation;
    }
}