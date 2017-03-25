package com.example.ingridstoen.alarme;
import android.os.AsyncTask;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.*;
import javax.xml.parsers.SAXParserFactory;


/**
 * Created by ingridstoen on 23.03.2017.
 */

public class Database extends AsyncTask<URL, Integer, Long> {

    Connection connection;
    String username;
    String password;
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
            save_data();




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

    public void save_data() throws  SQLException{

        String sql= "INSERT INTO Student(username, user_password) VALUES(?,?)";
        PreparedStatement pr= connection.prepareStatement(sql);
        pr.setString(1,this.username);
        pr.setString(2,this.password);
        pr.executeUpdate();


    }



}
