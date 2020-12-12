package com.example.ysrasenmdede.ankettquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class ikinci extends AppCompatActivity {
 TextView tad,tyas,tcinsiyet;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ikinci);
        tad = (TextView) findViewById(R.id.tad);
        tyas= (TextView) findViewById(R.id.tyas);
        tcinsiyet = (TextView) findViewById(R.id.tcinsiyet);

        Bundle bundle = getIntent().getExtras();

        Toast.makeText(getApplicationContext(),"Anket Yüklendi",Toast.LENGTH_SHORT).show();
    }
}
