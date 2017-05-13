package com.example.trial3;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
 
public class ListViewCheckboxesActivity extends Activity {
 
 MyCustomAdapter dataAdapter = null;
	String[] salad={"Green","Russian","Fruit"};
	String[] soups={"Tomato","Cream and Onion", "Ministone","Sweet and Sour"};
	String[] main_course={"Paneer","Vegetable","Kofta","Bharta"};
	String[] rice={"Biryani","Plain","Jeera"};
	String[] dessert={"Ice Cream","Kulfi","Pastry"};
	String[] breads={"Naan","Roti","Butter Naan","Butter Roti"};
 
 @Override
 public void onCreate(Bundle savedInstanceState) {
  super.onCreate(savedInstanceState);
  setContentView(R.layout.main1);
  
	
	String[] itemsnamer = getResources().getStringArray(R.array.foodcatnames);
	Spinner s123 = (Spinner) findViewById(R.id.spinner1);
	
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
          	
          //	updte(salad);
        	  displayListView(salad);
          }
          else if(a12.equals("Starter")){
          	String[] starter=getResources().getStringArray(R.array.Starter);
          //	updte(starter);
          	 displayListView(starter);
          	
          }
          else if(a12.equals("Soups")){
          
          	//updte(soups);
        	  displayListView(soups);
          	
          }
          else if(a12.equals("Main Course")){
	            
         // 	updte(main_course);
        	  displayListView(main_course);
          }
          else if(a12.equals("Breads")){
	            
        //  	updte(breads);
        	  displayListView(breads);	
          }
          else if(a12.equals("Desserts")){
	            
          	//updte(dessert);
        	  displayListView(dessert);
          }
          else if(a12.equals("Rice")){
	            
          	//updte(rice);
        	  displayListView(rice);
          }
		}
		
	
		
		
      
      	@Override
  		public void onNothingSelected(AdapterView<?> arg0) {
  			// TODO Auto-generated method stub 
      		}});
  
	Button	button1 = (Button) findViewById(R.id.button1);
	
	button1.setOnClickListener(new View.OnClickListener(){
	@SuppressWarnings("deprecation")
	@Override
			public void onClick(View v){ 
		
		
			
			Intent intent = new Intent(v.getContext(),Game_start.class);
		
					ListViewCheckboxesActivity.this.startActivity(intent);
				
				
				}});
  
  
  
  
  
  
  
  
  
  
  
 
  //Generate list View from ArrayList
 
 
  checkButtonClick();
 
 }
 
 private void displayListView(String ress[]) {
 
  //Array list of countries
  ArrayList<Country> countryList = new ArrayList<Country>(ress.length);
  	 		for(int i=0;i<ress.length;i++){
  	 			Country country=new Country(i+"a",ress[i],false);
  		countryList.add(country);
  	 		}
  	/*
  Country country = new Country("AFG","Afghanistan",false);
  countryList.add(country);
  country = new Country("ALB","Albania",true);
  countryList.add(country);
  country = new Country("DZA","Algeria",false);
  countryList.add(country);
  country = new Country("ASM","American Samoa",true);
  countryList.add(country);
  country = new Country("AND","Andorra",true);
  countryList.add(country);
  country = new Country("AGO","Angola",false);
  countryList.add(country);
  country = new Country("AIA","Anguilla",false);
  countryList.add(country);
 */
  //create an ArrayAdaptar from the String Array
  dataAdapter = new MyCustomAdapter(this,
    R.layout.country_info, countryList);
  ListView listView = (ListView) findViewById(R.id.listView1);
  // Assign adapter to ListView
  listView.setAdapter(dataAdapter);
 
 
 /* listView.setOnItemClickListener(new OnItemClickListener() {
   public void onItemClick(AdapterView<?> parent, View view,
     int position, long id) {
    // When clicked, show a toast with the TextView text
    Country country = (Country) parent.getItemAtPosition(position);
    Toast.makeText(getApplicationContext(),
      "Clicked on Row: " + country.getName(),
      Toast.LENGTH_LONG).show();
   }
  });*/
 
 }
 
 private class MyCustomAdapter extends ArrayAdapter<Country> {
 
  private ArrayList<Country> countryList;
 
  public MyCustomAdapter(Context context, int textViewResourceId,
    ArrayList<Country> countryList) {
   super(context, textViewResourceId, countryList);
   this.countryList = new ArrayList<Country>();
   this.countryList.addAll(countryList);
  }
 
  private class ViewHolder {
   TextView code;
   CheckBox name;
  }
 
  @Override
  public View getView(int position, View convertView, ViewGroup parent) {
 
   ViewHolder holder = null;
   Log.v("ConvertView", String.valueOf(position));
 
   if (convertView == null) {
   LayoutInflater vi = (LayoutInflater)getSystemService(
     Context.LAYOUT_INFLATER_SERVICE);
   convertView = vi.inflate(R.layout.country_info, null);
 
   holder = new ViewHolder();
   holder.code = (TextView) convertView.findViewById(R.id.code);
   holder.name = (CheckBox) convertView.findViewById(R.id.checkBox1);
   convertView.setTag(holder);
 
    holder.name.setOnClickListener( new View.OnClickListener() { 
     public void onClick(View v) { 
      CheckBox cb = (CheckBox) v ; 
      Country country = (Country) cb.getTag(); 
      /*Toast.makeText(getApplicationContext(),
       "Clicked on Checkbox: " + cb.getText() +
       " is " + cb.isChecked(),
       Toast.LENGTH_LONG).show();*/
      country.setSelected(cb.isChecked());
     } 
    }); 
   }
   else {
    holder = (ViewHolder) convertView.getTag();
   }
 
   Country country = countryList.get(position);
   holder.code.setText(""/* (" +  country.getCode() + ")"*/);
   holder.name.setText(country.getName());
   holder.name.setChecked(country.isSelected());
   holder.name.setTag(country);
 
   return convertView;
 
  }
 
 }
 
 private void checkButtonClick() {
 
 
  Button myButton = (Button) findViewById(R.id.findSelected);
  myButton.setOnClickListener(new OnClickListener() {
 
   @Override
   public void onClick(View v) {
 
    StringBuffer responseText = new StringBuffer();
    responseText.append("");
 
    ArrayList<Country> countryList = dataAdapter.countryList;
    for(int i=0;i<countryList.size();i++){
     Country country = countryList.get(i);
     if(country.isSelected()){
      responseText.append("\n" + country.getName());
     }
    }
 
   Toast.makeText(getApplicationContext(),
      responseText, Toast.LENGTH_LONG).show();
    String entrydata=responseText.toString();
    DBAdapter db=new DBAdapter(getApplicationContext());
	db.open();
    
	Spinner s123 = (Spinner) findViewById(R.id.spinner1);
	
	int poss=s123.getPositionForView(s123);
	String a12=(String) (s123.getItemAtPosition(poss));
	SharedPreferences pref1=getSharedPreferences("food",MODE_WORLD_READABLE);
	String string1=pref1.getString("food1", null);
	string1=(entrydata+","+string1);
	Editor edit=pref1.edit();
	edit.putString("food1",string1);
	edit.commit();
/*    if(a12.equals("Salads")){
    	db.insertFood(entrydata, null, null, null, null, null, null);      	
    
    }
    else if(a12.equals("Starter")){
    	String[] starter=getResources().getStringArray(R.array.Starter);
     	db.insertFood(null, entrydata, null, null, null, null, null);
    	
    }
    else if(a12.equals("Soups")){
    	db.insertFood(null, null, entrydata, null, null, null, null);	
    }
    else if(a12.equals("Main Course")){
    	db.insertFood(null, null, null, entrydata, null, null, null);
    }
    else if(a12.equals("Breads")){
    	db.insertFood(null, null, null, null, entrydata, null, null);
    }
    else if(a12.equals("Desserts")){
    	db.insertFood(null, null, null, entrydata, null, entrydata, null);
    	
    }
    else if(a12.equals("Rice")){
          
    	db.insertFood(null, null, null, null, null, null, entrydata);    }
db.close();
   */
   }
  });
 
 }
 
}