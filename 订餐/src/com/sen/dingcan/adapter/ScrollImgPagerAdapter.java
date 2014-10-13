package com.sen.dingcan.adapter;

import java.util.List;

import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;

public class ScrollImgPagerAdapter extends PagerAdapter {

	private OnItemClickListener itemClickListener;
	
	private List<ImageView> imgs;
	public ScrollImgPagerAdapter(Fragment fragment,List<ImageView> imgs)
	{
		if(fragment instanceof OnItemClickListener)
			itemClickListener=(OnItemClickListener) fragment;
		this.imgs=imgs;
	}
	
	@Override
	public int getCount() {
		return imgs.size();
	}

	@Override
	public boolean isViewFromObject(View arg0, Object arg1) {
		return arg0==arg1;		
	}
	
	@Override
	public Object instantiateItem(ViewGroup container, int position) {
		ImageView img=imgs.get(position);
		final int p=position;
		img.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				itemClickListener.onPagerItemClick(v,p);
			}
		});
		container.addView(img);
		return imgs.get(position);
	}
	
	@Override
	public void destroyItem(ViewGroup container, int position, Object object) {
		container.removeView((View) object);
		object=null;
	}

	
	public interface OnItemClickListener
	{
		void onPagerItemClick(View view,int postion);
	}
}
