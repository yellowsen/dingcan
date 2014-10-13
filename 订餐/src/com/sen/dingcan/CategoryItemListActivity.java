package com.sen.dingcan;

import java.util.ArrayList;

import com.sen.dingcan.adapter.CategoryItemListItemAdapter;
import com.sen.dingcan.bean.Food;

import android.app.ListActivity;
import android.os.Bundle;

public class CategoryItemListActivity extends ListActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_category_list);

		ArrayList<Food> foodList = new ArrayList<Food>();
		for (int i = 0; i < 10; i++) {
			Food food = new Food();
			food.setIcon2(R.drawable.food);
			food.setName("红烧肉");
			food.setPrice(10);
			foodList.add(food);
		}

		CategoryItemListItemAdapter adapter = new CategoryItemListItemAdapter(
				this, foodList);

		setListAdapter(adapter);
	}

}
