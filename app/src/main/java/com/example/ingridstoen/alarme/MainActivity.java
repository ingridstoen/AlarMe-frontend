package com.example.ingridstoen.alarme;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.app.Activity;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends Activity implements View.OnClickListener {

    //Declaring variables
    public static String username, password;
    Button Register;
    Button Login;
    EditText edit_username, edit_password;



    @Override
    //The method onCreate initialize the MainActivity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edit_username = (EditText) findViewById(R.id.login_username);
        edit_password = (EditText) findViewById(R.id.login_password);
        Login = (Button) findViewById(R.id.Login);
        Login.setOnClickListener(this);
        Register = (Button) findViewById(R.id.Register);
        Register.setOnClickListener(this);


    }

    @Override


    public void onClick(View v) {
        // Perform action on click
        switch (v.getId()) {
            case R.id.Login:
                //Initialize and validate
                Login();
                if (validate()) {
                    Intent intent = new Intent(MainActivity.this, DisplayCoursesActivity.class);
                    username = edit_username.getText().toString();
                    password = edit_password.getText().toString();
                    startActivity(intent);
                }else {
                    break;
                }
                break;

            case R.id.Register:
                startActivity(new Intent(this, RegisterUser.class));
                break;

        }
    }



    public void Login(){
        initialize();
        if (!validate()) {
            Toast.makeText(this, "Signup has Failed", Toast.LENGTH_SHORT).show();

        }

    }


    //Validating  user Feide username and password
    public boolean validate(){
        boolean valid= true;
        if (username.isEmpty()){
            edit_username.setError("Please enter your Feide username");
            valid= false;

        }else if( password.isEmpty()){
            edit_password.setError("Please enter your Feide password" );
            valid= false;
        } return valid;
    }


    //initialize the input to string variables
    public void initialize(){
        username= edit_username.getText().toString().trim();
        password= edit_password.getText().toString().trim();
    }


    }

