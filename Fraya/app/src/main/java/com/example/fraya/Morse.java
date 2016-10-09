package com.example.fraya;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.graphics.Color;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Morse extends ActionBarActivity {

	public static final String DEBUGTAG = "DJP";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_morse);
		addButtonListener();
	}
	
	private void addButtonListener(){
		Button btn = (Button) findViewById(R.id.morseButton);
		
		btn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				EditText edittext = (EditText) findViewById(R.id.morseEdit);
				TextView textView = (TextView) findViewById(R.id.morseDisplay);
				
				
				String text = edittext.getText().toString();
				
				String mtext = MorseConverter.Converter(text);
				
				

				Log.d(DEBUGTAG, "Clicked Morse button");

				try {
					textView.setText(mtext);
					textView.setTextColor(Color.parseColor("#000000"));
					textView.setTextSize(60);
					}
				catch (Exception e) {
					Log.d(DEBUGTAG, "Didn't go through");
				}
				
		}
	});

}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.morse, menu);
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
