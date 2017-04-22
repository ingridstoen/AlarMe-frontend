package com.example.ingridstoen.alarme;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.app.Activity;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends Activity implements View.OnClickListener {

    //test comment

    public static String username, password;
    String password_db;
    Button button;
    Button bLogin;
    EditText edit_username, edit_password;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edit_username = (EditText) findViewById(R.id.login_username);
        edit_password = (EditText) findViewById(R.id.login_password);
        bLogin = (Button) findViewById(R.id.bLogin);
        bLogin.setOnClickListener(this);
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(this);
        try{
             password_db= new ValidPassword().execute().get();
        }catch (Exception e) {
        e.printStackTrace();

    }

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.bLogin:
                register();
                if (validate()) {
                    Intent intent = new Intent(MainActivity.this, DisplayCoursesActivity.class);
                    username = edit_username.getText().toString();
                    password = edit_password.getText().toString();
                    // intent.putExtra("username",username);
                    // intent.putExtra("password", password);
                    startActivity(intent);
                }else {
                    break;
                }
                break;

            case R.id.button:
                startActivity(new Intent(this, RegisterUser.class));
                break;

        }
    }



    public void register(){
        initialize(); //initialize the input to string variables
        if (!validate()){
            Toast.makeText(this,"Signup has Failed", Toast.LENGTH_SHORT).show();

        }else{
            onSignupSucess();

        }

    }

    public void onSignupSucess(){

    }
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

    public void initialize(){
        username= edit_username.getText().toString().trim();
        password= edit_password.getText().toString().trim();
    }


    }

