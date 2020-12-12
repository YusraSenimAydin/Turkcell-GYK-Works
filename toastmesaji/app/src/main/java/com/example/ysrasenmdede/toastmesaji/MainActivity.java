package com.example.ysrasenmdede.toastmesaji;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {
     Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn=(Button)findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Toast.makeText(getApplicationContext(),"bu bir bilgi mesajıdır", Toast.LENGTH_LONG).show();
            }

        });
    }
}
