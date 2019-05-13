package model;

public class MiniFacultyCourseBag {
	private MiniFacultyCourseInfo[] miniFacultyCourseInfo;
	private int nElems;

	public MiniFacultyCourseInfo[] getMiniFacultyCourseInfo() {
		return miniFacultyCourseInfo;
	}

	public void setMiniFacultyCourseInfo(MiniFacultyCourseInfo[] miniFacultyCourseInfo) {
		this.miniFacultyCourseInfo = miniFacultyCourseInfo;
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
		
		for(int i = 0; i < miniFacultyCourseInfo.length; i++) {
			s += miniFacultyCourseInfo[i].toString();
		}
		
		return s;
	}
}
