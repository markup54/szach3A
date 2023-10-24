package pl.zabrze.zs10.zegarszachy3a;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private CountDownTimer timer;
    private TextView textView;
    private Button buttonStart;
    private Button buttonStop;
    private int liczbaSekund =20;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
        timer = new CountDownTimer(liczbaSekund*1000,1000) {
            @Override
            public void onTick(long l) {
                liczbaSekund =(int) l/1000;
                textView.setText(String.valueOf(liczbaSekund));
            }

            @Override
            public void onFinish() {
                textView.setText("Koniec");

            }
        };
        timer.start();
    }
}