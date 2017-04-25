package com.example.ingridstoen.alarme;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RegisterUser extends Activity implements View.OnClickListener {

    //Declaring variables
    Button bRegister;
    EditText edit_username, edit_password;


    @Override
    //The method onCreate initialize the RegisterUser Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_user);
        edit_username = (EditText) findViewById(R.id.register_username);
        edit_password = (EditText) findViewById(R.id.register_password);
        bRegister = (Button) findViewById(R.id.bRegister);
        bRegister.setOnClickListener(this);
    }

    // Perform action on click
    @Override
    public void onClick(View v) {
        try {
            if (v.getId() == bRegister.getId()) {
                String username = edit_username.getText().toString();
                String password = edit_password.getText().toString();
                Database_Register database_register = new Database_Register(username,password);
                database_register.execute();
                //Start Splash_Screen activity
                Intent intent= new Intent(RegisterUser.this, Splash_Screen.class);
                startActivity(intent);

            }
        } catch(Exception e){
            System.out.print(e);

        }

            }

    }



