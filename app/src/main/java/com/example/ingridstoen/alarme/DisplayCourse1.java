package com.example.ingridstoen.alarme;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class DisplayCourse1 extends AppCompatActivity {



    @Override
    //The method onCreate initialize the DisplayCourse1
    protected void onCreate(Bundle savedInstanceState) {
        try {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_display_course1);

            //Create listview
            ListView lv = (ListView) findViewById(R.id.course1);

            //Declaring variables
            List<String> assignment = null;
            List<String> courses = null;
            List<String> splittedList_courses=null;
            List<String> splittedList_assignment=null;
            List<String> coursecode_course = new ArrayList<>(); //List with coursecode
            List<String> coursecode_assignment= new ArrayList<>(); //List with assignemnt name
            List<String> assignmentOnly = new ArrayList<>();
            List<String> assignmentsDisplay1 = new ArrayList<>(); //A List with assignments in course1


            try {
                //Execute assignment list from Database_Assignments class
                assignment = new Database_Assignments().execute().get();

                //Execute courses list from Database_Courses class
                courses = new Database_Courses().execute().get();
                for (String a : courses) {
                    // Separate course code from course name
                    splittedList_courses = new ArrayList<String>(Arrays.asList(a.split(" ")));
                    coursecode_course.add(splittedList_courses.get(0));
                }

                for (String b : assignment) {
                    // Separate assignment names from assignment course code
                    splittedList_assignment = new ArrayList<String>(Arrays.asList(b.split(" ")));
                    coursecode_assignment.add(splittedList_assignment.get(0));
                    String bStripped = b.replace(splittedList_assignment.get(0),"");
                    assignmentOnly.add(bStripped);
                }
                
                for (int i = 0; i < coursecode_assignment.size(); i++) {
                    if (coursecode_course.size() != 0) {
                        if (coursecode_course.get(0).equals(coursecode_assignment.get(i))) {
                            assignmentsDisplay1.add(assignmentOnly.get(i));
                        }
                    }


                }




            }catch (InterruptedException e) {
            e.printStackTrace();

        }
            //Display assignmentDisplay1 in simpe_list_item_1 listview
            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, assignmentsDisplay1);
            lv.setAdapter(arrayAdapter);


            } catch (ExecutionException e) {
                e.printStackTrace();

            }
        }
}





