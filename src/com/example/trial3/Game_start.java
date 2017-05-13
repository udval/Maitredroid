package com.example.trial3;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class Game_start extends Activity {
	public void onBackPress(){this.finish();}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_game_start);
		SharedPreferences pref1=getSharedPreferences("food",MODE_WORLD_READABLE);
		String string1=pref1.getString("food1", null);
		TextView text=(TextView) findViewById(R.id.textView3);
		text.setText(string1);
		
		 
		Button	button1 = (Button) findViewById(R.id.button1);
		
		button1.setOnClickListener(new View.OnClickListener(){
		@SuppressWarnings("deprecation")
		
		
		
		
		 String[] s={"1","2","3"};@Override
				public void onClick(View v){ 
			 
			 SharedPreferences pref1=getSharedPreferences("food",MODE_WORLD_READABLE);
				String string1=pref1.getString("food1", null);
				string1=("");
				Editor edit=pref1.edit();
				edit.putString("food1",string1);
				edit.commit();
			 
			 
			 
			 
			 
			 final Builder alertDialog = new AlertDialog.Builder(Game_start.this); //Read Update
			 
		        alertDialog.setTitle("Choose 1,2 or 3 Difficulty wise:").setItems(s,new DialogInterface.OnClickListener()
		        { public void onClick(DialogInterface dialog, int which) {
		        	if(which==0){
		        	Intent game = new Intent(Game_start.this,Game.class);  //create an Intent to launch the Game Activity
					Maze maze = MazeCreator.getMaze(1);    //use helper class for creating the Maze
					game.putExtra("maze", maze);			//add the maze to the intent which we'll retrieve in the Maze Activity
					Game_start.this.startActivity(game);}
		        	else if(which==1){
		        	Intent game2 = new Intent(Game_start.this,Game.class);  //create an Intent to launch the Game Activity
					Maze maze2 = MazeCreator.getMaze(2);    //use helper class for creating the Maze
					game2.putExtra("maze", maze2);			//add the maze to the intent which we'll retrieve in the Maze Activity
					Game_start.this.startActivity(game2);}
		        	else if(which==2){
		        	Intent game3 = new Intent(Game_start.this,Game.class);  //create an Intent to launch the Game Activity
					Maze maze3 = MazeCreator.getMaze(3);    //use helper class for creating the Maze
					game3.putExtra("maze", maze3);			//add the maze to the intent which we'll retrieve in the Maze Activity
					Game_start.this.startActivity(game3);}
		        	else{dialog.dismiss();}
					
		        	
		        	
		        	
		        	
		           }

		        	
		        	
		        	
		        	
		        	
		        });
		      

		        alertDialog.show(); 
		           }
		        });


		Button	button2 = (Button) findViewById(R.id.button2);
		
		button2.setOnClickListener(new View.OnClickListener(){
		@SuppressWarnings("deprecation")
		
		
		
		
		@Override
				public void onClick(View v){
			SharedPreferences pref1=getSharedPreferences("food",MODE_WORLD_READABLE);
			String string1=pref1.getString("food1", null);
			string1=("");
			Editor edit=pref1.edit();
			edit.putString("food1",string1);
			edit.commit();
			
			
			String url = "http://www.google.com";
				Intent i = new Intent(Intent.ACTION_VIEW);
				i.setData(Uri.parse(url));
				startActivity(i); }});
		
		Button	button3 = (Button) findViewById(R.id.button3);
		
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
			Intent i = new Intent(Game_start.this,M5.class);
			startActivity(i);
			
			
		}});
		
		   
		
	}
	
	


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.game_start, menu);
		return true;
	}

}
