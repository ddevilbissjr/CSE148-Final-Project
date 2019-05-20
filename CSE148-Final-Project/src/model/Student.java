package model;

import java.io.Serializable;

import utils.Chargeable;

public class Student extends Person implements Chargeable, Serializable {
	
	private Major major;

	private double gpa;
	private MiniStudentCourseBag miniStudentCourseBag;
	
	public double getGpa() {
		return gpa;
	}

	public void setGpa(double gpa) {
		this.gpa = gpa;
	}

	public MiniStudentCourseBag getMiniStudentCourseBag() {
		return miniStudentCourseBag;
	}

	public void setMiniStudentCourseBag(MiniStudentCourseBag miniStudentCourseBag) {
		this.miniStudentCourseBag = miniStudentCourseBag;
	}
	
	public Major getCurrentMajor() {
		return major;
	}

	public void setCurrentMajor(Major currentMajor) {
		this.major = currentMajor;
	}

	@Override
	public double chargeFood() {
		double totalCharge = 0.0;
		
		for(MiniStudentCourseInfo m : miniStudentCourseBag.getMiniStudentInfo()) {
			totalCharge += m.getNumberOfCredits() * 10.0;
		}
		
		return totalCharge;
	}

	@Override
	public double chargeTechnology() {
		if (major.equals(Major.CSE) || major.equals(Major.CST)) {
			return 5.0;
		}
		return 0.0;
	}

	@Override
	public double chargeActivities() {
		return 50.0;
	}

	@Override
	public double chargeOfficeUse() {
		return 0.0;
	}
}
