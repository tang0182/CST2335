package com.example.tangshican.androidlabs;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class LoginActivity extends Activity {
    protected static final String ACTIVITY_NAME = "StartActivity";

    private SharedPreferences sharedPreferences;
    private Button loginbutton;
    private EditText emailEditText;
    private static String MY_PREF = "MY_PREF";
    public static String Default_Email_Key = "Default_Email_Key";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //reference loginButton
        loginbutton = findViewById(R.id.button_login);
        //reference emailEditText
        emailEditText = findViewById(R.id.email_edit_button);

        //initial or get SharedPreference
        sharedPreferences = getSharedPreferences(MY_PREF, Context.MODE_PRIVATE);
        //sharedPreferences=context.getSharedPreferences(getString(R.string.my_pref),Context.MODE_PRIVATE);
        //get value from SharedPref and save it into a variable
        String defaultEmail = sharedPreferences.getString("DefaultEmail", "email@domain.com");
        //sharedPreferences.getString("Defaultemail","email@domain.com");

        loginbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor edit = sharedPreferences.edit();
                edit.putString("Default_Email_Key","email@example.com");
                edit.commit();
                Intent intent = new Intent(LoginActivity.this, StartActivity.class);
                startActivity(intent);
            }
        });
    }


    @Override
    protected void onResume(){
        super.onResume();
        Log.i(ACTIVITY_NAME,"In onCreate()");
        Log.i(ACTIVITY_NAME,"In onResume()");
    }
    @Override
    protected void onStart(){
        super.onStart();
        Log.i(ACTIVITY_NAME,"In onCreate()");
        Log.i(ACTIVITY_NAME,"In onResume()");
    }
    @Override
    protected void onPause(){
        super.onPause();
        Log.i(ACTIVITY_NAME,"In onCreate()");
        Log.i(ACTIVITY_NAME,"In onResume()");
    }
    @Override
    protected void onStop(){
        super.onStop();
        Log.i(ACTIVITY_NAME,"In onCreate()");
        Log.i(ACTIVITY_NAME,"In onResume()");
    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.i(ACTIVITY_NAME,"In onCreate()");
        Log.i(ACTIVITY_NAME,"In onResume()");
    }
}
