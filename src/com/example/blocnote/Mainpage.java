package com.example.blocnote;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.Html;
import android.text.TextWatcher;
import android.text.method.ScrollingMovementMethod;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class Mainpage extends Activity {

	  private Button hideShow = null;
	  private slider slider = null;
	  private RelativeLayout toHide = null;
	  private EditText editer = null;
	  private TextView text = null;
	  private RadioGroup colorChooser = null;
	 
	  private Button bold = null;
	  private Button italic = null;
	  private Button underline = null;
	 
	  private ImageButton smile = null;
	  private ImageButton heureux = null;
	  private ImageButton clin = null;
	 
	  private SmileyGetter getter = null;
	 
	  private String currentColor = "#000000";
	 
	  @Override
	  public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.activity_mainpage);
	 
	    getter = new SmileyGetter(this);

	    hideShow = (Button) findViewById(R.id.hideShow);
	    hideShow.getRootView().setBackgroundColor(R.color.background);
	    hideShow.setOnClickListener(new View.OnClickListener() {
	      @Override
	      public void onClick(View vue) {
	        if(slider.toggle())
	        {
	          hideShow.setText(R.string.hide);
	        }else
	        {
	          hideShow.setText(R.string.show);
	        }
	      }
	    });
	    toHide = (RelativeLayout) findViewById(R.id.toHide);
	    slider = (slider) findViewById(R.id.slider);
	    slider.setToHide(toHide);
	    text = (TextView) findViewById(R.id.text);
	    text.setMovementMethod(new ScrollingMovementMethod());
	    editer = (EditText) findViewById(R.id.edit);
	    editer.setOnKeyListener(new View.OnKeyListener() {
	      @Override
	      public boolean onKey(View v, int keyCode, KeyEvent event) {
	        int cursorIndex = editer.getSelectionStart();
	        if(event.getAction() == 0)
	          if(keyCode == 66)
	            editer.getText().insert(cursorIndex, "<br />");
	        return true;
	      }
	    });
	    editer.addTextChangedListener(new TextWatcher() {
	      @Override
	      public void onTextChanged(CharSequence s, int start, int before, int count) {
	        text.setText(Html.fromHtml("<font color=\"" + currentColor + "\">" + editer.getText().toString() + "</font>", getter, null));
	      }
	 
	      @Override
	      public void beforeTextChanged(CharSequence s, int start, int count, int after) {
	 
	      }
	 
	      @Override
	      public void afterTextChanged(Editable s) {
	 
	      }
	    });

	    colorChooser = (RadioGroup) findViewById(R.id.colors);

	    colorChooser.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
	      @Override
	      public void onCheckedChanged(RadioGroup group, int checkedId) {
	        switch(checkedId)
	        {
	          case R.id.black:
	            currentColor = "#000000";
	            break;
	          case R.id.blue:
	            currentColor = "#0022FF";
	            break;
	          case R.id.red:
	            currentColor = "#FF0000";
	        }

	        editer.setText(editer.getText().toString());
	      }
	    });
	         
	    smile = (ImageButton) findViewById(R.id.smile);
	    smile.setOnClickListener(new View.OnClickListener() {
	      @Override
	      public void onClick(View v) {
	        int selectionStart = editer.getSelectionStart();
	        editer.getText().insert(selectionStart, "<img src=\"smile\" >");
	      }
	    });
	         
	    heureux =(ImageButton) findViewById(R.id.heureux);
	    heureux.setOnClickListener(new View.OnClickListener() {
	      @Override
	      public void onClick(View v) {
	        int selectionStart = editer.getSelectionStart();
	        editer.getText().insert(selectionStart, "<img src=\"heureux\" >");
	      }
	    });
	 
	    clin = (ImageButton) findViewById(R.id.clin);
	    clin.setOnClickListener(new View.OnClickListener() {
	      @Override
	      public void onClick(View v) {
	        int selectionStart = editer.getSelectionStart();
	        editer.getText().insert(selectionStart, "<img src=\"clin\" >");
	      }
	    });
	         
	    bold = (Button) findViewById(R.id.bold);
	    bold.setOnClickListener(new View.OnClickListener() {
	      @Override
	      public void onClick(View vue) {
	        int selectionStart = editer.getSelectionStart();
	        int selectionEnd = editer.getSelectionEnd();
	         
	        Editable editable = editer.getText();
	        if(selectionStart == selectionEnd)

	          editable.insert(selectionStart, "<b></b>");
	        else
	        {
	          editable.insert(selectionStart, "<b>");
	          editable.insert(selectionEnd + 3, "</b>");
	        }
	      }
	    });
	         
	    italic = (Button) findViewById(R.id.italic);
	    italic.setOnClickListener(new View.OnClickListener() {
	      @Override
	      public void onClick(View vue) {

	        int selectionStart = editer.getSelectionStart();

	        int selectionEnd = editer.getSelectionEnd();
	 
	        Editable editable = editer.getText();
	 
	        if(selectionStart == selectionEnd)
	          editable.insert(selectionStart, "<i></i>");
	        else
	        {
	          editable.insert(selectionStart, "<i>");
	          editable.insert(selectionEnd + 3, "</i>");
	        }
	      }
	    });
	 
	     underline = (Button) findViewById(R.id.underline);
	     underline.setOnClickListener(new View.OnClickListener() {
	      @Override
	      public void onClick(View vue) {
	        int selectionStart = editer.getSelectionStart();
	        int selectionEnd = editer.getSelectionEnd();
	 
	        Editable editable = editer.getText();
	         
	        if(selectionStart == selectionEnd)
	          editable.insert(selectionStart, "<u></u>");
	        else
	        {
	          editable.insert(selectionStart, "<u>");
	          editable.insert(selectionEnd + 3, "</u>");
	        }
	      }
	    });
	  }
}
