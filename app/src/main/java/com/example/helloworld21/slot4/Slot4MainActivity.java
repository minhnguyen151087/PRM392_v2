package com.example.helloworld21.slot4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.helloworld21.R;

import java.util.ArrayList;

public class Slot4MainActivity extends AppCompatActivity {
    ListView lv;
    Slot4Adapter adapter;
    ArrayList<Slot4Context> ls = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slot4_main);
        lv=findViewById(R.id.slot4lv);
        //tao nguon du lieu
        ls.add(new Slot4Context("Nguyen Van A","18",R.drawable.ic_launcher_background));
        ls.add(new Slot4Context("Tran Van B","17",R.drawable.ic_launcher_background));
        ls.add(new Slot4Context("Le Van A","19",R.drawable.ic_launcher_background));
        ls.add(new Slot4Context("Le Thi D","21",R.drawable.ic_launcher_background));
        //tao  Adapter
        adapter = new Slot4Adapter(ls, this);
        lv.setAdapter(adapter);
    }
}