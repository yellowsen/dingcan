package com.sen.dingcan.adapter;

import java.util.List;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.sen.dingcan.R;
import com.sen.dingcan.bean.Food;
import com.sen.dingcan.utils.ViewHolder;

public class CategoryItemListItemAdapter extends BaseAdapter {

	private List<Food> foodList;
	private Context context;
	public CategoryItemListItemAdapter(Context context,List<Food> foodList)
	{
		this.foodList=foodList;
		this.context=context;
	}
	
	@Override
	public int getCount() {
		return foodList.size();
	}

	@Override
	public Object getItem(int position) {
		return foodList.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		if(convertView==null)
		{
			convertView=View.inflate(context, R.layout.category_list_item, null);
		}
		ImageView foodIcon=ViewHolder.get(convertView, R.id.iv_food_icon);
		TextView foodName=ViewHolder.get(convertView, R.id.tv_food_name);
		TextView foodPrice=ViewHolder.get(convertView, R.id.tv_food_price);
		
		foodIcon.setImageResource(foodList.get(position).getIcon2());
		foodName.setText(foodList.get(position).getName());
		foodPrice.setText("￥"+foodList.get(position).getPrice());
		
		return convertView;
	}

}
