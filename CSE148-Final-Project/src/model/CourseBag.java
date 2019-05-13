package model;

public class CourseBag {
	private Course[] courseArray = new Course[1000];
	private int nElems;
	
	public Course[] getCourseArray() {
		return courseArray;
	}
	public void setCourseArray(Course[] courseArray) {
		this.courseArray = courseArray;
	}
	public int getnElems() {
		return nElems;
	}
	public void setnElems(int nElems) {
		this.nElems = nElems;
	}
}
