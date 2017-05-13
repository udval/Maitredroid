package com.example.trial3;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class Game extends Activity {
	public void onCreate(Bundle bundle) {
		super.onCreate(bundle);
		Intent intent = getIntent();
		Bundle extras = intent.getExtras();
		Maze maze = (Maze)extras.get("maze");
		GameView view1 = new GameView(this,maze);
		setContentView(view1);
	}
}
