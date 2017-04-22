package com.example.ingridstoen.alarme;

import android.test.ActivityInstrumentationTestCase2;
import android.widget.EditText;
import android.widget.TextView;
import com.example.ingridstoen.alarme.MainActivity;

import junit.framework.TestCase;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by aminaettayebi on 22.04.2017.
 */
public class MainActivityTest  extends ActivityInstrumentationTestCase2<MainActivity>{

//Create Main activity Object
   /* MainActivity activity;

    public void setUp() throws  Exception{
        super.setUp();
        activity= new MainActivity();*/

    public MainActivityTest(){
        super (MainActivity.class);

    }





    //}
    @Test
    public void testonCreate(){
        MainActivity activity = new MainActivity();
        //TextView textView= (TextView) activity.findViewById(R.id.view_register);
        EditText edit_username= (EditText) activity.findViewById(R.id.login_username) ;
        EditText edit_password= (EditText) activity.findViewById(R.id.login_password);
        edit_username.setText("amina");
        edit_password.setText("123");
        assertEquals("amina",edit_username.getText());
        assertEquals("123",edit_password.getText());



    }

    @Test
    public void onClick() throws Exception {

    }

    @Test
    public void register() throws Exception {

    }

    @Test
    public void onSignupSucess() throws Exception {

    }

    @Test
    public void validate() throws Exception {

    }

    @Test
    public void initialize() throws Exception {

    }

}