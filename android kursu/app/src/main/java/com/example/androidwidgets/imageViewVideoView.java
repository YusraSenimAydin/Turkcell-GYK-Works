package com.example.androidwidgets;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.VideoView;

public class imageViewVideoView extends AppCompatActivity {
    private Button buttonDegistir, buttonBasla, buttonDurdur;
    private ImageView imageView;
    private VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_view_video_view);

        buttonBasla = findViewById(R.id.buttonBasla);
        buttonDegistir = findViewById(R.id.buttonDegistir);
        buttonDurdur = findViewById(R.id.buttonDurdur);
        imageView = findViewById(R.id.imageView);
        videoView = findViewById(R.id.videoView);

        buttonDegistir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView.setImageResource(R.drawable.hummel);//image resim eklemek istiyorsak
            }
        });
        buttonBasla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //raw dosyasında ki adresini bulmamız lazım
                //uriler bizim ulaşmak istediğimiz yerlerin adresidir.oradaki adrese göre video calisir
                Uri adres = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.video);
                videoView.setVideoURI(adres);
                videoView.start();
            }
        });
        buttonDurdur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                videoView.stopPlayback();

            }
        });

    }
}
