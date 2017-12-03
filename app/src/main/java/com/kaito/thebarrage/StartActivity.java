package com.kaito.thebarrage;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.Button;


public class StartActivity extends AppCompatActivity {

    Button button;
    Button button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_activity);

        button = (Button) findViewById(R.id.count);
        button2 = (Button)findViewById(R.id.Time);



        if (Build.VERSION.SDK_INT >= 19){
            Window window = getWindow();
            View view = window.getDecorView();
            view.setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY |
                            View.SYSTEM_UI_FLAG_HIDE_NAVIGATION |
                            View.SYSTEM_UI_FLAG_FULLSCREEN
            );}
    }
    public void count(View v){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }

    public void time(View v){
        Intent intent = new Intent(this,TimeActivity.class);
        startActivity(intent);
    }



}