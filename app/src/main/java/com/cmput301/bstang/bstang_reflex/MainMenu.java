package com.cmput301.bstang.bstang_reflex;


import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainMenu extends Activity {

    //Started this by following guide at http://blog.idleworx.com/2011/06/build-simple-android-app-2-button.html then edited from there.

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        Button singlePlayer = (Button)findViewById(R.id.singlePlayer);
        singlePlayer.setOnClickListener(singleListener); // Register the onClick listener with the implementation above

        Button multiPlayer = (Button)findViewById(R.id.multiPlayer);
        multiPlayer.setOnClickListener(multiListener); // Register the onClick listener with the implementation above
    }

    //Create an anonymous implementation of OnClickListener
    private OnClickListener singleListener = new OnClickListener() {
        public void onClick(View v) {
            Intent a = new Intent(MainMenu.this, SinglePlayerInfo.class);
            startActivity(a);
        }
    };

    // Create an anonymous implementation of OnClickListener
    private OnClickListener multiListener = new OnClickListener() {
        public void onClick(View v) {
            Intent a = new Intent(MainMenu.this, MultiPlayerInfo.class);
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