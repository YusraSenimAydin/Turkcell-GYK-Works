package com.example.ysrasenmdede.loginapparayuz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public abstract class MainActivity extends AppCompatActivity {

    private EditText edtmail;
    private EditText edtpass;
    private Button btnTikla;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtmail = (EditText) findViewById(R.id.edtmail);
        edtpass = (EditText) findViewById(R.id.edtpass);
        btnTikla = (Button) findViewById(R.id.btnTıkla);

    }


    public void btnTıkla(View view) {
        Intent intent= new Intent(this,LoginActivity.class );
        startActivity(intent);
    }
}
