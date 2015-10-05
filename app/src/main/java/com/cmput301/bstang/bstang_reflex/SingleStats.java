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

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class SingleStats extends SinglePlayer {

    private ListView lv;
    public static List<Integer> first10 = new ArrayList<Integer>();
    public static List<Integer> first100 = new ArrayList<Integer>();
    public static List<String> statsList = new ArrayList<String>();
    int minAll;
    int min10;
    int min100;
    int maxAll;
    int max10;
    int max100;
    double dMinAll;
    double dMin10;
    double dMin100;
    double dMaxAll;
    double dMax10;
    double dMax100;
    double avgAll;
    double avg10;
    double avg100;
    double medAll;
    double med10;
    double med100;
    private static final String FILENAME = "file.sav";

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_stats);


        minAll = Collections.min(stats);
        maxAll = Collections.max(stats);
        avgAll = average(stats);
        medAll = median(stats);
        Collections.reverse(stats);

        if(stats.size() >= 10) {
            first10 = stats.subList(0, 9);
        }
        else if(stats.size() >= 100) {
            first100 = stats.subList(0, 99);
        }
        else {
            first10 = stats;
            first100 = stats;
        }

        min10 = Collections.min(first10);
        max10 = Collections.max(first10);
        avg10 = average(first10);
        med10 = median(first10);
        min100 = Collections.min(first100);
        max100 = Collections.max(first100);
        avg100 = average(first100);
        med100 = median(first100);

        dMinAll = (double)minAll;
        dMin10 = (double)min10;
        dMin100 = (double)min100;
        dMaxAll = (double)maxAll;
        dMax10 = (double)max10;
        dMax100 = (double)max100;

        statsList = Arrays.asList("Min of all: " + String.valueOf(dMinAll), "Min if last 10: " + String.valueOf(dMin10),
                "Min of last 100: " + String.valueOf(dMin100), "Max of all: " + String.valueOf(dMaxAll), "Max of last 10: " + String.valueOf(dMax10),
                "Max of last 100: " + String.valueOf(dMax100), "Average of all: " + String.valueOf(avgAll), "Average of last 10: " + String.valueOf(avg10),
                "Average of last 100: " + String.valueOf(avg100), "Median of all: " + String.valueOf(medAll), "Median of last 10: " + String.valueOf(med10),
                "Median of last 100: " + String.valueOf(med100));



        lv = (ListView) findViewById(R.id.statsList);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>( this,
                android.R.layout.simple_list_item_1, statsList );

        lv.setAdapter(arrayAdapter);

    }


    //following function from http://stackoverflow.com/questions/10791568/calculating-average-of-an-array-list
    private double average(List<Integer> stats) {
        Integer sum = 0;
        if(!stats.isEmpty()) {
            for (Integer stat : stats) {
                sum += stat;
            }
            return sum.doubleValue() / stats.size();
        }
        return sum;
    }
    //following function from https://lembra.wordpress.com/2011/08/02/sum-mean-median-and-standard-deviation-using-lists-in-java/
    public double median(List<Integer> stats){
        int middle = stats.size()/2;

        if (stats.size() % 2 == 1) {
            return stats.get(middle);
        } else {
            return (stats.get(middle-1) + stats.get(middle)) / 2.0;
        }
    }

    //following functions form the lonely twitter example in the labs

    private void loadFromFile() {
        try {
            FileInputStream fis = openFileInput(FILENAME);
            BufferedReader in = new BufferedReader(new InputStreamReader(fis));
            Gson gson = new Gson();
            //Following line based on https://google-gson.googlecode.com/svn/trunk/gson/docs/javadocs/com/google/gson/Gson.html
            Type listType = new TypeToken<ArrayList<Double>>() {}.getType();
            statsList = gson.fromJson(in, listType);


        } catch (FileNotFoundException e) {
            statsList = new ArrayList<String>();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void saveInFile() {
        try {
            FileOutputStream fos = openFileOutput(FILENAME, 0);
            OutputStreamWriter writer = new OutputStreamWriter(fos);
            Gson gson = new Gson();
            gson.toJson(statsList, writer);
            writer.flush();
            fos.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
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