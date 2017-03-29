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
                Database_Register d = new Database_Register();
                d.setUsername(username);
                d.setPassword(password);
                System.err.print(d.getUsername() + d.getPassword());
                d.execute();
                startActivity( new Intent(this, DisplayCoursesActivity.class));
            }
        } catch(Exception e){
            System.out.print(e);
            System.err.print("xjax");
        }




            }

    }



