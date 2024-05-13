package com.example.helloworld21.slot5;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class Demo51ProductDAO {
    private Demo5SqllteHelper dbHelper;
    private SQLiteDatabase db;
    private Context context;
    public Demo51ProductDAO(Context context){
        this.context= context;
        dbHelper= new Demo5SqllteHelper(context);
        db=dbHelper.getWritableDatabase();
    }
    public int insertProduct(Demo51Product product){
        ContentValues values = new ContentValues();//data for insert
        values.put("productId", product.getId());
        values.put("name",product.getName());
        values.put("price",product.getPrice());
        //insert
        if(db.insert("ProductManager",null , values) < 0){
            return -1;//unsuccessful
        }
        return 1;
    }
    public List<Demo51Product> getAll()
    {
        List<Demo51Product> list = new ArrayList<>();
        //con tro de doc du lieu
        Cursor c = db.query("ProductManager",null, null,null,null,null,null);
        c.moveToFirst();
        while(c.isAfterLast()== false){
            Demo51Product product = new Demo51Product();
            product.setId(c.getString(0));
            product.setName(c.getString(1));
            product.setPrice(c.getDouble(2));
            list.add(product);
            c.moveToNext();
        }
        c.close();
        return list;
    }
}
