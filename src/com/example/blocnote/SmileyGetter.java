package com.example.blocnote;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.Html.ImageGetter;

public class SmileyGetter implements ImageGetter {

	  protected Context context = null;
	   
	  public SmileyGetter(Context c) {
	    context = c;
	  }
	 
	  public void setContext(Context context) {
	    this.context = context;
	  }
	@Override
	public Drawable getDrawable(String smiley) {
		
		Drawable retour = null;
	    Resources resources = context.getResources();

	    if(smiley.compareTo("clin") == 0)
	      retour = resources.getDrawable(R.drawable.clin);
	    else if(smiley.compareTo("smile") == 0)
	      retour = resources.getDrawable(R.drawable.smile);
	    else
	      retour = resources.getDrawable(R.drawable.heureux);
	    retour.setBounds(0, 0, retour.getIntrinsicWidth(), retour.getIntrinsicHeight());
	    return retour;
	}

}
