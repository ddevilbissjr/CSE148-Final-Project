package utils;

import java.util.Random;

import model.Course;
import model.Faculty;
import model.LetterGrade;
import model.MiniFacultyCourseBag;
import model.MiniFacultyCourseInfo;
import model.MiniStudentCourseBag;
import model.MiniStudentCourseInfo;
import model.Person;
import model.PersonBag;
import model.Student;

public class PersonFactory {
	
	public static PersonBag bag = new PersonBag();
	private static Random rand = new Random();
	private static int personCounter = 0;
	
	public static void createPeople (String type, int howMany) {
		
		NameFactory.readFirstNames();
		NameFactory.readLastNames();
		
		if(bag.getPersonArray() == null) {
			bag.setPersonArray(new Person[howMany]);
		} else {
			Person[] people = new Person[howMany + (bag.getPersonArray().length - 1)];
			
			for(int i = 0; i < bag.getPersonArray().length; i++) {
				people[i] = bag.getPersonArray()[i];
			}
			
			bag.setPersonArray(people);
		}
		
		if (type.equals("Student")) {
			for(int i = 0; i < howMany; i++) {
				createStudent();
			}
		} else {
			for(int i = 0; i < howMany; i++) {
				createFaculty();
			}
		}
	}
	
	public static void createStudent () {
		Student student = new Student();
		MiniStudentCourseBag miniBag = new MiniStudentCourseBag();
		
		student.setFirstName(NameFactory.getNewFirstName());
		student.setLastName(NameFactory.getNewLastName());
		student.setId(createUniqueID().trim());
		
		int courses = rand.nextInt(3) + 3; // minimum 3, max 6
		
		MiniStudentCourseInfo[] infos = new MiniStudentCourseInfo[courses];
		miniBag.setMiniStudentInfo(infos);
		
		for(int i = 0; i < courses; i++) {
			Course course = CourseFactory.courses.get(rand.nextInt(CourseFactory.courses.size()-1));
			MiniStudentCourseInfo info = new MiniStudentCourseInfo();
			
			info.setCourseNumber(course.getCourseNumber());
			info.setCurrentLetterGrade(LetterGrade.values()[rand.nextInt(LetterGrade.values().length-1)]);
			info.setNumberOfCredits(course.getNumberOfCredits());
			info.setCurrentCourseStatus(StudentFactory.getCourseStatus());
			
			infos[i] = info;
		}
		
		student.setCurrentMajor(StudentFactory.createMajor());
		student.setGpa(StudentFactory.createGpa());
		student.setMiniStudentCourseBag(miniBag);
		
		bag.getPersonArray()[bag.getnElems()] = student;
		
		if(bag.getnElems() < bag.getPersonArray().length - 1) {
			bag.setnElems(bag.getnElems()+1);
		}
	}
	
	public static void createFaculty () {
		Faculty faculty = new Faculty();
		MiniFacultyCourseBag miniBag = new MiniFacultyCourseBag();
		
		faculty.setFirstName(NameFactory.getNewFirstName());
		faculty.setLastName(NameFactory.getNewLastName());
		faculty.setId(createUniqueID().trim());
		
		int courses = rand.nextInt(2) + 1; // minimum 1, max 3
		
		MiniFacultyCourseInfo[] infos = new MiniFacultyCourseInfo[courses];
		miniBag.setMiniFacultyCourseInfo(infos);
		
		for(int i = 0; i < courses; i++) {
			Course course = CourseFactory.courses.get(rand.nextInt(CourseFactory.courses.size()-1));
			MiniFacultyCourseInfo info = new MiniFacultyCourseInfo();
			
			info.setCourseNumber(course.getCourseNumber());
			info.setCourseTitle(course.getCourseTitle());
			info.setNumberOfCredits(course.getNumberOfCredits());
			info.setCurrentCourseStatus(FacultyFactory.getCourseStatus());
			
			infos[i] = info;
		}
		
		faculty.setCurrentTitle(FacultyFactory.createTitle());
		faculty.setCurrentDepartment(FacultyFactory.createDepartment());
		faculty.setOfficePhone(FacultyFactory.createPhone());
		faculty.setSalary(FacultyFactory.createSalary());
		faculty.setMiniFacultyCourseBag(miniBag);
		
		bag.getPersonArray()[bag.getnElems()] = faculty;
		
		if(bag.getnElems() < bag.getPersonArray().length - 1) {
			bag.setnElems(bag.getnElems()+1);
		}
	}
	
	public static String createUniqueID () {
		String realID = String.valueOf(++personCounter);
		
		while(realID.length() < 9) {
			realID = "0" + realID;
		}
		
		return realID;
	}
	
	public static Person getRandomPerson (String type) {
		Person person = null;
		
		while (person == null) {
			Person p = bag.getPersonArray()[rand.nextInt(bag.getPersonArray().length-1)];
			if (type.equals("Student")) {
				if(Student.class.isAssignableFrom((p).getClass())) {
					person = p;
				}
			} else if (type.equals("Faculty")) {
				if(Faculty.class.isAssignableFrom((p).getClass())) {
					person = p;
				}
			} else {
				System.out.println("uhh");
			}
		}
		
		return person;
	}
	
	public static Person getPersonByName (String name) {
		for(int i = 0; i < bag.getPersonArray().length - 2; i++) {
			Person p = bag.getPersonArray()[i];
			
			if(p.getFirstName().equals(name)) {
				return p;
			}
		}
		return null;
	}
	
	public static Person getPersonByID (int ID) {
		for(int i = 0; i < bag.getPersonArray().length - 2; i++) {
			Person p = bag.getPersonArray()[i];
			
			if(Integer.parseInt(p.getId()) == ID) {
				return p;
			}
		}
		return null;
	}

	public static void deleteByID(String id) {
		Person[] anotherArray = new Person[bag.getPersonArray().length - 1]; 
        
        for (int i = 0, k = 0; i < bag.getPersonArray().length; i++) {
  
            if (bag.getPersonArray()[i].toString().equals(id)) {
                continue;
            }
            
            anotherArray[k++] = bag.getPersonArray()[i]; 
        }
        
        bag.setPersonArray(anotherArray);
	}
}
