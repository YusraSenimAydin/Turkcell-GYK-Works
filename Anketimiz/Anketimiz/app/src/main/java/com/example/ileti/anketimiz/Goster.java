package com.example.ileti.anketimiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class Goster extends AppCompatActivity {

    TextView tb_isim,tb_telefonmarka,tb_bilgisayarmarka;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goster);

        tb_isim = (TextView) findViewById(R.id.tv_isim);
        tb_bilgisayarmarka = (TextView) findViewById(R.id.tv_bilgisayar);
        tb_telefonmarka = (TextView) findViewById(R.id.tv_telefon);

        Bundle bundle = getIntent().getExtras();
        tb_isim.setText(bundle.getString("isim").toString());
        tb_bilgisayarmarka.setText(bundle.get("bilgisayarmarkasi").toString());
        tb_telefonmarka.setText(bundle.get("telefonmarkasi").toString());

        Toast.makeText(getApplicationContext(),"Anket Yüklendi",Toast.LENGTH_SHORT).show();
    }

}
