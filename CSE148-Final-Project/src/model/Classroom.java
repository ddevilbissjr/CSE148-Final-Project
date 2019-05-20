package model;

import java.io.Serializable;

public class Classroom  implements Serializable {
	private String roomNumber; // R304
	public enum roomBuilding { // Why is this even an option? If it can be found using roomNumber with the first initial? And WTH is NFL???????
		Riverhead,
		Islip,
		Smithtown,
		NFL
	}
	
	public String getClassroomNumber () {
		return roomNumber;
	}

	public void setClassroomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}
}
