package com.example.tangshican.androidlabs;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class StartActivity extends Activity {
    protected static final String ACTIVITY_NAME="StartActivity";
    private Button buttonstart;
    public static final int REQUEST_CODE=50;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        buttonstart = findViewById(R.id.button_start);
        buttonstart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StartActivity.this,ListItemsActivity.class);
                startActivityForResult(intent, REQUEST_CODE);
            }
        });
    }

        protected void onActivityResult ( int requestCode, int resultCode,Intent data){
            if (requestCode == REQUEST_CODE && resultCode==RESULT_OK) {
                Log.i(ACTIVITY_NAME, "Returned to StartActivity.onActivityResult");
                String messagePassed = data.getStringExtra("Response");
                if(messagePassed != null) {
                    Toast.makeText(getApplicationContext(), messagePassed, Toast.LENGTH_SHORT).show();
                }
            }
        }

        @Override
        protected void onResume () {
            super.onResume();
            Log.i(ACTIVITY_NAME, "In onCreate()");
            Log.i(ACTIVITY_NAME, "In onResume()");
        }
        @Override
        protected void onStart () {
            super.onStart();
            Log.i(ACTIVITY_NAME, "In onCreate()");
            Log.i(ACTIVITY_NAME, "In onResume()");
        }
        @Override
        protected void onPause () {
            super.onPause();
            Log.i(ACTIVITY_NAME, "In onCreate()");
            Log.i(ACTIVITY_NAME, "In onResume()");
        }
        @Override
        protected void onStop () {
            super.onStop();
            Log.i(ACTIVITY_NAME, "In onCreate()");
            Log.i(ACTIVITY_NAME, "In onResume()");
        }
        @Override
        protected void onDestroy () {
            super.onDestroy();
            Log.i(ACTIVITY_NAME, "In onCreate()");
            Log.i(ACTIVITY_NAME, "In onResume()");
        }

}
