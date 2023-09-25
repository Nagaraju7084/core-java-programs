package com.psystem;

public class Example {
	
	public static void main(String[] args) {
		
		int i = 200;
		
		//String s = String.valueOf(i);
		
		String s = "200";
		
		System.out.println(i+100); //300
		System.out.println(s+100); //200100
		System.out.println(i+100+s); //300200
		System.out.println(s+100+i); //200100200
		
	}
}
