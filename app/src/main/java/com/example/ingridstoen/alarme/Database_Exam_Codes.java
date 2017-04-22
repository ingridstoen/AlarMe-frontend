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

public class Database_Exam_Codes extends AsyncTask<List<String>, Void, List> {

    List<String> courses_codes = new ArrayList<String>();
    String username;
    String password;
    int student_id;
    Connection connection;

    public int getStudent_id() {

        return this.student_id;
    }


    protected List<String> doInBackground(List... params) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception e) {
            System.err.println("Cannot create connection");
        }
        try {

            setConnection();
            getStudent_id();
            String sql = "SELECT coursecode from Exam WHERE student_id ='" + this.selectSutdent_id() + "'";
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs;
            rs = stmt.executeQuery();
            while (rs.next()) {
                courses_codes.add("amina");
                courses_codes.add(rs.getString("coursecode"));

            }


        } catch (Exception e) {
            System.err.println(e);


        }
        return courses_codes;
    }


    protected void onPostExecute(List courses_codes) {
        this.courses_codes = courses_codes;
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
        try {
            Class.forName("com.mysql.jdbc.Driver");
            setConnection();
            Statement stmt = connection.createStatement();
            String sql = "SELECT student_id from Student WHERE username = '" + MainActivity.username + "'";
            ResultSet r = ((java.sql.Statement) stmt).executeQuery(sql);
            while (r.next()) {
                this.student_id = r.getInt(1);

            }
            return this.student_id;
        } catch (Exception e) {
            System.out.println("Her skjedde det noe feil:" + e);
        }return 0;
    }



}


