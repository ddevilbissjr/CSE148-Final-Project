package model;

import java.io.Serializable;
import java.text.DecimalFormat;

import utils.Chargeable;

public class Faculty extends Person implements Chargeable, Serializable {
	
	private double salary;
	private String officePhone;
	private MiniFacultyCourseBag miniFacultyCourseBag;
	private Title title;
	private Department department;
	
	public Title getCurrentTitle() {
		return title;
	}
	public void setCurrentTitle(Title currentTitle) {
		this.title = currentTitle;
	}
	public Department getCurrentDepartment() {
		return department;
	}
	public void setCurrentDepartment(Department currentDepartment) {
		this.department = currentDepartment;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public String getOfficePhone() {
		return officePhone;
	}
	public void setOfficePhone(String officePhone) {
		this.officePhone = officePhone;
	}
	public MiniFacultyCourseBag getMiniFacultyCourseBag() {
		return miniFacultyCourseBag;
	}
	public void setMiniFacultyCourseBag(MiniFacultyCourseBag miniFacultyCourseBag) {
		this.miniFacultyCourseBag = miniFacultyCourseBag;
	}
	@Override
	public double chargeFood() {
		double totalCharge = 0.0;
		
		for(MiniFacultyCourseInfo m : miniFacultyCourseBag.getMiniFacultyCourseInfo()) {
			totalCharge += m.getNumberOfCredits() * 10.0;
		}
		
		return totalCharge;
	}
	@Override
	public double chargeTechnology() {
		return 0.0;
	}
	@Override
	public double chargeActivities() {
		return 0.0;
	}
	@Override
	public double chargeOfficeUse() {
		DecimalFormat df = new DecimalFormat("0.00");
		return Double.parseDouble(df.format(0.01 * salary));
	}
}
