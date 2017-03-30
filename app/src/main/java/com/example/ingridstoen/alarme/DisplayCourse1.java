package com.example.ingridstoen.alarme;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class DisplayCourse1 extends AppCompatActivity {

    ListView course1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_display_course1);
            ListView lv = (ListView) findViewById(R.id.course1);
            List<String> assignment = null;
            List<String> courses = null;
            List<String> assignmentTDT4140 = new ArrayList<>();
            List<String> splittedList2;
            String coursecode1;
            try {
                assignment = new Database_Assignments().execute().get();
                courses = new Database_Exam_Codes().execute().get();
                for (String a : assignment) {
                    String[] array = a.toString().split(" ", 1);
                    List<String> splittedList1 = new ArrayList<String>(Arrays.asList(a.split(" ")));
                    coursecode1 = splittedList1.get(0);
                    Log.e("Liste", coursecode1);

                }
                /*for (String a: assignment) {
                     String[] array = a.toString().split(" ", 1);
                     List<String> splittedList1 = new ArrayList<String>(Arrays.asList(a.split(" ")));
                     coursecode1 = splittedList1.get(0);
                     Log.e("Liste", coursecode1);

                    for (String b : courses) {
                        String[] array1 = b.toString().split(" ", 1);
                        splittedList2 = new ArrayList<String>(Arrays.asList(b.split(" ")));
                        String coursecode2 = splittedList2.get(0);
                    }

                    for (int i = 0; i < splittedList2.size(); i++) {
                        if (coursecode1.equals(splittedList2.get(0))) {
                            assignmentTDT4140.add(a);

                        }
                    }*/


            }catch (InterruptedException e) {
            e.printStackTrace();

        }

            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, courses);
            lv.setAdapter(arrayAdapter);


            } catch (ExecutionException e) {
                e.printStackTrace();


                //} catch (Exception e) {
                //  e.printStackTrace();
                //}


            }
        }
}






