package com.core.java.college270923;

//270923
public class College2 {
	
	private MyCollection collection;
	
	public College2() {
		collection = new MyCollection();
	}
	
	public void add(Student2 st2) {
		collection.addObject(st2);
	}
	
	public int capacity() {
		return collection.capacity();
	}
	
	public int size() {
		return collection.size();
	}

	public static void main(String[] args) {
		College2 college = new College2();
		//at this point, the capacity and size
		System.out.println(college.capacity());
		System.out.println(college.size());
		college.add(new Student2());
		college.add(new Student2());
		college.add(new Student2());
		college.add(new Student2());
		college.add(new Student2());
		college.add(new Student2());
		college.add(new Student2());
		college.add(new Student2());
		college.add(new Student2());
		college.add(new Student2());
		
		System.out.println("students are stored");
		//at this point, the capacity and size
		System.out.println(college.capacity());
		System.out.println(college.size());
		
		college.add(new Student2());
		
		//at this point the capacity and the size
		System.out.println(college.capacity()); //20
		System.out.println(college.size()); //11
		System.out.println("new student is inserting and storing");
		
		
	}
}

class Student2{
	
}
