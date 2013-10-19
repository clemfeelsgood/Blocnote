package com.example.blocnote;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;


public class slider extends LinearLayout {
	protected boolean isOpen=true;
	protected RelativeLayout toHide = null;

	protected final static int SPEED = 300;
	

	Animation.AnimationListener closeListener = new Animation.AnimationListener() {
		public void onAnimationEnd(Animation animation) {
			toHide.setVisibility(View.GONE);
		}   
		public void onAnimationRepeat(Animation animation) {		
		}   
		public void onAnimationStart(Animation animation) {	
		}
	};
	
	Animation.AnimationListener openListener = new Animation.AnimationListener() {
		public void onAnimationEnd(Animation animation) {
		}    
		public void onAnimationRepeat(Animation animation) {
		} 
		public void onAnimationStart(Animation animation) {
			toHide.setVisibility(View.VISIBLE);
		}
	};

	public slider(Context context) {
		super(context);
	}
	
	public slider(Context context, AttributeSet attrs) {
		super(context, attrs);
	}
	
	public boolean toggle() {
		  TranslateAnimation animation = null;
		  isOpen = !isOpen;
		  if (isOpen) 
		  {
		    animation = new TranslateAnimation(0.0f, 0.0f, -toHide.getHeight(), 0.0f);
		    animation.setAnimationListener(openListener);
		  } else
		  {
		    animation = new TranslateAnimation(0.0f, 0.0f, 0.0f, -toHide.getHeight());
		    animation.setAnimationListener(closeListener);
		  }

		  animation.setDuration(SPEED);
		  animation.setInterpolator(new AccelerateInterpolator());
		  startAnimation(animation);
		  return isOpen;
		}
	public void setToHide(RelativeLayout toHide) {
		this.toHide = toHide;
	}
}
