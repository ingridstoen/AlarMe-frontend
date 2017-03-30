package com.example.ingridstoen.alarme;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RegisterUser extends Activity implements View.OnClickListener {
    Button bRegister;
    EditText edit_username, edit_password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_user);
        edit_username = (EditText) findViewById(R.id.register_username);
        edit_password = (EditText) findViewById(R.id.register_password);
        bRegister = (Button) findViewById(R.id.bRegister);
        bRegister.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {

        try {
            if (v.getId() == bRegister.getId()) {
                String username = edit_username.getText().toString();
                String password = edit_password.getText().toString();
                Database_Register d = new Database_Register(username,password);
                d.execute();
                Intent intent= new Intent(RegisterUser.this, DisplayCoursesActivity.class);
                // to pass data from RegisterUser.java to DisplayCoursesActivity.class
                intent.putExtra("username",username);
                intent.putExtra("password", password);
                //Calling the other activity
                startActivity(intent);

                //startActivity( new Intent(this, DisplayCoursesActivity.class));
            }
        } catch(Exception e){
            System.out.print(e);

        }


            }

    }



