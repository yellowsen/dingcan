package com.sen.dingcanhoutai;

import java.io.File;
import java.io.IOException;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import cn.bmob.v3.datatype.BmobFile;
import cn.bmob.v3.listener.SaveListener;
import cn.bmob.v3.listener.UploadFileListener;

public class AddCategoryActivity extends Activity implements OnClickListener {

	private static final int IMAGE_CODE = 0;
	private final String IMAGE_TYPE = "image/*";
	private EditText mCategoryName;
	private Button mCategoryIcon;
	private Button mSubmit;
	private TextView mCategoryIconPath;
	private String path="";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_category);

		mCategoryName = (EditText) findViewById(R.id.et_category_name);
		mCategoryIcon = (Button) findViewById(R.id.btn_add_category_icon);
		
		mCategoryIconPath = (TextView) findViewById(R.id.tv_category_icon_path);
		mCategoryIcon.setOnClickListener(this);
		mSubmit = (Button) findViewById(R.id.btn_submit);

		mSubmit.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {

		switch (v.getId()) {
		case R.id.btn_submit:
			
			if(path.length()<=0)
			{
				Toast.makeText(this, "请先选择分类图标", 1).show();
				return;
			}
			
			final BmobFile bmobFile=new BmobFile(new File(path));
			
			bmobFile.uploadblock(this, new UploadFileListener() {
				
				@Override
				public void onSuccess() {
					Toast.makeText(AddCategoryActivity.this, bmobFile.getFileUrl(), 1).show();
				}
				
				@Override
				public void onFailure(int arg0, String arg1) {
					
				}
			});
			
			
			
			String categoryName = mCategoryName.getText().toString();
			Category category = new Category();
			category.setName(categoryName);
			category.setIcon("sd/aaa.jpg");

			category.save(this, new SaveListener() {

				@Override
				public void onSuccess() {
					System.out.println("上传成功");
				}

				@Override
				public void onFailure(int arg0, String arg1) {
					System.out.println("上传失败" + arg0);
				}
			});
			break;

		case R.id.btn_add_category_icon:

			Intent getAlbum = new Intent(Intent.ACTION_GET_CONTENT);
			getAlbum.setType(IMAGE_TYPE);
			startActivityForResult(getAlbum, IMAGE_CODE);

			break;

		}
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (resultCode != RESULT_OK) { // 此处的 RESULT_OK 是系统自定义得一个常量
			// Log.e(TAG,"ActivityResult resultCode error");
			return;
		}
		Bitmap bm = null;
		ContentResolver resolver = getContentResolver();
		if (requestCode == IMAGE_CODE) {
			Uri originalUri = data.getData();
			
			String string = originalUri.toString();
			
			
			int index = string.indexOf("sdcard");
			
			path = string.substring(index);
		}

	}
}
