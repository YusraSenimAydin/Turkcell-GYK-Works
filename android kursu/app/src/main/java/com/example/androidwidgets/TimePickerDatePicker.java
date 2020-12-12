package com.example.androidwidgets;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import java.util.Calendar;

public class TimePickerDatePicker extends AppCompatActivity {
    private EditText editTextSaat, editTextTarih;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_picker_date_picker);

        editTextSaat = findViewById(R.id.editTextSaat);
        editTextTarih = findViewById(R.id.editTextTarih);

        editTextSaat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //kullanıcıdan zamanı almak isticem
                //öncelikli olarak timepicker varsayılan zamanı istiyor
                //saat dakikayı istiyor. saat ve dakikayı güncel olarak almak istiyorum
                //tıklandıgı zaman o an saat kacsa onu almak istiyorum
                Calendar c = Calendar.getInstance();
                //anlık saati ve dakikayı secmesi icin calendar diye bir sınıf var
                int saat = c.get(Calendar.HOUR_OF_DAY);
                int dk = c.get(Calendar.MINUTE);
                //Time picker diye bir nesne olusturcam o nesne bize bunların gösterilmesini saglıcak


                TimePickerDialog timePicker=new TimePickerDialog(TimePickerDatePicker.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        editTextSaat.setText( hourOfDay + ":" + minute);//Ayarla butonu tiklandiginda textview'a yazdırıyoruz

                    }
                },saat,dk,true);
                //24 saate uygun mu değil mi
                timePicker.setTitle("Saat seçiniz");
                timePicker.setButton(TimePickerDialog.BUTTON_POSITIVE,"AYARLA",timePicker);
                timePicker.setButton(TimePickerDialog.BUTTON_NEGATIVE, "İptal", timePicker);

                timePicker.show();
            }
        });

        editTextTarih.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar mcurrentTime = Calendar.getInstance();
                int year = mcurrentTime.get(Calendar.YEAR);//Güncel yili aliyoruz
                int month = mcurrentTime.get(Calendar.MONTH);//Güncel ayi aliyoruz
                int day = mcurrentTime.get(Calendar.DAY_OF_MONTH);//Güncel günü aliyoruz

                DatePickerDialog datePicker=new DatePickerDialog(TimePickerDatePicker.this, new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear,
                                          int dayOfMonth) {

                        editTextTarih.setText( dayOfMonth + "/" + monthOfYear+ "/"+year);//Ayarla butonu tiklandiginda textview'a yazdırıyoruz

                    }
                },year,month,day);//baslarken set edilcek degerlerimizi atiyoruz
                datePicker.setTitle("Tarih Seçiniz");
                datePicker.setButton(DatePickerDialog.BUTTON_POSITIVE, "Ayarla", datePicker);
                datePicker.setButton(DatePickerDialog.BUTTON_NEGATIVE, "İptal", datePicker);

                datePicker.show();
            }
        });
    }
}
