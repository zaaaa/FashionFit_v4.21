package com.sitizahirahmkgmail.fashionfit;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Handler;

public class firstActivity extends AppCompatActivity {

    //declaring variables
    String gender="";
    public void pickGender(View view) {
        ImageView img = (ImageView) findViewById(R.id.imageView);

        if(view.getId()== R.id.male){
            img.setImageResource(R.drawable.fashionfit_icon3);
            gender="male";
        }
        else if (view.getId()== R.id.female){
            img.setImageResource(R.drawable.fashionfit_icon2);
            gender="female";
        }

    }
    //storing user information
    //String [] userArray= new String[2];
    //retrieving login values
    EditText username = (EditText)findViewById(R.id.username);
    EditText password = (EditText)findViewById(R.id.password);
    String user = username.getText().toString();
    String pwd = password.getText().toString();
    public void login(View view) {
        if (user != null && pwd != null) {
            Toast.makeText(this, user, Toast.LENGTH_SHORT).show();

        } else {
            Toast.makeText(this, "No input", Toast.LENGTH_SHORT).show();
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //media player
        MediaPlayer mpstart = MediaPlayer.create(this, R.raw.djgriffin135raveygameloop6mp3);
        mpstart.setAudioStreamType(AudioManager.STREAM_MUSIC);
        mpstart.setLooping(true);
        mpstart.start();

       /* FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_first, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
