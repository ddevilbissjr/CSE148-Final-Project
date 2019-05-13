package utils;

import java.text.DecimalFormat;
import java.util.Random;

import model.Department;
import model.FacultyCourseStatus;
import model.StudentCourseStatus;
import model.Title;

public class FacultyFactory extends PersonFactory {
	public static String createPhone () {
		Random rand = new Random();
		return "(" + rand.nextInt(999) + ") " + rand.nextInt(999) + "-" + rand.nextInt(9999);
	}
	
	public static double createSalary () {
		DecimalFormat df = new DecimalFormat("0.00");
		Random rand = new Random();
		
		return Double.parseDouble(df.format(rand.nextDouble() * 100000.0));
	}

	public static Title createTitle() {
		Random rand = new Random();
		return Title.values()[rand.nextInt(Title.values().length)];
	}

	public static Department createDepartment() {
		Random rand = new Random();
		return Department.values()[rand.nextInt(Department.values().length)];
	}

	public static FacultyCourseStatus getCourseStatus () {
		Random rand = new Random();
		return FacultyCourseStatus.values()[rand.nextInt(FacultyCourseStatus.values().length-1)];
	}
}
