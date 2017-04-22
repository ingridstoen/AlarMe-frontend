package com.example.ingridstoen.alarme;
import android.app.AlarmManager;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;
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
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ExecutionException;

public class calandar extends AppCompatActivity {
    List<String> inputDatabaseList = new ArrayList<>();



    /*
    The MIT License (MIT)

    Copyright (c) [2016] [Sundeepk]

    Permission is hereby granted, free of charge, to any person obtaining a copy
    of this software and associated documentation files (the "Software"), to deal
    in the Software without restriction, including without limitation the rights
    to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
    copies of the Software, and to permit persons to whom the Software is
    furnished to do so, subject to the following conditions:

    The above copyright notice and this permission notice shall be included in all
    copies or substantial portions of the Software.

    THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
    IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
    FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
    AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
    LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
    OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
    SOFTWARE.
    */

        CompactCalendarView compactCalendar;
        private SimpleDateFormat dateFormatMonth = new SimpleDateFormat("MMMM- yyyy", Locale.getDefault());

        // method to get date for a date described with letters. Paramenter 0 for saturday and 5 for thursday
        public String getNextWeekOfDay(int weekOfDay) {
            DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");

            Calendar today = Calendar.getInstance();

            int dayOfWeek = today.get(Calendar.DAY_OF_WEEK);
            int daysUntilNextWeekOfDay = weekOfDay - dayOfWeek;
            Calendar nextWeekOfDay = (Calendar) today.clone();

            nextWeekOfDay.add(Calendar.DAY_OF_WEEK, daysUntilNextWeekOfDay);
            nextWeekOfDay.add(Calendar.DAY_OF_WEEK, 7);
            nextWeekOfDay.set(Calendar.HOUR_OF_DAY, 0);
            Date nextWeekOfDayDateFormat = nextWeekOfDay.getTime();
            String dateString = dateFormat.format(nextWeekOfDayDateFormat);
            return dateString;
        }


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_calandar);

            final ActionBar actionBar = getSupportActionBar();
            actionBar.setDisplayHomeAsUpEnabled(false);
            actionBar.setTitle(null);

            compactCalendar = (CompactCalendarView) findViewById(R.id.compactcalendar_view);
            compactCalendar.setUseThreeLetterAbbreviation(true);

            // List that gets the assignments from the datebase as a list on the format [assName, date, assName, date, ...]

            try {
                inputDatabaseList = new DatabaseAssignmentsCalendar().execute().get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }


            // List that stores the assignment name only (separated from the matching date)
            final List<String> assignmentsName = new ArrayList<>();

            // List that stores the assignment dates as Strings (separated from matching assignment name)
            final List<String> assignmentDatesString = new ArrayList<>();
            // List that stores assignment dates converted to milliseconds
            final List<Long> assignmentDatesMilli = new ArrayList<>();


            // Separate assignment names from assignment dates
            for (int i = 0; i < inputDatabaseList.size(); i++) {
                if (i % 2 == 0) {
                    assignmentsName.add(inputDatabaseList.get(i));
                } else {
                    if (inputDatabaseList.get(i).matches("[a-zA-ZæøåÆØÅ]+")) {
                        if (inputDatabaseList.get(i).equals("mandag")) {
                            assignmentDatesString.add(getNextWeekOfDay(2));
                        } else if (inputDatabaseList.get(i).equals("tirsdag")) {
                            assignmentDatesString.add(getNextWeekOfDay(3));
                        } else if (inputDatabaseList.get(i).equals("onsdag")) {
                            assignmentDatesString.add(getNextWeekOfDay(4));
                        } else if (inputDatabaseList.get(i).equals("torsdag")) {
                            assignmentDatesString.add(getNextWeekOfDay(5));
                        } else if (inputDatabaseList.get(i).equals("fredag")) {
                            assignmentDatesString.add(getNextWeekOfDay(6));
                        } else if (inputDatabaseList.get(i).equals("lørdag")) {
                            assignmentDatesString.add(getNextWeekOfDay(0));
                        } else if (inputDatabaseList.get(i).equals("søndag")) {
                            assignmentDatesString.add(getNextWeekOfDay(1));
                        } else {
                            System.out.println("date format from itsLearing has changed!");
                        }
                    } else {
                        String dateString = inputDatabaseList.get(i) + ".2017";
                        assignmentDatesString.add(dateString);
                    }
                }
            }


            //SETTER FORMEN TIL Å SE SLIK UT
            final DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
            // converts dates on string format to milliseconds, and adds to the list "assignmentDatesMilli"
            for (String dateString : assignmentDatesString) {
                try {
                    Date d = df.parse(dateString);
                    long milliseconds = d.getTime();
                    assignmentDatesMilli.add(milliseconds);
                } catch (ParseException e) {
                    e.printStackTrace();
                }

            }

           if (assignmentDatesMilli.size()== assignmentsName.size()){
                for (int i = 0; i < assignmentsName.size(); i++) {
                    Event e = new Event(Color.RED, assignmentDatesMilli.get(i), assignmentsName.get(i));
                    compactCalendar.addEvent(e);
                }

            }else {
               System.out.println("Lists not equal length");
           }


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
                        Toast.makeText(context, "No events planned" , Toast.LENGTH_SHORT).show();
                    }

                }

                //For å printe dato for alle dager i kalender: df.format(dateClicked.getTime())

                @Override
                public void onMonthScroll(Date firstDayOfNewMonth) {
                    actionBar.setTitle(dateFormatMonth.format(firstDayOfNewMonth));
                }
            });





            }


    // I main:
    NotificationManager nm;
    boolean isNotificActive = false;
    int notifID = 0;

    public void setNotificationd(List<Long> assignmentDatesMilli) {
         for (Long assignment: assignmentDatesMilli) {
            String notificText = "Frist om to dager";

            NotificationCompat.Builder notificBuilder =  new NotificationCompat.Builder(this)
                    .setContentTitle("Reminder:")
                    .setContentText(assignment+ ": " + notificText)
                    .setTicker("Alert new reminder")
                    .setSmallIcon(R.mipmap.ic_launcher);
            Intent moreInfoIntent = new Intent(this, DisplayCoursesActivity.class);
            TaskStackBuilder tStackBuilder = TaskStackBuilder.create(this);
            tStackBuilder.addParentStack(DisplayCoursesActivity.class);
            tStackBuilder.addNextIntent(moreInfoIntent);
            PendingIntent pendingIntent = tStackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);
            notificBuilder.setContentIntent(pendingIntent);
            nm = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
            nm.notify(notifID, notificBuilder.build());
            isNotificActive = true;
        }
    }

    public void stopNotification() {
        if (isNotificActive) {
            nm.cancel(notifID);
        }
    }



    public void setAlarm(Date date) {
        Long alertTime = date.getTime() - (0x2a300 * 1000); //to dager før frist
        Intent alertIntent = new Intent(this, AlertReceiver.class);
        AlarmManager alarmManager = (AlarmManager)
                getSystemService(Context.ALARM_SERVICE);
        alarmManager.set(AlarmManager.RTC_WAKEUP, alertTime, PendingIntent.getBroadcast(this, 1, alertIntent,
                PendingIntent.FLAG_UPDATE_CURRENT));
    }




        }















