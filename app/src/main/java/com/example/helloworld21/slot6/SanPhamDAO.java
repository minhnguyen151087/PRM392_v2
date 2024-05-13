package com.example.helloworld21.slot6;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class SanPhamDAO {
    private SQLiteDatabase db;
    private SQLiteOpenHelper helper;
    private Context context;

    public static final String TABLE_NAME=("sanpham");
    public SanPhamDAO(Context context){
        this.context = context;
        helper = new Demo6SQLiteHelper(context);//create database
        db= helper.getWritableDatabase();
    }
    public int insertProduct(Sanpham p){
        ContentValues values = new ContentValues();
        values.put("maSP", p.getMaSP());
        values.put("tenSP",p.getTenSP());
        values.put("soLuongSP",String.valueOf(p.getSoLuongSp()));
        if(db.insert(TABLE_NAME,null,values) < 0){
            return -1;
        }
        return 0;
    }
    public int deleteProduct(String masp){
        if(db.delete(TABLE_NAME,"maSP = ?",new String[]{masp}) >=0 ){
            return -1;
        }
        return 0;
    }
    public int updateProduct(Sanpham p){
        ContentValues values = new ContentValues();
        values.put("maSP", p.getMaSP());
        values.put("tenSP",p.getTenSP());
        values.put("soLuongSP",String.valueOf(p.getSoLuongSp()));
        if(db.update(TABLE_NAME,values,"maSP=?", new String[]{p.getMaSP()}) < 0){
            return -1;
        }
        return 0;
    }
    public List<Sanpham> getAll(){
        List<Sanpham> ls = new ArrayList<>();
        Cursor c = db.query(TABLE_NAME,null,null,null,null,null,null);
        c.moveToFirst();
        while (c.isAfterLast() == false){
            Sanpham s = new Sanpham();
            s.setMaSP(c.getString(0));
            s.setTenSP(c.getString(1));
            s.setSoLuongSp(c.getInt(2));
            ls.add(s);
            c.moveToNext();
        }
        c.close();
        return ls;
    }
    public List<String> getAllProductToString(){
        List<String> ls = new ArrayList<>();
        Cursor c = db.query(TABLE_NAME,null,null,null,null,null,null);
        c.moveToFirst();
        while (c.isAfterLast() == false){
            Sanpham s = new Sanpham();
            s.setMaSP(c.getString(0));
            s.setTenSP(c.getString(1));
            s.setSoLuongSp(c.getInt(2));
            String chuoi = s.getMaSP()+" - " + s.getTenSP() + " - " +s.getSoLuongSp();
            ls.add(chuoi);
            c.moveToNext();
        }
        c.close();
        return ls;
    }
}
