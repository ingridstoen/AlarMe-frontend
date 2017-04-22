package com.example.ingridstoen.alarme;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;

public class Splash_Screen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash__screen);


        Handler handler= new Handler();
        handler.postDelayed(new Runnable() {

            public void run() {
                startActivity(new Intent (Splash_Screen.this, DisplayCoursesActivity.class));
                finish();

            }

        },100);
    }
}

