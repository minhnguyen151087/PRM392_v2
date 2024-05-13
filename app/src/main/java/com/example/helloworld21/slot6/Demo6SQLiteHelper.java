package com.example.helloworld21.slot6;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Demo6SQLiteHelper extends SQLiteOpenHelper {
    public static final String SQL_CREATE_TABLE_SANPHAM = "create TABLE sanpham(\n" +
            "maSP text PRIMARY Key,\n" +
            "tenSP text,\n" +
            "soLuongSP real);";
    public Demo6SQLiteHelper( Context context) {
        super(context, "sanpham", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_TABLE_SANPHAM);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
