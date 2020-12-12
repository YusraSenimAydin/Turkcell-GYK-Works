package com.example.androidwidgets;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class Spinner extends AppCompatActivity {
    private Spinner spinnerilk ;
    private Button buttonGöster;
    private ArrayList<String> ulkeler = new ArrayList<>();
    private ArrayAdapter<String> veriAdaptoru;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);

        ulkeler.add("TÃ¼rkiye");
        ulkeler.add("Ä°talya");
        ulkeler.add("GÃ¼ney Kore");
        ulkeler.add("Almanya");
        ulkeler.add("Ä°spanya");
        ulkeler.add("Portekiz");
        ulkeler.add("Japonya");



    }




}
