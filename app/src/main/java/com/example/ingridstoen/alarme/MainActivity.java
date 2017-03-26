package com.example.ingridstoen.alarme;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.app.Activity;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends Activity implements View.OnClickListener {

    String username, password;
    Button button;
    Button bLogin;
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
        ArrayList<String> vals= new ArrayList<>(Arrays.asList("fysikk","Matte","Kjemi"));

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bLogin:
                ArrayList<String> vals= new ArrayList<>(Arrays.asList("fysikk","Matte","Kjemi"));
                ListView lv= (ListView) findViewById(R.id.listView1);
                ArrayAdapter ad= new ArrayAdapter(vals,this);
                lv.setAdapter(ad);

                /*username = edit_username.getText().toString();
                password = edit_password.getText().toString();
                Database_Login db= new Database_Login();
                db.setUsername(username);
                db.setPassword(password);
                db.execute();
                startActivity(new Intent(this, DisplayCoursesActivity.class));
                break;*/
            case R.id.button:
                startActivity(new Intent(this, RegisterUser.class));
                break;
        }
    }
}
