package com.example.ysrasenmdede.telefonrehberi;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;

public class Veritabani extends SQLiteOpenHelper {
    private static String DATABASE_NAME = "veritabani.db";
    private static int DATABASE_VERSION = 1;
    private static String KISILER_TABLE = "kisiler";

    public static String ROW_ID = "id";
    public static String ROW_NAME = "ad";
    public static String ROW_PHONE = "telefon";
    public Context c;

    public Veritabani(Context contex) {

        super(contex, DATABASE_NAME, null, DATABASE_VERSION);
        this.c = contex;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table kisiler(id integer primary key autoincrement,ad text not null,telefon text not null)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + KISILER_TABLE);
        onCreate(db);
    }

    public void VeriEkle(String ad, String telefon) {
        try {
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues cv = new ContentValues();
            cv.put("telefon", telefon);
            cv.put("ad", ad);
            db.insertOrThrow(KISILER_TABLE, null, cv);
            db.close();
        } catch (Exception ex) {
            Toast.makeText(c, ex.getMessage(), Toast.LENGTH_LONG).show();
        }

    }

    public List<String> VeriListele() {
        try {
            List<String> veriler = new ArrayList<String>();
            SQLiteDatabase db = this.getWritableDatabase();
            String[] sutunlar = {"id", "ad", "telefon"};
            Cursor cursor = db.query(KISILER_TABLE, sutunlar, null, null, null, null, null);

            while (cursor.moveToNext()) {
                veriler.add(cursor.getInt(0) + "-" + cursor.getString(1) + "-" + cursor.getString(2));

            }
            db.close();
            cursor.close();

            return veriler;
        } catch (Exception ex) {

            Toast.makeText(c, ex.getMessage(), Toast.LENGTH_LONG).show();
            return null;
        }

    }
}
