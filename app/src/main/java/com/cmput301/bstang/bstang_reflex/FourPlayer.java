package com.cmput301.bstang.bstang_reflex;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class FourPlayer extends Activity {

    public static ArrayList<Integer> fourStats = new ArrayList<>();
    int player1 = 0;
    int player2 = 0;
    int player3 = 0;
    int player4 = 0;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_four_player);

        Button player_1 = (Button) findViewById(R.id.fourPlayer1);
        player_1.setOnClickListener(player1Listener); // Register the onClick listener with the implementation above

        Button player_2 = (Button) findViewById(R.id.fourPlayer2);
        player_2.setOnClickListener(player2Listener); // Register the onClick listener with the implementation above

        Button player_3 = (Button) findViewById(R.id.fourPlayer3);
        player_3.setOnClickListener(player3Listener); // Register the onClick listener with the implementation above

        Button player_4 = (Button) findViewById(R.id.fourPlayer3);
        player_4.setOnClickListener(player4Listener); // Register the onClick listener with the implementation above

        Button stats = (Button) findViewById(R.id.stats);
        stats.setOnClickListener(statsListener); // Register the onClick listener with the implementation above

    }

    private OnClickListener statsListener = new OnClickListener() {
        public void onClick(View v) {
            fourStats.add(player1);
            fourStats.add(player2);
            fourStats.add(player3);
            fourStats.add(player4);
            Intent a = new Intent(FourPlayer.this, FourStats.class);
            startActivity(a);
        }
    };

    //Create an anonymous implementation of OnClickListener
    private OnClickListener player1Listener = new OnClickListener() {
        public void onClick(View v) {
            final AlertDialog player_1 = new AlertDialog.Builder(FourPlayer.this).create();
            player_1.setTitle("Buzz!");
            player_1.setMessage("Player 1 Pressed the buzzer first!");
            player_1.setButton("Okay!", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    player1 += 1;
                    player_1.cancel();
                }
            });
            player_1.show();
        }
    };

    private OnClickListener player2Listener = new OnClickListener() {
        public void onClick(View v) {
            final AlertDialog player_2 = new AlertDialog.Builder(FourPlayer.this).create();
            player_2.setTitle("Buzz!");
            player_2.setMessage("Player 2 Pressed the buzzer first!");
            player_2.setButton("Okay!", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    player2 += 1;
                    player_2.cancel();
                }
            });
            player_2.show();
        }
    };

    private OnClickListener player3Listener = new OnClickListener() {
        public void onClick(View v) {
            final AlertDialog player_3 = new AlertDialog.Builder(FourPlayer.this).create();
            player_3.setTitle("Buzz!");
            player_3.setMessage("Player 3 Pressed the buzzer first!");
            player_3.setButton("Okay!", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    player3 += 1;
                    player_3.cancel();
                }
            });
            player_3.show();
        }
    };


    private OnClickListener player4Listener = new OnClickListener() {
        public void onClick(View v) {
            final AlertDialog player_4 = new AlertDialog.Builder(FourPlayer.this).create();
            player_4.setTitle("Buzz!");
            player_4.setMessage("Player 4 Pressed the buzzer first!");
            player_4.setButton("Okay!", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    player4 += 1;
                    player_4.cancel();
                }
            });
            player_4.show();
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
