package com.sen.dingcan.adapter;

import java.util.List;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;


public class MyViewPagerAdapter extends FragmentPagerAdapter {

	private List<Fragment> fragments;
	
	public MyViewPagerAdapter(FragmentManager fm) {
		super(fm);
	}

	public MyViewPagerAdapter(FragmentManager fm,List<Fragment> fragments)
	{
		super(fm);
		this.fragments=fragments;
		
	}
	
	

	@Override
	public Fragment getItem(int arg0) {
	
		return fragments.get(arg0);
	}

	@Override
	public int getCount() {
		
		return fragments.size();
	}

}
