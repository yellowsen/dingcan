package com.sen.dingcanhoutai;

import cn.bmob.v3.Bmob;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener {

	private Button mAddCategory;
	private Button mAddFood;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		
		Bmob.initialize(this, "9b9558723e54f4412c049524be9a690c");
		
		mAddCategory = (Button) findViewById(R.id.btn_add_category);

		mAddFood = (Button) findViewById(R.id.btn_add_food);

		mAddCategory.setOnClickListener(this);
		mAddFood.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
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

	@Override
	public void onClick(View v) {

		Intent intent = null;
		switch (v.getId()) {
		case R.id.btn_add_category:
			intent = new Intent(this, AddCategoryActivity.class);
			break;

		case R.id.btn_add_food:
			intent = new Intent(this, AddFoodyActivity.class);
			break;
		}
		startActivity(intent);
	}
}
