package com.cmput301.bstang.bstang_reflex;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class ThreePlayer extends Activity {

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three_player);

        Button player_1 = (Button) findViewById(R.id.threePlayer1);
        player_1.setOnClickListener(player1Listener); // Register the onClick listener with the implementation above

        Button player_2 = (Button) findViewById(R.id.threePlayer2);
        player_2.setOnClickListener(player2Listener); // Register the onClick listener with the implementation above

        Button player_3 = (Button) findViewById(R.id.threePlayer3);
        player_3.setOnClickListener(player3Listener); // Register the onClick listener with the implementation above

    }

    //Create an anonymous implementation of OnClickListener
    private OnClickListener player1Listener = new OnClickListener() {
        public void onClick(View v) {
            Toast.makeText(ThreePlayer.this, "One", Toast.LENGTH_LONG).show();
        }
    };

    private OnClickListener player2Listener = new OnClickListener() {
        public void onClick(View v) {
            Toast.makeText(ThreePlayer.this, "Two", Toast.LENGTH_LONG).show();
        }
    };

    private OnClickListener player3Listener = new OnClickListener() {
        public void onClick(View v) {
            Toast.makeText(ThreePlayer.this, "Three", Toast.LENGTH_LONG).show();
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