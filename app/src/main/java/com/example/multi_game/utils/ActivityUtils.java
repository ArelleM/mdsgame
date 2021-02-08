package com.example.multi_game.utils;

import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;

import com.example.multi_game.R;
import com.example.multi_game.activity.CreatePlayerActivity;
import com.example.multi_game.activity.SplashActivity;

public class ActivityUtils {
    public static void launchActivity(AppCompatActivity activity, Class className) {
        launchActivity(activity,className,true,true);
    }
    public static void launchActivity(AppCompatActivity activity, Class className, boolean isFinish, boolean isSlide){
        Intent intent = new Intent(activity, className);
        launchActivity(activity, intent, isFinish, isSlide);
    }
    public static void launchActivity(AppCompatActivity activity,Intent intent,boolean isFinish, boolean isSlide){

        activity.startActivity(intent);
        activity.overridePendingTransition(isSlide ? R.anim.slide_in_from_right : R.anim.fade_in, R.anim.fade_out);
        if (isFinish) activity.finish();
    }

}
