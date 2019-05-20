package model;

import java.io.Serializable;

public class MiniStudentCourseInfo implements Serializable {
	
	private String courseNumber;
	private double numberOfCredits;
	private LetterGrade letterGrade;
	private StudentCourseStatus courseStatus;
	
	public LetterGrade getCurrentLetterGrade() {
		return letterGrade;
	}
	public void setCurrentLetterGrade(LetterGrade currentLetterGrade) {
		this.letterGrade = currentLetterGrade;
	}
	public StudentCourseStatus getCurrentCourseStatus() {
		return courseStatus;
	}
	public void setCurrentCourseStatus(StudentCourseStatus currentCourseStatus) {
		this.courseStatus = currentCourseStatus;
	}
	public String getCourseNumber() {
		return courseNumber;
	}
	public void setCourseNumber(String courseNumber) {
		this.courseNumber = courseNumber;
	}
	public double getNumberOfCredits() {
		return numberOfCredits;
	}
	public void setNumberOfCredits(double d) {
		this.numberOfCredits = d;
	}
	
	@Override
	public String toString () {
		return "[" + courseNumber + ": " + numberOfCredits + ", " + letterGrade.toString() + ", " + courseStatus.toString() + "]";
	}
}
