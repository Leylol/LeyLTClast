package com.gmail.leylol.leyltc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {


    //Explicit

    private EditText userEditext, passwordEditext;
    private String userString, passwordString, nameString;
    private String[] loginString;
    private boolean aBoolean = true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Bind Widget


        userEditext = (EditText) findViewById(R.id.editText11);
        passwordEditext = (EditText) findViewById(R.id.editText10);


    }   //  Main Method


    public void ClickSignUpMain(View view) {
        startActivity(new Intent(MainActivity.this, SignUpActivity.class));
    }

    public void ClickSignInMain(View view) {

        userString = userEditext.getText().toString().trim();
        passwordString = passwordEditext.getText().toString().trim();


        if (userString.equals("") || passwordString.equals("")) {

            //Have Space
            MyAlert myAlert = new MyAlert(MainActivity.this,
                    getResources().getString(R.string.title_have_space),
                    getResources().getString(R.string.message_have_space),
                    R.drawable.doremon48);
            myAlert.MyDialog();


        } else {
            //No Space

            try {

                SynUser synUser = new SynUser(MainActivity.this);
                synUser.execute();
                String s = synUser.get();
                Log.d("14Dec", "JSON" + s);


                JSONArray jsonArray = new JSONArray(s);
                loginString = new String[4];

                //Loop For

                for (int i = 0; i < jsonArray.length(); i+=1) {
                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    if (userString.equals(jsonObject.getString("User"))) {

                        loginString[0] = jsonObject.getString("Id");
                        loginString[1] = jsonObject.getString("Name");
                        loginString[2] = jsonObject.getString("User");
                        loginString[3] = jsonObject.getString("Password");
                        aBoolean = false;

                    }
                }
                if (aBoolean) {

                MyAlert myAlert = new MyAlert(MainActivity.this,
                        getResources().getString(R.string.title_user_false),
                        getResources().getString(R.string.message_password_false),
                        R.drawable.rat48);

                        myAlert.MyDialog();

                } else if (passwordString.equals(loginString[3])) {
                    //Password True
                    Toast.makeText(MainActivity.this,"Welcome " + loginString[1],Toast.LENGTH_SHORT).show();

                } else {
                    //Password False

                    MyAlert myAlert = new MyAlert(MainActivity.this,
                            getResources().getString(R.string.title_user_false),
                            getResources().getString(R.string.message_password_false),
                            R.drawable.doremon48);

                    myAlert.MyDialog();
                }

                /*
                MyAlert myAlert = new MyAlert(MainActivity.this, "Message Dialog", s.toString(), R.drawable.kon48);
                myAlert.MyDialog();
                */




            } catch (Exception e) {
                Log.d("14Dec2016", "e Main ==> " + e.toString());
            }
        }


        //startActivity(new Intent(MainActivity.this, SignInActivity.class));
    }

}    //  Main Class
