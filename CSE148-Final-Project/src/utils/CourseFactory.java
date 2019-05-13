package utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import model.Classroom;
import model.Course;
import model.CourseBag;

public class CourseFactory {
	
	public static CourseBag bag = new CourseBag();
	public static List<Course> courses = new ArrayList<Course>();
	
	public static void createCourses() {
		try {
			readCourseInventory();
		} catch (IOException e) {e.printStackTrace();}
		
		bag.setCourseArray(courses.toArray(bag.getCourseArray()));
	}
	
	public static void readCourseInventory () throws IOException {
	    BufferedReader br = new BufferedReader(new FileReader("src/input_data/Course_Inventory.txt"));
	    
	    Course course = null;
	    int count = 0;
	    String line;
	    while ((line = br.readLine()) != null && bag.getnElems() < 1000) {
	        
	        if(count < 4) {
	        	count++;
	        } else {
	        	count = 0;
	        	continue;
	        }
	        
	        switch(count) {
	        case 1:
	        	course = new Course();
	        	course.setCourseNumber(line);
	        	break;
	        case 2:
	        	course.setCourseTitle(line);
	        	break;
	        case 3:
	        	course.setCourseDescription(line);
	        	break;
	        case 4:
	        	course.setNumberOfCredits(Double.parseDouble(line));
	        	courses.add(course);
	        	break;
	        }
	    }
	    
	    br.close();
	}
	
	public static void emitCourseNumber (int num) {
		System.out.println(bag.getCourseArray()[num].getCourseNumber());
	}
	
	public static void emitCourseTitle (int num) {
		System.out.println(bag.getCourseArray()[num].getCourseTitle());
	}
	
	public static void emitNumberOfCredits (int num) {
		System.out.println(bag.getCourseArray()[num].getNumberOfCredits());
	}
	
	public static void emitCourseDescription (int num) {
		System.out.println(bag.getCourseArray()[num].getCourseDescription());
	}

	public static void deleteByCourseNumber(String courseNumber) {
		Course[] anotherArray = new Course[bag.getCourseArray().length - 1]; 
        
        for (int i = 0, k = 0; i < bag.getCourseArray().length; i++) { 
  
            if (bag.getCourseArray()[i].getCourseNumber().equals(courseNumber)) { 
                continue; 
            } 
            
            anotherArray[k++] = bag.getCourseArray()[i]; 
        }
        
        bag.setCourseArray(anotherArray);
	}
}
