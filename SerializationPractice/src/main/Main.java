package main;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Student student=new Student(10,"lokesh");
//		System.out.println(student);
//		
//		try {
//			ObjectOutputStream oos= new ObjectOutputStream(new FileOutputStream("file.ser"));
//			oos.writeObject(student);
//			oos.close();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
		try {
			ObjectInputStream ois=new ObjectInputStream(new FileInputStream("file.ser"));
			
			Student s=(Student)ois.readObject();
			System.out.println(s);
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
