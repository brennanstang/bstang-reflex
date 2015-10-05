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

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class TwoStats extends TwoPlayer {

    private ListView lv;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two_stats);

        lv = (ListView) findViewById(R.id.statsList);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>( this,
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

