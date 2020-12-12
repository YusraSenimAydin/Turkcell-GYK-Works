package com.example.ysrasenmdede.calisma3;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
private ListView ListView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView1=(ListView) findViewById(R.id.ListView1);

        ArrayList<Ogrenciler>ogrencilerArrayList=new ArrayList<>();
        ogrencilerArrayList.add(new Ogrenciler(R.drawable.userbir,"Yüsra senim dede", "17.03.19"));
        ogrencilerArrayList.add(new Ogrenciler(R.drawable.useriki,"Diyar Aydın", "17.03.19"));
        CustomAdapter customAdapter=new CustomAdapter(this,ogrencilerArrayList);
        ListView1.setAdapter(customAdapter);
    }
}
