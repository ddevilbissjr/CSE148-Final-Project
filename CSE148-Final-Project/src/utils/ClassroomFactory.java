package utils;

import java.util.Random;

import model.Classroom;
import model.ClassroomBag;

public class ClassroomFactory {
	
	public static ClassroomBag bag = new ClassroomBag();
	
	public static void createClassroom (int howMany) {
		for(int i = 0; i < howMany; i++) {
			Classroom classroom = new Classroom();
			
			classroom.setClassroomNumber(newClassroomNum());
			
			bag.getClassroomArray()[bag.getnElems()] = classroom;
			if(bag.getnElems() < bag.getClassroomArray().length - 1) {
				bag.setnElems(bag.getnElems()+1);
			}
		}
	}
	
	public static String newClassroomNum () {
		String s = "";
		Random rand = new Random();
		
		switch (rand.nextInt(Classroom.roomBuilding.values().length - 1)) {
		case 0:
			s += "R";
			break;
		case 1:
			s += "I";
			break;
		case 2:
			s += "S";
			break;
		case 3:
			s += "N";
			break;
		}
		
		s += rand.nextInt(3); // floor number, max 3 floors
		
		int num = rand.nextInt(20); // classrooms per floor, max 20
		
		if(num < 10) {
			s += "0" + num;
		} else {
			s += num;
		}
		
		return s;
	}
	
	public static Classroom getClassroomByRoomNum (String str) {
		Classroom classroom = null;
		for(Classroom c : bag.getClassroomArray()) {
			if(c.getClassroomNumber().equals(str)) {
				classroom = c;
				break;
			}
			System.out.println("Classroom not found.");
		}
		return classroom;
	}
	
	public static void getClasses () {
		System.out.print("Classrooms: ");
		for(int i = 0; i < bag.getClassroomArray().length; i++) {
			if(i < bag.getClassroomArray().length - 1) {
				System.out.print(bag.getClassroomArray()[i].getClassroomNumber() + ", ");
			} else {
				System.out.println(bag.getClassroomArray()[i].getClassroomNumber() + ".");
			}
		}
	}

	public static void deleteByRoomNumber(String classroomNumber) {
        Classroom[] anotherArray = new Classroom[bag.getClassroomArray().length - 1]; 
        
        for (int i = 0, k = 0; i < bag.getClassroomArray().length; i++) { 
  
            if (bag.getClassroomArray()[i].getClassroomNumber().equals(classroomNumber)) { 
                continue; 
            } 
            
            anotherArray[k++] = bag.getClassroomArray()[i]; 
        }
        
        bag.setClassroomArray(anotherArray);
	}
}
