package com.example.trial3;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.ListActivity;
import android.util.SparseBooleanArray;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Checkable;
import android.widget.ExpandableListView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.support.v4.app.NavUtils;
import android.annotation.TargetApi;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build;

public class MenuActivity extends ListActivity implements Checkable {

	String[] salad={"Green","Russian","Fruit"};
	String[] soups={"Tomato","Cream and Onion", "Ministone","Sweet and Sour"};
	String[] main_course={"Paneer","Vegetable","Kofta","Bharta"};
	String[] rice={"Biryani","Plain","Jeera"};
	String[] dessert={"Ice Cream","Kulfi","Pastry"};
	String[] breads={"Naan","Roti","Butter Naan","Butter Roti"};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.menu);
		// Show the Up button in the action bar.
		//setupActionBar();
		DBAdapter db=new DBAdapter(this);
		db.open();
		
		String[] itemsnamer = getResources().getStringArray(R.array.foodcatnames);
		Spinner s123 = (Spinner) findViewById(R.id.spinner21);
		
		ArrayAdapter<?> adapter1 = new ArrayAdapter<Object>(this,
		android.R.layout.simple_spinner_dropdown_item ,itemsnamer); 
		s123.setAdapter(adapter1);
		
	
	
		s123.setOnItemSelectedListener(new OnItemSelectedListener(){
	 
		
			@Override
			public void onItemSelected(AdapterView<?> pview, View vview, int poss,
					long longish) {
				Toast toast = Toast.makeText(pview.getContext(),"You've chosen " + pview.getItemAtPosition(poss), Toast.LENGTH_LONG);
	            toast.show();
	           String a12=(String) pview.getItemAtPosition(poss);
	            if(a12.equals("Salads")){
	            	
	            	updte(salad);
	            }
	            else if(a12.equals("Starter")){
	            	String[] starter=getResources().getStringArray(R.array.Starter);
	            	updte(starter);
	            	
	            }
	            else if(a12.equals("Soups")){
	            
	            	updte(soups);
	            	
	            }
	            else if(a12.equals("Main Course")){
		            
	            	updte(main_course);
	            	
	            }
	            else if(a12.equals("Breads")){
		            
	            	updte(breads);
	            	
	            }
	            else if(a12.equals("Desserts")){
		            
	            	updte(dessert);
	            	
	            }
	            else if(a12.equals("Rice")){
		            
	            	updte(rice);
	            	
	            }
			}
			
		
			
			
	        
	        	@Override
	    		public void onNothingSelected(AdapterView<?> arg0) {
	    			// TODO Auto-generated method stub 
	        		}});
//ArrayAdapter<String> ap1=new ArrayAdapter<String>(this, R.layout.row_layout, R.id.textView1,salad);
//ls.setAdapter(ap1);
		
		
		Button	button1 = (Button) findViewById(R.id.button1);
		
		button1.setOnClickListener(new View.OnClickListener(){
		@SuppressWarnings("deprecation")
		@Override
				public void onClick(View v){ 
			
			
				
				Intent intent = new Intent(v.getContext(),Game_start.class);
			
						MenuActivity.this.startActivity(intent);
					
					
					}});
		Button b2=(Button) findViewById(R.id.button2);		
	b2.setOnClickListener(new View.OnClickListener(){

		@SuppressWarnings("unchecked")
		@Override
		public void onClick(View v) {
			
			/*ListView ls1=(ListView) findViewById(R.id.listView1);
			
			ArrayAdapter<String> r;
			r=(ArrayAdapter<String>) ls1.getAdapter();
			*/
			
			
	//	Toast.makeText(getParent(),r.getCount(),Toast.LENGTH_SHORT).show();
			
			
			// TODO Auto-generated method stub
			
		}
		
		
		
		
		
		
	});
	
	
	
	
	
	
	
	}

	
	
	void updte(String[] ress){
		
    	//Spinner s124= (Spinner) findViewById(R.id.spinner21);
    	//ArrayAdapter<Object> adap2= new ArrayAdapter<Object>(getParent(), android.R.layout.simple_spinner_dropdown_item, salad);
		
    	//ArrayAdapter<?> adapt2 = new ArrayAdapter<Object>(this,
    	//		android.R.layout.simple_spinner_dropdown_item ,ress);
    	//s124.setAdapter(adapt2);
		////ListView ls=(ListView) findViewById(R.id.listView1);					
	   // //ArrayAdapter<String> ap1=new ArrayAdapter<String>(getApplicationContext(), R.layout.row_layout,R.id.checkBox1,ress);
		//ArrayAdapter<String> ap1=new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_checked,ress);
		//ls.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);        
	    //ls.setTextFilterEnabled(true);
		
    	
		//ls.setAdapter(ap1);
       
    	
    	 
    	
	}
	/*int texti(){
		ListView ls1=(ListView) findViewById(R.id.listView1);
		int i=ls1.getCount();
		return i;
		
	}*/

	@Override
	public boolean isChecked() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setChecked(boolean arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void toggle() {
		// TODO Auto-generated method stub
		
	}
	
	 





}
/*	*//**
	 * Set up the {@link android.app.ActionBar}, if the API is available.
	 *//*
	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	private void setupActionBar() {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
			getActionBar().setDisplayHomeAsUpEnabled(true);
		}
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			// This ID represents the Home or Up button. In the case of this
			// activity, the Up button is shown. Use NavUtils to allow users
			// to navigate up one level in the application structure. For
			// more details, see the Navigation pattern on Android Design:
			//
			// http://developer.android.com/design/patterns/navigation.html#up-vs-back
			//
			NavUtils.navigateUpFromSameTask(this);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

}*/
