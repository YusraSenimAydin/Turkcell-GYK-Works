package com.example.androidwidgets;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.TextView;

public class ProgressBarSeekBarRatingBar extends AppCompatActivity {
    private TextView textViewSlider, textViewRating;
    private Button buttonBasla, buttonBitir;
    private ProgressBar progressBar;
    private SeekBar slider;
    private RatingBar ratingBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_bar_seek_bar_rating_bar);

        textViewRating = findViewById(R.id.textViewRating);
        textViewSlider = findViewById(R.id.textViewSlider);
        buttonBasla = findViewById(R.id.buttonBasla);
        buttonBitir = findViewById(R.id.buttonDurdur);
        progressBar = findViewById(R.id.progressBar);
        slider = findViewById(R.id.slider);
        ratingBar = findViewById(R.id.ratingBar);

        buttonBasla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar.setVisibility(View.VISIBLE);
            }
        });

        buttonBasla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar.setVisibility(View.INVISIBLE);
            }
        });
        slider.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            //ilerleyesin sonucunu verir. ilerleme miktarını verir.i yazan hangi durumda oldugunu verir
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                textViewSlider.setText("Slider:" + i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            //float v ondalıklı olarak verilen oyu bize veriyor.int istersem
            //buyuk sayıyı kucuk sayıya dönüstürcem
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                textViewRating.setText("Oy:" + ((int) v));
            }
        });
    }
}
