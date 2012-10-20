package com.example.yahoohackday;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MapViewActivity extends Activity {
	private Button button;
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
	}
	
	public void findViews() {
		button = (Button) findViewById(R.id.button1);
		
		button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent intent = new Intent();
				intent.putExtra("location_name", "南港展覽館1");
				intent.setClass(MapViewActivity.this, NewsListActivity.class);
	            startActivity(intent);
			}
		});
	}
}
