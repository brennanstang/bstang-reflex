package com.cmput301.bstang.bstang_reflex;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class TwoStats extends TwoPlayer {

    private ListView lv;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two_stats);

        lv = (ListView) findViewById(R.id.statsList);

        ArrayAdapter<Integer> arrayAdapter = new ArrayAdapter<Integer>( this,
                android.R.layout.simple_list_item_1, twoStats );

        lv.setAdapter(arrayAdapter);
    }

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
