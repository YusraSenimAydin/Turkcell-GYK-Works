package com.example.ysrasenmdede.rehberuygulamas;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


import java.util.ArrayList;
import java.util.List;

public class Veritabani extends SQLiteOpenHelper {
    private static final String DATABASE_NAME="veritabani";
    private static final int DATABASE_VERSION=1;
    private static final String KISILER_TABLE="kisiler";

    public static final String ROW_ID="id";
    public static final String ROW_NAME="ad";
    public static final String ROW_PHONE="telefon";
    public Veritabani(Context contex){
        super(contex , DATABASE_NAME, null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
          db.execSQL(" CREATE TABLE "+ KISILER_TABLE +"("+ROW_ID+" INTEGER PRIMARY KEY,"+ROW_NAME+"TEXT NOT NULL,"+ROW_PHONE+" TEXT NOT NULL)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
       db.execSQL("DROP TABLE IF EXISTS "+ KISILER_TABLE);
       onCreate(db);
    }
    public void VeriEkle(String ad, String telefon){
        SQLiteDatabase db= this.getWritableDatabase();
        ContentValues cv= new ContentValues();
        cv.put(ROW_NAME,ad.trim());
        cv.put(ROW_PHONE,telefon.trim());
        db.insert(KISILER_TABLE,null,cv);
        db.close();
    }
   public List<String>VeriListele(){
        List<String> veriler= new ArrayList<>();
        SQLiteDatabase db= this.getWritableDatabase();
        String [] sutunlar={"ROW_ID" , "ROW_NAME", "ROW_PHONE" };
        Cursor cursor = db.query(KISILER_TABLE , sutunlar,null,null,null,null,null);
        while(cursor.moveToNext()){
            veriler.add(cursor.getInt(0)+"-"+cursor.getString(1)+"-"+cursor.getString(2));

        }
        db.close();
        return  veriler;

    }


    }

