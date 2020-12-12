package com.example.ysrasenmdede.gyk401.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ysrasenmdede.gyk401.R;
import com.example.ysrasenmdede.gyk401.model.diet;

import java.util.List;

public class DietListAdapter<dietList> extends BaseAdapter {

    private final List<com.example.ysrasenmdede.gyk401.model.diet> diet;
    private final android.view.LayoutInflater LayoutInflater;

    private LayoutInflater layoutInflater;
    private List<diet>dietList;

    public DietListAdapter(LayoutInflater layoutInflater, List<diet> dietList) {
        this.LayoutInflater=layoutInflater;
        this.diet=dietList;
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int i) {
        return dietList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup parent) {
        View dietView=layoutInflater.inflate(R.layout.fragment_diet_list, null );
        ImageView FoodPicture=(ImageView)dietView.findViewById(R.id.custom_diet_food_picture);
        TextView FoodName=(TextView)dietView.findViewById(R.id.custom_diet_food_name);
        TextView FoodCalorie=(TextView)dietView.findViewById(R.id.custom_diet_food_calorie);
        diet diet=dietList.get(i);
        FoodPicture.setImageResource(diet.getFoodPicture());
        FoodName.setText(diet.getFoodName());
        FoodCalorie.setText(diet.getFoodCalorie());


        return dietView;
    }
}
