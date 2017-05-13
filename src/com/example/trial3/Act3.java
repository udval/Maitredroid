package com.example.trial3;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

public class Act3 extends Activity {
	public void onBackPress(){this.finish();}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	setContentView(R.layout.activity_act3);
	Button button2 = (Button)findViewById(R.id.button1);
	final TimePicker t1;
	t1=(TimePicker) findViewById(R.id.timePicker1);
	
	SharedPreferences sh=getSharedPreferences("num_people",0);
	SharedPreferences sh1=getSharedPreferences("rest",0);
	String people=sh.getString("people", "wrong");
	String rest=sh1.getString("rest", "wrong");
	TextView tv= (TextView) findViewById(R.id.textView1);
	
	tv.setText("You have selected  "+rest+" Restaurant for " +people+ "   People");

	button2.setOnClickListener(new OnClickListener() {
@Override
public void onClick(View v){

	if(t1.getCurrentHour()<12){
		
		 SharedPreferences hour = getSharedPreferences("hour", 0);
		   SharedPreferences mins = getSharedPreferences("mins", 0);
	   SharedPreferences.Editor editor1 = hour.edit();
	   SharedPreferences.Editor editor = mins.edit();
	   editor1.putString("hour", t1.getCurrentHour()+" :");
	editor.putString("mins",	t1.getCurrentMinute()+"AM");
	   // Commit the edits!
	   editor1.commit();
	   editor.commit();
	} else{
		 SharedPreferences hour = getSharedPreferences("hour", 0);
		   SharedPreferences mins = getSharedPreferences("mins", 0);
	 SharedPreferences.Editor editor1 = hour.edit();
	 SharedPreferences.Editor editor = mins.edit();
	 editor1.putString("hour", (t1.getCurrentHour()-12)+": ");
	editor.putString("mins",	t1.getCurrentMinute()+"PM");
	 // Commit the edits!
	 editor1.commit();
	 editor.commit();
		
	}
	
	
	
	
	
	//Toast.makeText(getApplicationContext(),"you have selected time"+ t1.getCurrentHour()+ "hours"+t1.getCurrentMinute()+"minutes", Toast.LENGTH_SHORT).show();
	Intent intent = new Intent(v.getContext(),M4.class);
	startActivityForResult(intent,1);}   

	} );
	
	
	
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.act3, menu);
		return true;
	}

}
