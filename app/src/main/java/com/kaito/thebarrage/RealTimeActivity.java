package com.kaito.thebarrage;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class RealTimeActivity extends AppCompatActivity {
    ImageView imageView;
    EditText editText;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.real_time_activity);
        imageView = (ImageView) findViewById(R.id.doroid);
        editText = (EditText)findViewById(R.id.edittext);
        button = (Button)findViewById(R.id.ok);




        if (Build.VERSION.SDK_INT >= 19){
            Window window = getWindow();
            View view = window.getDecorView();
            view.setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY |
                            View.SYSTEM_UI_FLAG_HIDE_NAVIGATION |
                            View.SYSTEM_UI_FLAG_FULLSCREEN
            );}
    }


    public void ok(View v){

        String str= editText.getText().toString();


        if (str.equals("↑↑↓↓←→←→BA")){
            Intent intent = new Intent(this,SeikoActivity.class);
            startActivity(intent);
        }else if (str.equals("上上下下左右左右BA") ){
            Intent intent = new Intent(this,SeikoActivity.class);
            startActivity(intent);
        }else if (str.equals("うえうえしたしたひだりみぎひだりみぎBA")){
            Intent intent = new Intent(this,SeikoActivity.class);
            startActivity(intent);
        }

    }

    }






