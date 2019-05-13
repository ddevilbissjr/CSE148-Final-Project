package utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class NameFactory {
	
	public static List<String> firstNames = new ArrayList<String>();
	public static List<String> lastNames = new ArrayList<String>();
	
	public static void readFirstNames () {
		
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader("src/input_data/First_Names.txt"));
			
		    String line;
		    while ((line = br.readLine()) != null) {
		    	firstNames.add(line);
		    }
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void readLastNames () {
		
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader("src/input_data/Last_Names.txt"));
			
		    String line;
		    while ((line = br.readLine()) != null) {
		    	lastNames.add(line);
		    }
		    
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static String getNewFirstName () {
		Random rand = new Random();
		return firstNames.get(rand.nextInt(firstNames.size()));
	}
	
	public static String getNewLastName () {
		Random rand = new Random();
		return lastNames.get(rand.nextInt(lastNames.size()));
	}
}
