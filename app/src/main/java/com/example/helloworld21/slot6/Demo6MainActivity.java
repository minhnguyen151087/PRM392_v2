package com.example.helloworld21.slot6;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.helloworld21.R;

import java.util.ArrayList;
import java.util.List;

public class Demo6MainActivity extends AppCompatActivity {
    EditText txtMa, txtTen, txtSL;
    Button btnLoad,btnAdd, btnEdit,btnDelete;
    ListView lv;
    SanPhamDAO sanPhamDAO;
    ArrayAdapter<String> arrayAdapter;
    List<String> ds = new ArrayList<>();
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo6_main);
        txtMa=findViewById(R.id.slot6txtMaSP);
        txtTen=findViewById(R.id.slot6txtTenSP);
        txtSL = findViewById(R.id.slot6txtSLSP);
        btnLoad = findViewById(R.id.slot6btnLoad);
        btnAdd = findViewById(R.id.slot6btnAdd);
        btnEdit= findViewById(R.id.slot6btnEdit);
        btnDelete = findViewById(R.id.slot6btnDelete);
        lv=findViewById(R.id.slot6LV);
        sanPhamDAO = new SanPhamDAO(this);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Sanpham s = new Sanpham();
                s.setMaSP(txtMa.getText().toString());
                s.setTenSP(txtTen.getText().toString());
                s.setSoLuongSp(Integer.parseInt(txtSL.getText().toString()));
                int kq = sanPhamDAO.insertProduct(s);
                if(kq == -1){
                    Toast.makeText(getApplicationContext(),"Insert that bai",Toast.LENGTH_LONG).show();
                }
                else if(kq == 0){
                    Toast.makeText(getApplicationContext(),"Insert thanh cong",Toast.LENGTH_LONG).show();
                }
            }
        });
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int kq = sanPhamDAO.deleteProduct(txtMa.getText().toString());
                if(kq == -1){
                    Toast.makeText(getApplicationContext(),"Delete that bai",Toast.LENGTH_LONG).show();
                }
                else if(kq == 0){
                    Toast.makeText(getApplicationContext(),"Delete thanh cong",Toast.LENGTH_LONG).show();
                }
            }
        });
        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Sanpham s = new Sanpham();
                s.setMaSP(txtMa.getText().toString());
                s.setTenSP(txtTen.getText().toString());
                s.setSoLuongSp(Integer.parseInt(txtSL.getText().toString()));
                int kq = sanPhamDAO.updateProduct(s);
                if(kq == -1){
                    Toast.makeText(getApplicationContext(),"Update that bai",Toast.LENGTH_LONG).show();
                }
                else if(kq == 0){
                    Toast.makeText(getApplicationContext(),"Update thanh cong",Toast.LENGTH_LONG).show();
                }
            }
        });
        btnLoad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ds.clear();
                ds = sanPhamDAO.getAllProductToString();
                arrayAdapter = new ArrayAdapter<>(Demo6MainActivity.this,
                        android.R.layout.simple_list_item_1,ds);
                lv.setAdapter(arrayAdapter);
            }
        });
    }
}