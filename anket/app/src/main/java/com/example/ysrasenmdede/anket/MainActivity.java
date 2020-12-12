package com.example.ysrasenmdede.anket;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView t1=(TextView)findViewById(R.id.textView);
        TextView t2=(TextView)findViewById(R.id.textView2);
        RadioGroup rg1=(RadioGroup) findViewById(R.id.radioGroup);
        Button btn1=(Button)findViewById(R.id.button);
        CheckBox c1=(CheckBox) findViewById(R.id.checkBox);
        CheckBox c2=(CheckBox) findViewById(R.id.checkBox2);
        CheckBox c3=(CheckBox) findViewById(R.id.checkBox3);
        CheckBox c4=(CheckBox) findViewById(R.id.checkBox4);
        CheckBox c5=(CheckBox) findViewById(R.id.checkBox5);
        CheckBox c6=(CheckBox) findViewById(R.id.checkBox6);

    }
    public void onClick(View view)
    {
        Toast.makeText(getApplicationContext(),"Başarıyla anketiniz yapılmıştır",Toast.LENGTH_LONG).show();
    }
}
