package com.example.ingridstoen.alarme;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.util.Iterator;
import java.util.HashMap;
import java.util.Date;

public class DisplayCourse1 extends AppCompatActivity {

    private Database_Login course1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_course1);
        course1 = new Database_Login();
    }

    public void setCourse1() {
        for (String key: course1.getAssignments().keySet()){
            //GJØR NOE MED NØKKEL
        }
         for (Date value: course1.getAssignments().values()){
             //gjør noe med datp


        }





    }
}
