package com.example.trial3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;
import org.xmlpull.v1.XmlPullParserException;

import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class ExtraNetAct extends Activity {
	static String Method_name="feedcitydetails";
	static String URL="http://10.0.2.2:57488/Service1.asmx";
	static String NameSpace="http://tempuri.org/";
	static String SOAP_Action="http://tempuri.org/feedcitydetails";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_extra_net);

	new Soapclass().execute("");
		

	}





	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.extra_net, menu);
		return true;
	}
	

	private class Soapclass extends AsyncTask<String,Void,String>{
		 protected String doInBackground(String...params){
			
	 try
		 {
		 SoapObject Request1 = new SoapObject(NameSpace,Method_name);
		 //SoapSerializationEnvelope envelope =new SoapSerializationEnvelope(SoapEnvelope.VER11);
		 PropertyInfo pi = new PropertyInfo();
		    pi.setName("cityname");
		    pi.setValue("surat");
		    
		    Request1.addProperty(pi);
		  /*  PropertyInfo pj=new PropertyInfo();
		    pj.setName("b");
		    pj.setValue(58);
		    Request1.addProperty(pj);
*/
		 SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
		 envelope.dotNet = true;
		 envelope.setOutputSoapObject(Request1);

		 HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);
		

		 androidHttpTransport.call(SOAP_Action,envelope);
		 SoapObject result = (SoapObject)envelope.getResponse();
		  result.getProperty(0); 
		    
		    String e2=result.getProperty(0).toString();
		  return e2;
		  
		 } 
		 
		  catch(Exception e)
		  {   
		  e.printStackTrace(); 
		  Log.e("AndroidRuntime", "getMessage(): "+e.getMessage());
		  Log.e("AndroidRuntime", "getLocalizedMessage(): "+e.getLocalizedMessage());
		  Log.e("AndroidRuntime", "fillInStackTrace(): "+e.fillInStackTrace().toString());
		  String result1="new error";
		  return result1;
		  }
			 
		 }
		  protected void onProgressUpdate(Void... progress) {
		     
		 }
		 protected void onPostExecute(String result1){
			 TextView Tt=(TextView) findViewById(R.id.textView234);
			 Tt.setText(result1+"no show 3");
			  
		 	}

		 }}













	
	
	
	
	
