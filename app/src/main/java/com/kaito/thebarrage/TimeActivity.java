package com.kaito.thebarrage;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class TimeActivity extends AppCompatActivity {
    ImageView imageView;
    TextView textView;
    ImageButton imageButton;
    Button button;
    Button color;
    int count;

    CountDownTimer countDownTimer;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.time_activity);
        textView = (TextView)findViewById(R.id.textView3);
        imageButton = (ImageButton)findViewById(R.id.hair);
        imageView = (ImageView)findViewById(R.id.sorry);
        button = (Button)findViewById(R.id.startw);
        color = (Button)findViewById(R.id.color);

        countDownTimer = new CountDownTimer(4000, 100) {
            @Override
            public void onTick(long millisUntilFinished) {
                int time = (int)millisUntilFinished /1000;

             //   textView.setText("あと"+time+"秒");


            }


            @Override
            public void onFinish() {
                imageButton.setBackgroundColor(Color.rgb(64, 33, 15));

            }
        };




        if (Build.VERSION.SDK_INT >= 19){
            Window window = getWindow();
            View view = window.getDecorView();
            view.setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY |
                            View.SYSTEM_UI_FLAG_HIDE_NAVIGATION |
                            View.SYSTEM_UI_FLAG_FULLSCREEN



            );}
    }

    public void hair(View v){
        count = count + 1 ;
        if (count % 14 == 0){
            Intent intent = new Intent(this,RealTimeActivity.class);
            startActivity(intent);
        }
    }

    public void startw(View v){
        Intent intent = new Intent(this,StartActivity.class);
        startActivity(intent);
    }




    public void color(View v){
        countDownTimer.start();
        imageButton.setBackgroundResource(R.color.hair);

        Log.d("TimeActivity", "color");
    }




}

