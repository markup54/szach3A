package pl.zabrze.zs10.zegarszachy3a;

import android.graphics.Color;
import android.os.CountDownTimer;
import android.widget.TextView;

public class Gracz {
    private boolean dzialajacy;
    private int sekundy = 180;
    private TextView textView;
    private CountDownTimer timer;

    public Gracz(boolean dzialajacy, TextView textView) {
        this.dzialajacy = dzialajacy;
        this.textView = textView;
    }

    public boolean isDzialajacy() {
        return dzialajacy;
    }

    public int getSekundy() {
        return sekundy;
    }

    public void setDzialajacy(boolean dzialajacy) {
        this.dzialajacy = dzialajacy;
    }
    public void startCzas(){
        timer = new CountDownTimer(sekundy*1000,1000) {
            @Override
            public void onTick(long l) {
                sekundy = (int)l/1000;
                pokazCzas(sekundy);
            }

            @Override
            public void onFinish() {
                textView.setText("Koniec czasu");
            }
        };
        timer.start();
        dzialajacy = true;
    }
    public void stopCzas(){
        timer.cancel();
        dzialajacy = false;
    }
    private void pokazCzas(int s){
        int sek = s%60;
        int minuty = ((int)s/60)%60;
        int godziny =(int) s/3600;
        textView.setText(String.format("%02d:%02d:%02d",godziny,minuty,sek));
        if(s<30){
            textView.setTextColor(Color.RED);

        }
    }
}
