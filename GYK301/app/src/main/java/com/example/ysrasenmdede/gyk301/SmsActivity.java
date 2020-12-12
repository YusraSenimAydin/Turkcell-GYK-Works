package com.example.ysrasenmdede.gyk301;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SmsActivity extends AppCompatActivity {
    EditText sendMessage, receiveNumber;
    Button sendSmsMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms);
        sendMessage=(EditText) findViewById(R.id.msj);
        receiveNumber=(EditText) findViewById(R.id.tel);
        sendSmsMessage = (Button)findViewById(R.id.btnGonder);
        sendSmsMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message= sendMessage.getText().toString();
                String phoneNumber=receiveNumber.getText().toString();
                composeMmsMessage(message,phoneNumber);
            }
        });
    }

    private void composeMmsMessage(String message, String phoneNumber) {
        Uri uri=Uri.parse("smsto:"+phoneNumber);
        Intent intent=new Intent(Intent.ACTION_SENDTO,uri);
        intent.putExtra("sms_body",message);
        startActivity(intent);
    }
}
