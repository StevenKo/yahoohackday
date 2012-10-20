package com.example.yahoohackday;

import com.example.sqlite.SQLite;
import android.os.Bundle;
import android.app.TabActivity;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.TabHost.OnTabChangeListener;

public class MainActivity extends TabActivity implements OnTabChangeListener{

	private TabHost tabHost;
	private TabHost.TabSpec spec;
	private TextView topbar_text;
	private LinearLayout topbarLayout;
	private SQLite sqlite;
	public static String TAG = "MovieTabActivities";
	
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        sqlite = new SQLite(this);
        
        topbarLayout = (LinearLayout) findViewById(R.id.topbar);        
        topbar_text = (TextView)findViewById(R.id.topbar_text);
        topbar_text.setText("AllYaNu");
        
        tabHost = getTabHost();  // The activity TabHost
        tabHost.setup();
        tabHost.setCurrentTab(0);
        
        tab1();
        tab2();
        tab3();
        tab4();
        tab5();
        
        tabHost.setOnTabChangedListener(this);
    }
    
    @Override
    public void onResume(){
		super.onResume();
	}
    
    @Override
    protected void onDestroy(){
    	super.onDestroy();
    }
    
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    	super.onActivityResult(requestCode, resultCode, data);
    }
     
    @Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if(keyCode == KeyEvent.KEYCODE_BACK
				&& event.getAction() == KeyEvent.ACTION_DOWN){
			
			return true;
	    } else
	    	return super.onKeyDown(keyCode, event);
	}
    
    private void tab1() {
    	View ActivitysTab = LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
    	//ImageView image = (ImageView) ActivitysTab.findViewById(R.id.imageview_tabicon);
		//image.setImageResource(R.drawable.calendar_blank);
		TextView ActivitysTabLabel = (TextView) ActivitysTab.findViewById(R.id.textview_tabicon);
		ActivitysTabLabel.setText("電影打卡");
		
		// Create an Intent to launch an Activity for the tab (to be reused)
		// Initialize a TabSpec for each tab and add it to the TabHost
        Intent intentList = new Intent().setClass(this, MapViewActivity.class);
        spec = tabHost.newTabSpec("tab1")
        				.setIndicator(ActivitysTab)
        				.setContent(intentList);
        tabHost.addTab(spec);
    }
    
    private void tab2() {
    	View MyListTab = LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
    	//ImageView image = (ImageView) MyListTab.findViewById(R.id.imageview_tabicon);
        //image.setImageResource(R.drawable.notebook);
        TextView MyListTabLabel = (TextView) MyListTab.findViewById(R.id.textview_tabicon);
        MyListTabLabel.setText("電影櫃");
        
        Intent intentMyList = new Intent().setClass(this, MapViewActivity.class);
        spec = tabHost.newTabSpec("tab2")
        				.setIndicator(MyListTab)
        				.setContent(intentMyList);
        tabHost.addTab(spec);
    }
    
    private void tab3() {
    	View CreateTab = LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
    	//ImageView image = (ImageView) CreateTab.findViewById(R.id.imageview_tabicon);
        //image.setImageResource(R.drawable.users);
        TextView CreateTabLabel = (TextView) CreateTab.findViewById(R.id.textview_tabicon);
        CreateTabLabel.setText("朋友動態");
        
        Intent intentCreate = new Intent().setClass(this, MapViewActivity.class);
        spec = tabHost.newTabSpec("tab3")
                		.setIndicator(CreateTab)
                		.setContent(intentCreate);
        tabHost.addTab(spec);
    }

    private void tab4() {
    	View ActivitysTab = LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
    	//ImageView image = (ImageView) ActivitysTab.findViewById(R.id.imageview_tabicon);
		//image.setImageResource(R.drawable.search_dark);
		TextView ActivitysTabLabel = (TextView) ActivitysTab.findViewById(R.id.textview_tabicon);
		ActivitysTabLabel.setText("電影搜尋");
    	        
        Intent intentList = new Intent().setClass(this, MapViewActivity.class);
		intentList.putExtra("check", false);
        spec = tabHost.newTabSpec("tab4")
        				.setIndicator(ActivitysTab)
        				.setContent(intentList);
        tabHost.addTab(spec);
    }
    
    private void tab5(){
    	View ActivitysTab = LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
    	//ImageView image = (ImageView) ActivitysTab.findViewById(R.id.imageview_tabicon);
		//image.setImageResource(R.drawable.info);
		TextView ActivitysTabLabel = (TextView) ActivitysTab.findViewById(R.id.textview_tabicon);
		ActivitysTabLabel.setText("電影報");
    	        
		Intent intentList = new Intent().setClass(this, MapViewActivity.class);
        spec = tabHost.newTabSpec("tab5")
        				.setIndicator(ActivitysTab)
        				.setContent(intentList);
        tabHost.addTab(spec);
    }
    
    public void onTabChanged(String tabId) {
		if(tabId == "tab1") {
			topbar_text.setText("電影打卡");
			topbarLayout.setVisibility(View.VISIBLE);
		} else if (tabId == "tab2") {
			topbar_text.setText("電影櫃");
			topbarLayout.setVisibility(View.VISIBLE);
		} else if (tabId == "tab3") { 
			topbar_text.setText("朋友動態");
			topbarLayout.setVisibility(View.VISIBLE);
		} else if (tabId == "tab4") {
			topbar_text.setText("電影搜尋");
			topbarLayout.setVisibility(View.VISIBLE);
		} else if(tabId == "tab5") {
			topbar_text.setText("電影報");
			topbarLayout.setVisibility(View.VISIBLE);
		}
		
	}
}
