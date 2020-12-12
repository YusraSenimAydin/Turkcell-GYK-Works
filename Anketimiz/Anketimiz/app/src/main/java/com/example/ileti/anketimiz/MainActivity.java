package com.example.ileti.anketimiz;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    RadioGroup telefon_markasi;
    RadioButton tmarkasi;

    int[] cb_id = {R.id.cb_dell,R.id.cb_monster,R.id.cb_samsung};
    CheckBox cb_bilgisayar;
    String cb_cevaplar ="";

    EditText isminiz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        telefon_markasi = (RadioGroup) findViewById(R.id.rg_telefon);
        isminiz = (EditText) findViewById(R.id.isim);
    }
    public void  btn_gonder(View view){
        int rb_cevap = telefon_markasi.getCheckedRadioButtonId();
        tmarkasi = (RadioButton) findViewById(rb_cevap);

        for(int i = 0;i < cb_id.length;i++){
            cb_bilgisayar = (CheckBox) findViewById(cb_id[i]);
            if(cb_bilgisayar.isChecked())
                cb_cevaplar+= cb_bilgisayar.getText().toString();
        }

        AlertDialog.Builder uyari = new AlertDialog.Builder(this);
        uyari.setTitle("Başlık");
        uyari.setMessage("Diğer sayfaya gidecek misin ? (setMessage)");
        uyari.setCancelable(false);
        uyari.setPositiveButton("Gönder", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent frm_goster = new Intent(getApplicationContext(),Goster.class);

                frm_goster.putExtra("isim",isminiz.getText().toString());
                frm_goster.putExtra("telefonmarkasi",tmarkasi.getText().toString());
                frm_goster.putExtra("bilgisayarmarkasi",cb_cevaplar);
                startActivity(frm_goster);

            }
        });
        uyari.create().show();

    }
}


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
