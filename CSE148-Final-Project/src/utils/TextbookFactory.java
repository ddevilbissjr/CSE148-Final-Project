package utils;

import java.text.DecimalFormat;
import java.util.Random;

import model.Person;
import model.Textbook;
import model.TextbookBag;

public class TextbookFactory {
	public static TextbookBag bag = new TextbookBag();
	
	public static void createTextbook (int howMany) {
		for(int i = 0; i < howMany; i++) {
			Textbook textbook = new Textbook();
			
			textbook.setAuthor(NameFactory.getNewFirstName() + " " + NameFactory.getNewLastName());
			textbook.setBookTitle(createBookTitle());
			textbook.setIsbn(createIsbn());
			textbook.setPrice(createPrice());
			
			bag.getTextbookArray()[bag.getnElems()] = textbook;
			if(bag.getnElems() < bag.getTextbookArray().length - 1) {
				bag.setnElems(bag.getnElems()+1);
			}
		}
	}
	
	public static double createPrice () {
		DecimalFormat df = new DecimalFormat("0.00");
		Random rand = new Random();
		
		return Double.parseDouble(df.format(rand.nextInt(999) + rand.nextDouble())); // smh textbook prices
	}
	
	public static String createIsbn () {
		Random rand = new Random();
		
		// EX: 978-3-16-148410-0
		return rand.nextInt(999) + "-" 
				+ rand.nextInt(9) + "-"
				+ rand.nextInt(99) + "-"
				+ rand.nextInt(999999) + "-"
				+ rand.nextInt(9);
	}
	
	public static String createBookTitle () {
		Random rand = new Random();
		return CourseFactory.courses.get(rand.nextInt(CourseFactory.courses.size())).getCourseTitle() 
				+ " Textbook";
	}

	public static void deleteByIsbn(String isbn) {
		Textbook[] anotherArray = new Textbook[bag.getTextbookArray().length - 1]; 
        
        for (int i = 0, k = 0; i < bag.getTextbookArray().length; i++) { 
  
            if (bag.getTextbookArray()[i].getIsbn().equals(isbn)) {
                continue; 
            } 
            
            anotherArray[k++] = bag.getTextbookArray()[i]; 
        }
        
        bag.setTextbookArray(anotherArray);
	}
}
