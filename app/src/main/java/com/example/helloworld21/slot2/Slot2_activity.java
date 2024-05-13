package com.example.helloworld21.slot2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.helloworld21.R;

public class Slot2_activity extends AppCompatActivity {
    //var all control
    EditText txt1,txt2;
    Button btn1;
    TextView tv1;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slot2);
        //reference control to memory
        txt1=findViewById(R.id.slot2Txt1);
        txt2=findViewById(R.id.slot2Txt2);
        btn1=findViewById(R.id.slot2Btn1);
        tv1=findViewById(R.id.slot2Lb);
        //event handing
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sumfn();
            }
        });
        //write a function for Sum

    }
    void sumfn(){
        //get data of input
        double a = Double.parseDouble( txt1.getText().toString());
        double b = Double.parseDouble(txt2.getText().toString());
        //sum
        double s = a + b;
        //display result
        tv1.setText(String.valueOf(s));
    }
}