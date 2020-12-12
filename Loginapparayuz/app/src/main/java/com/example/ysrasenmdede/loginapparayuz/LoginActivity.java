package com.example.ysrasenmdede.loginapparayuz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {
    private TextView txtView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        txtView=(TextView)findViewById(R.id.txtView);
    }
}
