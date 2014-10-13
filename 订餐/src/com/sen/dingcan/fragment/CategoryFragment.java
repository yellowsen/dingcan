package com.sen.dingcan.fragment;

import java.util.ArrayList;
import java.util.HashMap;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.SimpleAdapter;

import com.sen.dingcan.CategoryItemListActivity;
import com.sen.dingcan.R;


public class CategoryFragment extends Fragment {
	private static final String TAG = "CategoryFragment";
	private View rootView;
	private GridView gridView;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		rootView = inflater.inflate(R.layout.fragment_category, null);

		return rootView;
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);

		gridView = (GridView) rootView.findViewById(R.id.gv_foods);
		
		setData();

		setListener();
	}

	private void setListener() {

		
		gridView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				Intent intent=new Intent(CategoryFragment.this.getActivity(),CategoryItemListActivity.class);
				startActivity(intent);
			}
		});
	}

	private void setData() {
		// 生成动态数组，并且转入数据
		ArrayList<HashMap<String, Object>> lstImageItem = new ArrayList<HashMap<String, Object>>();
		for (int i = 0; i < 10; i++) {
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("ItemImage", R.drawable.ic_launcher);// 添加图像资源的ID
			map.put("ItemText", "NO." + String.valueOf(i));// 按序号做ItemText
			lstImageItem.add(map);
		}
		// 生成适配器的ImageItem <====> 动态数组的元素，两者一一对应
		SimpleAdapter saImageItems = new SimpleAdapter(getActivity(), // 没什么解释
				lstImageItem,// 数据来源
				R.layout.classification,// night_item的XML实现

				// 动态数组与ImageItem对应的子项
				new String[] { "ItemImage", "ItemText" },

				// ImageItem的XML文件里面的一个ImageView,两个TextView ID
				new int[] { R.id.iv_food_icon, R.id.tv_food_name });
		// 添加并且显示
		gridView.setAdapter(saImageItems);
	}
}
