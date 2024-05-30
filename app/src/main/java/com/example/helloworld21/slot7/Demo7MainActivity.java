package com.example.helloworld21.slot7;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.helloworld21.R;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Demo7MainActivity extends AppCompatActivity {
    Context context = this;
    TextView tvResult;
    EditText txt1;
    Button btnRead,btnSave;
    EditText txtUser,txtPass;
    Button btnLogin, btnCancel;
    CheckBox isSave;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.demo71_login_layout);
//        tvResult = findViewById(R.id.demo7txtResult);
//        txt1 = findViewById(R.id.demo7editText);
//        btnRead = findViewById(R.id.demo7btnRead);
//        btnSave = findViewById(R.id.demo7btnSave);
//        requestPermission();
//        btnSave.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                saveData(txt1.getText().toString(),context);
//
//            }
//        });
//        btnRead.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String data =readData(context);
//                tvResult.setText(data);
//            }
//        });
        txtUser=findViewById(R.id.demo7txtUserName);
        txtPass =findViewById(R.id.demo7txtPassword);
        btnLogin=findViewById(R.id.demo7btnLogin);
        btnCancel=findViewById(R.id.demo7btnCancel);
        isSave = findViewById(R.id.demo7checkbox);
        restorePass();
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });
    }
    String strU,strP;
    public void login(){
        strU = txtUser.getText().toString();
        strP = txtPass.getText().toString();
        if(strU.isEmpty() || strP.isEmpty()){
            Toast.makeText(getApplicationContext(),"UserName, Password is not empty",Toast.LENGTH_LONG).show();
            return;
        }
        else if (strU.equalsIgnoreCase("admin")&& strP.equalsIgnoreCase("admin")){
            saveUpToPreference(strU,strP,isSave.isChecked());
            Toast.makeText(getApplicationContext(),"Login successful",Toast.LENGTH_LONG).show();
        }
    }
    public void saveDataToFile(String data){
        String path = Environment.getExternalStorageDirectory().getAbsolutePath()+"data1.txt";
        try{
            OutputStreamWriter o = new OutputStreamWriter(new FileOutputStream(path));
            o.write(data);
            o.close();
        } catch (FileNotFoundException e){
            throw  new RuntimeException(e);
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }
    public boolean requestPermission(){
        if(Build.VERSION.SDK_INT >= 23){
            if(checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) ==
                    PackageManager.PERMISSION_GRANTED
                    && checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) ==
                    PackageManager.PERMISSION_GRANTED
                    && checkSelfPermission(Manifest.permission.MANAGE_EXTERNAL_STORAGE) ==
                    PackageManager.PERMISSION_GRANTED){
                return true;
            }
            else{
                ActivityCompat.requestPermissions(Demo7MainActivity.this,new String[]{
                        Manifest.permission.READ_EXTERNAL_STORAGE,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE,
                        Manifest.permission.MANAGE_EXTERNAL_STORAGE
                },1);
                return false;
            }
        }else{
            return true;
        }
    }
    public String saveData(String data,Context context){
        String path="";
        ContextWrapper cw = new ContextWrapper(context);
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.GINGERBREAD_MR1){
            path = cw.getExternalFilesDir(Environment.DIRECTORY_DCIM)+"/data1.txt";
        }else{
            path = Environment.getExternalStorageDirectory().getAbsolutePath()+"/data1.txt";
        }
        try{
            OutputStreamWriter o = new OutputStreamWriter(new FileOutputStream(path));
            o.write(data);
            o.close();
            return "Save data successful";
        }catch (FileNotFoundException e){
            e.printStackTrace();
            return  e.getMessage();
        } catch (IOException e) {
            e.printStackTrace();
            return  e.getMessage();
        }
    }

    //android API32
    public String readData(Context context){
        String result = "";
        String path="";
        ContextWrapper cw = new ContextWrapper(context);
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.GINGERBREAD_MR1){
            path = cw.getExternalFilesDir(Environment.DIRECTORY_DCIM)+"/data1.txt";
        }else{
            path = Environment.getExternalStorageDirectory().getAbsolutePath()+"/data1.txt";
        }
        try{
            Scanner sc = new Scanner(new File(path));
            while (sc.hasNext()){
                result = sc.nextLine()+"\n";
            }
            sc.close();
        }catch (FileNotFoundException e){
            throw new RuntimeException(e);
        }
        return result;
    }
    public String readDataFromFile(){
        String data="";
        String path= Environment.getExternalStorageDirectory().getAbsolutePath()+"/data1.txt";
        try{
            Scanner sc = new Scanner(new File(path));
            while (sc.hasNext()){
                data = sc.nextLine()+"\n";
            }
            sc.close();
        }catch (FileNotFoundException e){
            throw new RuntimeException(e);
        }
        return data;
    }
    public void saveUpToPreference(String u, String p, boolean status){
        SharedPreferences sharedPreferences = getSharedPreferences("H_FILE",MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        if(!status){
            editor.clear();
        }else{
            editor.putString("USERNAME", u);
            editor.putString("PASSWORD",p);
            editor.putBoolean("REMEMBER",status);
        }
        editor.commit();
    }
    public List<Object> restorePass(){
        List<Object> list = new ArrayList<>();
        SharedPreferences sharedPreferences = getSharedPreferences("H_FILE",MODE_PRIVATE);
        boolean check = sharedPreferences.getBoolean("REMEMBER", false);
        if(check){
            String username = sharedPreferences.getString("USERNAME","");
            txtUser.setText(username);
            String password = sharedPreferences.getString("PASSWORD","");
            txtPass.setText(password);
            list.add(username);
            list.add(password);
            list.add(check);
        }
        isSave.setChecked(check);
        return list;
    }
}