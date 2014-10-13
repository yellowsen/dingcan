package com.sen.dingcan.fragment;

import java.util.ArrayList;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;

import com.sen.dingcan.R;
import com.sen.dingcan.adapter.ActivitiesListItemAdapter;

public class ActivitiesFragment extends Fragment {

	private ListView rootView;

	private int[] imgIds = { R.drawable.fish, R.drawable.fish, R.drawable.fish,
			R.drawable.fish };

	private ArrayList<ImageView> imgs;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		rootView = (ListView) inflater.inflate(R.layout.framgent_activities,
				null);

		return rootView;
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);

		initVeiw();

		setData();
	}

	private void setData() {

		ActivitiesListItemAdapter adapter=new ActivitiesListItemAdapter(getActivity(), imgIds);
		
		rootView.setAdapter(adapter);
		
	}

	private void initVeiw() {

	}
}
