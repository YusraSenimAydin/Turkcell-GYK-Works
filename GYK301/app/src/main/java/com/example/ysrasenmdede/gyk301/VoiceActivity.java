package com.example.ysrasenmdede.gyk301;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.IOException;

import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;

public class VoiceActivity extends AppCompatActivity implements View.OnClickListener {
    Button recordVoiceBtn, stopVoiceBtn, playVoiceBtn;
    private MediaPlayer player;
    private MediaRecorder recorder;
    private final  String filepath = Environment.getExternalStorageDirectory().getPath()+ "/record.3gp";
    private static final int REQUEST_AUDIO_PERMISSION_CODE=200;
    private String RECORD_AUDIO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voice);
        recordVoiceBtn = (Button)findViewById(R.id.recordVoiceBtn);
        stopVoiceBtn = (Button)findViewById(R.id.stopVoiceBtn);
        playVoiceBtn = (Button)findViewById(R.id.playVoiceBtn);

        recordVoiceBtn.setOnClickListener(this);
        stopVoiceBtn.setOnClickListener(this);
        playVoiceBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v == recordVoiceBtn){
            if(checkPermission()){
                startRecording();
            } else {

                startRecording();
            }

        } else if(v == stopVoiceBtn){
            stopRecording();

        } else if(v == playVoiceBtn){
            playingRecording();

        }
    }

 
    private void playingRecording() {
        player = new MediaPlayer();
        player.setVolume(1.0f, 1.0f);
        try{
            player.setDataSource(filepath);
            player.prepare();
            player.start();
            Toast.makeText(this, "Kayıt Çalıyor", Toast.LENGTH_SHORT).show();

            player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    player.stop();
                    player.release();
                    player = null;
                }
            });
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void stopRecording() {
        if(recorder != null){
            Toast.makeText(this, "Kayıt Durduruldu", Toast.LENGTH_SHORT).show();
            recorder.stop();
            recorder.reset();
            recorder.release();

            recorder = null;
        }
    }
    private void requestPermissions() {
        ActivityCompat.requestPermissions(VoiceActivity.this, new String[]{RECORD_AUDIO, WRITE_EXTERNAL_STORAGE}, REQUEST_AUDIO_PERMISSION_CODE);
    }

    private void startRecording() {
        recorder = new MediaRecorder();
        //mıc değeri kaydın mikrofon üerinden gelen ses ile yapılacağını gösterir
        recorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        //setOutput format ise kaydın hangi sıkıştırma formatı ile çevrileceğini
        recorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
        //.setaudio encoder metodu ise kulllanıcalacak codec değerini seçer
        recorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
        //setoutputformat ile oluşturulan ses dosyasının kayıt edileceği konumu belirleriz
        recorder.setOutputFile(filepath);
        try {
            recorder.prepare();
            recorder.start();

        } catch (IOException e){
            e.printStackTrace();

        } catch ( IllegalStateException e){
            e.printStackTrace();
        }

    }
    private boolean checkPermission() {
        int result = ContextCompat.checkSelfPermission(getApplicationContext(), WRITE_EXTERNAL_STORAGE);
        int result_1 = ContextCompat.checkSelfPermission(getApplicationContext(), RECORD_AUDIO);
        return result == PackageManager.PERMISSION_GRANTED && result_1 == PackageManager.PERMISSION_GRANTED;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode){
            case REQUEST_AUDIO_PERMISSION_CODE:
                if(grantResults.length > 0){
                    boolean permissionToRecord = grantResults[0] == PackageManager.PERMISSION_GRANTED;
                    boolean permissionToStore = grantResults[1] == PackageManager.PERMISSION_GRANTED;
                    if(permissionToRecord && permissionToStore){
                        Toast.makeText(getApplicationContext(), "Permissin Granded", Toast.LENGTH_SHORT).show();
                    } else{
                        Toast.makeText(getApplicationContext(), "Permissin Denied", Toast.LENGTH_SHORT).show();
                    } break;
                }
        }
    }
}


