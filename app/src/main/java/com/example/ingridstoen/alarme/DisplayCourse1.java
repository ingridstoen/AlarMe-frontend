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



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_display_course1);
            ListView lv = (ListView) findViewById(R.id.course1);
            List<String> assignment = null;
            List<String> courses = null;
            List<String> splittedList1=null;
            List<String> splittedList2=null;
            List<String> coursecodeC = new ArrayList<>();
            List<String> coursecodeA = new ArrayList<>();
            List<String> assignmentOnly = new ArrayList<>();
            List<String> assignmentsDisplay1 = new ArrayList<>();

            try {
                assignment = new Database_Assignments().execute().get();
                courses = new Database_Courses().execute().get();
                for (String a : courses) {
                    //String[] array1 = a.toString().split(" ", 2);
                    splittedList1 = new ArrayList<String>(Arrays.asList(a.split(" ")));
                    coursecodeC.add(splittedList1.get(0));
                }


                for (String b : assignment) {
                    //String[] array2 = b.toString().split(" ", 1);
                    splittedList2 = new ArrayList<String>(Arrays.asList(b.split(" ")));
                    coursecodeA.add(splittedList2.get(0));
                    String bStripped = b.replace(splittedList2.get(0),"");
                    assignmentOnly.add(bStripped);
                }
                
                for (int i = 0; i < coursecodeA.size(); i++) {
                    if (coursecodeC.size() != 0) {
                        if (coursecodeC.get(0).equals(coursecodeA.get(i))) {
                            assignmentsDisplay1.add(assignmentOnly.get(i));
                        }
                    }
                    //Exeption her?

                }




            }catch (InterruptedException e) {
            e.printStackTrace();

        }

            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, assignmentsDisplay1);
            lv.setAdapter(arrayAdapter);


            } catch (ExecutionException e) {
                e.printStackTrace();



            }
        }
}






