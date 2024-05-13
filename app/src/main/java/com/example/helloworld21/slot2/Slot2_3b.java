package com.example.helloworld21.slot2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.helloworld21.R;

public class Slot2_3b extends AppCompatActivity {
    TextView tv1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slot23b);
        tv1 = findViewById(R.id.slo2A2_3Tv1);
        Intent i1 = getIntent();
        //extract data package
        double a = Double.parseDouble(i1.getExtras().getString("a"));
        double b = Double.parseDouble(i1.getExtras().getString("b"));
        //sum
        double sum = a+b;
        //put data to screen
        tv1.setText(String.valueOf(sum));
    }
}