package com.example.ingridstoen.alarme;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.Iterator;
import java.util.HashMap;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class DisplayCourse1 extends AppCompatActivity {

    ListView course1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_display_course1);
            Database_Assignments db = new Database_Assignments();
            ListView lv = (ListView) findViewById(R.id.course1);
            List assignment = null;
            try {
                    assignment = new Database_Assignments().execute().get();
            } catch (InterruptedException e) {

                    e.printStackTrace();

            } catch (ExecutionException e) {

                    e.printStackTrace();
                }

                ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, assignment);
                lv.setAdapter(arrayAdapter);
        } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }



