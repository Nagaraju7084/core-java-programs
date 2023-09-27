package com.core.java.college270923;


//270923
public class College {
	
	private Student[] st;
	private int index;
	
	public College() {
		this.st = new Student[10]; //intial capacity/length
	}
	
	public void join(Student st) {
		this.st[index] = st;
		index++;
	}
	
	public static void main(String[] args) {
		College college = new College();
		
		college.join(new Student());
		college.join(new Student());
		college.join(new Student());
		college.join(new Student());
		college.join(new Student());
		college.join(new Student());
		college.join(new Student());
		college.join(new Student());
		college.join(new Student());
		college.join(new Student());
		
		System.out.println("students are stored");
		
		//college.join(new Student()); //index out of bounds
		//solution please go to College2.java file
		
	}
}

class Student{
	
}
