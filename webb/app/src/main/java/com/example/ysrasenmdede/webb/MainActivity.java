package com.example.ysrasenmdede.webb;

import android.content.Context;
import android.net.ConnectivityManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button Geri, Ileri, Anasayfa, Git;
    WebView webV;
    EditText URL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        webV = (WebView) findViewById(R.id.webV);
        webV.getSettings().setJavaScriptEnabled(true);
        webV.setWebViewClient(new MyWebViewClient());
        webV.loadUrl("http://www.google.com.tr");
        URL = (EditText) findViewById(R.id.URL);
        Geri = (Button) findViewById(R.id.Geri);
        Ileri = (Button) findViewById(R.id.Ileri);
        Anasayfa = (Button) findViewById(R.id.Anasayfa);
        Git = (Button) findViewById(R.id.Git);

        Git.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (URL.getText().toString().length() > 10) {
                    Toast.makeText(
                            getApplicationContext(),
                            URL.getText().toString()
                                    + " adresi yükleniyor...",
                            Toast.LENGTH_SHORT).show();
                    if (InternetKontrol())
                        webV.loadUrl("http://" + URL.getText().toString());
                    else
                        BaglantiHatasiVer();
                } else {
                    Toast.makeText(getApplicationContext(), "Geçersiz Adres",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
        Anasayfa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                if (InternetKontrol())
                    webV.loadUrl("http://www.google.com.tr");
                else
                    BaglantiHatasiVer();
            }
        });
        Geri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                if (webV.canGoBack()) {
                    webV.goBack();
                }
            }
        });
        Ileri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                if (webV.canGoForward()) {
                    webV.goForward();
                }
            }
        });
    }

    private class MyWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }

    public void BaglantiHatasiVer() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                MainActivity.this);
        alertDialogBuilder.setTitle("Sunucu Hatası");
        alertDialogBuilder.setMessage(
                "internet bağlantınızı kontrol edip tekrar deneyin")
                .setCancelable(true);
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

    public boolean InternetKontrol() {
        ConnectivityManager manager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        if (manager.getActiveNetworkInfo() != null
                && manager.getActiveNetworkInfo().isAvailable()
                && manager.getActiveNetworkInfo().isConnected()) {
            return true;
        } else {
            return false;
        }
    }
}