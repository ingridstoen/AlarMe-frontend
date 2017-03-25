package com.example.ingridstoen.alarme;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Calendar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);
    }

    public void viewCourses(View view) {
        Intent intent = new Intent(this, DisplayCoursesActivity.class);
        startActivity(intent);
    }
}
