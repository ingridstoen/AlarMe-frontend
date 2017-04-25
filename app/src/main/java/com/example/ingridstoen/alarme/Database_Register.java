package com.example.ingridstoen.alarme;
import android.os.AsyncTask;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.*;
import java.util.ArrayList;

public class Database_Register extends AsyncTask<URL, Integer, Long> {

    Connection connection;
    private final String  username;
    private  final String password;

    Database_Register(String username,String password){
        this.username= username;
        this.password= password;
    }



    public final  String getUsername() {

        return this.username;
    }

    public final String getPassword() {

        return this.password;
    }


    //The Database_Courses extends AsyncTask and  override doInBackground method and OnPostExecute method
    protected Long doInBackground(URL... urls) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception e) {
            System.err.println("Cannot create connection");
        }
        try {
            setConnection();
            save_data();
        } catch (Exception e) {
            System.err.println(e);
        }
        return 1L;
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


    //Save student username and password in the database
    public void save_data() throws SQLException {
        String sql = "INSERT INTO Student(username, user_password) VALUES(?,?)";
        PreparedStatement pr = connection.prepareStatement(sql);
        pr.setString(1, this.username);
        pr.setString(2, this.password);
        pr.executeUpdate();
    }
}