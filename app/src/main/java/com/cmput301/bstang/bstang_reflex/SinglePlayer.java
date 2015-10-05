package com.cmput301.bstang.bstang_reflex;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.Random;



public class SinglePlayer extends Activity {

    long timeStart;
    long timeEnd;
    long timeChange;
    Toast reactionTime;
    Toast click;
    Handler clickHandler = new Handler();
    int i;
    int l;
    private Boolean b = Boolean.FALSE;
    public static ArrayList<Integer> stats = new ArrayList<>();


    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_player);


        Button stats_button = (Button) findViewById(R.id.statsButton);
        stats_button.setOnClickListener(statsListener);

        Button singlePlayer = (Button) findViewById(R.id.buzzer);
        singlePlayer.setOnClickListener(buzzerListener);

        Button begin = (Button) findViewById(R.id.beginButton);
        begin.setOnClickListener(beginListener);


    }

    private OnClickListener beginListener = new OnClickListener() {
        public void onClick(View v) {
            if (b == Boolean.FALSE) {
                Random r = new Random();
                i = r.nextInt(2000 - 10) + 10;
                clickHandler.postDelayed(clickRun, i);
                timeStart = System.currentTimeMillis();
            } else {
                reactionTime.cancel();
                Random r = new Random();
                i = r.nextInt(2000 - 10) + 10;
                clickHandler.postDelayed(clickRun, i);
                timeStart = System.currentTimeMillis();
            }
        }
    };

    private OnClickListener statsListener = new OnClickListener() {
        public void onClick(View v) {
            if (stats.isEmpty()) {
                final AlertDialog noStats = new AlertDialog.Builder(SinglePlayer.this).create();
                noStats.setTitle("No Stats!");
                noStats.setMessage("You haven't played yet!");
                noStats.setButton("Okay!", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        noStats.cancel();
                    }
                });
                noStats.show();
            } else {
                clickHandler.removeCallbacks(clickRun);
                Intent a = new Intent(SinglePlayer.this, SingleStats.class);
                startActivity(a);
            }
        }
    };


    private OnClickListener buzzerListener = new OnClickListener() {
        public void onClick(View v) {
            timeEnd = System.currentTimeMillis();
            timeChange = timeEnd - timeStart;
            if (timeChange < i) {
                clickHandler.removeCallbacks(clickRun);
                final AlertDialog infoAlert = new AlertDialog.Builder(SinglePlayer.this).create();
                infoAlert.setTitle("Too Soon!");
                infoAlert.setMessage("You clicked before you were prmopted!");
                infoAlert.setButton("Okay!", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        infoAlert.cancel();
                    }
                });
                infoAlert.show();
            } else {
                click.cancel();
                //following line from http://stackoverflow.com/questions/9600082/can-we-convert-a-string-variable-to-long-or-viceversa-in-android
                String time = Long.toString(timeChange);
                String finalMessage = "It took you " + time + " milliseconds to react!";
                b = Boolean.TRUE;
                reactionTime = Toast.makeText(SinglePlayer.this, finalMessage, Toast.LENGTH_LONG);
                reactionTime.show();
                l = (int) timeChange;
                stats.add(l);
            }
        }
    };

    Runnable clickRun = new Runnable() {
        public void run() {
            click = Toast.makeText(SinglePlayer.this, "Click!!", Toast.LENGTH_LONG);
            click.show();
        }
    };

    @Override
    protected void onStart() {//activity is started and visible to the user
        super.onStart();
    }


    @Override
    protected void onResume() {//activity was resumed and is visible again
        super.onResume();

    }
    @Override
    protected void onPause() { //device goes to sleep or another activity appears
        super.onPause();
        if (b == Boolean.TRUE) {
            reactionTime.cancel();
            clickHandler.removeCallbacks(clickRun);
        }

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
