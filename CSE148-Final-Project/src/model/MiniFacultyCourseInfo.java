package model;

public class MiniFacultyCourseInfo {
	
	private FacultyCourseStatus courseStatus;
	private String courseNumber;
	private String courseTitle;
	private double numberOfCredits;
	
	public FacultyCourseStatus getCurrentCourseStatus() {
		return courseStatus;
	}
	public void setCurrentCourseStatus(FacultyCourseStatus currentCourseStatus) {
		this.courseStatus = currentCourseStatus;
	}
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
	public double getNumberOfCredits() {
		return numberOfCredits;
	}
	public void setNumberOfCredits(double d) {
		this.numberOfCredits = d;
	}
	@Override
	public String toString () {
		return "[" + courseNumber + ": " + courseTitle + ", " + numberOfCredits + ", " + courseStatus + "]";
	}
}
