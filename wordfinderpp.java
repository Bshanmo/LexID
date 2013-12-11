import java.util.Scanner;
import java.util.Arrays;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.*;
import java.util.*;
import java.util.ArrayList;

public class wordfinder{
    public static void fillArray(String filename, String array[], int size)
    {
        try{
        File file = new File (filename);
        boolean bool = file.canRead();
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
		StringBuffer stringBuffer = new StringBuffer();
        //System.out.println(bool);
        String word;
        for (int i = 0; i < size; i ++){
        		word = bufferedReader.readLine();
        		String string3 = word.toLowerCase();
				array[i] = string3;
				//System.out.println(array[i]);
        	
        	//stringBuffer.append(word);
			//stringBuffer.append("\n");
		}
        fileReader.close();
//        System.out.println("Contents of file:");
//        System.out.println(array[0]);
//        System.out.println(array[1]);
		//System.out.println(stringBuffer.toString());
	} catch (IOException e) {
		e.printStackTrace();
	}
    }
	public static void checkWord(String array[], String end[], String letters[], int wordsize, int wordarraysize)
	{
		int j = 0;
	    int c = 0;
		while ( j < 10)
		{
			for (int e = 0; e < wordarraysize; e++)
			{
				String word = array[e];
				boolean wordPass = true;
				for(int f = 0; f < wordsize; f++)
				{
					if (charCheck(word,letters[f], f) == false)
					{
						wordPass = false;
					}
				}
				if (wordPass == true)
				{
					end[j] = word;
					j++;
					c++;
				}
			}
		}
		if (c == 0)
		{
			System.out.println("Sorry, there are no words that exist.");
		}
		else
		{
		System.out.println ("Here are the first " + (c) + " commonwords matching your criteria: ");
			for (int u = 0; u < c; u++)
			{
				System.out.println(end[u]);
			}
		}
	}
	public static boolean charCheck(String testWord,char wordLetter, int place)
	{
		if (testWord.charAt(place-1) == letter.charAt(0))
		{
			return true;
		else
		{
			return false;
		}
	}
	/*
    public static void checkChar(String array[], String end[], String letter, int place, int size)
    {
    	System.out.println(place);
    	System.out.println(letter.charAt(0));
	    int j = 0;
	    int c = 0;
	    for (int i = 0; i < 10; i++)
	    {
//	    	System.out.println(i);
//	    	System.out.println(j);
		    boolean skip = false;
		    while(skip == false)
		    {	
			    if (array[j].charAt(place-1) == letter.charAt(0))
				    {
			    	
					    skip = true;
				    }
			    
			    j++;
			    
			    if (j >= size - 1)
			    {
				    skip = true;
			    }
		    }
		    if (j == size - 1)
			    {
		    	 	c = i;
				    i = 10;
			    }
		    else
		    {
			    end[i] = array[j-1];
			    if (i == 9)
			    {
			    	c = i;
			    }
		    }
		    
	    }
        System.out.println ("Here are the first " + (c) + " commonwords matching your criteria: ");

	    for (int u = 0; u < c; u++)
	    {
	        System.out.println(end[u]);
	    }
//	System.out.println("Array filled");
    }
    */
    public static void main(String []args){
        Scanner s = new Scanner(System.in);
        System.out.println("Hello World");
        System.out.println("How many letters is your word?");
        //int a = 0;
    	int[] amount = {0,2,37,223,637,688,686,635,504,354,274,161,71,41,21};
        //char exe;
        //int pos;
        int a = s.nextInt();
        String filename = "Commonwords" + a + ".txt";
        System.out.println(filename);
        int size = amount[a];
		char[] letters = new char[a];
        String[] list = new String[size];
        System.out.println(amount[a]);
        fillArray(filename, list, size);
//		for(int q = 0; q < size; q++)
//		{
//			System.out.println(list[q]);
//		}
        
        Collections.shuffle(Arrays.asList(list));
        System.out.println ("Which character would you like to search for?");
	    String exe = s.next(".");
	    System.out.println ("Where would you like to find it?");
        int pos = s.nextInt();
		letters[pos-1] = exe.charAt(0);
        String[] found = new String[10];
	    checkWord(list,found,letters, a, size);
	    System.out.println ("done?");
	    //int sop = s.nextInt();
    }
}
