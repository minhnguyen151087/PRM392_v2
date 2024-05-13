package com.example.helloworld21.slot5;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Demo5SqllteHelper extends SQLiteOpenHelper {
    public static final String DB_Name="{ProductManager}";
    public static final String SQL_CREATE_PRODUCT="CREATE TABLE ProductManager(\n" +
            "productId text PRIMARY KEY,\n" +
            "name text,\n" +
            "price real,\n" +
            "image real);";

    public Demo5SqllteHelper( Context context) {
        super(context, DB_Name, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //tao database
        db.execSQL(SQL_CREATE_PRODUCT);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS ProductManager");
    }
}
