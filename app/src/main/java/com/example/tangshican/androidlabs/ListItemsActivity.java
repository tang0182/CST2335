package com.example.tangshican.androidlabs;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.Toast;

public class ListItemsActivity extends Activity {
    protected static final String ACTIVITY_NAME="StartActivity";
    static final int REQUEST_IMAGE_CAPTURE = 1;
    private ImageButton imagebutton;
    private Switch aSwitch;
    private CheckBox checkBox;
    private Intent intent;
    private ImageView imageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_items);
        imagebutton=findViewById(R.id.imageButton);
        aSwitch=findViewById(R.id.switch_button);
        checkBox=findViewById(R.id.checkbox_button);

        imagebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
            }
              //  Toast.makeText(ListItemsActivity.this,R.string.correct_toast,Toast.LENGTH_SHORT).show();

        });
       aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
           @Override
           public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
               if(isChecked) {
                   CharSequence text = "Switch is On";// "Switch is Off"
                   int duration = Toast.LENGTH_SHORT; //= Toast.LENGTH_LONG if Off
                   Toast toast = Toast.makeText(ListItemsActivity.this, text, duration); //this is the ListActivity
                   toast.show(); //display your message box
               }else{
                   CharSequence text = "Switch is Off";
                   int duration = Toast.LENGTH_SHORT; //= Toast.LENGTH_LONG if Off
                   Toast toast = Toast.makeText(ListItemsActivity.this, text, duration); //this is the ListActivity
                   toast.show(); //display your message box
               }
           }
       });
       checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
           @Override
           public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
               if(isChecked) {
                    buildDialog();
                   //AlertDialog.Builder builder = new AlertDialog.Builder(ListItemsActivity.this);
                   // 2. Chain together various setter methods to set the dialog characteristics
                   //builder.setMessage(R.string.dialog_message); //Add a dialog message to strings.xml
               }
           }
       });

    }
    private void buildDialog(){
        new AlertDialog.Builder(this)
                .setTitle("")
                .setMessage("Do you want to finish the activity?")
                .setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //checkBox.setChecked(false);
                        Intent resultIntent = new Intent( );
                        resultIntent.putExtra("Response", "Here is my response");
                        setResult(Activity.RESULT_OK, resultIntent);
                        finish();
                    }
                })
                .setNegativeButton(R.string.no, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //do nothing
                    }
                })
                .show();
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            imagebutton.setImageBitmap(imageBitmap);
        }
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
