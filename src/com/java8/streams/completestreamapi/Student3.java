package com.java8.streams.completestreamapi;

public class Student3 implements Comparable<Student3>{
	
	private String name;
	private int score;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	
	public Student3(String name, int score) {
		super();
		this.name = name;
		this.score = score;
	}
	
	@Override
	public String toString() {
		return "Student3 [name=" + name + ", score=" + score + "]";
	}
	@Override
	public int compareTo(Student3 another) {
		return another.getScore() - this.score;
	}
	
}
