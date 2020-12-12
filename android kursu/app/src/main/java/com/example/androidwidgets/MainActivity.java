package com.example.androidwidgets;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button buttonYap;
    private EditText editTextGirdi;
    private TextView textViewCikti;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        textViewCikti=findViewById(R.id.textViewCikti);
        editTextGirdi=findViewById(R.id.editTextGirdi);
        buttonYap=findViewById(R.id.buttonYap);
// butona bastıgım zaman edittexten aldıgım veriyi textviewe cıktı olarak yazdırmak
        buttonYap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String alinanVeri=editTextGirdi.getText().toString(); //editable ı stringlesmem lazım
                if(!TextUtils.isEmpty(alinanVeri)){//Girdi kontrolu
                    textViewCikti.setText(alinanVeri);// textviewin icine atmma

                }else{
                    textViewCikti.setText( "Veri Yok");
                }
                editTextGirdi.setText("  ");//yazılan yazı butona basıldıktan sonra silinsin istiyorum

            }
        });
    }
}
