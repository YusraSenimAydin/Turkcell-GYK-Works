package com.example.ysrasenmdede.gazeteler;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;



public class Main2Activity extends AppCompatActivity {

    private WebView webView;

    public static String haberUrl;

    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        webView = (WebView) findViewById(R.id.webView);

        progressBar = (ProgressBar) findViewById(R.id.progressBar);

        webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return false;
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                progressBar.setVisibility(View.GONE);
            }
        });
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl(haberUrl);
    }
}
