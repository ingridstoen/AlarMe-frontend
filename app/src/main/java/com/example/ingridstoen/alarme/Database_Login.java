package com.example.ingridstoen.alarme;

import android.os.AsyncTask;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by aminaettayebi on 26.03.2017.
 */

public class Database_Login  extends AsyncTask<URL, Integer, Long> {
    Connection connection;
    String username;
    String password;
    int student_id;
    ArrayList<String> courses;

    public int selectStudent_id(){

        return this.student_id;
    }

    public void SetStudent_id(int student_id){

        this.student_id=student_id;
    }

    public ArrayList<String> getList(){
        return this.courses;

    }

    public void setList( ArrayList<String> courses){
        this.courses= courses;
    }

    protected Long doInBackground(URL... urls) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception e) {
            System.err.println("Cannot create connection");
        }
        try {
            setConnection();
            getSutdent_id();

            //getStudent_id();
        } catch (Exception e) {
            System.err.println(e);
        }
        return 1L;
    }

    public void setConnection() throws SQLException {
        String server = "sql11.freemysqlhosting.net";
        String database = "sql11163131";
        String user_name = "sql11163131";
        String pass_word = "wi4gXfVvT3";
        String connectionString = "jdbc:mysql://" + server + "/" + database + "?user=" + user_name + "&password=" + pass_word;
        connection = DriverManager.getConnection(connectionString);
    }

    public void getSutdent_id() throws SQLException {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            setConnection();
            Statement stmt =  connection.createStatement();
            String sql = "SELECT student_id from Student WHERE username = '"+this.username+"'";
            ResultSet r= ((java.sql.Statement) stmt).executeQuery(sql);
            while(r.next()){
                this.student_id= r.getInt(1);
                System.out.println(r.getString(1));
            }}catch(Exception e){
            System.out.println( "Her skjedde det noe feil:" + e);
        }
    }
    public void getCourses() throws SQLException {
        ArrayList<String> courses = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception e) {
            System.out.println(e);
        }
        try {
            setConnection();
            Statement stmt =  connection.createStatement();
            String sql = "SELECT coursecode,coursename from Exam WHERE student_id = '"+this.student_id+"'";
            ResultSet r= ((java.sql.Statement) stmt).executeQuery(sql);
            while(r.next()){
                String coursecode = r.getString(1);
                String coursename = r.getString(2);
                courses.add(coursecode);
                courses.add(coursename);

            }
        }catch(Exception e){
            System.out.println( "error:" + e);


        }
    }



}
