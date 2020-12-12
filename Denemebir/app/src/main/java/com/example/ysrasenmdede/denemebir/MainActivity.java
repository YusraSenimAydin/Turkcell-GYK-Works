package com.example.ysrasenmdede.denemebir;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    private ListView listView1;
    private String[] sehirler={"HATAY","MERSİN","SAMSUN","İSTANBUL","ANKARA","EDİRNE","İZMİR"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView1=(ListView)findViewById(R.id.listView1);
        ArrayAdapter<String>veriAdaptoru=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,sehirler);
        listView1.setAdapter(veriAdaptoru);

        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                AlertDialog.Builder diyalogolusturucusu=new AlertDialog.Builder(MainActivity.this);
                diyalogolusturucusu.setMessage(sehirler[position])
                        .setCancelable(false)
                        .setPositiveButton("tamam", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                diyalogolusturucusu.create().show();
            }
        });
    }
}
