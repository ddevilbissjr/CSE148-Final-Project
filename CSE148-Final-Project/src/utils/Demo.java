package utils;

import java.util.Random;

import model.Classroom;
import model.Faculty;
import model.Student;
import model.Textbook;

public class Demo {
	public static void main (String[] args) {
		
		NameFactory.readFirstNames(); 	//
		NameFactory.readLastNames(); 	// Necessary resources I need loaded in first.
		CourseFactory.createCourses();	//
		
		Random rand = new Random();
		
		ClassroomFactory.createClassroom(50);
		ClassroomFactory.getClasses();
		
		Classroom classroom = ClassroomFactory.bag.getClassroomArray()[rand.nextInt(ClassroomFactory.bag.getClassroomArray().length)];
		ClassroomFactory.deleteByRoomNumber(classroom.getClassroomNumber());
		
		int randomCourse = rand.nextInt(CourseFactory.bag.getCourseArray().length - 1); // Grab random course from bag for example
		CourseFactory.emitCourseNumber(randomCourse);
		CourseFactory.emitCourseTitle(randomCourse);
		CourseFactory.emitCourseDescription(randomCourse);
		CourseFactory.emitNumberOfCredits(randomCourse);
		
		CourseFactory.deleteByCourseNumber("XMB111");
		
		PersonFactory.createPeople("Student", 2000);
		Student stu = (Student) PersonFactory.getPersonByID(696);
		
		System.out.println("#" + stu.getId() + ": ");
		System.out.println("	" + stu.getFirstName() + " " + stu.getLastName());
		System.out.println("	" + stu.getCurrentMajor().toString());
		System.out.println("	" + stu.getGpa());
		System.out.println("	" + stu.getMiniStudentCourseBag().toString());
		
		PersonFactory.createPeople("Faculty", 500);
		Faculty fac = (Faculty) PersonFactory.getPersonByID(2345);
		
		System.out.println("#" + fac.getId() + ": ");
		System.out.println("	" + fac.getFirstName() + " " + fac.getLastName());
		System.out.println("	" + fac.getCurrentDepartment().toString());
		System.out.println("	" + fac.getOfficePhone());
		System.out.println("	" + fac.getSalary());
		System.out.println("	" + fac.getMiniFacultyCourseBag().toString());
		
		TextbookFactory.createTextbook(50);
		Textbook book = TextbookFactory.bag.getTextbookArray()[rand.nextInt(TextbookFactory.bag.getTextbookArray().length)];
		
		System.out.println("Textbook:");
		System.out.println("	" + book.getBookTitle());
		System.out.println("	" + book.getAuthor());
		System.out.println("	" + book.getIsbn());
		System.out.println("	" + "$" + book.getPrice());
		
		TextbookFactory.deleteByIsbn(book.getIsbn());
	}
}