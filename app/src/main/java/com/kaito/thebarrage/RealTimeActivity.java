package com.kaito.thebarrage;

import android.content.Intent;
import android.inputmethodservice.Keyboard;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class RealTimeActivity extends AppCompatActivity {
    ImageView imageView;
    EditText editText;
    Button answer;
    CustomKeyboardView mKeyboardView;
    Keyboard mKeyboard;



    List<String> list = new ArrayList<String>();
    List<String> answerList = new ArrayList<String>();
    List mList = new ArrayList<String>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.real_time_activity);
        imageView = (ImageView) findViewById(R.id.doroid);

        mKeyboardView = (CustomKeyboardView)findViewById(R.id.keyboardView);

        answerList.add("上");
        answerList.add("上");
        answerList.add("下");
        answerList.add("下");
        answerList.add("右");
        answerList.add("右");
        answerList.add("左");
        answerList.add("左");
        answerList.add("A");
        answerList.add("B");


        setUpKeyboard();



        if (Build.VERSION.SDK_INT >= 19) {
            Window window = getWindow();
            View view = window.getDecorView();
            view.setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY |
                            View.SYSTEM_UI_FLAG_HIDE_NAVIGATION |
                            View.SYSTEM_UI_FLAG_FULLSCREEN
            );
        }
    }

    public void ok(View v) {

        String str = editText.getText().toString();


        if (str.equals("↑↑↓↓←→←→BA")) {
            Intent intent = new Intent(this, SeikoActivity.class);
            startActivity(intent);
        } else if (str.equals("上上下下左右左右BA")) {
            Intent intent = new Intent(this, SeikoActivity.class);
            startActivity(intent);
        } else if (str.equals("うえうえしたしたひだりみぎひだりみぎBA")) {
            Intent intent = new Intent(this, SeikoActivity.class);
            startActivity(intent);
        }

    }

    public void answer(View v){
        Intent intent = new Intent(this,AnswerActivity.class);
        startActivity(intent);
    }

    public void setUpKeyboard(){
        mKeyboardView.setPreviewEnabled(false);
        mKeyboardView.setOnKeyboardActionListener(new BasicOnKeyboardActionListener(RealTimeActivity.this,mKeyboardView) {
            @Override
            public void onText(CharSequence text) {
                Log.d("TAG", text.toString());
                list.add(text.toString());
                if (checkArray()) {
                    Intent intent = new Intent(getApplicationContext(), SeikoActivity.class);
                    startActivity(intent);
                }

            }
        });
    }

    private Boolean checkArray() {
        Boolean flag = true;
        if (answerList.size() != list.size()) {
            return false;
        }
        for (int i = 0; i  < answerList.size(); i++) {
            String string = list.get(i);
            String string2 = answerList.get(i);

            if (string.equals(string2)){
                // do nothing
            }else {
                list.remove(i);
                flag = false;
                break;
            }
        }
        return flag;
    }
    @Override
    public void onResume(){
        super.onResume();
        mKeyboardView.setVisibility(View.GONE);
        mKeyboard = new Keyboard(RealTimeActivity.this,R.xml.mykeyboard);
        showKeyboardWithAnimation();
        mKeyboardView.setVisibility(View.VISIBLE);
        mKeyboardView.setKeyboard(mKeyboard);
    }


    public void showKeyboardWithAnimation(){
        if (mKeyboardView.getVisibility() == View.GONE){
            Animation animation = AnimationUtils
                    .loadAnimation(RealTimeActivity.this,
                            R.anim.slide_from_bottom);
            mKeyboardView.showWithAnimationStart(animation);
        }
    }
}