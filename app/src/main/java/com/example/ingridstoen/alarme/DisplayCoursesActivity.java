package com.example.ingridstoen.alarme;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.app.Activity;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

import java.sql.Date;
import java.sql.SQLException;
import java.util.HashMap;

public class DisplayCoursesActivity extends FragmentActivity {
    String username, password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_courses);

        try{

            Database_Login db= new Database_Login();
            db.execute();
            ListView lv= (ListView) findViewById(R.id.list);
            ArrayAdapter ad= new ArrayAdapter(db.addCourses(),this);
            lv.setAdapter(ad);

        }
        catch(Exception e){
            System.out.print("e");
        }











    }

    public void course1(View view) {
        Intent intent = new Intent(this, DisplayCourse1.class);
        Database_Login db = new Database_Login();
        try {
            db.addAssignments();
            HashMap<String, Date> assignments = db.getAssignments();
            for (String key: assignments.keySet()) {

            }
        } catch(SQLException e) {
            System.out.println(e.getMessage());
        }
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

    public void viewCalendar(View view) {
        Intent intent = new Intent(this, Calendar.class);
        startActivity(intent);
    }
}
