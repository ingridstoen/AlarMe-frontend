package com.example.ingridstoen.alarme;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;

public class Splash_Screen extends AppCompatActivity {

    @Override
    //The method onCreate initialize the Splash_Screen Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash__screen);
        //Creating Handler instance
        Handler handler= new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                //run the splash_Screen activity
                startActivity(new Intent (Splash_Screen.this, DisplayCoursesActivity.class));
                finish();

            }

        },75000);
    }
}

