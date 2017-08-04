package com.kateyeeum.guessingmarriageage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private int randomAge;
    private int currentAge;
    private int guessAge;
    private String messageView;

    private EditText currentAgeText;
    private EditText guessAgeText;
    private TextView boxMessage;
    private Button btnInvisible;
    private Button submit;
    private Button submitInvisible;
    private LinearLayout messageBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void setRandomAge(View view) {


        //catch two inputs in variables
        currentAgeText = (EditText) findViewById(R.id.currentAge);
        guessAgeText = (EditText) findViewById(R.id.guessAge);

        //convert two values into integer
        currentAge = Integer.parseInt(currentAgeText.getText().toString());
        guessAge = Integer.parseInt(guessAgeText.getText().toString());

        //random age number to guess
        Random rand = new Random();
        randomAge = rand.nextInt(40) + currentAge;

        checkAge(view);
    }

    public void checkAge(View view){

        //if statements to display message box

//        if(currentAgeText != null && guessAgeText != null) {

            if (currentAge > 0 && currentAge <= guessAge) {

                if (guessAge > randomAge) {

                    messageView = "Too Old!";

                } else if (guessAge < randomAge) {

                    messageView = "Too Young!";

                } else {

                    messageView = "Perfect!";
                }

            } else {

                messageView = "Your age should be same or younger than guessing age";

            }
//        } else{
//            messageView = "Please fill the age input!";
//        }

        // Message Layout
        boxMessage = (TextView) findViewById(R.id.textInMessage);
        boxMessage.setText(messageView);

        btnInvisible = (Button) findViewById(R.id.submit);
        btnInvisible.setVisibility(View.INVISIBLE);

        messageBox = (LinearLayout) findViewById(R.id.messageLayout);
        messageBox.setVisibility(View.VISIBLE);

    }

    public void tryAgain(View view){

        if(guessAge == randomAge) {

            messageBox.setVisibility(View.INVISIBLE);
            recreate();

        }else {
            //show another button
            submit = (Button) findViewById(R.id.submit);
            submit.setVisibility(View.INVISIBLE);
            submitInvisible = (Button) findViewById(R.id.submitInvisible);
            submitInvisible.setVisibility(View.VISIBLE);


            messageBox.setVisibility(View.INVISIBLE);
            guessAgeText.setText("");
            btnInvisible.setVisibility(View.VISIBLE);

        }

    }
}
