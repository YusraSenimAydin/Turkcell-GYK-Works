package com.example.ysrasenmdede.gyk301;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
  Button open_photo_and_video ,open_voice,open_map ,open_web, send_sms, dial_call;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        open_photo_and_video=(Button) findViewById(R.id.open_photo_and_video);
        open_voice= (Button)findViewById(R.id.open_voice);
        open_map=(Button)findViewById(R.id.open_map);
        open_web=(Button)findViewById(R.id.open_web);
        send_sms=(Button)findViewById(R.id.send_sms);
        dial_call=(Button)findViewById(R.id.dial_call);
        open_photo_and_video.setOnClickListener(this);
        open_voice.setOnClickListener(this);
        open_map.setOnClickListener(this);
        open_web.setOnClickListener(this);
        send_sms.setOnClickListener(this);
        dial_call.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        if(view==open_photo_and_video){
            Intent openPhotoAndVideoIntent = new Intent(MainActivity.this,CameraActivity.class);
            startActivity(openPhotoAndVideoIntent);
        }
        else if (view==open_voice){
            Intent openVoiceIntent = new Intent(MainActivity.this,VoiceActivity.class);
            startActivity(openVoiceIntent);
        }
        else if (view==open_map){
            Intent openMapIntent = new Intent(MainActivity.this,mapActivity.class);
            startActivity(openMapIntent);
        }
        else if (view==open_web){
            Intent openWebIntent = new Intent(MainActivity.this,WebActivity.class);
            startActivity(openWebIntent);
        }
        else if (view==send_sms){
            Intent sendSmsIntent = new Intent(MainActivity.this,SmsActivity.class);
            startActivity(sendSmsIntent);
        }
        else if (view==dial_call){
            Intent dialCallIntent = new Intent(MainActivity.this,CallActivity.class);
            startActivity(dialCallIntent);
        }
    }
}
