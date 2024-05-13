package com.example.helloworld21.slot3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.helloworld21.R;

public class slot32MainActivity extends AppCompatActivity {
    EditText txtA,txtB,txtC;
    Button btn1;
    TextView tvResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slot32_main);
        tvResult= findViewById(R.id.tvKq);
        Intent intent1=getIntent();
        int a= Integer.parseInt(intent1.getExtras().getString("hsa"));
        int b=Integer.parseInt(intent1.getExtras().getString("hsb"));
        int c=Integer.parseInt(intent1.getExtras().getString("hsc"));
        int delta=b*b-4*a*c;
        if(delta<0){
            tvResult.setText("PTVN");
        }
        else if(delta==0){
            tvResult.setText("PT co nghiem kep x="+ (-b)/(2*a));
        }
        else {
            float x1= (float) ((-b+Math.sqrt(delta))/(2*a));
            float x2= (float) ((-b-Math.sqrt(delta))/(2*a));
            tvResult.setText("PT co 2 nghiem x1="+x1+" va x2="+x2);
        }
}
}