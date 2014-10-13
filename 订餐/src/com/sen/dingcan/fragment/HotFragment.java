package com.sen.dingcan.fragment;

import java.util.ArrayList;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import com.sen.dingcan.FoodDescActivity;
import com.sen.dingcan.LoginActivity;
import com.sen.dingcan.R;
import com.sen.dingcan.adapter.ScrollImgPagerAdapter;
import com.sen.dingcan.adapter.ScrollImgPagerAdapter.OnItemClickListener;


public class HotFragment extends Fragment implements OnItemClickListener {

	private ScrollView rootView;
	private ViewPager mScrollImg;

	private int[] imgIds = { R.drawable.fish, R.drawable.fish, R.drawable.fish,
			R.drawable.fish };
	private LinearLayout pointGroup;
	private ArrayList<ImageView> imageList;
	protected int lastPosition;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		rootView = (ScrollView) inflater.inflate(R.layout.fragment_hot, null);

		return rootView;
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);

		initView();

		setData();

		setListener();
	}

	private void setListener() {

	}

	private void initView() {
		// 滑动图片
		mScrollImg = (ViewPager) rootView.findViewById(R.id.vp_scroll_img);

		pointGroup = (LinearLayout) rootView.findViewById(R.id.point_group);

		gridView = (GridView) rootView.findViewById(R.id.gv_foods);
	}

	private void setData() {

		imageList = new ArrayList<ImageView>();
		for (int i = 0; i < imgIds.length; i++) {
			ImageView img = new ImageView(getActivity());

			img.setBackgroundResource(imgIds[i]);
			imageList.add(img);

			// 添加指示点
			ImageView point = new ImageView(getActivity());
			LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
					LinearLayout.LayoutParams.WRAP_CONTENT,
					LinearLayout.LayoutParams.WRAP_CONTENT);

			params.rightMargin = 20;
			point.setLayoutParams(params);

			point.setBackgroundResource(R.drawable.point_bg);
			if (i == 0) {
				point.setEnabled(true);
			} else {
				point.setEnabled(false);
			}
			pointGroup.addView(point);

		}

		ScrollImgPagerAdapter adapter = new ScrollImgPagerAdapter(this,
				imageList);

		mScrollImg.setAdapter(adapter);

		mScrollImg.setOnPageChangeListener(new OnPageChangeListener() {

			@Override
			public void onPageSelected(int position) {
				position = position % imageList.size();
				// 设置文字描述内容

				// 改变指示点的状态
				// 把当前点enbale 为true
				pointGroup.getChildAt(position).setEnabled(true);
				// 把上一个点设为false
				pointGroup.getChildAt(lastPosition).setEnabled(false);
				lastPosition = position;

				// if(lastPosition==imageList.size()-1)
				// {
				// lastPosition=0;
				// }
			}

			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {

			}

			@Override
			public void onPageScrollStateChanged(int arg0) {

			}
		});

		// isRunning = true;
		// handler.sendEmptyMessageDelayed(0, 5000);

	}

	/**
	 * 判断是否自动滚动
	 */
	private boolean isRunning = false;

	private Handler handler = new Handler() {
		public void handleMessage(android.os.Message msg) {

			// 让viewPager 滑动到下一页
			int postion = mScrollImg.getCurrentItem() + 1;
			if (postion > imageList.size() - 1) {
				postion = 0;
			}
			mScrollImg.setCurrentItem(postion);
			if (isRunning) {
				handler.sendEmptyMessageDelayed(0, 5000);
			}
		};
	};
	private GridView gridView;

	public void onDestroy() {

		isRunning = false;
	};

	@Override
	public void onPause() {
		super.onPause();
		isRunning = false;
	}

	@Override
	public void onStart() {
		super.onStart();
		isRunning = true;
		handler.sendEmptyMessageDelayed(0, 5000);
	}

	@Override
	public void onPagerItemClick(View view, int postion) {

		Intent intent = new Intent(getActivity(), LoginActivity.class);

		startActivity(intent);
	}

}
