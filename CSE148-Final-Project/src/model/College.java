package model;

import utils.ClassroomFactory;
import utils.CourseFactory;
import utils.NameFactory;
import utils.PersonFactory;
import utils.TextbookFactory;

public class College {
	private PersonBag personBag;
	private TextbookBag textbookBag;
	private CourseBag courseBag;
	private ClassroomBag classroomBag;
	
	public College(int maxStudentBag, int maxFacultyBag, int maxTextbookBag, int maxClassroomBag) {
		NameFactory.readFirstNames(); 	//
		NameFactory.readLastNames(); 	// Necessary resources I need loaded in first.
		CourseFactory.createCourses();	//
		
		PersonFactory.createPeople("Student", maxStudentBag);
		PersonFactory.createPeople("Faculty", maxFacultyBag);
		
		TextbookFactory.createTextbook(maxTextbookBag);
		
		ClassroomFactory.createClassroom(maxClassroomBag);
		
		personBag = PersonFactory.bag;
		textbookBag = TextbookFactory.bag;
		courseBag = CourseFactory.bag;
		classroomBag = ClassroomFactory.bag;
	}

	public PersonBag getPersonBag() {
		return personBag;
	}

	public void setPersonBag(PersonBag personBag) {
		this.personBag = personBag;
	}

	public TextbookBag getTextbookBag() {
		return textbookBag;
	}

	public void setTextbookBag(TextbookBag textbookBag) {
		this.textbookBag = textbookBag;
	}

	public CourseBag getCourseBag() {
		return courseBag;
	}

	public void setCourseBag(CourseBag courseBag) {
		this.courseBag = courseBag;
	}

	public ClassroomBag getClassroomBag() {
		return classroomBag;
	}

	public void setClassroomBag(ClassroomBag classroomBag) {
		this.classroomBag = classroomBag;
	}
}
