package pl.zabrze.zs10.zegarszachy3a;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SzachyActivity extends AppCompatActivity {

    private TextView textView1;
    private TextView textView2;
    private Button button;
    private Gracz gracz1;
    private Gracz gracz2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_szachy);
        textView1 = findViewById(R.id.textView2);
        textView2 = findViewById(R.id.textView3);
        button = findViewById(R.id.button);
        gracz1 = new Gracz(true,textView1);
        gracz1.startCzas();
        gracz2 = new Gracz(false,textView2);
        button.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(gracz1.isDzialajacy()){
                            gracz2.startCzas();
                            gracz1.stopCzas();
                            button.setText("Gracz2");
                        }
                        else{
                            gracz1.startCzas();
                            gracz2.stopCzas();
                            button.setText("Gracz1");
                        }
                    }
                }
        );
        //TODO znikanie po końcu czasu przycisku
        //TODO dodawanie nowych sekund za wykonanie ruchu
        //TODO ikon
        //TODO wyglad bardziej szachowy
        //TODO wyswietlanie na początku czasu
        //TODO wybor czasu (3 minuty, 10 minut itd)
        //TODO po obroceniu tracimy dane -> ViewModel
        //TODO przerobić to na dwa fragmenty


    }
}