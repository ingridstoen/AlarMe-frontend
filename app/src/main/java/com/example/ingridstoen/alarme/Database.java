package com.example.ingridstoen.alarme;
import android.os.AsyncTask;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.*;
import java.util.ArrayList;

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

    public void SetStudent_id(int student_id){
        this.student_id=student_id;
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
            setConnection();
            getSutdent_id();
            getCourses();
            getAssignement();
            setConnection();
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

    public void save_data() throws SQLException {
        String sql = "INSERT INTO Student(username, user_password) VALUES(?,?)";
        PreparedStatement pr = connection.prepareStatement(sql);
        pr.setString(1, this.username);
        pr.setString(2, this.password);
        pr.executeUpdate();
    }

    public void getSutdent_id() throws SQLException {
    }

    public void getSutdent_id(String brukernavn) throws SQLException {
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

    public void getAssignement()throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            setConnection();
            Statement stmt = connection.createStatement();
            String sql = "SELECT * from Assignment where student_id ='" + this.student_id + "'";
            ResultSet r = ((java.sql.Statement) stmt).executeQuery(sql);
            while (r.next()) {
                System.out.println(r.getString(2) + " " + r.getString(3) + " " + r.getString(4));
            }
        } catch(Exception e) {
                System.out.println("error:" + e);
        }
    }

    public void getStudent_id() {
        try {
            Statement stm = connection.createStatement();
            String query = "SELECT student_id From student WHERE username = '" + this.username + "'";
            ResultSet rs = stm.executeQuery(query);
            while (rs.next()) {
                this.student_id = rs.getInt("student_id");
            }
        } catch (Exception e) {
            System.out.println("Her skjedde det noe feil: " + e);
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