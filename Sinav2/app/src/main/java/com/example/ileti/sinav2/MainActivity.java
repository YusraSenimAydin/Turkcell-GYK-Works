package com.example.ileti.sinav2;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    RadioGroup rg_isletim;
    RadioButton cevap;
    String sg_cevap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rg_isletim = (RadioGroup) findViewById(R.id.rg_deneme);

    }

    public void btn_goster(View view){

      int rg_id =  rg_isletim.getCheckedRadioButtonId();
      cevap = (RadioButton) findViewById(rg_id);
      sg_cevap = cevap.getText().toString();


        AlertDialog.Builder uyari = new AlertDialog.Builder(this);
        uyari.setTitle("Uyari başlığı");
        uyari.setMessage("Detaylar kısımı (Başka sayfaya geçmek istiyor musunuz ?");

        uyari.setPositiveButton("Tamam", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent frm_sayfa2 = new Intent(getApplicationContext(),Sayfa2.class);
                frm_sayfa2.putExtra("isletim",sg_cevap);
                startActivity(frm_sayfa2);

            }
        });

        /*Create fonksiyonun ardından show gelmeli.*/
        uyari.create().show();

    }
}
