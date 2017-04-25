package com.example.ingridstoen.alarme;

import android.os.AsyncTask;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by aminaettayebi on 29.03.2017.
 */

public class Database_Assignments extends AsyncTask<List<String>, Void, List> {
    Connection connection;
    String username;
    String password;
    int student_id;

    List<String> assignments = new ArrayList<String>();
    List<String> assignmentName = new ArrayList<String>();
    List<String> assignmentDate = new ArrayList<String>();




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


    //The Database_Courses extends AsyncTask and  override doInBackground method and OnPostExecute method.

    protected List<String> doInBackground(List... params) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception e) {
            System.err.println("Cannot create connection");
        }
        try {
            setConnection();
            getStudent_id();
            String sql = "SELECT course_code, assignment_name, assignment_date from Assignment WHERE student_id ='"+this.selectSutdent_id()+"'";
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs;
            rs = stmt.executeQuery();
            while (rs.next()) {
                assignmentName.add(rs.getString("assignment_name"));
                assignmentDate.add(rs.getString("assignment_date"));
                assignments.add(rs.getString("course_code") + "  " + rs.getString("assignment_name") + " har frist: " + rs.getString("assignment_date"));

            }


        } catch (Exception e) {
            System.err.println(e);


        }
        return assignments;
    }



    //Etablishing connection to the database
    public void setConnection() throws SQLException {
        String server = "sql11.freemysqlhosting.net";
        String database = "sql11163131";
        String user_name = "sql11163131";
        String pass_word = "wi4gXfVvT3";
        String connectionString = "jdbc:mysql://" + server + "/" + database + "?user=" + user_name + "&password=" + pass_word;
        connection = DriverManager.getConnection(connectionString);
    }

  //Select the student id fra database with the username= MainActivity.username.
    public int selectSutdent_id() throws SQLException {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            setConnection();
            Statement stmt = connection.createStatement();
            String sql = "SELECT student_id from Student WHERE username = '"+MainActivity.username+"'";
            ResultSet r= ((java.sql.Statement) stmt).executeQuery(sql);
            while(r.next()){
                this.student_id= r.getInt(1);

            }return this.student_id;
        }catch(Exception e){
            System.out.println( "Her skjedde det noe feil:" + e);
        }return 0;







}
}
