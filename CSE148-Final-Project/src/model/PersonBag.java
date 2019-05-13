package model;

public class PersonBag {
	private Person[] personArray;
	private int nElems;
	
	public Person[] getPersonArray() {
		return personArray;
	}
	public void setPersonArray(Person[] personArray) {
		this.personArray = personArray;
	}
	public int getnElems() {
		return nElems;
	}
	public void setnElems(int nElems) {
		this.nElems = nElems;
	}
}
