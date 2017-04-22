package com.example.ingridstoen.alarme;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.os.AsyncTask;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.*;
import java.util.*;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * Created by aminaettayebi on 29.03.2017.
 */

public class Database_Courses  extends AsyncTask <List<String>, Void, List> {
    List<String> courses = new ArrayList<String>();
    List<String> courses_code = new ArrayList<String>();
    int student_id;
    String username;
    String password;
    Connection connection;
    Context context;



    /*public void setUsername(String username) {
        this.username = username;
    }*/

    public void setPassword(String password) {
        this.password = password;
    }

    public int getStudent_id(){

        return this.student_id;
    }

    /*public void setStudent_id(int student_id){

        this.student_id=student_id;
    }*/

    //'"+this.selectSutdent_id()+"'"


    protected List<String> doInBackground(List... params) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception e) {
            System.err.println("Cannot create connection");
        }
        try {
            setConnection();
            String sql = "SELECT coursecode,coursename,exam_date from Exam WHERE student_id ='"+this.selectSutdent_id()+"'";
           // String sql = "SELECT coursecode,coursename from Exam WHERE student_id =119";
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs;
            rs = stmt.executeQuery();

            while (rs.next()) {
                courses.add(rs.getString("coursecode") +" "+rs.getString("coursename")+"      Date: " + rs.getString("exam_date"));

            }

        } catch (Exception e) {
            System.err.println(e);

        }

        return courses;
    }

    protected void onPostExecute(List courses) {
        // Result is here now, may be 6 different List type.
        this.courses = courses;
    }

    public String toString() {
        return "id";
    }

    public void setConnection() throws SQLException {
        String server = "sql11.freemysqlhosting.net";
        String database = "sql11163131";
        String user_name = "sql11163131";
        String pass_word = "wi4gXfVvT3";
        String connectionString = "jdbc:mysql://" + server + "/" + database + "?user=" + user_name + "&password=" + pass_word;
        connection = DriverManager.getConnection(connectionString);
    }

    public int selectSutdent_id() throws SQLException {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            setConnection();
            Statement stmt = connection.createStatement();
            //String sql = "SELECT student_id from Student WHERE username = '"+this.username+"'";
            String sql = "SELECT student_id from Student WHERE username ='"+MainActivity.username+"'";
            ResultSet r= ((java.sql.Statement) stmt).executeQuery(sql);
            while(r.next()){
               this.student_id= r.getInt(1);

            }return  this.student_id;
        }catch(Exception e){
            System.out.println( "Her skjedde det noe feil:" + e);
        }return 0;


}

}


