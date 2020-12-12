package com.example.ysrasenmdede.gazeteler;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView ListView1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView1=(ListView) findViewById(R.id.List);

        final ArrayList<Gazeteler> gazetelerArrayList=new ArrayList<>();
        gazetelerArrayList.add(new Gazeteler(R.drawable.sabah,"Sabah" , "https://www.sabah.com.tr/"));
        gazetelerArrayList.add(new Gazeteler(R.drawable.hurriyet,"Huriyet", "http://www.hurriyet.com.tr/"));

        CustomAdapter customAdapter=new CustomAdapter(this,gazetelerArrayList);
        ListView1.setAdapter(customAdapter);
        ListView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Main2Activity.haberUrl = gazetelerArrayList.get(position).url;

                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(intent);


            }
        });
    }

}
