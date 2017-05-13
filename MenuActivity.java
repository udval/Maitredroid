package com.example.trial3;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Checkable;
import android.widget.ExpandableListView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;
import android.support.v4.app.NavUtils;
import android.annotation.TargetApi;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;

public class MenuActivity extends Activity implements Checkable {

	String[] salad={"Onion","Tomato","Cabbage"};
	String temp[]=null;
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
	            	temp=salad;
	            }
	            else if(a12.equals("Starter")){
	            	String[] starter=getResources().getStringArray(R.array.Starter);
	            	updte(starter);
	            	temp=starter;
	            	
	            }
			
			}
			
			
			
	        
	        	@Override
	    		public void onNothingSelected(AdapterView<?> arg0) {
	    			// TODO Auto-generated method stub 
	        		}});
//ArrayAdapter<String> ap1=new ArrayAdapter<String>(this, R.layout.row_layout, R.id.textView1,salad);
//ls.setAdapter(ap1);
		
		
			//-- Start of extra code
		
		ListView ls=(ListView) findViewById(R.id.listView1);					
		ArrayAdapter<String> ap1=new ArrayAdapter<String>(getApplicationContext(), R.layout.row_layout, R.id.checkBox1,temp);
		
		ls.setAdapter(myArrayAdapter);
	        myListView.setOnItemClickListener(myOnItemClickListener);
	        
	        getResult = (Button)findViewById(R.id.button2);
	        getResult.setOnClickListener(new OnClickListener(){

	   @Override
	   public void onClick(View v) {
	    String result = "";
	    
	    /*
	    //getCheckedItemPositions
	    List<Integer> resultList = myArrayAdapter.getCheckedItemPositions();
	    for(int i = 0; i < resultList.size(); i++){
	     result += String.valueOf(resultList.get(i)) + " ";
	    }
	    */
	    
	    //getCheckedItems
	    List<String> resultList = myArrayAdapter.getCheckedItems();
	    for(int i = 0; i < resultList.size(); i++){
	     result += String.valueOf(resultList.get(i)) + "\n";
	    }
	    
	    myArrayAdapter.getCheckedItemPositions().toString();
	    Toast.makeText(
	      getApplicationContext(), 
	      result, 
	      Toast.LENGTH_LONG).show();
	   }});
	        
	    }
	    
	    OnItemClickListener myOnItemClickListener
	    = new OnItemClickListener(){

	  @Override
	  public void onItemClick(AdapterView<?> parent, View view, int position,
	    long id) {
	   myArrayAdapter.toggleChecked(position);
	   
	  }};
	    
	    private class MyArrayAdapter extends ArrayAdapter<String>{
	     
	     private HashMap<Integer, Boolean> myChecked = new HashMap<Integer, Boolean>();

	  public MyArrayAdapter(Context context, int resource,
	    int textViewResourceId, List<String> objects) {
	   super(context, resource, textViewResourceId, objects);
	   
	   for(int i = 0; i < objects.size(); i++){
	    myChecked.put(i, false);
	   }
	  }
	     
	  public void toggleChecked(int position){
	   if(myChecked.get(position)){
	    myChecked.put(position, false);
	   }else{
	    myChecked.put(position, true);
	   }
	   
	   notifyDataSetChanged();
	  }
	  
	  public List<Integer> getCheckedItemPositions(){
	   List<Integer> checkedItemPositions = new ArrayList<Integer>();
	   
	   for(int i = 0; i < myChecked.size(); i++){
	    if (myChecked.get(i)){
	     (checkedItemPositions).add(i);
	    }
	   }
	   
	   return checkedItemPositions;
	  }
	  
	  public List<String> getCheckedItems(){
	   List<String> checkedItems = new ArrayList<String>();
	   
	   for(int i = 0; i < myChecked.size(); i++){
	    if (myChecked.get(i)){
	     (checkedItems).add(dayOfWeekList.get(i));
	    }
	   }
	   
	   return checkedItems;
	  }

	  @Override
	  public View getView(int position, View convertView, ViewGroup parent) {
	   View row = convertView;
	   
	   if(row==null){
	    LayoutInflater inflater=getLayoutInflater();
	    row=inflater.inflate(R.layout.row, parent, false);  
	   }
	   
	   CheckedTextView checkedTextView = (CheckedTextView)row.findViewById(R.id.text1);
	   checkedTextView.setText(dayOfWeekList.get(position));
	   
	   Boolean checked = myChecked.get(position);
	   if (checked != null) {
	    checkedTextView.setChecked(checked);
	            }
	   
	   return row;
	  }
	  
	    }
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		//--- End of extra code extra
		
		
		
		
		
		
		
		Button	button1 = (Button) findViewById(R.id.button1);
		
		button1.setOnClickListener(new View.OnClickListener(){
		@SuppressWarnings("deprecation")
		@Override
				public void onClick(View v){ 
			
			
				
				Intent intent = new Intent(v.getContext(),Game_start.class);
			
						MenuActivity.this.startActivity(intent);
					
					
					}});
		}
	
	void updte(String[] ress){
		
    	//Spinner s124= (Spinner) findViewById(R.id.spinner21);
    	//ArrayAdapter<Object> adap2= new ArrayAdapter<Object>(getParent(), android.R.layout.simple_spinner_dropdown_item, salad);
		
    	//ArrayAdapter<?> adapt2 = new ArrayAdapter<Object>(this,
    	//		android.R.layout.simple_spinner_dropdown_item ,ress);
    	//s124.setAdapter(adapt2);
		ListView ls=(ListView) findViewById(R.id.listView1);					
	ArrayAdapter<String> ap1=new ArrayAdapter<String>(getApplicationContext(), R.layout.row_layout, R.id.checkBox1,ress);
    	ls.setAdapter(ap1);
	}

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
