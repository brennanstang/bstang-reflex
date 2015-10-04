package com.cmput301.bstang.bstang_reflex;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;


public class SinglePlayer extends Activity {

    long timeStart;
    long timeEnd;
    long timeChange;
    Toast click;
    Toast reactionTime;
    Handler dHandler = new Handler();
    Handler cHandler = new Handler();
    int i;


    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_player);

        Button singlePlayer = (Button) findViewById(R.id.buzzer);
        singlePlayer.setOnClickListener(buzzerListener);

    }


    private OnClickListener buzzerListener = new OnClickListener() {
        public void onClick(View v) {
            click.cancel();
            timeEnd = System.currentTimeMillis();
            timeChange = timeEnd - timeStart;
            //following line from http://stackoverflow.com/questions/9600082/can-we-convert-a-string-variable-to-long-or-viceversa-in-android
            String time = Long.toString(timeChange);
            String finalMessage = "It took you " + time + " milliseconds to react!";
            reactionTime = Toast.makeText(SinglePlayer.this, finalMessage, Toast.LENGTH_LONG);
            reactionTime.show();
            dHandler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    recreate();
                }
            }, 4000);
        }
    };


    @Override
    protected void onStart() {//activity is started and visible to the user
        super.onStart();
        Random r = new Random();
        i = r.nextInt(2000 - 10) + 10;

    }
    @Override
    protected void onResume() {//activity was resumed and is visible again
        super.onResume();

    }
    @Override
    protected void onPause() { //device goes to sleep or another activity appears
        super.onPause();
        reactionTime.cancel();

    }
    @Override
    protected void onStop() { //the activity is not visible anymore
        super.onStop();

    }
    @Override
    protected void onDestroy() {//android has killed this activity
        super.onDestroy();
    }
}
