package com.kaito.thebarrage;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

public class SeikoActivity extends AppCompatActivity {
    TextView textView ;
    TextView textView2 ;
    TextView startBack;
    Button button ;
    Button button2 ;
    Button button3 ;
    Button button4 ;
    int point = 0 ;
    int point2 = 0 ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.seiko_activity);
        textView = (TextView)findViewById(R.id.textView);
        textView2 = (TextView)findViewById(R.id.textView2);
        startBack = (TextView)findViewById(R.id.startBack);
        button = (Button)findViewById(R.id.button);
        button2 = (Button)findViewById(R.id.button2);
        button3 = (Button)findViewById(R.id.button3);
        button4 = (Button)findViewById(R.id.button4);


        CountDownTimer countDownTimer = new CountDownTimer(20000,100) {
            @Override
            public void onTick(long millisUntilFinished) {
                int time = (int)millisUntilFinished / 1000;
                ((TextView)findViewById(R.id.tv)).setText("あと" + time + "秒");

                switch(startBack.getVisibility()){
                    case View.VISIBLE:
                        startBack.setVisibility(View.GONE);
                        break;
                    case View.GONE:
                        startBack.setVisibility(View.GONE);
                        break;}

            }



            @Override
            public void onFinish() {
                button.setEnabled(false);
                button2.setEnabled(false);
                button3.setEnabled(false);
                button4.setEnabled(false);

                switch(startBack.getVisibility()){
                    case View.VISIBLE:
                    case View.GONE:
                        startBack.setVisibility(View.VISIBLE);
                        break;}



                if (point > point2){
                    textView.setText("WIN");
                    textView2.setText("LOSE");
                }

                if (point < point2){
                    textView2.setText("WIN");
                    textView.setText("LOSE");
                }



            }
        }.start();

        if (Build.VERSION.SDK_INT >= 19){
            Window window = getWindow();
            View view = window.getDecorView();
            view.setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY |
                            View.SYSTEM_UI_FLAG_HIDE_NAVIGATION |
                            View.SYSTEM_UI_FLAG_FULLSCREEN
            );
        }
    }

    public void left(View v) {
        point = point + 1;
        textView.setText("" + point + "回");
    }

    public void right(View v){
        point = point + 1 ;
        textView.setText(""+point+"回");

    }

    public void right2(View v){
        point2 = point2 + 1;
        textView2.setText(point2 +"回");

    }

    public void left2(View v){
        point2 = point2 + 1;
        textView2.setText(point2 +"回");

    }

    public void startBack(View v){
        Intent intent = new Intent(this,StartActivity.class);
        startActivity(intent);

    }

}