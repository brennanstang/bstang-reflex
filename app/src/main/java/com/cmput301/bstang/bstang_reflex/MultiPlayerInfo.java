package com.cmput301.bstang.bstang_reflex;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MultiPlayerInfo extends Activity {

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi_player_info);

        Button multi_reaction = (Button) findViewById(R.id.multiReaction);
        multi_reaction.setOnClickListener(multiReactionListener); // Register the onClick listener with the implementation above

    }

    //Create an anonymous implementation of OnClickListener
    private OnClickListener multiReactionListener = new OnClickListener() {
        public void onClick(View v) {
            Intent a = new Intent(MultiPlayerInfo.this, NumPlayers.class);
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