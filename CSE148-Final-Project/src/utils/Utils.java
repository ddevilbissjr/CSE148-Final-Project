package utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import model.College;

public class Utils {
	public static void restore(College college) throws IOException, ClassNotFoundException {
		String fileName= "College.dat";
		FileInputStream fin = new FileInputStream(fileName);
		ObjectInputStream ois = new ObjectInputStream(fin);
		college = (College) ois.readObject();
		ois.close();
	}

	public static void backup(College college) throws IOException {
		String fileName= "College.dat";
	    FileOutputStream fos = new FileOutputStream(fileName);
	    ObjectOutputStream oos = new ObjectOutputStream(fos);
	    oos.writeObject(college);
	    oos.close();
	}
}
