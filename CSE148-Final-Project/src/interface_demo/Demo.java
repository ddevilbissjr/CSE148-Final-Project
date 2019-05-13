package interface_demo;

import java.text.DecimalFormat;

import model.Faculty;
import model.Person;
import model.Student;
import utils.CourseFactory;
import utils.NameFactory;
import utils.PersonFactory;

public class Demo {

	public static void main(String[] args) {
		
		NameFactory.readFirstNames(); 	//
		NameFactory.readLastNames(); 	// Necessary resources I need loaded in first.
		CourseFactory.createCourses();	//
		
		PersonFactory.createPeople("Student", 200);
		PersonFactory.createPeople("Faculty", 20);
		
		Student exampleStudent = (Student) PersonFactory.getRandomPerson("Student");
		Faculty exampleFaculty = (Faculty) PersonFactory.getRandomPerson("Faculty");
		
		System.out.println("Random Student Fees: [" + exampleStudent.getFirstName() + " " + exampleStudent.getLastName() + " (" + exampleStudent.getId() + "): [" 
				+ "Parking: $" + exampleStudent.chargeParking() + ", "
				+ "Food: $" + exampleStudent.chargeFood() + ", "
				+ "Technology: $" + exampleStudent.chargeTechnology() + ", "
				+ "Activities: $" + exampleStudent.chargeActivities() + ", "
				+ "Office Use: $" + exampleStudent.chargeOfficeUse() + "]]"
		);
		
		System.out.println("Random Faculty Fees: [" + exampleFaculty.getFirstName() + " " + exampleFaculty.getLastName() + " (" + exampleFaculty.getId() + "): [" 
				+ "Parking: $" + exampleFaculty.chargeParking() + ", "
				+ "Food: $" + exampleFaculty.chargeFood() + ", "
				+ "Technology: $" + exampleFaculty.chargeTechnology() + ", "
				+ "Activities: $" + exampleFaculty.chargeActivities() + ", "
				+ "Office Use: $" + exampleFaculty.chargeOfficeUse() + "]]"
		);
		
		Double totalStudentCharges = 0.0;
		Double totalFacultyCharges = 0.0;
		
		for(Person person : PersonFactory.bag.getPersonArray()) {
			if(Student.class.isAssignableFrom((person).getClass())) {
				totalStudentCharges += (person.chargeParking() + person.chargeFood() + person.chargeTechnology() + person.chargeActivities() + person.chargeOfficeUse());
			} else if(Faculty.class.isAssignableFrom((person).getClass())) {
				totalFacultyCharges += (person.chargeParking() + person.chargeFood() + person.chargeTechnology() + person.chargeActivities() + person.chargeOfficeUse());
			}
		}
		
		DecimalFormat df = new DecimalFormat("0.00");
		
		System.out.println("Total Student Charges: $" + Double.parseDouble(df.format(totalStudentCharges)));
		System.out.println("Total Faculty Charges: $" + Double.parseDouble(df.format(totalFacultyCharges)));
	}
}
