package com.example.trial3;

import android.os.Bundle;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class Main1Activity extends Activity {

	
	protected void onActivityResult(int requestCode, int resultCode, Intent data){
		if(resultCode==0){finish();}
	}



	
protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);			
		setContentView(R.layout.activity_main1);
	
		final EditText		EditText1=(EditText) findViewById(R.id.editText1);
		final EditText		EditText2=(EditText) findViewById(R.id.editText2);
		
		final DBAdapter db1 = new DBAdapter(this); 
		  
		
		db1.open();
		try {
			Cursor c1=db1.getAllContacts();
			
     
		 if(!(c1.moveToFirst()))
		 { 
	Button	button1 = (Button) findViewById(R.id.button1);
	
	button1.setOnClickListener(new OnClickListener(){
	@Override
			public void onClick(View v){ 
	
		
		
		
		
		
		if ((EditText1.getText().toString().length() <= 0)|(EditText2.getText().toString().length() <= 10)) {
			EditText1.setError("Enter name");
			EditText2.setError("Enter 10 digits");
			Toast.makeText(getApplicationContext(),"Field cannot be blank", Toast.LENGTH_SHORT).show();
			
		} else if ((!EditText1.getText().toString().matches("[a-zA-Z ]+"))|(!EditText2.getText().toString().matches("[0-9 ]+"))) {
			EditText1.setError("Only Alphabet");
			EditText2.setError("Numbers only");
			Toast.makeText(getApplicationContext()," Name only Alphabet and Number 11digits with 0", Toast.LENGTH_SHORT).show();
			
		} else {
			db1.open();
			String q=EditText1.getText().toString();
			String p=EditText2.getText().toString();
			db1.insertContact(q,p);
			db1.close();

			Intent intent = new Intent(v.getContext(),MainActivity.class);
		
					Main1Activity.this.startActivity(intent);
		}
		
			
				
				
				}});
	

	
  }
		 else{ Intent i2 = new Intent(this,MainActivity.class);
			startActivityForResult(i2,0);}
		 
		 
		 
		}
		
	finally {

		
	}
		
		
		}
	}
 

	
























	


