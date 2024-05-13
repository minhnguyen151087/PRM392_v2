package com.example.helloworld21.slot3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.helloworld21.R;

public class LoginDemo extends AppCompatActivity {
    EditText txt1, txt2;
    Button btn1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_demo);
        txt1=findViewById(R.id.demo3txt1);
        txt2=findViewById(R.id.demo3txt2);
        btn1=findViewById(R.id.demo3btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });
    }
    private void login(){
        if(txt1.getText().toString().equals("admin") && txt2.getText().toString().equals("12345")){
            Toast.makeText(LoginDemo.this,"Login successfully",Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(LoginDemo.this,"User of password wrong",Toast.LENGTH_LONG).show();
        }
    }
}