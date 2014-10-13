package com.sen.dingcan;


import java.util.ArrayList;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.sen.dingcan.adapter.MyViewPagerAdapter;
import com.sen.dingcan.fragment.ActivitiesFragment;
import com.sen.dingcan.fragment.CategoryFragment;
import com.sen.dingcan.fragment.HotFragment;
import com.sen.dingcan.fragment.ServiceFragment;

public class MainActivity extends FragmentActivity implements OnClickListener {

	private ViewPager mViewPager;
	private TextView mHot;
	private TextView mCategory;
	private TextView mActivities;
	private TextView mService;
	private LinearLayout tabs;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.acitity_main);

		

		initView();// 初始化view
		setData();// 设置数据
	}

	private void initView() {

		mViewPager = (ViewPager) findViewById(R.id.viewpager);

		mHot = (TextView) findViewById(R.id.tv_hot);
		mHot.setTextColor(MainActivity.this.getResources().getColor(R.color.tabhost));
		
		mCategory = (TextView) findViewById(R.id.tv_category);
		mActivities = (TextView) findViewById(R.id.tv_activities);
		mService = (TextView) findViewById(R.id.tv_service);

		tabs = (LinearLayout) findViewById(R.id.tabs);
		
		
		mHot.setOnClickListener(this);
		mCategory.setOnClickListener(this);
		mActivities.setOnClickListener(this);
		mService.setOnClickListener(this);

	}

	private void setData() {
		
		
		
		ArrayList<Fragment> fragments=new ArrayList<Fragment>();
		
		HotFragment hotFragment=new HotFragment();
		CategoryFragment categoryFragment=new CategoryFragment();
		ActivitiesFragment activitiesFragment=new ActivitiesFragment();
		ServiceFragment serviceFragment=new ServiceFragment();
		
		fragments.add(hotFragment);
		fragments.add(categoryFragment);
		fragments.add(activitiesFragment);
		fragments.add(serviceFragment);
		
		
		MyViewPagerAdapter adapter=new MyViewPagerAdapter(getSupportFragmentManager(), fragments);
		
		mViewPager.setAdapter(adapter);
		mViewPager.setCurrentItem(0);
		mViewPager.setOnPageChangeListener(new OnPageChangeListener() {
			
			@Override
			public void onPageSelected(int arg0) {
				MainActivity.this.setAllTextColortoBlack();
				switch (arg0) {
				case 0:
					mHot.setTextColor(MainActivity.this.getResources().getColor(R.color.tabhost));
					break;
				case 1:
					mCategory.setTextColor(MainActivity.this.getResources().getColor(R.color.tabhost));
					break;
				case 2:
					mActivities.setTextColor(MainActivity.this.getResources().getColor(R.color.tabhost));
					break;
				case 3:
					mService.setTextColor(MainActivity.this.getResources().getColor(R.color.tabhost));
					break;
				}
				
			}
			
			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onPageScrollStateChanged(int arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
	}

	
	
	
//	@Override
//	public boolean onCreateOptionsMenu(Menu menu) {
//		// Inflate the menu; this adds items to the action bar if it is present.
//		getMenuInflater().inflate(R.menu.main, menu);
//		return true;
//	}
//
//	@Override
//	public boolean onOptionsItemSelected(MenuItem item) {
//		// Handle action bar item clicks here. The action bar will
//		// automatically handle clicks on the Home/Up button, so long
//		// as you specify a parent activity in AndroidManifest.xml.
//		int id = item.getItemId();
//		if (id == R.id.action_settings) {
//			return true;
//		}
//		return super.onOptionsItemSelected(item);
//	}

	@Override
	public void onClick(View v) {

		setAllTextColortoBlack();
		switch (v.getId()) {
		case R.id.tv_hot:
			mHot.setTextColor(MainActivity.this.getResources().getColor(R.color.tabhost));
			this.mViewPager.setCurrentItem(0);
			
			break;

		case R.id.tv_category:
			mCategory.setTextColor(MainActivity.this.getResources().getColor(R.color.tabhost));
			
			this.mViewPager.setCurrentItem(1);
			break;
		case R.id.tv_activities:
			mActivities.setTextColor(MainActivity.this.getResources().getColor(R.color.tabhost));
			this.mViewPager.setCurrentItem(2);
			break;
		case R.id.tv_service:
			mService.setTextColor(MainActivity.this.getResources().getColor(R.color.tabhost));
			this.mViewPager.setCurrentItem(3);
			break;

		}

	}
	/**
	 *把tabs所以的item颜色设为黑色
	 */
	private void setAllTextColortoBlack()
	{
		for(int i=0;i<tabs.getChildCount();i++)
		{
			TextView tv=(TextView) tabs.getChildAt(i);
			tv.setTextColor(getResources().getColor(R.color.bg_black));
		}
		
	}

}
