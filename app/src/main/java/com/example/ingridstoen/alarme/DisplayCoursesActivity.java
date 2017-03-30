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
public class DisplayCoursesActivity extends FragmentActivity implements View.OnClickListener {
    Button button;
    protected void onCreate(Bundle savedInstanceState) {
        try {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_display_courses);
            button = (Button) findViewById(R.id.button);
            button.setOnClickListener(this);
            Database_Courses db = new Database_Courses();
            ListView lv = (ListView) findViewById(R.id.list_view);
            List courses = null;
            List courses_codes = null;
            try {
                courses = new Database_Courses().execute().get();
                ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, courses);
                lv.setAdapter(arrayAdapter);
            /*courses_codes = new Database_Exam_Codes().execute().get();
            ArrayAdapter<String> arrayAdapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, courses_codes);
            lv.setAdapter(arrayAdapter1);*/
                lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        if (position == 0) {
                            Intent intent = new Intent(view.getContext(), DisplayCourse1.class);
                            startActivityForResult(intent, 0);
                        }
                        if (position == 1) {
                            Intent intent = new Intent(view.getContext(), DisplayCourse2.class);
                            startActivityForResult(intent, 1);

                        }
                        if (position == 2) {
                            Intent intent = new Intent(view.getContext(), DisplayCourse3.class);
                            startActivityForResult(intent, 2);

                        }
                        if (position == 3) {
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
        }


    }

    public void onClick(View v) {
       /* switch (v.getId()) {
            case R.id.button2:
                Intent intent = new Intent(DisplayCoursesActivity.this, Calender.class);
                startActivity(intent);
                break;

        }*/
    }


}
