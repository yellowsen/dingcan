package com.sen.dingcan.view;

import com.sen.dingcan.R;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class OptionView extends RelativeLayout {

	private ImageView mIcon;
	private TextView mTitle;


	public OptionView(Context context) {
		super(context);
		initView(context);
	}

	
	public OptionView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		initView(context);
	}


	public OptionView(Context context, AttributeSet attrs) {
		super(context, attrs);

		initView(context);
		
		getAttrs(context, attrs);
		
	}


	private void initView(Context context)
	{
		View.inflate(context, R.layout.view_option, this);
		
		mIcon = (ImageView) findViewById(R.id.iv_option_icon);
		
		mTitle = (TextView) findViewById(R.id.tv_option_tile);
	}
	

	private void getAttrs(Context context, AttributeSet attrs) {
		TypedArray array= context.obtainStyledAttributes(attrs,R.styleable.OptionView);
	
		String title = array.getString(R.styleable.OptionView_title);
		Drawable drawable = array.getDrawable(R.styleable.OptionView_icon);
		
		mIcon.setImageDrawable(drawable);
		mTitle.setText(title);
	}
	


}
