package com.example.trial3;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class M5 extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_m5);
	Button	button3 = (Button) findViewById(R.id.button1);
		
		button3.setOnClickListener(new View.OnClickListener(){
		@SuppressWarnings("deprecation")
		
		
		
		
		@Override
				public void onClick(View v){
			SharedPreferences pref1=getSharedPreferences("food",MODE_WORLD_READABLE);
			String string1=pref1.getString("food1", null);
			string1=("");
			Editor edit=pref1.edit();
			edit.putString("food1",string1);
			edit.commit();
			Intent i = new Intent(M5.this,M6.class);
			startActivity(i);
			
			
		}});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.m5, menu);
		return true;
	}

}
