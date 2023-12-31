package com.java8.streams.completestreamapi;

public class Author {

	private String name;
	private String email;
	private int age;
	private char gender;
	
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public Author(String name, String email, int age, char gender) {
		super();
		this.name = name;
		this.email = email;
		this.age = age;
		this.gender = gender;
	}
	
	@Override
	public String toString() {
		return "Author [name=" + name + ", email=" + email + ", age=" + age + ", gender=" + gender + "]";
	}
	
}
