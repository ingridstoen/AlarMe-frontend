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

public class DisplayCourse2 extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_display_course2);
            ListView lv = (ListView) findViewById(R.id.list_view2);
            List<String> assignment = null;
            List<String> courses = null;
            List<String> splittedList1=null;
            List<String> splittedList2=null;
            List<String> coursecodeC = new ArrayList<>();
            List<String> coursecodeA = new ArrayList<>();
            List<String> assignmentOnly = new ArrayList<>();
            List<String> assignmentsDisplay2 = new ArrayList<>();
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
                    if (coursecodeC.size() >= 1) {
                        if (coursecodeC.get(1).equals(coursecodeA.get(i))) {
                            assignmentsDisplay2.add(assignmentOnly.get(i));
                        }
                    }
                    //Exeption her?

                }




            }catch (InterruptedException e) {
                e.printStackTrace();

            }

            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, assignmentsDisplay2);
            lv.setAdapter(arrayAdapter);


        } catch (ExecutionException e) {
            e.printStackTrace();



        }
    }
}
















































































