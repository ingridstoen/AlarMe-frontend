package com.example.ingridstoen.alarme;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by aminaettayebi on 25.03.2017.
 */

public class getCourses  extends Database{


    @Override
    public  void setconnection() throws SQLException {
        super.setconnection();
    }

    public void getCourses() throws SQLException{
        String sql= "select coursename from 'Exam'";
        Statement stmt= connection.createStatement();
        ResultSet result= stmt.executeQuery(sql);


    }





}
