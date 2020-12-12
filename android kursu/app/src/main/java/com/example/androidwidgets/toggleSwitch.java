package com.example.androidwidgets;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;
import android.widget.ToggleButton;

public class toggleSwitch extends AppCompatActivity {
    private ToggleButton toggleButton;
    private Switch mSwitch;
    private Button buttonYap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toggle_switch);

        toggleButton = findViewById(R.id.toggleButton);
        mSwitch = findViewById(R.id.mSwitch);
        buttonYap = findViewById(R.id.buttonYap);

        buttonYap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butona bastıgım zaman on mu off mu olduklarını anlamak icin
                Boolean switchDurum = mSwitch.isChecked();
                Boolean toggleDurum = toggleButton.isChecked();
                // toast mesaji ile göstericem
                // ilk istedigi parametre contextdir
                //contex androidten bir parca olarak düsünülebilir.Android parcacıgı
                //Androidin kendine ait görsel nesneleri vardır. Toast gibi. Diyor ki bu activity icinde calıssın.
                // calıstırmak ıcın ben bu activityle calısıyorum dıye ıspatlamamız lazım.
                //1.yöntem getApplicationContext diye biliriz
                //2.yötem bulundugu sınıfın adı mainActivity
                //3.yöntem direk this diyebiliriz(Button icinde degilde dısında oldugunda)..Metodu isaret eder
                //mainActivity.this dersek bu activityde oldugumusuz isaret eder
                //toasta ikinci parametre vermek istedigim mesaji istiyor

                Toast.makeText(toggleSwitch.this,
                        "SD:"+switchDurum+ "TD:"+toggleDurum
                        ,Toast.LENGTH_SHORT).show();

            }
        });
        //check eddildiginde ,check edilmesi degistiginde bir sonuc verir
        //tıklanıldıgı zaman bir işlem yapar
  mSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
      @Override
      public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
            Log.e("Switch Durum",String.valueOf(b));
      }
  });
  toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
      @Override
      public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
          Log.e("Toggle Durum",String.valueOf(b));
      }
  });
    }
}
