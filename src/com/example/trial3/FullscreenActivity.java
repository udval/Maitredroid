package com.example.trial3;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;


public class FullscreenActivity extends Activity {
	
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.activity_fullscreen);
	
	

	Button button1 = (Button)findViewById(R.id.button1);
	button1.setOnClickListener(new OnClickListener() {
@Override
public void onClick(View v1){
	Intent intent = new Intent(v1.getContext(),Act3.class);
	startActivityForResult(intent,0);}   

	} );
	
	Button button2 = (Button)findViewById(R.id.button2);
	button2.setOnClickListener(new OnClickListener() {
@Override
public void onClick(View v2){
	Intent intent = new Intent(v2.getContext(),M4.class);
	startActivityForResult(intent,0);}   

	} );
	
	Button button3 = (Button)findViewById(R.id.button3);
	button3.setOnClickListener(new OnClickListener() {
@Override
public void onClick(View v3){
	Intent intent = new Intent(v3.getContext(),M5.class);
	startActivityForResult(intent,0);}   

	} );
	
	Button button4 = (Button)findViewById(R.id.button4);
	button4.setOnClickListener(new OnClickListener() {
@Override
public void onClick(View v4){
	Intent intent = new Intent(v4.getContext(),M6.class);
	startActivityForResult(intent,0);}   

	} );
	

  } }