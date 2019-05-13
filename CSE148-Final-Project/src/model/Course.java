package model;

public class Course {
	private String courseNumber;
	private String courseTitle;
	private String courseDescription;
	private double numberOfCredits;
	
	public String getCourseNumber() {
		return courseNumber;
	}
	public void setCourseNumber(String courseNumber) {
		this.courseNumber = courseNumber;
	}
	public String getCourseTitle() {
		return courseTitle;
	}
	public void setCourseTitle(String courseTitle) {
		this.courseTitle = courseTitle;
	}
	public String getCourseDescription() {
		return courseDescription;
	}
	public void setCourseDescription(String courseDescription) {
		this.courseDescription = courseDescription;
	}
	public double getNumberOfCredits() {
		return numberOfCredits;
	}
	public void setNumberOfCredits(double numberOfCredits) {
		this.numberOfCredits = numberOfCredits;
	}
}
