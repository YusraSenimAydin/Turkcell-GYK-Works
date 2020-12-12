package com.example.contactus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    EditText  edt_isim, edt_mail,edt_konu,edt_mesaj;
    Button btnGonder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edt_isim = findViewById(R.id.edt_isim);
        edt_mail = findViewById(R.id.edt_mail);
        edt_konu = findViewById(R.id.edt_konu);
        edt_mesaj = findViewById(R.id.edt_mesaj);
        btnGonder = findViewById(R.id.btnGonder);
        btnGonder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String isim=edt_isim.getText().toString();
                String email     = edt_mail.getText().toString();
                String subject   = edt_konu.getText().toString();
                String message   = edt_mesaj.getText().toString();
                if (TextUtils.isEmpty(isim)){
                    edt_isim.setError("Adınızı giriniz");
                    edt_isim.requestFocus();
                    return;
                }

                Boolean onError = false;
                if (!isValidEmail(email)) {
                    onError = true;
                    edt_mail.setError("Geçersiz E-posta");
                    return;
                }

                if (TextUtils.isEmpty(subject)){
                    edt_konu.setError("Konunuzu Giriniz");
                    edt_konu.requestFocus();
                    return;
                }

                if (TextUtils.isEmpty(message)){
                    edt_mesaj.setError("Mesajınızı Giriniz");
                    edt_mesaj.requestFocus();
                    return;
                }

                Intent sendEmail = new Intent(android.content.Intent.ACTION_SEND);

                /* Fill it with Data */
                sendEmail.setType("plain/text");
                sendEmail.putExtra(android.content.Intent.EXTRA_EMAIL, new String[]{"dr.m.karthiik@gmail.com"});
                sendEmail.putExtra(android.content.Intent.EXTRA_SUBJECT, subject);
                sendEmail.putExtra(android.content.Intent.EXTRA_TEXT,
                        "name:"+isim+'\n'+"Email ID:"+email+'\n'+"Message:"+'\n'+message);

                /* Send it off to the Activity-Chooser */
                startActivity(Intent.createChooser(sendEmail, "Send mail..."));


            }
        });
    }
    @Override
    public void onResume() {
        super.onResume();
        //Get a Tracker (should auto-report)


    }

    @Override
    protected void onStart() {
        super.onStart();

    }

    @Override
    protected void onStop() {
        super.onStop();

    }

    private boolean isValidEmail(String email) {
        String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
    }

