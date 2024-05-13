package com.example.helloworld21.tuan41;

import android.content.Context;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class Tuan41VolleyFn {
    String strJSON="";
    public void getJsonArrayOfObject(Context context, TextView textView)
    {
        //1. Tao request
        RequestQueue queue = Volley.newRequestQueue(context);
        //2.Url
        //3.Goi request
        //JsonArrayRequest(url,thanhCong,thatbai)
        //4.thuc thi request
    }
}
