package com.kaito.thebarrage;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView ;
    TextView textView2 ;
    Button button ;
    Button button2 ;
    Button button3 ;
    Button button4 ;
    Button title;
    int point = 0 ;
    int point2 = 0 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView)findViewById(R.id.textView);
        textView2 = (TextView)findViewById(R.id.textView2);
        button = (Button)findViewById(R.id.button);
        button2 = (Button)findViewById(R.id.button2);
        button3 = (Button)findViewById(R.id.button3);
        button4 = (Button)findViewById(R.id.button4);
        title = (Button)findViewById(R.id.button6);


        switch(title.getVisibility()){
            case View.VISIBLE:
                title.setVisibility(View.GONE);
                break;
            case View.GONE:
                title.setVisibility(View.GONE);
                break;}



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

    public void left(View v){
        point = point +1 ;
        textView.setText(""+point+"回");

        switch(title.getVisibility()){
            case View.VISIBLE:
                title.setVisibility(View.VISIBLE);
                break;}
        if (point == 250){
            //押した回数が250回になったら勝敗が決まる
            textView.setText("WIN");
            textView2.setText("LOSE");
            button.setEnabled(false);
            button2.setEnabled(false);
            button3.setEnabled(false);
            button4.setEnabled(false);


        }
    }

    public void right(View v){
        point = point + 1 ;
        textView.setText(""+point+"回");

        switch(title.getVisibility()){
            case View.VISIBLE:
                title.setVisibility(View.VISIBLE);
                break;}
        if (point == 250){
            textView.setText("WIN");
            textView2.setText("LOSE");
            button.setEnabled(false);
            button2.setEnabled(false);
            button3.setEnabled(false);
            button4.setEnabled(false);


        }
    }

    public void right2(View v){
        point2 = point2 + 1;
        textView2.setText(point2 +"回");//6

        switch(title.getVisibility()){
            case View.VISIBLE:
                title.setVisibility(View.VISIBLE);
                break;}
        if (point2 == 250){
            textView2.setText("WIN");//3//6
            textView.setText("LOSE");//5//3
            button.setEnabled(false);
            button2.setEnabled(false);
            button3.setEnabled(false);
            button4.setEnabled(false);


        }
    }

    public void left2(View v){
        point2 = point2 + 1;
        textView2.setText(point2 +"回");//6]

        switch(title.getVisibility()){
            case View.VISIBLE:
                title.setVisibility(View.VISIBLE);
                break;}
        if (point2 == 250) {
            textView2.setText("WIN");//3//6
            textView.setText("LOSE");//5//3
            button.setEnabled(false);
            button2.setEnabled(false);
            button3.setEnabled(false);
            button4.setEnabled(false);


        }
    }

    public void title(View v){
        Intent intent = new Intent(this,StartActivity.class);
        startActivity(intent);
    }

}
