package com.example.ingridstoen.alarme;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.github.sundeepk.compactcalendarview.CompactCalendarView;
import com.github.sundeepk.compactcalendarview.domain.Event;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ExecutionException;

public class Calendar extends AppCompatActivity {

    //HUSK Å LEGGE TIL COPY RIGHTS!!! -----------------------

    CompactCalendarView compactCalendar;
    private SimpleDateFormat dateFormatMonth = new SimpleDateFormat("MMMM- yyyy", Locale.getDefault());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);
        /*
        final ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(false);
        actionBar.setTitle(null);

        compactCalendar = (CompactCalendarView) findViewById(R.id.compactcalendar_view);
        compactCalendar.setUseThreeLetterAbbreviation(true);


        List<String> assignments = null;
        List<String> splittedAssignment = null;
        List<String> splittedAssignmentNameDate = null;
        final List<String> assignmentsNameDate = new ArrayList<>();
        final List<String> assignmentsName = new ArrayList<>();
        final List<Long> assignmentDatesMilli = new ArrayList<>();
        final List<String> assignmentDatesString = new ArrayList<>();
        final List<String> assignmentCorusecode = new ArrayList<>();
        final DateFormat df = new SimpleDateFormat("MM.dd.yyyy");

        //assignments.add("Test 1");
        //assignments.add("Oving 7");
        //assignmentDatesString.add("04.07.2017");
        //assignmentDatesString.add("04.08.2017");

        try {
            try {
                assignments = new Database_Assignments().execute().get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            //Separate all coursecodes for the assignments
            for (String assignment : assignments) {
                splittedAssignment = new ArrayList<String>(Arrays.asList(assignment.split(" ",2)));
                assignmentCorusecode.add(splittedAssignment.get(0));
                String coursecodeStripped = assignment.replace(splittedAssignment.get(0),"");
                assignmentsNameDate.add(coursecodeStripped);
            }

            //Separate assignment names from assignment dates
            for (String e : assignmentsNameDate) {
                splittedAssignmentNameDate = new ArrayList<>(Arrays.asList(e.split(" ")));
                assignmentDatesString.add(splittedAssignmentNameDate.get(splittedAssignment.size()-1));

            }



            for (String dS : assignmentDatesString) {
                try {
                    Date d = df.parse(dS);
                    long milliseconds = d.getTime();
                    assignmentDatesMilli.add(milliseconds);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }


            List<Event> assignementEvents = new ArrayList<>();

            for (int i=0; i < assignments.size(); i++) {
                Event e = new Event(Color.RED, assignmentDatesMilli.get(i), assignments.get(i) );
                compactCalendar.addEvent(e);
            }

            //Set date format


            compactCalendar.setListener(new CompactCalendarView.CompactCalendarViewListener() {
                @Override
                public void onDayClick(Date dateClicked) {
                    Context context = getApplicationContext();
                    if (assignmentDatesMilli.contains(dateClicked.getTime())) {
                        for (int i = 0; i < assignmentsName.size(); i++) {
                            if (dateClicked.getTime() == assignmentDatesMilli.get(i)) {
                                Toast.makeText(context, assignmentsName.get(i), Toast.LENGTH_SHORT).show();
                            }

                        }
                    } else {
                        Toast.makeText(context, df.format(dateClicked.getTime()) , Toast.LENGTH_SHORT).show();
                    }

                }

                @Override
                public void onMonthScroll(Date firstDayOfNewMonth) {
                    actionBar.setTitle(dateFormatMonth.format(firstDayOfNewMonth));
                }
            });
        }catch (ExecutionException e) {
            e.printStackTrace();
        }*/
    }
}