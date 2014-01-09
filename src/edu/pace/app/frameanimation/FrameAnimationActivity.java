package edu.pace.app.frameanimation;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class FrameAnimationActivity extends Activity {

	Button animationButton;
	ImageView animationView;
	AnimationDrawable animation;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_frame_animation);
		animationButton = (Button)findViewById(R.id.buttonAnimate);
		animationView = (ImageView)findViewById(R.id.animationView);
		
		animationButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				startAnimation();
			}
		});
	}
	
	class Starter implements Runnable {
		public void run() {
			animation.start();
		}
	}
	
	void startAnimation() {
		animation = new AnimationDrawable();
		animation.addFrame(getResources().getDrawable(R.drawable.h1), 200);
		animation.addFrame(getResources().getDrawable(R.drawable.h2), 200);
		animation.addFrame(getResources().getDrawable(R.drawable.h3), 200);
		animation.addFrame(getResources().getDrawable(R.drawable.h4), 200);
		animation.setOneShot(true);
		animationView.setImageDrawable(animation);
		animationView.post(new Starter());
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.frame_animation, menu);
		return true;
	}

}
