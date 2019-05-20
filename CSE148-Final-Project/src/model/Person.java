package model;

import java.io.Serializable;

import utils.Chargeable;

public abstract class Person implements Chargeable, Serializable {
	private String firstName; 
	private String lastname; 
	private String id;
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastname;
	}
	public void setLastName(String lastname) {
		this.lastname = lastname;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public double chargeParking() {
		return 20.00;
	}
}
