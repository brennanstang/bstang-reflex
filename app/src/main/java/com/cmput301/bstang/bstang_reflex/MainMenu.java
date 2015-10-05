/*Copyright [2015] [Brennan Stang]

        Licensed under the Apache License, Version 2.0 (the "License");
        you may not use this file except in compliance with the License.
        You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

        Unless required by applicable law or agreed to in writing, software
        distributed under the License is distributed on an "AS IS" BASIS,
        WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
        See the License for the specific language governing permissions and
        limitations under the License.*/

package com.cmput301.bstang.bstang_reflex;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
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
            AlertDialog infoAlert = new AlertDialog.Builder(MainMenu.this).create();
            infoAlert.setTitle("Single Player Instructions");
            infoAlert.setMessage("This game tests your reaction time by seeing how fast you can press a button once prompted.\n" +
                    "After a short delay you will be prompted to press the button on the screen. Then just press it.\n" +
                    "How fast you reacted will then be displayed for you. You can click on stats to view your previous times.\n" +
                    "After a short delay the game will restart. To quit just press the back button.");
            infoAlert.setButton("Okay!", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    Intent a = new Intent(MainMenu.this, SinglePlayer.class);
                    startActivity(a);
                }
            });
            infoAlert.show();
        }
    };

    private OnClickListener multiListener = new OnClickListener() {
        public void onClick(View v) {
            AlertDialog infoAlert = new AlertDialog.Builder(MainMenu.this).create();
            infoAlert.setTitle("Multi-Player Instructions");
            infoAlert.setMessage("Once you have chosen the required number of players, buzzers will appear for each fo you to press. The first one who presses will be notified.");
            infoAlert.setButton("Okay!", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    Intent a = new Intent(MainMenu.this, NumPlayers.class);
                    startActivity(a);
                }
            });
            infoAlert.show();
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