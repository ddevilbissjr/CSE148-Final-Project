package model;

public class ClassroomBag {
	private Classroom[] classroomArray = new Classroom[50];
	private int nElems;
	
	public void setnElems(int nElems) {
		this.nElems = nElems;
	}
	public void setClassroomArray(Classroom[] c) {
		c = classroomArray;
	}
	public Classroom[] getClassroomArray() {
		return classroomArray;
	}
	public int getnElems() {
		return nElems;
	}
}
