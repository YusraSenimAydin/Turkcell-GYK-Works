package com.example.ysrasenmdede.gyk301;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CallActivity extends AppCompatActivity {
    EditText phoneNumber;
    Button call_1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call);
        phoneNumber=(EditText) findViewById(R.id.phoneNumber);
        call_1=(Button) findViewById(R.id.call1);

        call_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String callNumber=phoneNumber.getText().toString();
                callPhoneCell(callNumber);
            }
        });
    }

    private void callPhoneCell(String callNumber) {
        Intent intent=new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:"+callNumber));
        if(intent.resolveActivity(getPackageManager())!=null){
            startActivity(intent);
        }
    }
}
