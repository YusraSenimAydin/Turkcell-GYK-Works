package com.example.ysrasenmdede.odevveritabani;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
   private veritabani veritabani=new veritabani(MainActivity.this);

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
                Veritabani veritabani=new Veritabani(MainActivity.this);
                veritabani.VeriEkle(isim.getText().toString(), telefon.getText().toString());



            }

        });

        Button listele= (Button) findViewById(R.id.listele);
        final ListView listView=(ListView) findViewById(R.id.veriler);
        listele.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                com.example.ysrasenmdede.rehberuygulamas.Veritabani veritabani=new com.example.ysrasenmdede.rehberuygulamas.Veritabani(MainActivity.this);
                List<String> vVeriler=veritabani.VeriListele();
                ArrayAdapter<String > adapter= new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,android.R.id.text1,vVeriler);
                listView.setAdapter(adapter);

            }
        });

    }
}

