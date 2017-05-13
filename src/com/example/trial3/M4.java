package com.example.trial3;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class M4 extends Activity {
	public void onBackPressed(){
		this.finish();
		}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_m4);
		setResult(0);
		SharedPreferences sh=getSharedPreferences("num_people",0);
		SharedPreferences sh1=getSharedPreferences("rest",0);
		SharedPreferences sh2=getSharedPreferences("hour",0);
		SharedPreferences sh3=getSharedPreferences("mins",0);
		String people=sh.getString("people", "wrong");
		String rest=sh1.getString("rest", "wrong");
		String hour=sh2.getString("hour", "wrong");
		String mins=sh3.getString("mins", "wrong");
		TextView tv= (TextView) findViewById(R.id.textView1);
		
		tv.setText("You have selected  "+rest+" Restaurant for " +people+ "   People"+
				" at " +hour+ " "+mins
				
				
				);
		 
		Button	button1 = (Button) findViewById(R.id.button1);
		
		button1.setOnClickListener(new OnClickListener(){
		@Override
				public void onClick(View v){ 
			
			
				
				Intent intent = new Intent(M4.this,ListViewCheckboxesActivity.class);
			
						M4.this.startActivity(intent);
					
					
					}});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.m4, menu);
		return true;
	}

}
