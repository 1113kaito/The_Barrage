package com.kaito.thebarrage;

import android.app.Activity;
import android.drm.DrmStore;
import android.inputmethodservice.KeyboardView;
import android.support.v7.app.ActionBar;
import android.util.Log;

public class BasicOnKeyboardActionListener implements KeyboardView.OnKeyboardActionListener{

    CustomKeyboardView displayKeyboardView;
    Activity mTargetActivity;

    public BasicOnKeyboardActionListener(Activity targetActivity,CustomKeyboardView displayKeyboardView){
        mTargetActivity = targetActivity;
        this.displayKeyboardView = displayKeyboardView;
    }
    @Override
    public void swipeUp(){

    }
    @Override
    public void swipeRight(){

    }

    @Override
    public void swipeLeft(){


    }

    @Override
    public void swipeDown(){

    }

    @Override
    public void onText(CharSequence text){

//        Log.e("TAG",String.valueOf(text));


    }

    @Override
    public void onRelease(int primaryCode){
    }

    @Override
    public void onPress(int primaryCode){
    }

    @Override
    public void onKey(int primaryCode, int[] keyCode){
    }
}
