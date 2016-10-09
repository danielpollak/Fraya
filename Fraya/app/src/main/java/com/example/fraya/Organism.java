package com.example.fraya;

import android.app.Activity;
import android.graphics.Color;
import android.util.Log;
import android.view.*;
import android.widget.Button;
import android.widget.RelativeLayout;

public class Organism {

	public static final String DEBUGTAG = "DJP";
	public Activity activity;

	private int id;
	private int Row;
	private int Col;
	private Button btn;

	public Organism(Activity _activity, int C, int R, int size) {
		//unintuitive as is seems, Columns is x, rows is y
		Row = R;
		Col = C;

		// in constructor, instantiate a button by somehow adding it to
		// activity_game_of_life. This is where you do it.
		putOrgsInRelativeLayout(_activity, size);

		addButtonListener();

	}

	public int getRow() {
		return Row;
	}

	public int getCol() {
		return Col;
	}

	/* the this.activity allows us to instantiate outside of activity, the
		LinearL lets us add it to xml.*/
	public void putOrgsInRelativeLayout(Activity _activity, int size) {
		this.activity = _activity;
		RelativeLayout relativeLayout = (RelativeLayout) this.activity
				.findViewById(R.id.activity_game_of_life);


		btn = new Button(_activity);
		btn.setLayoutParams(new RelativeLayout.LayoutParams(size, size));
		//RelativeLayout.LayoutParams.WRAP_CONTENT
		// and finally add button to LinLay
		// in Colony, this will happen repeatedly, so it makes it into a
		// board.

		btn.setText("O");
		btn.setTextColor(Color.parseColor("#663300"));
		btn.setBackgroundColor(Color.parseColor("#663300"));
		relativeLayout.addView(btn);
	}

	public boolean isAlive()
	{
		if(btn.getText().equals("X"))
			return true;
		else
			return false;
	}
	
	public void dieO()
	{
		btn.setText("O");
		btn.setTextColor(Color.parseColor("#663300"));
		btn.setBackgroundColor(Color.parseColor("#663300"));
	}
	
	public void liveO()
	{
		btn.setText("X");
		btn.setTextColor(Color.parseColor("#006699"));
		btn.setBackgroundColor(Color.parseColor("#006699"));
	}
	
	
	public void addId(int i) {
		btn.setId(i);
		id = i;
	}

	public int getId() {
		return id;
	}

	public void addOrgRuleL(int v) {
		// v refers to an Organism (which is a child of View technically)
		RelativeLayout.LayoutParams but = (RelativeLayout.LayoutParams) btn
				.getLayoutParams();
		but.addRule(RelativeLayout.RIGHT_OF, v);
		but.addRule(RelativeLayout.ALIGN_TOP, v);
	}

	public void addOrgRuleU(int v) {
		// v refers to an Organism (which is a child of View technically)
		RelativeLayout.LayoutParams but = (RelativeLayout.LayoutParams) btn
				.getLayoutParams();
		but.addRule(RelativeLayout.BELOW, v);
		but.addRule(RelativeLayout.ALIGN_LEFT, v);
	}
	
	public void addOrgRuleP(){
		RelativeLayout.LayoutParams but = (RelativeLayout.LayoutParams) btn
				.getLayoutParams();
		but.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
		but.addRule(RelativeLayout.ALIGN_PARENT_TOP);
	}

	public void addButtonListener() {

		btn.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Button button = (Button) v;
				Log.d(DEBUGTAG, "Clicked organism");

					if (button.getText().equals("O")) {
						button.setText("X");
						button.setTextColor(Color.parseColor("#006699"));
						button.setBackgroundColor(Color.parseColor("#006699"));
					} else {
						button.setText("O");
						button.setTextColor(Color.parseColor("#663300"));
						button.setBackgroundColor(Color.parseColor("#663300"));
					}



			}
		});

	}

}
