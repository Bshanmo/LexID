package com.example.android_java_ec327;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
//import android.content.Intent;



public class MainActivity extends Activity 
{
	// public final static String EXTRA_MESSAGE = "com.example.android-java-EC327.MESSAGE";

	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        //Buttons defined here.
        Button switchAbout = (Button)findViewById(R.id.button_about);
        Button switchPlay = (Button)findViewById(R.id.button_play);
        //
        //Button functions are defined here.
        switchPlay.setOnClickListener(new View.OnClickListener() {
        	@Override
        	public void onClick(View view){
        		Intent go_Play = new Intent(view.getContext(), Number1Activity.class);
        		startActivity(go_Play);
        	}
        });
        
        switchAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent go_About = new Intent(view.getContext(),AboutActivity.class);
                startActivity(go_About);
            }
            
        });

}
}
