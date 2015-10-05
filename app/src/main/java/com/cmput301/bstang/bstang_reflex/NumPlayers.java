package com.cmput301.bstang.bstang_reflex;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class NumPlayers extends Activity {

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_num_players);


        Button players_2 = (Button) findViewById(R.id.players2);
        players_2.setOnClickListener(TwoPlayerListener); // Register the onClick listener with the implementation above

        Button players_3 = (Button) findViewById(R.id.players3);
        players_3.setOnClickListener(ThreePlayerListener); // Register the onClick listener with the implementation above

        Button players_4 = (Button) findViewById(R.id.players4);
        players_4.setOnClickListener(FourPlayerListener); // Register the onClick listener with the implementation above

    }

    private OnClickListener TwoPlayerListener = new OnClickListener() {
        public void onClick(View v) {
            Intent a = new Intent(NumPlayers.this, TwoPlayer.class);
            startActivity(a);
        }
    };

    private OnClickListener ThreePlayerListener = new OnClickListener() {
        public void onClick(View v) {
            Intent a = new Intent(NumPlayers.this, ThreePlayer.class);
            startActivity(a);
        }
    };

    private OnClickListener FourPlayerListener = new OnClickListener() {
        public void onClick(View v) {
            Intent a = new Intent(NumPlayers.this, FourPlayer.class);
            startActivity(a);
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

