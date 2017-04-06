package com.example.ingridstoen.alarme;

import java.util.Date;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.sql.*;
import android.os.AsyncTask;
import java.net.URL;

/**
 * Created by aminaettayebi on 26.03.2017.
 */

public class Database_Login  {

    /*private DisplayCoursesActivity dis;
    Connection connection;
    Statement stm;
    String username;
    String password;
    int student_id;
    ResultSet r;


    private ArrayList<String> courses;
    private DisplayCoursesActivity display;

    private HashMap<String, Date> assignments;

    public HashMap<String, Date> getAssignments(){

        return this.assignments;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getStudent_id(){

        return this.student_id;
    }

    public void setStudent_id(int student_id){

        this.student_id=student_id;
    }



    public ArrayList<String> getCourses(){


        return this.courses;
    }

    public void setCourses(ArrayList<String> courses) {

        this.courses = courses;
    }


    public Database_Login(DisplayCoursesActivity display) {
        this.display= display;

        }


    protected void onPostExecute(ArrayList<String> courses){
        display.setList(courses);


    }

    @Override
    protected  ArrayList<String> doInBackground(Void...urls) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception e) {
            System.err.println("Cannot create connection");
        }
        try {
            setConnection();
            addCourses();


        } catch (Exception e) {
            System.err.println(e);
        } return this.getCourses();
    }






    public void setConnection() throws SQLException {
        String server = "sql11.freemysqlhosting.net";
        String database = "sql11163131";
        String user_name = "sql11163131";
        String pass_word = "wi4gXfVvT3";
        String connectionString = "jdbc:mysql://" + server + "/" + database + "?user=" + user_name + "&password=" + pass_word;
        connection = DriverManager.getConnection(connectionString);
    }



    /*public void selectSutdent_id() throws SQLException {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            setConnection();
            Statement stmt = connection.createStatement();
            String sql = "SELECT student_id from Student WHERE username = '"+this.username+"'";
            ResultSet r= ((java.sql.Statement) stmt).executeQuery(sql);
            while(r.next()){
                this.student_id= r.getInt(1);

            }}catch(Exception e){
            System.out.println( "Her skjedde det noe feil:" + e);
        }
    }


    public void addCourses() throws SQLException {
        try {
            ArrayList<String> courses = new ArrayList<>();
            courses.add("amina");
            String sql = "SELECT coursecode,coursename from Exam WHERE student_id =97";
            //stm = connection.createStatement();
           // r = stm.executeQuery(sql);
           // while (r.next()) {
               // courses.add(r.getString(2) + r.getString(3));
            //setCourses(courses);





        }catch (Exception e){
            System.out.print(e);
        }

        }



   /* public void addAssignments()throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            setConnection();
            Statement stmt = connection.createStatement();
            String sql = "SELECT * from Assignment where student_id ='" + this.student_id + "'";
            ResultSet r = ((java.sql.Statement) stm).executeQuery(sql);
            while (r.next()) {
                assignments.put(r.getString(2)+r.getString(3),r.getDate(4));
            }
        } catch(Exception e) {
            System.out.println("error:" + e);
        }
    }
*/
}
