package com.example.helloworld21.slot5;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.example.helloworld21.R;

import java.util.ArrayList;
import java.util.List;

public class Demo5MainActivity extends AppCompatActivity {
    ListView listView;
    Demo51Adapter adapter;
    List<Demo51Product> list = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo5_main);
        listView=findViewById(R.id.demo51ListView);
        Demo5SqllteHelper helper = new Demo5SqllteHelper(this);
        SQLiteDatabase db = helper.getReadableDatabase(); // chay co so du lieu
        Demo51ProductDAO dao = new Demo51ProductDAO(this);
        Demo51Product p = new Demo51Product("1","San pham",12.0,1);
        int kq = dao.insertProduct(p);
        list=dao.getAll();
        adapter= new Demo51Adapter(list,this);
        listView.setAdapter(adapter);
        Toast.makeText(this,kq,Toast.LENGTH_LONG).show();
    }
}