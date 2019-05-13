package utils;

import java.text.DecimalFormat;
import java.util.Random;

import model.StudentCourseStatus;
import model.LetterGrade;
import model.Major;

public class StudentFactory extends PersonFactory {
	public static double createGpa () { // Just for now.
		Random rand = new Random();
		DecimalFormat df = new DecimalFormat("0.00");
		
		return Double.parseDouble(df.format(rand.nextDouble() * 5.0));
	}
	
	public static Major createMajor () {
		Random rand = new Random();
		return Major.values()[rand.nextInt(Major.values().length-1)];
	}
	
	public static StudentCourseStatus getCourseStatus () {
		Random rand = new Random();
		return StudentCourseStatus.values()[rand.nextInt(StudentCourseStatus.values().length-1)];
	}
}
