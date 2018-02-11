package com.kaito.thebarrage;

import android.content.Context;
import android.inputmethodservice.KeyboardView;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;

public class CustomKeyboardView extends KeyboardView{
    public CustomKeyboardView(Context context, AttributeSet attrs){
        super(context, attrs);
    }

    public void showWithAnimationStart(Animation animation){
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                //TODO Auto-generated method stub

            }

            @Override
            public void onAnimationRepeat(Animation animation) {setVisibility(View.VISIBLE);}
        });

        setAnimation(animation);

    }
}
