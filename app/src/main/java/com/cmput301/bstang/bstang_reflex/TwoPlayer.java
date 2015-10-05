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

public class TwoPlayer extends Activity {

    public static ArrayList<Integer> twoStats = new ArrayList<>();
    int player1 = 0;
    int player2 = 0;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two_player);

        Button player_1 = (Button) findViewById(R.id.twoPlayer1);
        player_1.setOnClickListener(player1Listener); // Register the onClick listener with the implementation above

        Button player_2 = (Button) findViewById(R.id.twoPlayer2);
        player_2.setOnClickListener(player2Listener); // Register the onClick listener with the implementation above

        Button stats = (Button) findViewById(R.id.stats);
        stats.setOnClickListener(statsListener); // Register the onClick listener with the implementation above

    }

    private OnClickListener statsListener = new OnClickListener() {
        public void onClick(View v) {
            twoStats.add(player1);
            twoStats.add(player2);
            Intent a = new Intent(TwoPlayer.this, TwoStats.class);
            startActivity(a);
        }
    };

    private OnClickListener player1Listener = new OnClickListener() {
        public void onClick(View v) {
            final AlertDialog player_1 = new AlertDialog.Builder(TwoPlayer.this).create();
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
            final AlertDialog player_2 = new AlertDialog.Builder(TwoPlayer.this).create();
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
    };;
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
