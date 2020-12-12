package com.example.androidwidgets;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListViewGridView extends AppCompatActivity {
    private ListView liste;
    private ArrayList<String> meyveler = new ArrayList<>();
    private ArrayAdapter<String> veriAdaptoru;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_grid_view);
        liste =  findViewById(R.id.liste);
        meyveler.add("Elma");
        meyveler.add("Armut");
        meyveler.add("kiraz");
        meyveler.add("Karpuz");
        meyveler.add("kavun");
        meyveler.add("Mandalin");
        meyveler.add("üzüm");



        veriAdaptoru=new ArrayAdapter<String>
                (this,
                        android.R.layout.simple_list_item_1,
                        android.R.id.text1,
                        meyveler);


        liste.setAdapter(veriAdaptoru);

        registerForContextMenu(liste);


liste.setOnItemClickListener(new AdapterView.OnItemClickListener() {
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(getApplicationContext(),"Meyve: "+ meyveler.get(position), Toast.LENGTH_SHORT).show();
    }
});



    }
    }

