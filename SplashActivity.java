package com.example.myapplicationrealrealrealarray;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

public class SplashActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            Thread.sleep(4000);
        }catch(InterruptedException e) {
            e.printStackTrace();
        }
        startActivity(new Intent(SplashActivity.this, PreviewActivity.class));
        finish();


    }
}



