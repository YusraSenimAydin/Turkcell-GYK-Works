package com.example.draganddrop;

import android.content.ClipData;
import android.content.ClipDescription;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnDragListener, View.OnLongClickListener {
    private TextView textView;
    private Button button;
    private ImageView imageView;

    private LinearLayout ust_tasarim;
    private LinearLayout sol_tasarim;
    private LinearLayout sag_tasarim;

    private static final String YAZI_ETIKET = "YAZI";
    private static final String BUTTON_ETIKET = "BUTON";
    private static final String RESIM_ETIKET = "RESİM";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ust_tasarim = findViewById(R.id.ust_tasarim);
        sol_tasarim = findViewById(R.id.sol_tasarim);
        sag_tasarim = findViewById(R.id.sag_tasarim);

        textView = findViewById(R.id.textView);
        textView.setTag(YAZI_ETIKET);//etiketi görsel nesneye ekledik
        button = findViewById(R.id.button);
        button.setTag(BUTTON_ETIKET);
        imageView = findViewById(R.id.imageView);
        imageView.setTag(RESIM_ETIKET);
        //uzun basılma listenerlarının görsel nesnelere bağlanması
        textView.setOnLongClickListener(this);
        button.setOnLongClickListener(this);
        imageView.setOnLongClickListener(this);
// sürüklenme listenerlarının tasarıma bağlanması
        ust_tasarim.setOnDragListener(this);
        sol_tasarim.setOnDragListener(this);
        sag_tasarim.setOnDragListener(this);

    }


    @Override
    public boolean onDrag(View view, DragEvent dragEvent) {
        switch (dragEvent.getAction()) {
            case DragEvent.ACTION_DRAG_STARTED:
                return true;
            case DragEvent.ACTION_DRAG_ENTERED:
                //eger görsel nesne tasarım alanına girerse
                //tasarım alanının arkaplanı sarı renk yaptım
                view.getBackground().setColorFilter(Color.YELLOW, PorterDuff.Mode.SRC_IN);
                view.invalidate();//sarı rengi uyguluyor
                return true;
            case DragEvent.ACTION_DRAG_LOCATION:
                return true;
            case DragEvent.ACTION_DRAG_EXITED:
                //eger görsel nesne tasarım alanından cıkarsa tasarım alanı eski haline döner
                view.getBackground().clearColorFilter();
                view.invalidate();
                return true;
            case DragEvent.ACTION_DROP:
                //eger görsel nesne tasarım alına bırakılırsa tasarım alanı eski haline döner
                view.getBackground().clearColorFilter();
                view.invalidate();
                // sürüklenen görsel nesne
                View gorselNesne = (View) dragEvent.getLocalState();
                // sürüklenen görsel nesnenin eski bulundugu tasarım alanı
                ViewGroup eskiTasarimAlani = (ViewGroup) gorselNesne.getParent();
                // görsel nesnenin eskki bulundugu alanı sil
                eskiTasarimAlani.removeView(gorselNesne);

                //view sürüklenen tasarım alanını yani hedef tasarım alanını LinerLayouta dönüştürdük
                LinearLayout hedefTasarimAlani = (LinearLayout) view;
                //hedeflenen tasarım alanına görsel nesneyi ekledij
                hedefTasarimAlani.addView(gorselNesne);
                //görsel nesne görünür olur
                gorselNesne.setVisibility(View.VISIBLE);

                return true;
            case DragEvent.ACTION_DRAG_ENDED:
                view.getBackground().clearColorFilter();
                view.invalidate();
                Toast.makeText(this,"sürüklenme bitti ", Toast.LENGTH_SHORT).show();
                return true;
            default:
                break;
        }
        return false;
    }

    @Override
    public boolean onLongClick(View view) {
        //uzun süre basılı tutulan nesnenin etiketi alınır
        ClipData.Item item = new ClipData.Item((CharSequence) view.getTag());
        //etiket text türünde oldugu için açıklama yapılır
        String[] mimeTypes = {ClipDescription.MIMETYPE_TEXT_PLAIN};
        //kopyalanacak veri olusturulur
        ClipData clipData = new ClipData(view.getTag().toString(), mimeTypes, item);
        //görsel nesnenin gölgesi olusturulur
        View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(view);
        //sürüklemeye baslatılır
        view.startDrag(clipData, shadowBuilder, view, 0);
        // görsel nesne sürüklenmeye baslatılınca görünmez olur
        view.setVisibility(View.INVISIBLE);

        return true;
    }
}