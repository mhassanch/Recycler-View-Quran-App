package com.hassan.quranapprv;

public class surahModel {
    int SurahID;
    String SurahIntro;
    String SurahNameE;
    String Nazool;
    String SurahNameU;

    public surahModel(int surahID, String surahIntro, String surahNameE, String nazool, String surahNameU) {
        SurahID = surahID;
        SurahIntro = surahIntro;
        SurahNameE = surahNameE;
        Nazool = nazool;
        SurahNameU = surahNameU;
    }

    public int getSurahID() {
        return SurahID;
    }

    public void setSurahID(int surahID) {
        SurahID = surahID;
    }

    public String getSurahIntro() {
        return SurahIntro;
    }

    public void setSurahIntro(String surahIntro) {
        SurahIntro = surahIntro;
    }

    public String getSurahNameE() {
        return SurahNameE;
    }

    public void setSurahNameE(String surahNameE) {
        SurahNameE = surahNameE;
    }

    public String getNazool() {
        return Nazool;
    }

    public void setNazool(String nazool) {
        Nazool = nazool;
    }

    public String getSurahNameU() {
        return SurahNameU;
    }

    public void setSurahNameU(String surahNameU) {
        SurahNameU = surahNameU;
    }
}
