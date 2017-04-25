package com.example.ingridstoen.alarme;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class DisplayCourse3 extends AppCompatActivity {




    @Override
    //The method onCreate initialize the DisplayCourse3
    protected void onCreate(Bundle savedInstanceState) {
        try {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_display_course3);
            //Declare listview
            ListView lv = (ListView) findViewById(R.id.list_view3);
            List<String> assignment = null;
            List<String> courses = null;
            List<String> splittedList_courses=null;
            List<String> splittedList_assignments=null;
            List<String> coursecode_courses = new ArrayList<>();
            List<String> coursecode_assignments = new ArrayList<>();
            List<String> assignmentOnly = new ArrayList<>();
            List<String> assignmentsDisplay3 = new ArrayList<>(); //A list with assignments in course3

            try{
                assignment = new Database_Assignments().execute().get();
                courses = new Database_Courses().execute().get();
                for (String a : courses) {
                    // Separate course code from course name
                    splittedList_courses = new ArrayList<String>(Arrays.asList(a.split(" ")));
                    coursecode_courses.add(splittedList_courses.get(0));
                }

                for (String b : assignment) {
                    // Separate assignment names from assignment course code
                    splittedList_assignments = new ArrayList<String>(Arrays.asList(b.split(" ")));
                    coursecode_assignments.add(splittedList_assignments.get(0));
                    String bStripped = b.replace(splittedList_assignments.get(0),"");
                    assignmentOnly.add(bStripped);
                }

                for (int i = 0; i < coursecode_assignments.size(); i++) {
                    if (coursecode_courses.size() >= 2) {
                        if (coursecode_courses.get(2).equals(coursecode_assignments.get(i))) {
                            assignmentsDisplay3.add(assignmentOnly.get(i));
                        }
                    }


                }




            }catch (InterruptedException e) {
                e.printStackTrace();

            }
            //Display assignmentsDisplay3

            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, assignmentsDisplay3);
            lv.setAdapter(arrayAdapter);


        } catch (ExecutionException e) {
            e.printStackTrace();



        }
    }
}
















































































