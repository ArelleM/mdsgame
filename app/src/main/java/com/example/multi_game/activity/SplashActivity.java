package com.example.multi_game.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import com.example.multi_game.R;
import com.example.multi_game.utils.ActivityUtils;

public class SplashActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                ActivityUtils.launchActivity(SplashActivity.this, CreatePlayerActivity.class);
            }
        },2000);


    }
}
