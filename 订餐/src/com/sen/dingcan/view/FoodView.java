package com.sen.dingcan.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.sen.dingcan.R;
import com.sen.dingcan.bean.Food;

public class FoodView extends LinearLayout {

	private ImageView foodIcon;
	private TextView foodName;
	private TextView foodPrice;

	public FoodView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		initView(context);
	}

	public FoodView(Context context, AttributeSet attrs) {
		super(context, attrs);
		
		
		initView(context);
	}

	public FoodView(Context context) {
		super(context);
		initView(context);
	}

	private void initView(Context context) {
		View.inflate(context, R.layout.view_food, this);
		this.setBackgroundColor(context.getResources().getColor(android.R.color.background_light));
		
		foodIcon = (ImageView) this.findViewById(R.id.iv_food_icon);
		
		foodName = (TextView) this.findViewById(R.id.tv_food_name);
		
		foodPrice = (TextView) this.findViewById(R.id.tv_food_price);
		
	
	}
	
	
	public void setFoodData(Food food)
	{
		if(food==null)
			return;
		foodName.setText(food.getName());
		foodPrice.setText(String.valueOf(food.getPrice()));
		
		
	}
	
	
}
