package com.example.ysrasenmdede.rehberuygulamas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final EditText isim= (EditText) findViewById(R.id.isim);
        final EditText telefon= (EditText) findViewById(R.id.telefon);
        Button button= (Button) findViewById(R.id.button);


        button.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                final  Veritabani veritabani=new Veritabani(MainActivity.this);
                 veritabani.VeriEkle(isim.getText().toString(), telefon.getText().toString());
                 Toast.makeText(getApplicationContext(),"kayıtlar eklendi!", Toast.LENGTH_LONG).show();



             }

         });

         Button listele= (Button) findViewById(R.id.listele);
         final ListView listView=(ListView) findViewById(R.id.veriler);
         final Veritabani veritabani=new Veritabani(MainActivity.this);
         final List<String> vVeriler=veritabani.VeriListele();
         registerForContextMenu(listView);
         listele.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayAdapter<String >adapter= new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,android.R.id.text1,vVeriler);
                listView.setAdapter(adapter);

            }
        });

        }
    }

