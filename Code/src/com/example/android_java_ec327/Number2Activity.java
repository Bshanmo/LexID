package com.example.android_java_ec327;

import java.io.IOException;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Number2Activity extends Activity {
	private static final String TAG = "Number2Activiy";
	//Variables for later use.
	int numberOfButtons;
	ViewGroup ShowChildren;
	Button enterButton;
	//chararray will be called later.
	char[] chararray;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		//numberOfButtons collects intent (hopefully an int value) and transfers it to the for loop later.
		// The ViewGroup is actually the scrolling layout from the xml file - it holds 15 children.
		// The for loop changes a child to visible depending on numberOfButtons.
		//Intent catchNumber = getIntent();
		//
		//Grab the intent from Number1Activity.java and then have it so that
		//it hides a number of input buttons (equal to the intent). Then, report
		//the intent to the java program so that it saves it (since we need it
		//apparently). Afterwards, plug in the letters for the input buttons that
		//ARE available. The next step after this is to somehow return the letter
		//inputs into the main java program so that it spits out 10 random words.
		//
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_number2);
		Intent intent = getIntent();
		numberOfButtons = intent.getIntExtra("PassThis", 3);
		
		chararray = new char[numberOfButtons];
		
		TextView inputThis = (TextView)findViewById(R.id.UserInputNumber);
		inputThis.setText(String.valueOf(numberOfButtons));
		
		ShowChildren = (ViewGroup)findViewById(R.id.linearLayout1);
		for (int i = 0; i < numberOfButtons; i++)
		{
			View child = ShowChildren.getChildAt(i);
			child.setVisibility(1);
		}
		Button testButton = (Button)findViewById(R.id.testButton);
		testButton.setOnClickListener(new OnClickListener(){
		@Override
			public void onClick(View view)
			{
			for (int i = 0; i < numberOfButtons; i++)
			{
				View child = (View) ShowChildren.getChildAt(i);
				EditText EditChild = (EditText) child;
				String PassThisString = EditChild.getText().toString();
				if (PassThisString.matches(""))
				{
					chararray[i] = '_';
				}
				else
				{
					//PassThisString = "a";
					char PassThisChar = PassThisString.charAt(0);
					chararray[i] = PassThisChar;
				}				
			}
			TextView showArray = (TextView)findViewById(R.id.showArray0);
			String charToString = String.valueOf(chararray[0]);
			showArray.setText(charToString);
			}
		});
		
		enterButton = (Button)findViewById(R.id.enterButton);
		enterButton.setOnClickListener(new OnClickListener(){
		@Override
			public void onClick(View view)
			{
				for (int i = 0; i < numberOfButtons; i++)
				{
//					chararray[0] = 'a';
//					chararray[i] = '_';
					View child = (View) ShowChildren.getChildAt(i);
					EditText EditChild = (EditText) child;
					String PassThisString = EditChild.getText().toString();
					if (PassThisString.matches(""))
					{
						chararray[i] = '_';
					}
					else
					{
						//PassThisString = "a";
						char PassThisChar = PassThisString.charAt(0);
						if (PassThisChar == ' ')
						{
							chararray[i] = '_';
						}
						else
						{
							chararray[i] = PassThisChar;
						}
					}				
				}
				
				//passOnValues passes on number of letters, actual letters, and their positions. Maybe a char array?
	        	Intent passOnValues = new Intent(view.getContext(), Number3Activity.class);
	        	passOnValues.putExtra("number", numberOfButtons);
	        	passOnValues.putExtra("charArray", chararray);
	        	startActivity(passOnValues);
//        		intPassThis = Integer.valueOf(inputText.getText().toString());
//	        	Intent passOnNumber = new Intent(view.getContext(), Number2Activity.class);
//	        	passOnNumber.putExtra("PassThis", intPassThis);
//	        	startActivity(passOnNumber);
			}
		});
		
		
	}

}
