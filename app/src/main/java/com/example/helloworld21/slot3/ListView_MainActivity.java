package com.example.helloworld21.slot3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.helloworld21.R;

public class ListView_MainActivity extends AppCompatActivity {
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_main);
        listView=findViewById(R.id.demoListView);
        //create data source
        getDataToListView();
    }
    private void getDataToListView(){
        //1/Create data source
        String[] arr = new String[]{
                "lap trinh java 1",
                "Computer science introduction",
                "Mobile programing",
                "Cross-platfrom with .Net",
                "Java script Introduction"
        };
        ArrayAdapter<String> adapter = new ArrayAdapter<>(ListView_MainActivity.this, android.R.layout.simple_list_item_1,arr);
        listView.setAdapter(adapter);
    }
}