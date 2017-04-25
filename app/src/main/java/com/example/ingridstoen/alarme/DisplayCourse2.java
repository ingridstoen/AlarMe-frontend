package com.example.ingridstoen.alarme;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class DisplayCourse2 extends AppCompatActivity {



    //The method onCreate initialize the DisplayCourse2
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_display_course2);
            //create listview lv
            ListView lv = (ListView) findViewById(R.id.list_view2);

            //Declaring variables
            List<String> assignment = null;
            List<String> courses = null;
            List<String> splittedList_courses=null;
            List<String> splittedList_assignments=null;
            List<String> coursecode_courses = new ArrayList<>();
            List<String> coursecode_assignments = new ArrayList<>();
            List<String> assignmentOnly = new ArrayList<>();
            List<String> assignmentsDisplay2 = new ArrayList<>(); //A list with assignments in course2
            try{
                //Execute assignment list from Database_Assignments class
                assignment = new Database_Assignments().execute().get();

                //Execute courses list from Database_Courses class
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
                    if (coursecode_courses.size() >= 1) {
                        if (coursecode_courses.get(1).equals(coursecode_assignments.get(i))) {
                            assignmentsDisplay2.add(assignmentOnly.get(i));
                        }
                    }


                }

            }catch (InterruptedException e) {
                e.printStackTrace();

            }

            //Displatying assignmentsDisplay2 in simple_list_item_1 listview
            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, assignmentsDisplay2);
            lv.setAdapter(arrayAdapter);


        } catch (ExecutionException e) {
            e.printStackTrace();



        }
    }
}
















































































