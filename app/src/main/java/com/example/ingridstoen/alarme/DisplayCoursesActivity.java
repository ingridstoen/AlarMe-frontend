package com.example.ingridstoen.alarme;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.sql.SQLException;
import java.util.HashMap;
import android.widget.ArrayAdapter;
import android.widget.Toolbar;


import java.util.concurrent.ExecutionException;
public class DisplayCoursesActivity extends FragmentActivity implements View.OnClickListener{

    //Declaring variables
    Button Calender;
    Button Logout;


    //The method onCreate initialize the DisplayCoursesActivity
    protected void onCreate(Bundle savedInstanceState) {

        try {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_display_courses);

            //Create a list view in activity_Display_courses
            ListView lv = (ListView) findViewById(R.id.list_view);
            List courses = null;

            try {
                courses = new Database_Courses().execute().get(); //execute courses liste from Database_Courses class
                ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, courses);
                lv.setAdapter(arrayAdapter);
                // Perform action on click
                lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        if (position == 0) {
                            //Start DisplayCourse1
                            Intent intent = new Intent(view.getContext(), DisplayCourse1.class);
                            startActivityForResult(intent, 0);
                        }
                        if (position == 1) {
                            //Start  DisplayCourse2
                            Intent intent = new Intent(view.getContext(), DisplayCourse2.class);
                            startActivityForResult(intent, 1);

                        }
                        if (position == 2) {
                            //Start  DisplayCourse3
                            Intent intent = new Intent(view.getContext(), DisplayCourse3.class);
                            startActivityForResult(intent, 2);

                        }
                        if (position == 3) {
                            //Start DisplayCourse4
                            Intent intent = new Intent(view.getContext(), DisplayCourse4.class);
                            startActivityForResult(intent, 3);
                        }

                    }

                });

            } catch (InterruptedException e) {

                e.printStackTrace();

            } catch (ExecutionException e) {

                e.printStackTrace();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }Calender = (Button) findViewById(R.id.Calender);
        Logout= (Button)findViewById(R.id.Logout);
        Calender.setOnClickListener(this);
        Logout.setOnClickListener(this);


    }


    // Perform action on click
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.Calender:
                Intent intent = new Intent(DisplayCoursesActivity.this, calandar.class);
                startActivity(intent);
                break;
            case R.id.Logout:
                Intent intent1 = new Intent(DisplayCoursesActivity.this, MainActivity.class);
                startActivity(intent1);
                break;



        }


} }
