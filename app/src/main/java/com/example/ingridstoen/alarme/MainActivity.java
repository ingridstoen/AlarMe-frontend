package com.example.ingridstoen.alarme;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import java.sql.PreparedStatement;
import java.sql.*;
import android.util.Log;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import  java.sql.ResultSet;
import java.sql.ResultSetMetaData;

public class MainActivity extends Activity implements View.OnClickListener {

    Button bLogin;
    Button button2;
    Button button3;
    Button button4;
    Button button5;
    EditText etbrukernavn, etpassord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etbrukernavn = (EditText) findViewById(R.id.etbrukernavn);
        etpassord = (EditText) findViewById(R.id.etpassord);
        bLogin = (Button) findViewById(R.id.bLogin);
        bLogin.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        try{
            if (v.getId() == bLogin.getId()) {
                String brukernavn = etbrukernavn.getText().toString();
                String passord=etpassord.getText().toString();
                Database db= new Database();
                db.setUsername(brukernavn);
                db.setPassword(passord);
                db.execute();
                //new Database().execute();
                startActivity( new Intent(this, DisplayCoursesActivity.class));

            }
            else if (v.getId()== bLogin.getId()){
                String brukernavn= etbrukernavn.getText().toString();
                String passord=etpassord.getText().toString();
                startActivity(new Intent(this, DisplayCoursesActivity.class));

            }




        }
        catch(Exception e){
            System.out.print(e);
        }
    }
}