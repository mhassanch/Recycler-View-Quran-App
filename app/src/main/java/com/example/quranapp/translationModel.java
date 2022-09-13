package com.example.quranapp;

public class translationModel {
    public int getAyaID() {
        return AyaID;
    }

    public void setAyaID(int ayaID) {
        AyaID = ayaID;
    }

    public String getArabic_Text() {
        return Arabic_Text;
    }

    public void setArabic_Text(String arabic_Text) {
        Arabic_Text = arabic_Text;
    }

    public String getTranslation() {
        return translation;
    }

    public void setTranslation(String translation) {
        this.translation = translation;
    }

    private int AyaID;
    private String Arabic_Text;
    private String translation;

    public translationModel(int anInt, String string, String string1) {
        AyaID = anInt;
        Arabic_Text = string;
        translation = string1;
    }
}
