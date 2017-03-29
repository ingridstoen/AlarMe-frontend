package com.example.ingridstoen.alarme;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import android.os.AsyncTask;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.*;
import java.sql.Connection;
/**
 * Created by aminaettayebi on 29.03.2017.
 */


public class Database_Courses  extends AsyncTask <List<String>, Void, List> {
    List<String> courses = new ArrayList<String>();
    String username;
    String password;
    int student_id;
    Connection connection;

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


    protected List<String> doInBackground(List... params) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception e) {
            System.err.println("Cannot create connection");
        }
        try {

            /*String server = "sql11.freemysqlhosting.net";
            String database = "sql11163131";
            String user_name = "sql11163131";
            String pass_word = "wi4gXfVvT3";
            String connectionString = "jdbc:mysql://" + server + "/" + database + "?user=" + user_name + "&password=" + pass_word;
            connection = DriverManager.getConnection(connectionString);
            */
            setConnection();
            getStudent_id();
            String sql = "SELECT coursecode,coursename from Exam WHERE student_id =45";
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs;
            rs = stmt.executeQuery();
            while (rs.next()) {
                courses.add(rs.getString(1) +" "+rs.getString(2));

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


    public void selectSutdent_id() throws SQLException {
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


}


