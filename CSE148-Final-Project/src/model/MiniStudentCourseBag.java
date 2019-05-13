package model;

public class MiniStudentCourseBag {
	private MiniStudentCourseInfo[] miniStudentInfo;
	private int nElems;
	
	public MiniStudentCourseInfo[] getMiniStudentInfo() {
		return miniStudentInfo;
	}
	public void setMiniStudentInfo(MiniStudentCourseInfo[] miniStudentInfo) {
		this.miniStudentInfo = miniStudentInfo;
	}
	public int getnElems() {
		return nElems;
	}
	public void setnElems(int nElems) {
		this.nElems = nElems;
	}
	@Override
	public String toString () {
		String s = "";
		
		for(int i = 0; i < miniStudentInfo.length; i++) {
			s += miniStudentInfo[i].toString();
		}
		
		return s;
	}
}
