package com.sen.dingcan;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

public class FoodDescActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		
		setContentView(R.layout.activity_food_desc);
		
	}
}
