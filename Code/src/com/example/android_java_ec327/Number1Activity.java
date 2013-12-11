package com.example.android_java_ec327;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;



public class Number1Activity extends Activity {
	Button enterButton;
	EditText inputText;
	int intPassThis;
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_number1);
        
        enterButton = (Button)findViewById(R.id.enter);
        inputText = (EditText)findViewById(R.id.input);
        
        enterButton.setOnClickListener(new OnClickListener(){
        @Override
	        public void onClick(View view){
        	//This is where the intent is being passed on! I'm not sure if
        	//I did this correctly... I need some back up guys.
        	
        	//This try'n'catch tests if the input (which is hardcoded to be a number) is blank.
        	try{
        	intPassThis = Integer.valueOf(inputText.getText().toString());
        	}
        	catch(NumberFormatException e){
        	 Context context = getApplicationContext();
	  		   CharSequence text = "Invalid input!";
	  		   int duration = Toast.LENGTH_SHORT;
	  		   Toast warning = Toast.makeText(context, text, duration);
	  		   warning.show();
        }
        	//The rest of the code checks if the integer (intPassThis) fits the requirements to be passed onto intent.
       		 	if (intPassThis > 2 && intPassThis < 16){
       		 	Intent passOnNumber = new Intent(view.getContext(), Number2Activity.class);
	        	passOnNumber.putExtra("PassThis", intPassThis);
	        	startActivity(passOnNumber);
       		 	}
       		 	else{
    		   Context context = getApplicationContext();
    		   CharSequence text = "Invalid input!";
    		   int duration = Toast.LENGTH_SHORT;
    		   Toast warning = Toast.makeText(context, text, duration);
    		   warning.show();
       		 	}
	        }

			
  
        });
}
}
