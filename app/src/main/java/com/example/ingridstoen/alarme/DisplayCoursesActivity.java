package com.example.ingridstoen.alarme;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class DisplayCoursesActivity extends FragmentActivity {

    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_courses);
        viewPager = (ViewPager) findViewById(R.id.view_pager);
    }

    public void course1(View view) {
        Intent intent = new Intent(this, DisplayCourse1.class);
        startActivity(intent);
    }

    public void course2(View view) {
        Intent intent = new Intent(this, DisplayCourse2.class);
        startActivity(intent);
    }

    public void course3(View view) {
        Intent intent = new Intent(this, DisplayCourse3.class);
        startActivity(intent);
    }

    public void course4(View view) {
        Intent intent = new Intent(this, DisplayCourse4.class);
        startActivity(intent);
    }
}
