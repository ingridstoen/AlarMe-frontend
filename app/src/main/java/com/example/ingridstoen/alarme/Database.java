package com.example.ingridstoen.alarme;
import android.os.AsyncTask;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.SAXParserFactory;


/**
 * Created by ingridstoen on 23.03.2017.
 */

public class Database extends AsyncTask<URL, Integer, Long> {

    Connection connection;
    String username;
    String password;
    int student_id;
    ArrayList<String> courses;


    public int selectStudent_id(){
        return this.student_id;
    }

    public ArrayList<String> getList(){
        return this.courses;

    }

    public void setList( ArrayList<String> courses){
        this.courses= courses;

    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    protected Long doInBackground(URL... urls) {

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception e) {
            System.err.println("Cannot create connection");
        }
        try {


            setconnection();
            getStudent_id();








        } catch (Exception e) {
            System.err.println(e);
        }

        return 1L;
    }

    public void setconnection() throws SQLException {
        String server = "sql11.freemysqlhosting.net";
        String database = "sql11163131";
        String user_name = "sql11163131";
        String pass_word = "wi4gXfVvT3";
        String connectionString = "jdbc:mysql://" + server + "/" + database + "?user=" + user_name + "&password=" + pass_word;
        connection = DriverManager.getConnection(connectionString);


    }

    public void save_data() throws  SQLException {
        String sql= "INSERT INTO Student(username, user_password) VALUES(?,?)";
        PreparedStatement pr= connection.prepareStatement(sql);
        pr.setString(1,this.username);
        pr.setString(2,this.password);
        pr.executeUpdate();
    }

    public void getStudent_id() {
        try{
            Statement stm = connection.createStatement();
            String query = "SELECT student_id From student WHERE username = '" + this.username + "'";
            ResultSet rs = stm.executeQuery(query);
            while(rs.next()){
                this.student_id = rs.getInt("student_id");

            }
        }catch(Exception e){
            System.out.println("Her skjedde det noe feil: " + e);

        }

    }

  /*  public void getCourses() throws SQLException {
        ArrayList<String> courses = new ArrayList<>();
        Statement st = connection.createStatement();
        //int student_id = getStudent_id();
        String sql = "SELECT * FROM exam WHERE student_id = '" + this.student_id + "'";
        ResultSet rs = st.executeQuery(sql);
        if(rs.next()) {
            String coursecode = rs.getString("coursecode");
            String coursename = rs.getString("coursename");
            courses.add(coursecode);
            courses.add(coursename);

        }*/
    }



<<<<<<< HEAD
}
=======
>>>>>>> 7e1b980e6444951952d93d2a71b5547f4383c5be
