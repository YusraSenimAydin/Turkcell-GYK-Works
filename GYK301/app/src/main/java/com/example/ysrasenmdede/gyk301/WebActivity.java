package com.example.ysrasenmdede.gyk301;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.ClientCertRequest;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.Toast;

public class WebActivity extends AppCompatActivity {
     WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        webView=(WebView) findViewById(R.id.webView);
        String gyurl="https://gelecegiyazanlar.turkcell.com.tr/";
        openWebPage(gyurl);

    }

    private void openWebPage(String gyurl) {
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl(gyurl);
        final ProgressDialog progress=ProgressDialog.show(this,"Geleceği yazanlar","Yükleniyor");
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                Toast.makeText(getApplicationContext(), "Sayfa yükleniyor",Toast.LENGTH_SHORT).show();
            progress.dismiss();
            }

            @Override
            public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
                super.onReceivedError(view, request, error);
                Toast.makeText(getApplicationContext(), "Hata!!",Toast.LENGTH_SHORT).show();
                progress.dismiss();
            }
        });

    }
}
