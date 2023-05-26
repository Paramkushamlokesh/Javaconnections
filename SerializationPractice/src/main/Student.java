package main;

import java.io.Serializable;

public class Student implements Serializable{
		Integer roll;
		String name;
		public Student(Integer roll, String name) {
			this.roll = roll;
			this.name = name;
		}
		@Override
		public String toString() {
			return "Student [roll=" + roll + ", name=" + name + "]";
		}
		
}
