package com.example.helloworld21.slot5;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.helloworld21.R;

import java.util.List;

public class Demo51Adapter extends BaseAdapter{
    private List<Demo51Product> list;
    private Context context;

    public Demo51Adapter(List<Demo51Product> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Demo51ViewHolder holder;
        if(convertView == null){
            //create a blank view
            convertView = LayoutInflater.from(context).inflate(R.layout.demo51_item_view,parent,false);
            //refer id of itemView
            holder = new Demo51ViewHolder();
            holder.img=convertView.findViewById(R.id.demo51_itemView_img);
            holder.tvId= convertView.findViewById(R.id.demo51_itemView_tvId);
            holder.tvName= convertView.findViewById(R.id.demo51_itemView_tvName);
            holder.tvPrice= convertView.findViewById(R.id.demo51_itemView_tvPrice);
            convertView.setTag(holder);//create a template for later
        }
        else{
            //if exist view -> get view
            holder=(Demo51ViewHolder) convertView.getTag();
        }
        //set data
        Demo51Product product = list.get(position);
        if(product != null){
            holder.img.setImageResource(R.drawable.ic_launcher_background);
            holder.tvId.setText(product.getId());
            holder.tvName.setText(product.getName());
            holder.tvPrice.setText(String.valueOf(product.getPrice()));

        }
        return convertView;
    }

    static class Demo51ViewHolder  {
        ImageView img;
        TextView tvId,tvName,tvPrice;
    }
}
