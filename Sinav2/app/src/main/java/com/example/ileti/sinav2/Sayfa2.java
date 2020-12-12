package com.example.ileti.sinav2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

public class Sayfa2 extends AppCompatActivity {

    int[] rb_id = {R.id.cb_android,R.id.cb_ios,R.id.cb_tizen,R.id.cb_wphone};
    CheckBox telefonlar;
    String cevaplarimiz="",gelenler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sayfa2);

        // Bu kısım önemli : new kullanmıyoruz.
        Bundle bundle = getIntent().getExtras();

        gelenler = bundle.getString("isletim");
    }
    public void btn_cb_goster(View view){

        for (int i= 0;i<rb_id.length;i++){
            telefonlar = (CheckBox) findViewById(rb_id[i]);

            if(telefonlar.isChecked()){
                cevaplarimiz += telefonlar.getText()+ " - ";
            }
        }
        cevaplarimiz+= " // " +gelenler;
        Toast.makeText(this,cevaplarimiz,Toast.LENGTH_LONG).show();
        cevaplarimiz="";
    }
}
