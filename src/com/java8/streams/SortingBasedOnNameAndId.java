package com.java8.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


public class SortingBasedOnNameAndId {

	public static void main(String[] args) {
		List<Student> studentList = Arrays.asList(new Student(1, "abc"),
				new Student(2, "def"),
				new Student(3, "ghi"),
				new Student(4, "abc"));
		
		System.out.println("before sorting list is\t:"+studentList);
		
		List<Student> respList = studentList.stream().sorted(
				Comparator.comparing(Student::getName)
				).sorted(
				Comparator.comparing(Student::getId)		
						).collect(Collectors.toList());
		
		System.out.println("after soring list is:\t"+respList);
	
	}
	
}

class Student{
	
	private int id;
	private String name;
	
	
	public Student(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + "]";
	}
	
	
}