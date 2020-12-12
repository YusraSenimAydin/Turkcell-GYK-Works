package com.example.ysrasenmdede.ankettquiz;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText etad ,etyas;
    TextView tad,tyas,tcinsiyet,tögrnci,tdil;

    CheckBox cb_evet,cb_java,cb_cpp,cb_c;
    RadioButton rbbay;

    Button btngonder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etad=(EditText)findViewById(R.id.etad);
        etyas= (EditText)findViewById(R.id.etyas);
        tad = (TextView) findViewById(R.id.tad);
        tyas= (TextView) findViewById(R.id.tyas);
        tcinsiyet = (TextView) findViewById(R.id.tcinsiyet);
        tögrnci= (TextView) findViewById(R.id.tögrnci);
        tdil = (TextView) findViewById(R.id.tdil);
        cb_evet= (CheckBox) findViewById(R.id.cb_evet);
        cb_java = (CheckBox) findViewById(R.id.cb_java);
        cb_cpp = (CheckBox) findViewById(R.id.cb_cpp);
        cb_c = (CheckBox) findViewById(R.id.cb_c);
        rbbay = (RadioButton) findViewById(R.id.rbbay);
        btngonder= (Button) findViewById(R.id.btngonder);



        public void  btn_gonder(View view){
            for(int i = 0;i < cb_id.length;i++){
                cb_java= (CheckBox) findViewById(cb_id[i]);
                if(cb_java.isChecked()){
                    AlertDialog.Builder uyari = new AlertDialog.Builder(this);
                    uyari.setTitle("Başlık");
                    uyari.setMessage("Diğer sayfaya gidecek misin ? (setMessage)");
                    uyari.setCancelable(false);
                    uyari.setPositiveButton("Gönder", new DialogInterface.OnClickListener()
                }

        };
        public void onClick(DialogInterface Object dialog;
            dialog, int which) {
            Intent frm_goster = new Intent(getApplicationContext(),ikinci.class);

            frm_goster.putExtra("ad",.getText().toString());

            startActivity(frm_goster);



        }
};
