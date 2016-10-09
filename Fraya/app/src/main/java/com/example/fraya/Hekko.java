package com.example.fraya;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

//import android.widget.TextView;

public class Hekko extends ActionBarActivity {

	public static final String DEBUGTAG = "DJP";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_hekko);

		addHekkoPassListener();
	}

	/*
	 * Takes data from edittext bar and displays it as the button's text when it
	 * matches a password. CLicking on the button makes it go to Smash or
	 * somewhere else
	 */

	private void addHekkoPassListener() {

		Button btn = (Button) findViewById(R.id.hekko_button);

		btn.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				EditText edittext = (EditText) findViewById(R.id.hekko_edittext);
				Button button = (Button) findViewById(R.id.hekko_button);

				String text = edittext.getText().toString();

				Log.d(DEBUGTAG, "Clicked hekko button");

				try {
					if (text.equalsIgnoreCase("Morse"))
					{
						button.setText(text);
						Intent i = new Intent(Hekko.this, Morse.class);
						startActivity(i);
					} else if(text.equalsIgnoreCase("Game")||text.equalsIgnoreCase("GameOfLife")) {
						Intent i = new Intent(Hekko.this, GameOfLife.class);
						startActivity(i);					
					}
					else
						button.setText("Nope");
				} catch (Exception e) {
					Log.d(DEBUGTAG, "Didn't go through");
				}
			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.hekko, menu);
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
