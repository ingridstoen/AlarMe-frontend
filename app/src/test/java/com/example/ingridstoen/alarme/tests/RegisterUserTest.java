package com.example.ingridstoen.alarme.tests;

import android.app.Instrumentation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.ingridstoen.alarme.DisplayCoursesActivity;
import com.example.ingridstoen.alarme.MainActivity;
import com.example.ingridstoen.alarme.R;
import com.example.ingridstoen.alarme.RegisterUser;
import android.test.ActivityInstrumentationTestCase2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import static org.mockito.Mockito.when;
/**
 * Created by aminaettayebi on 22.04.2017.
 */

@RunWith(MockitoJUnitRunner.class)

/**
 * Created by aminaettayebi on 22.04.2017.
 */

public class RegisterUserTest extends   ActivityInstrumentationTestCase2<RegisterUser> {
    RegisterUser registeruser;


    public RegisterUserTest(){
        super (RegisterUser.class);

    }

    //this method start the activity

    @Override
    protected void setUp() throws  Exception{
        super.setUp();
        // open current activity.
        registeruser= getActivity();

    }

    @Test

    public void shouldShowErrorMessageWhenUsernameIsEmpty() throws  Exception{

    }
    public void testTextViewNotNull(){
        // register next activity that need to be monitored.

        Instrumentation.ActivityMonitor activityMonitor = getInstrumentation().addMonitor(DisplayCoursesActivity.class.getName(), null, false);
        Button button = (Button) registeruser.findViewById(R.id.bRegister);

        EditText username= (EditText) registeruser.findViewById(R.id.register_username) ;
        EditText passord= (EditText) registeruser.findViewById(R.id.register_password);
        TextView textView= (TextView) registeruser.findViewById(R.id.view_register);
        username.setText("amina");
        passord.setText("123");
        assertEquals("amina",username.getText());
        assertEquals("123",passord.getText());
        button.performClick();
        //Watch for the timeout
        //example values 5000 if in ms, or 5 if it's in seconds.
        DisplayCoursesActivity nextActivity = (DisplayCoursesActivity) getInstrumentation().waitForMonitorWithTimeout(activityMonitor, 5000);
        assertNotNull(nextActivity);
        nextActivity .finish();

    }


}
