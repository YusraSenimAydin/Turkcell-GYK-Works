package com.example.ysrasenmdede.cokluactivitiy;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText e1,e2;
    Button b1;

    public static final String kad = "kad";
    public static final String sifre = "sifre";

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1=(EditText)findViewById(R.id.editText);
        e2=(EditText)findViewById(R.id.editText2);
        b1=(Button)findViewById(R.id.button);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, com.example.ysrasenmdede.cokluactivitiy.anket.class);
                intent.putExtra(kad,e1.getText().toString());
                intent.putExtra(sifre,e2.getText().toString());
                startActivity(intent);
            }
        });


    }

}
