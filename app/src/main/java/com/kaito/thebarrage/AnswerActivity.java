package com.kaito.thebarrage;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class AnswerActivity extends AppCompatActivity {

    Button button;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aswer);

        button = (Button) findViewById(R.id.button6);
    }

    public void command(View v){
        Intent intent = new Intent(this,RealTimeActivity.class);
        startActivity(intent);
    }

    }