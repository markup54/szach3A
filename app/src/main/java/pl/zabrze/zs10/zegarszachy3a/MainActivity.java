package pl.zabrze.zs10.zegarszachy3a;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private CountDownTimer timer;
    private TextView textView;
    private Button buttonStart;
    private Button buttonStop;
    private int liczbaSekund =20;
    private boolean odpalony;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);



        buttonStart = findViewById(R.id.buttonStart);
        buttonStart.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        odpalony = true;
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
        );
        buttonStop = findViewById(R.id.buttonStop);
        buttonStop.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        odpalony = false;
                        timer.cancel();
                    }
                }
        );
    }
}