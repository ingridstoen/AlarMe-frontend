package com.example.ingridstoen.alarme;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class DisplayCourse3 extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_display_course3);
            ListView lv = (ListView) findViewById(R.id.list_view3);
            List<String> assignment = null;
            List<String> courses = null;
            List<String> splittedList1=null;
            List<String> splittedList2=null;
            List<String> coursecodeC = new ArrayList<>();
            List<String> coursecodeA = new ArrayList<>();
            List<String> assignmentOnly = new ArrayList<>();
            List<String> assignmentsDisplay3 = new ArrayList<>();
            try{
                assignment = new Database_Assignments().execute().get();
                courses = new Database_Courses().execute().get();
                for (String a : courses) {
                    splittedList1 = new ArrayList<String>(Arrays.asList(a.split(" ")));
                    coursecodeC.add(splittedList1.get(0));
                }
                for (String b : assignment) {

                    splittedList2 = new ArrayList<String>(Arrays.asList(b.split(" ")));
                    coursecodeA.add(splittedList2.get(0));
                    String bStripped = b.replace(splittedList2.get(0),"");
                    assignmentOnly.add(bStripped);
                }

                for (int i = 0; i < coursecodeA.size(); i++) {
                    if (coursecodeC.size() >= 2) {
                        if (coursecodeC.get(2).equals(coursecodeA.get(i))) {
                            assignmentsDisplay3.add(assignmentOnly.get(i));
                        }
                    }
                    //Exeption her?

                }




            }catch (InterruptedException e) {
                e.printStackTrace();

            }

            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, assignmentsDisplay3);
            lv.setAdapter(arrayAdapter);


        } catch (ExecutionException e) {
            e.printStackTrace();



        }
    }
}
















































































