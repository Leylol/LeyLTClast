package com.gmail.leylol.leyltc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;


public class SignUpActivity extends AppCompatActivity {

    //Explicit


    private EditText nameEditText, userEditText, passEditText;
    private String nameString, userString, passString;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        // Bind Widget
        nameEditText = (EditText) findViewById(R.id.editText);
        userEditText = (EditText) findViewById(R.id.editText2);
        passEditText = (EditText) findViewById(R.id.editText3);


    }   //main method

    public void clickSignUpSing(View view) {
        nameString = nameEditText.getText().toString().trim();
        userString = userEditText.getText().toString().trim();
        passString = passEditText.getText().toString().trim();


        if (nameString.equals("") || userString.equals("") || passString.equals("")) {

            //Have Space
            Log.d("13DecV1","Have Space!");


            MyAlert myAlert = new MyAlert(SignUpActivity.this, "Have Space!", "Please Fill All Blank !", R.drawable.doremon48);

            myAlert.MyDialog();


        }





    }   //Click Sign


}   //main class
