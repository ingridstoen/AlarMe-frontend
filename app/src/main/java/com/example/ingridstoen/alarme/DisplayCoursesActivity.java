package com.example.ingridstoen.alarme;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.sql.SQLException;
import java.util.HashMap;
import android.widget.ArrayAdapter;
import java.util.concurrent.ExecutionException;
public class DisplayCoursesActivity extends FragmentActivity {
    ListView listView;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
    try {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_courses);
        Database_Courses db = new Database_Courses();
        ListView lv = (ListView) findViewById(R.id.list_view);
        List courses = null;
        try {
            courses = new Database_Courses().execute().get();
        } catch (InterruptedException e) {

            e.printStackTrace();

        } catch (ExecutionException e) {

            e.printStackTrace();
        }

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, courses);
        lv.setAdapter(arrayAdapter);
        
    }catch (Exception e){
        e.printStackTrace();
    }






    }






    public void course1(View view) {
        Intent intent = new Intent(this, DisplayCourse1.class);
        startActivity(intent);
    }

    /*public void course2(View view) {
        Intent intent = new Intent(this, DisplayCourse2.class);
        startActivity(intent);
    }

    public void course3(View view) {
        Intent intent = new Intent(this, DisplayCourse3.class);
        startActivity(intent);
    }

    public void course4(View view) {
        Intent intent = new Intent(this, DisplayCourse4.class);
        startActivity(intent);
    }

    public void viewCalendar(View view) {
        Intent intent = new Intent(this, Calendar.class);
        startActivity(intent);
    }*/
}
