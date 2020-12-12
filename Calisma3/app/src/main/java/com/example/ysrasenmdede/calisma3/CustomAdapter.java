package com.example.ysrasenmdede.calisma3;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter {
    Context context;
    ArrayList<Ogrenciler> ogrencilerArrayList;
    public CustomAdapter(Context context,ArrayList<Ogrenciler>ogrencilerArrayList){
        this.context=context;
        this.ogrencilerArrayList=ogrencilerArrayList;

    }

    @Override
    public int getCount() {
        return ogrencilerArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return ogrencilerArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final View v=View.inflate(context ,R.layout.activity_ogrenciler, null);
        ImageView imageview=v.findViewById(R.id.resim);
        TextView textView=v.findViewById(R.id.txtad);
        TextView textView1=v.findViewById(R.id.txttarih);
        imageview.setImageResource(ogrencilerArrayList.get(position).foto);
        textView.setText(ogrencilerArrayList.get(position).isim);
        textView1.setText(ogrencilerArrayList.get(position).tarih);
        return v;
    }
}

