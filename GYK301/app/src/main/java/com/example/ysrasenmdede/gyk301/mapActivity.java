package com.example.ysrasenmdede.gyk301;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class mapActivity extends AppCompatActivity {
    Button open_map_page ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        open_map_page= findViewById(R.id.open_map_page);
        open_map_page.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri geoLocation= Uri.parse("geo:36.1968,36.1612");
                showMap(geoLocation);
            }


        });
    }
    private void showMap(Uri geoLocation) {
        Intent intent=new Intent(Intent.ACTION_VIEW);
        intent.setData(geoLocation);
        if (intent.resolveActivity(getPackageManager())!=null);
        startActivity(intent);
    }
}
