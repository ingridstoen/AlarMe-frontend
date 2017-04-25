package com.example.ingridstoen.alarme;

import android.app.NotificationManager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.AlarmManager;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.app.Activity;
import android.os.SystemClock;
import android.support.v7.app.NotificationCompat;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;


import com.github.sundeepk.compactcalendarview.CompactCalendarView;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ExecutionException;


public class NotificationActivity extends AppCompatActivity {

    List<String> inputDatabaseList = new ArrayList<>();
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
        notifyThis("Remember !", "Assignment due today");







        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_notification);
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

        for (Long date:assignmentDatesMilli){
            Calendar cal = Calendar.getInstance();
            cal.add(Calendar.SECOND, 5);
            //Create a new PendingIntent and add it to the AlarmManager
            Intent intent = new Intent(this, AlarmReceiverActivity.class);
            PendingIntent pendingIntent = PendingIntent.getActivity(this,
                    12345, intent, PendingIntent.FLAG_CANCEL_CURRENT);
            AlarmManager am = (AlarmManager)getSystemService(Activity.ALARM_SERVICE);
            am.set(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(),
                    pendingIntent);
            int i=0;
            scheduleNotification(getNotification(assignmentsName.get(i)), date.intValue());
            i++;

        }

    }



    private void scheduleNotification(Notification notification, int delay) {
        Intent notificationIntent = new Intent(this, NotificationPublisher.class);
        notificationIntent.putExtra(NotificationPublisher.NOTIFICATION_ID, 1);
        notificationIntent.putExtra(NotificationPublisher.NOTIFICATION, notification);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 0, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);

        long futureInMillis = SystemClock.elapsedRealtime() + delay;
        AlarmManager alarmManager = (AlarmManager)getSystemService(Context.ALARM_SERVICE);
        alarmManager.set(AlarmManager.ELAPSED_REALTIME_WAKEUP, futureInMillis, pendingIntent);
    }

    private Notification getNotification(String content) {
        Notification.Builder builder = new Notification.Builder(this);
        builder.setContentTitle("Notification");
        builder.setContentText(content);
        builder.setSmallIcon(R.mipmap.ic_launcher);
        return builder.build();
    }

    public void notifyThis(String title, String message) {
        NotificationCompat.Builder b = new NotificationCompat.Builder(this);
        b.setAutoCancel(true)
                .setDefaults(NotificationCompat.DEFAULT_ALL)
                .setWhen(System.currentTimeMillis())
                .setSmallIcon(R.mipmap.ic_launcher)
                .setTicker("{your tiny message}")
                .setContentTitle(title)
                .setContentText(message)
                .setContentInfo("INFO");

        NotificationManager nm = (NotificationManager) this.getSystemService(Context.NOTIFICATION_SERVICE);
        nm.notify(1, b.build());
    }



}
