package com.sen.dingcanhoutai;

import cn.bmob.v3.BmobObject;


public class Category extends BmobObject {

	private String name;
	private String icon;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	
}
