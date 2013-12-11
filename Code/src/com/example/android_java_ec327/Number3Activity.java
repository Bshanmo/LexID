package com.example.android_java_ec327;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

import android.app.Activity;
import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class Number3Activity extends Activity {
	String testString;
	ViewGroup layout;
	String childID;
	
	//This fills an array with all the words that are the same length in letters
	public static void fillArray(String filename, String array[], int size)
    {
		
//        try{
//        File file = new File (filename);
//        boolean bool = file.canRead();
//        FileReader fileReader = new FileReader(file);
//        BufferedReader bufferedReader = new BufferedReader(fileReader);
//		StringBuffer stringBuffer = new StringBuffer("");
//
//        String word;
//		//This loop saves each individual word from a seperate document
//		//And puts it into a place in the array
//        for (int i = 0; i < size; i ++){
//        		word = bufferedReader.readLine();
//        		String string3 = word.toLowerCase();
//				array[i] = string3;
//		}
//        fileReader.close();
//	} catch (IOException e) {
//		e.printStackTrace();
//		}
    	
    }
	//Checks each word in the array based on the criteria 
	//Given from the "letters" array
	//If word matches criteria, it's placed into an output array
    //Function checks letter from input with letter in word
  	public static boolean charCheck(String testWord,char wordLetter, int place)
  	{
  		//If there's a match, returns true
  		char testing = testWord.charAt(place);
  		if (testWord.charAt(place) == wordLetter)
  		{
  			return true;
  		}
  		//If no input, returns true
  		if (wordLetter == '_')
  		{
  			return true;
  		}
  		//If no match, returns false
  		else
  		{
  			return false;
  		}
  	}
	public void checkWord(String array[], String end[], char letters[], int wordsize, int wordarraysize)
	{
		Collections.shuffle(Arrays.asList(array));
		ViewGroup layout = (ViewGroup)findViewById(R.id.linearLayout1);
		//"j" is the size of the output array
		//"c" is the amount of elements placed into output array
		int j = 0;
	    int c = 0;
	    //System.out.println(c);
		//Runs each word to be checked
		for (int e = 0; e < wordarraysize; e++)
		{
			String word = array[e];
			//default value of word status is set to true
			boolean wordPass = true;
			for(int f = 0; f < wordsize; f++)
			{
				//When any letter in word does not match criteria, status is set to false
//				if (f %2 == 0)
//				{
//					wordPass = false;
//				}
				if (charCheck(word,letters[f], f) == false)
				{
					wordPass = false;
				}
			}
			//If nothing is false, the word is added to output array
			//"j" and "c" are incremented
			if (wordPass == true)
			{
				end[j] = word;
				j++;
				c++;
			}
			//If output array fills up, word scanning is terminated
			//Code prints out array
			//If output array doesn't fill up, and word scanning finishses
			//Code prints out number and words that match criteria in array
			if (j >= 10)
			{
				e = wordarraysize;
			}
		}
		
		if (c == 0)
		{
//			System.out.println("Sorry, there are no words that exist.");
			TextView errorMessage = (TextView)findViewById(R.id.Top);
			errorMessage.setText("Sorry, there are no words that exist.");
		}
		else
		{
			//this is a string, try exporting this to xml
			String qrs = "Your resulting " + (c) + " word(s) ";
			if (c == 10)
			{
				qrs += "(More words may exist)";
		}
			TextView errorMessage = (TextView)findViewById(R.id.Top);
			errorMessage.setText(qrs);
//		System.out.println ("Here are the " + (c) + " commonword(s) matching your criteria: ");
			for (int u = 0; u < c; u++)
			{
//				System.out.println(end[u]);
//				TextView child = (TextView)findViewById(R.id.word1);
				View child = layout.getChildAt(u);
				TextView textchild = (TextView) child;
				textchild.setText(end[u]);
			}
		}
	}
	//Main function
    public static void code(int a, char[] letters, String []args){
		//Scanner initialized to get input
//        Scanner s = new Scanner(System.in);
//        System.out.println("Hello World");
//        System.out.println("How long is your word?");
//    	int[] amount = {0,2,37,223,637,688,686,635,504,354,274,161,71,41,21};
//		//"a" is how many letters will be in the word
//    	//
//    	//
//    	//
//    	//WORK ON THIS! PROVIDE 'a'!
//    	//
//    	//
//    	//
//        //int a = s.nextInt();
//		//Textfile with words is called via string
//        String filename = "Commonwords" + a + ".txt";
//        int size = amount[a];
//		//char array holds criteria letters
//        //
//        //
//        //
//        //
//        //
//		//char[] letters = new char[a];
//		//This is a debugging array, only use for testing
////		for(int qa = 0; qa < a; qa++)
////		{
////			if(qa == 1)
////			{
////				letters[qa] = 'a';
////			}
////			else if (qa == 3)
////			{
////				letters[qa] = 'r';
////			}
////			else
////			{
////				letters[qa] = '_';
////			}
////		}
//		//fillArray fills the "list" array with words of same length
//		String[] list = new String[size];
//        fillArray(filename, list, size);
//
//        //Array is shuffled to produce random outputs every time
//        //
//        //
//        //
//        //PUT A BUTTON HERE FOR THIS ONE!
//        //
//        //
//        //
//        //
//        //
//        //
//        //
//        Collections.shuffle(Arrays.asList(list));
//		//"found" array displays first 10 words that match criteria via checkWord
//        //
//        //
//        //THIS IS THE OUTPUT
//        //
//        //
//        //
//        String[] found = new String[10];
//	    checkWord(list,found,letters, a, size);
    }
    
    
    // HERES WHERE THE MAGIC HAPPENS
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_number3);
		//
		final int a;
		final char[] letters;
    	int[] amount = {0,2,37,223,637,688,686,635,504,354,274,161,71,41,21};
		//"a" is how many letters will be in the word
        //int a = s.nextInt();
		//Textfile with words is called via string
		Intent intent = getIntent();
		a = intent.getIntExtra("number", 0);
		letters = intent.getCharArrayExtra("charArray");
        String filename = "commonwords" + a + ".txt";
        final int size = amount[a];        
        
//		TextView inputThis = (TextView)findViewById(R.id.arrayNumber);
//		inputThis.setText(String.valueOf(a));
		//char array holds criteria letters
		//char[] letters = new char[a];
		//fillArray fills the "list" array with words of same length
        
//        TextView array0 = (TextView)findViewById(R.id.showArray0);
//        array0.setText(letters[0]);
        
		final String[] list = new String[size];
		AssetManager AM = getAssets();
		
      try{
    	  InputStream IS = AM.open(filename);
    	  BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(IS));
          String word;
		//This loop saves each individual word from a seperate document
		//And puts it into a place in the array
          for (int i = 0; i < size; i ++){
      		word = bufferedReader.readLine();
      		String string3 = word.toLowerCase();
			list[i] = string3;
		}
          bufferedReader.close();
	} catch (IOException e) {
		e.printStackTrace();
		}
        //Array is shuffled to produce random outputs every time
		//Create a button for this.
        Collections.shuffle(Arrays.asList(list));
		//"found" array displays first 10 words that match criteria via checkWord

        final String[] found = new String[10];
	    checkWord(list,found,letters, a, size);
	    //Buttons are arranged here.
	    Button buttonReroll = (Button)findViewById(R.id.rerollButton);
	    Button buttonReset = (Button)findViewById(R.id.resetButton);
	    
	    buttonReroll.setOnClickListener(new View.OnClickListener() {
	    	@Override
	    	public void onClick(View view){
	    		checkWord(list,found,letters, a, size);
	    			//Have it reset the shuffle!
	    	}
	    });
	    
	    buttonReset.setOnClickListener(new OnClickListener(){
	    	@Override
            public void onClick(View view) {
                Intent go_Reset = new Intent(view.getContext(),MainActivity.class);
                startActivity(go_Reset);
            }
            
        });
	    
	}//Denotes end of onCreate.
}
