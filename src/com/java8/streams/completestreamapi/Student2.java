package com.java8.streams.completestreamapi;

import java.util.HashSet;
import java.util.Set;

public class Student2 {
	
	private int id;
	private String name;
	private String email;
	private Set<String> bookSet = new HashSet<>();
	
	public Set<String> getBookSet() {
		return bookSet;
	}

	public void setBookSet(Set<String> bookSet) {
		this.bookSet = bookSet;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", email=" + email + "]";
	}

	public Student2(int id, String name, String email, Set<String> bookSet) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.bookSet = bookSet;
	}
	
}
