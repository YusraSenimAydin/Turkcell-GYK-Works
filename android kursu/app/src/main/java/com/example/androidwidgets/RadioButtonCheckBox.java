package com.example.androidwidgets;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.Toast;

public class RadioButtonCheckBox extends AppCompatActivity {
    private CheckBox checkBoxJava, checkBoxC, checkBoxPhp;
    private RadioButton radioButtonBjk, radioButtonGs, radioButtonFb;
    private String dilSonuc = ""; // bunu içine seçilen dilleri eklicem
    private Button buttonYap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio_button_check_box);

        checkBoxJava = findViewById(R.id.checkBoxJava);
        checkBoxC = findViewById(R.id.checkBoxC);
        checkBoxPhp = findViewById(R.id.checkBoxPhp);

        radioButtonBjk = findViewById(R.id.radioButtonBjk);
        radioButtonFb = findViewById(R.id.radioButtonFb);
        radioButtonGs = findViewById(R.id.radioButtonGs);
        buttonYap = findViewById(R.id.buttonYap);

        buttonYap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (checkBoxJava.isChecked()) {
                    dilSonuc = dilSonuc + "JAVA";
                }
                if (checkBoxC.isChecked()) {
                    dilSonuc = dilSonuc + "C#";
                }
                if (checkBoxPhp.isChecked()) {
                    dilSonuc = dilSonuc + "PHP";
                }
                Toast.makeText(getApplicationContext(), dilSonuc, Toast.LENGTH_SHORT).show();
                dilSonuc = "";
            }
        });
        radioButtonBjk.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                Log.e("Beşiktaş", String.valueOf(b));
            }
        });
    }
}
