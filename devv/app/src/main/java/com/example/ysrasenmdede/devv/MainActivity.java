package com.example.ysrasenmdede.devv;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedWriter;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public static     LocationManager locationManager;
    public static   LocationListener locationListener;
    public static   Button btn;
    public static   TextView enlem, boylam;
    double e;
    double b;
    Context c;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        enlem = (TextView) findViewById(R.id.enlem);
        boylam = (TextView) findViewById(R.id.boylam);
        btn = (Button) findViewById(R.id.btn);
        btn.setOnClickListener(this);
        c=this;
    }
    @Override
    public void onClick(View v) {
        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        locationListener = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                //konum değistiginde bu fonk calısıyor
                  e=location.getLatitude();
                  b=location.getLongitude();
                MainActivity.enlem.setText(e+"");
                MainActivity.boylam.setText(b+"");
               post(e+"",b+"");
                locationManager.removeUpdates(locationListener);//listener iptal ediliyor
            }

            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {

            }

            @Override
            public void onProviderEnabled(String provider) {

            }

            @Override
            public void onProviderDisabled(String provider) {

            }
        };
        ActivityCompat.requestPermissions(MainActivity.this,new String[]{Manifest.permission.ACCESS_FINE_LOCATION},1);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            return;
        }
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 2000, 0, locationListener);

    }
    public  void post(final String enlem, final String boylam)
    {

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    URL url = new URL("http://yusradede.orgfree.com/harita.php");
                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                    conn.setReadTimeout(10000);
                    conn.setConnectTimeout(15000);
                    conn.setRequestMethod("POST");
                    conn.setDoInput(true);
                    conn.setDoOutput(true);
                    Uri.Builder builder = new Uri.Builder();//post paremetreleri ayarlanıyor
                    builder.appendQueryParameter("enlem",enlem);
                    builder.appendQueryParameter("boylam", boylam);
                    String query = builder.build().getEncodedQuery();

                    OutputStream os = conn.getOutputStream();//bağlantının cıkısı
                    BufferedWriter writer = new BufferedWriter(
                            new OutputStreamWriter(os, "UTF-8"));
                    writer.write(query);
                    writer.flush();
                    writer.close();
                    os.close();
                    conn.connect();
                    Log.d("hata",conn.getResponseMessage());
                }
                catch (Exception ex)
                {
                    Log.d("hata",ex.getMessage());
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        Toast.makeText(c,"Konumunuz Kayıt edildi.", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        }).start();
    }
}
