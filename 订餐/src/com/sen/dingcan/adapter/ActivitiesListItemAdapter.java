package com.sen.dingcan.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.sen.dingcan.R;

public class ActivitiesListItemAdapter extends BaseAdapter {

	private int[] imgIds;
	private Context context;
	public ActivitiesListItemAdapter(Context context,int[] imgIds)
	{
		this.context=context;
		this.imgIds=imgIds;
		
	}
	
	@Override
	public int getCount() {
		return imgIds.length;
	}

	@Override
	public Object getItem(int position) {
		return null;
	}

	@Override
	public long getItemId(int position) {
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ImageView img=null;
		if(convertView==null)
		{
			convertView=View.inflate(context, R.layout.activities_list_item, null);
			img=(ImageView) convertView.findViewById(R.id.iv_activities_list_item);
			convertView.setTag(img);
		}else
		{
			img=(ImageView) convertView.getTag();
		}
		
		img.setImageResource(imgIds[position]);
		
		return convertView;
	}

}
