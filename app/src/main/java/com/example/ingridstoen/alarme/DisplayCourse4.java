package com.example.ingridstoen.alarme;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Date;

public class DisplayCourse4 extends AppCompatActivity {
    private Database_Login course4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_course4);
    }

    public void setCourse1() {
        for (String key: course4.getAssignments().keySet()){
            //GJØR NOE MED NØKKEL
        }
        for (Date value: course4.getAssignments().values()){
            //gjør noe med datp


        }





    }
}
