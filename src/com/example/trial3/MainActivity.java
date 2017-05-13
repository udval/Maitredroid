package com.example.trial3;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	static String Method_name_city="feedcity";
	static String Menthod_name_restaurants="Restaurants";
	static String URL="http://10.0.2.2:7509/WebSite1/Service.asmx";
	static String NameSpace="http://tempuri.org/";
	static String SOAP_Action_city="http://tempuri.org/feedcity";
	static String SOAP_Action_Restaurant="http://tempuri.org/Restaurants";
	public static String num_people="num_people";
	
	
	public void onBackPress(){

		   SharedPreferences rest = getSharedPreferences("rest", 0);
		   SharedPreferences numpeople = getSharedPreferences(num_people, 0);
         SharedPreferences.Editor editor1 = numpeople.edit();
         SharedPreferences.Editor editor = rest.edit();
         editor1.putString("rest", "");
editor.putString(num_people,	 "");
         // Commit the edits!
         editor1.commit();
         editor.commit();
		
		
		
	this.finish();
	}


	
	@Override
	public void onCreate(Bundle savedInstanceState) {

		
		super.onCreate(savedInstanceState);
	setContentView(R.layout.activity_main);
 

	final DBAdapter db = new DBAdapter(this);
	db.open();
	

	
/*	Cursor c123 = db.getAllContacts();
	//Toast.makeText(getBaseContext(),c123.getCount() , Toast.LENGTH_LONG);
	
	
   if (c123==null)  {db.close();
   	 Intent i123 = new Intent(this,Main1Activity.class);
   	 startActivity(i123);
   } else{
	   */
  
String array_spinner[];
String array_spinner1[];


Cursor c12 = db.getContact(1);
	
	TextView txt_username = 
           (TextView) findViewById(R.id.textView6);  
	
          if(c12.moveToFirst()){
    	  txt_username.setText("Welcome "+c12.getString(1));}
     else{
         Toast.makeText(this, "No contact found", Toast.LENGTH_LONG).show();}
          
    array_spinner=new String[5];
	array_spinner[0]="1-2";
	array_spinner[1]="3-4";
	array_spinner[2]="5-8";
	array_spinner[3]="8-12";
	array_spinner[4]="More than 12";
	Spinner s = (Spinner) findViewById(R.id.spinner1);
	ArrayAdapter<?> adapter1 = new ArrayAdapter<Object>(this,
	android.R.layout.simple_spinner_dropdown_item ,array_spinner); 
	s.setAdapter(adapter1);
	s.setOnItemSelectedListener(new OnItemSelectedListener(){
 
	
		@Override
		public void onItemSelected(AdapterView<?> pview, View vview, int poss,
				long longish) {
			Toast toast = Toast.makeText(pview.getContext(),"You've chosen " + pview.getItemAtPosition(poss), Toast.LENGTH_LONG);
            toast.show();
            String a12=(String) pview.getItemAtPosition(poss);
            SharedPreferences numpeople = getSharedPreferences(num_people, 0);
            SharedPreferences.Editor editor1 = numpeople.edit();
            editor1.putString("people", a12);

            // Commit the edits!
            editor1.commit();

        
			
		}

		@Override
		public void onNothingSelected(AdapterView<?> arg0) {
			// TODO Auto-generated method stub
			
		}
		
	});
	
final AutoCompleteTextView autotext = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView1);

String[] itemsnamej = getResources().getStringArray(R.array.itemnames);

ArrayAdapter<String> adap2 = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,itemsnamej);
autotext.setAdapter(adap2);
String[] a1 = null;

new Soapclass1().execute(a1);
/*
autotext.setOnItemSelectedListener(new OnItemSelectedListener(){
	


	@Override
	public void onItemSelected(AdapterView<?> parentView, View arg1, int position,
			long arg3) {
		String[] respauto={parentView.getItemAtPosition(position).toString()};
		TextView tvt=(TextView) findViewById(R.id.textView2);
		Toast toast = Toast.makeText(parentView.getContext(),"You've chosen " + parentView.getItemAtPosition(position), Toast.LENGTH_LONG);
        toast.show();
		tvt.setText(parentView.getItemAtPosition(position).toString());
		
		
		
		
	// TODO Auto-generated method stub
		
	}

	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub
		
	}});
*/




Cursor arr1 = db.getAllCities();
if(arr1.getCount()<5)	{
int k=5;
array_spinner1=new String[k];

	array_spinner1[0]="Marriot";
	array_spinner1[1]="Dominoes,SG Highway";
	array_spinner1[2]="Saffron";
	array_spinner1[3]="Barbeque Nation";
	array_spinner1[4]="Dominoes, Vastrapur";
	for(int i = 0;i<5;i++){
		db.insertCity(array_spinner1[i]);
		}
	} 

int counting = arr1.getCount();           


//String[] itemsnameh = getResources().getStringArray(R.array.itemnames2);


 
String[] itemsnameh = new String[counting];
for(int w=1;w<=counting;w++){

Cursor arr2=db.getCity(w);
itemsnameh[w-1]=arr2.getString(1);

}
ArrayAdapter<String> adap3 = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,itemsnameh);
final AutoCompleteTextView autotext1 = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView2);
autotext1.setAdapter(adap3); 
	//Spinner s2 = (Spinner) findViewById(R.id.spinner2);
		//	ArrayAdapter<?> adap4 = new ArrayAdapter<Object>(this,android.R.layout.simple_spinner_dropdown_item ,array_spinner1);
	//s2.setAdapter(adap3);
	db.close();
	Button button2 = (Button)findViewById(R.id.button2);
			button2.setOnClickListener(new OnClickListener() {
		@Override
		public void onClick(View v){
			TextView etv=(TextView) findViewById(R.id.autoCompleteTextView1);
			TextView etv1=(TextView) findViewById(R.id.autoCompleteTextView2);
			
			
			
			if ((etv.getText().toString().length() <= 0)|(etv1.getText().toString().length() <= 0)) {
				etv.setError("Select City");
				etv1.setError("Select Hotel");
				Toast.makeText(getApplicationContext()," SELECT SOMETHING", Toast.LENGTH_SHORT).show();
				
			} else if ((!etv.getText().toString().matches("[a-zA-Z ]+"))|(!etv1.getText().toString().matches("[a-zA-Z \u0020 ,.0-9 ]+"))) {
				etv.setError("Select City");
				etv1.setError("Select Hotel");
				Toast.makeText(getApplicationContext()," SELECT SOMETHING", Toast.LENGTH_SHORT).show();
				
			} else {
				Intent intent = new Intent(v.getContext(),Act3.class);
				startActivityForResult(intent,1);
			}
			
			}   
		
			} );
			
			Button Button1 =(Button) findViewById(R.id.button1);
			Button1.setOnClickListener(new OnClickListener(){
				@Override
			public void onClick(View v1){
				
				
						autotext.setText("");
						autotext1.setText("");
					
					
				
				
				// new   Soapclass2().execute(a12);
					
				/*	Intent intent1 = new Intent(v1.getContext(),ExtraNetAct.class);
				
					startActivityForResult(intent1,32);*/
					
					
					
				}}); 

			
			autotext.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			
				@Override
				public void onItemClick(AdapterView<?> parentView, View arg1, int position,
						long arg3) {
			String iStrngCity=(String) parentView.getItemAtPosition(position);
			String[] p2 ={""};
			p2[0]=iStrngCity;
			Toast toast12 = Toast.makeText(getBaseContext(),"You've chosen " + parentView.getItemAtPosition(position), Toast.LENGTH_LONG);
			toast12.show();
			new   Soapclass3().execute(p2);
}
               });
			
			autotext1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
				
				@Override
				public void onItemClick(AdapterView<?> parentView, View arg1, int position,
						long arg3) {
			String iStrngCity=(String) parentView.getItemAtPosition(position);
			String[] p2 ={""};
			p2[0]=iStrngCity;
			Toast toast12 = Toast.makeText(getBaseContext(),"You've chosen " + parentView.getItemAtPosition(position), Toast.LENGTH_LONG);
			toast12.show();
			
			   SharedPreferences numpeople = getSharedPreferences("rest", 0);
	            SharedPreferences.Editor editor1 = numpeople.edit();
	            editor1.putString("rest", p2[0]);

	            // Commit the edits!
	            editor1.commit();
			
}
               });

			
			
			
			
			
			
			
		/*	 Button button33 = (Button)findViewById(R.id.imageButton1);
				button33.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v2){
				Intent i = new Intent(android.content.Intent.ACTION_VIEW,Uri.parse("geo:37.827500,-122.481670"));
				startActivity(i);
				}   
			
				} );*/
			
			
			 setResult(0);
	
	} 
	
	



private class Soapclass1 extends AsyncTask<String,Void,String[]>{
	 protected String[] doInBackground(String[] p){
		
try
	 {
	 SoapObject Request1 = new SoapObject(NameSpace,Method_name_city);
	 
	 PropertyInfo pi= new PropertyInfo();
		pi.setName("Hotel");
		pi.setValue("xyz1");
		
		Request1.addProperty(pi);
	 SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
	 envelope.dotNet = true;
	 envelope.setOutputSoapObject(Request1);
	 HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);
	

	 androidHttpTransport.call(SOAP_Action_city,envelope);
	 
	
	
	
	 SoapObject result = (SoapObject)envelope.getResponse();
	 String[] e3=new String[result.getPropertyCount()];
	 
	  for(int i=0;i<result.getPropertyCount();i++){
		  
				  String a=result.getProperty(i).toString();
				  e3[i]=a;
		  
	  }
	    
	   
	  return e3;
	  
	 } 
	 
	  catch(Exception e)
	  {   
	  e.printStackTrace(); 
	  Log.e("AndroidRuntime", "getMessage(): "+e.getMessage());
	  Log.e("AndroidRuntime", "getLocalizedMessage(): "+e.getLocalizedMessage());
	  Log.e("AndroidRuntime", "fillInStackTrace(): "+e.fillInStackTrace().toString());
	  String[] result1=new   String[]{"new error"};
	  return result1;
	  }
		 
	 }
	  protected void onProgressUpdate(Void... progress) {
	     
	 }
	 protected void onPostExecute(String[] e3){
		
		ArrayAdapter<String> adap4 = new ArrayAdapter<String>(getBaseContext(),android.R.layout.simple_list_item_1,e3);
		 AutoCompleteTextView autotext1 = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView1);
		 autotext1.setAdapter(adap4);
		 
	/*	 TextView tv6 = (TextView) findViewById(R.id.textView6);
		 tv6.setText("success");*/
		
	
		 
		 
		
		  
	 	}

	 }

private class Soapclass2 extends AsyncTask<String,Void,String[]>{
	 protected String[] doInBackground(String[] p1){
		
try
	 {
	 SoapObject Request2 = new SoapObject(NameSpace,Menthod_name_restaurants);
	 Request2.addProperty("Restname", p1[0]);
	 SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
	 envelope.dotNet = true;
	 envelope.setOutputSoapObject(Request2);
	 HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);
	

	 androidHttpTransport.call(SOAP_Action_Restaurant,envelope);
	 SoapObject result = (SoapObject)envelope.getResponse();
	 String[] e2=new String[result.getPropertyCount()];
	 
	  for(int i=0;i<result.getPropertyCount();i++){
		  
				  String a=result.getProperty(i).toString();
				  e2[i]=a;
		  
	  }
	    
	   
	  return e2;
	  
	 } 
	 
	  catch(Exception e)
	  {   
	  e.printStackTrace(); 
	  Log.e("AndroidRuntime", "getMessage(): "+e.getMessage());
	  Log.e("AndroidRuntime", "getLocalizedMessage(): "+e.getLocalizedMessage());
	  Log.e("AndroidRuntime", "fillInStackTrace(): "+e.fillInStackTrace().toString());
	  String[] result1=new   String[]{"new error"};
	  return result1;
	  }
		 
	 }
	  protected void onProgressUpdate(Void... progress) {
	     
	 }
	 protected void onPostExecute(String[] e2){
		
		 ArrayAdapter<String> adap3 = new ArrayAdapter<String>(getBaseContext(),android.R.layout.simple_list_item_1,e2);
		 AutoCompleteTextView autotext12 = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView2);
		 autotext12.setAdapter(adap3);
		
	
		 
		 
		
		  
	 	}

	 }





//This code is for specially called method passed as argument
private class Soapclass3 extends AsyncTask<String,Void,String[]>{
	 protected String[] doInBackground(String[] p2){
		
try
	 {
	String method=(String) p2[0];
	 SoapObject Request2 = new SoapObject(NameSpace,Menthod_name_restaurants);
	 Request2.addProperty("Restname", method);
	 SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
	 envelope.dotNet = true;
	 envelope.setOutputSoapObject(Request2);
	 HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);
	

	 androidHttpTransport.call(SOAP_Action_Restaurant,envelope);
	 SoapObject result = (SoapObject)envelope.getResponse();
	 String[] e2=new String[result.getPropertyCount()];
	 
	  for(int i=0;i<result.getPropertyCount();i++){
		  
				  String a=result.getProperty(i).toString();
				  e2[i]=a;
		  
	  }
	    
	   
	  return e2;
	  
	 } 
	 
	  catch(Exception e)
	  {   
	  e.printStackTrace(); 
	  Log.e("AndroidRuntime", "getMessage(): "+e.getMessage());
	  Log.e("AndroidRuntime", "getLocalizedMessage(): "+e.getLocalizedMessage());
	  Log.e("AndroidRuntime", "fillInStackTrace(): "+e.fillInStackTrace().toString());
	  String[] result1=new   String[]{"new error"};
	  return result1;
	  }
		 
	 }
	  protected void onProgressUpdate(Void... progress) {
	     
	 }
	 protected void onPostExecute(String[] e2){
		
		 ArrayAdapter<String> adap3 = new ArrayAdapter<String>(getBaseContext(),android.R.layout.simple_list_item_1,e2);
		 AutoCompleteTextView autotext12 = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView2);
		 autotext12.setAdapter(adap3);
		
	
		 
		 
		
		  
	 	}

	 }


}

	
	
	



