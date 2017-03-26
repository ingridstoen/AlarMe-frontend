package com.example.ingridstoen.alarme;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.app.Activity;
import android.widget.Button;

public class MainActivity extends Activity implements View.OnClickListener {

    String username, password;
    Button button;
    Button bLogin;
    EditText etbrukernavn, etpassord;
    EditText edit_username, edit_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edit_username = (EditText) findViewById(R.id.edit_username);
        edit_password = (EditText) findViewById(R.id.edit_password);
        bLogin = (Button) findViewById(R.id.bLogin);
        bLogin.setOnClickListener(this);
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(this);
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(this);
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

                //db.getCourses();
                //System.err.println(db.getList());
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
        switch (v.getId()) {
            case R.id.bLogin:
                username = edit_username.getText().toString();
                password = edit_password.getText().toString();
                startActivity(new Intent(this, DisplayCoursesActivity.class));
                break;
            case R.id.button:
                startActivity(new Intent(this, RegisterUser.class));
                break;
        }
    }
}}
