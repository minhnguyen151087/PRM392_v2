package com.example.helloworld21.slot3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.helloworld21.R;

public class slot3DemoMainActivity extends AppCompatActivity {
EditText txtA,txtB,txtC;
Button btn1;
TextView tvResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slot3_demo_main);
        txtA=findViewById(R.id.editTextTxtA);
        txtB=findViewById(R.id.editTextTxtB);
        txtC=findViewById(R.id.editTextTxtC);
        btn1= findViewById(R.id.slot3_1Btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendData();
            }
        });
    }
    private void sendData()
    {
        //get data from input of user
        String a=txtA.getText().toString();
        String b=txtB.getText().toString();
        String c=txtC.getText().toString();
        //create intent
        Intent intent=new Intent(slot3DemoMainActivity.this,slot32MainActivity.class);
        //put data to intent
        intent.putExtra("hsa",a);
        intent.putExtra("hsb",b);
        intent.putExtra("hsc",c);
        //start activity
        startActivity(intent);
    }
}