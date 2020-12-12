package com.example.ysrasenmdede.gazeteler;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter{
    Context context;
    ArrayList<Gazeteler>gazetelerArrayList;
    public CustomAdapter(Context context,ArrayList<Gazeteler>gazetelerArrayList){
        this.context=context;
        this.gazetelerArrayList=gazetelerArrayList;

    }

    @Override
    public int getCount() {
        return gazetelerArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return gazetelerArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final View v=View.inflate(context,R.layout.gazete,null);
        ImageView imageview=v.findViewById(R.id.resim);
        TextView textView=v.findViewById(R.id.name);
        imageview.setImageResource(gazetelerArrayList.get(position).foto);
        textView.setText( gazetelerArrayList.get(position).gazete);

        return v;
    }
}
