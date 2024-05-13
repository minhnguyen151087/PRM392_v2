package com.example.helloworld21.slot2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.helloworld21.R;

public class Slot2_2 extends AppCompatActivity {
    EditText txt1, txt2;
    Button btn1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //refer id from memory
        setContentView(R.layout.activity_slot22);
        txt1=findViewById(R.id.slot2_2Txt1);
        txt1=findViewById(R.id.slot2_2Txt2);
        btn1= findViewById(R.id.slot2_2Btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //set round from A to B
                Intent i = new Intent(Slot2_2.this,Slot2_3b.class);
                i.putExtra("a",txt1.getText().toString());
                i.putExtra("b",txt2.getText().toString());
                //start
                startActivity(i);
            }
        });
    }

}