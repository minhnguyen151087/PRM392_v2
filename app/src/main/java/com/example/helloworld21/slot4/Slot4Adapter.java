package com.example.helloworld21.slot4;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.helloworld21.R;

import java.util.ArrayList;

public class Slot4Adapter extends BaseAdapter {
    private ArrayList<Slot4Context> ls;
    private Context context;

    public Slot4Adapter(ArrayList<Slot4Context> ls,Context context) {
        this.ls = ls;
        this.context = context;
    }
    //lay ve so luong item
    @Override
    public int getCount() {
        return ls.size();
    }
    //lay ve Item
    @Override
    public Object getItem(int position) {
        return ls.get(position);
    }
    //lay ve Id
    @Override
    public long getItemId(int position) {
        return position;
    }
    //tao view
    //gandulieu
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //b1 tao view
        ViewAX vax;
        //new chua co view tao view moi
        if(convertView == null){
            vax = new ViewAX();//tao view moi
            //anh xa layout
            convertView = LayoutInflater.from(context).inflate(R.layout.slot4_listview_item, null);
            //anh xa tung thanh phan trong layout
            vax.img_hinh = convertView.findViewById(R.id.slot4itemHinh);
            vax.tv_ten=convertView.findViewById(R.id.slot4ItemTen);
            vax.tv_tuoi=convertView.findViewById(R.id.slot4ItemTuoi);
            //tao template de lan sau su dung
            convertView.setTag(vax);

        }
        //neu co view su dung lai view cu
        else{
            vax=(ViewAX) convertView.getTag();
        }
        vax.img_hinh.setImageResource(ls.get(position).getHinh());
        vax.tv_ten.setText(ls.get(position).getTen());
        vax.tv_tuoi.setText(ls.get(position).getTuoi());
        return convertView;//tra ve ket qua
    }
    //dinh nghia view
    class ViewAX{
        ImageView img_hinh;
        TextView tv_ten,tv_tuoi;
    }
}
