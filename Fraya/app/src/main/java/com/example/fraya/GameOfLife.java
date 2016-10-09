package com.example.fraya;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class GameOfLife extends ActionBarActivity {

    private Colony colony;
    public static final String DEBUGTAG = "DJP";
    public int organismSize = 50;

    private int colWidth = 7;
    private int colLength = 10;
    private boolean[][] nextArray = new boolean[colWidth][colLength];//should already be false...

    public Activity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_of_life);
        colony = new Colony(colWidth, colLength, this, organismSize);
    }



    public void addIterateListener(View v) {
        // make list of booleans for coordinates of each organism then, implement it

        for (int i = 0; i < colony.getWidth() - 1; i++){
            for (int j = 0; j < colony.getHeight() - 1; j++) {
                int glas = colony.findAdjacentOrgs(colony.getOrg(i, j));
                if (colony.getOrg(i, j).isAlive()) {//change to dies if fits parameters, otherwise leave alone.
                    if (glas == 2 || glas == 3) {
                        nextArray[i][j] = true;
                    } else {
                        nextArray[i][j] = false;
                    }
                    //living[livingIndex] = colony.getOrg(i, j);
                } else {//change to lives if fits parameters, otherwise leave alone.
                    if (glas == 3) {
                        nextArray[i][j] = true;
                    } else {
                        nextArray[i][j] = false;
                    }
                }
            }
        }
        for(int i = 0; i < colWidth; i++){
            for(int j = 0; j < colLength; j++){
                if(nextArray[i][j])
                    colony.getOrg(i, j).liveO();
                else
                    colony.getOrg(i, j).dieO();
            }
        }
    }

    public void decreaseOrganismSize(View v){
        if(organismSize > 10){
            organismSize -=10;
            colony = null;
            colony = new Colony(colWidth, colLength, this, organismSize);
        }

    }
    public void increaseOrganismSize(View v){
        organismSize += 10;
        colony = null;
        colony = new Colony(colWidth, colLength, this, organismSize);
    }
    public void increaseColonyWidth(View v){
        colWidth +=1;
        colony = null;
        colony = new Colony(colWidth, colLength, this, organismSize);
    }
    public void decreaseColonyWidth(View v){
        if(colWidth > 0){
            colWidth -=1;
            colony = null;
            colony = new Colony(colWidth, colLength, this, organismSize);
        }
    }
    public void increaseColonyHeight(View v){
        colLength +=1;
        colony = null;
        colony = new Colony(colWidth, colLength, this, organismSize);
    }
    public void decreaseColonyHeight(View v){
        if(colLength > 0){
            colLength -=1;
            colony = null;
            colony = new Colony(colWidth, colLength, this, organismSize);
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.game_of_life, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
