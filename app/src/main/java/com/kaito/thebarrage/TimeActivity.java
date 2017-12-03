package com.kaito.thebarrage;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.view.menu.MenuView;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class TimeActivity extends AppCompatActivity {
    ImageView imageView;
    ImageButton imageButton;
    Button button;
    int count;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.time_activity);
        imageButton = (ImageButton)findViewById(R.id.hair);
        imageView = (ImageView)findViewById(R.id.sorry);

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
        if (count == 14){
            Intent intent = new Intent(this,RealTimeActivity.class);
            startActivity(intent);
        }
    }

    public void startw(View v){
        Intent intent = new Intent(this,StartActivity.class);
        startActivity(intent);
    }

}

