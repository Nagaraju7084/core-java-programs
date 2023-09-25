package com.psystem;

public class Animal {

	void consume1(int a) {
		System.out.println(a+" consumed!!");
	}
	
	public static void consume(int a) {
		System.out.println("consumed static "+a);
	}
	
	public static void main(String[] args) {
		Animal a = new Animal();
		a.consume(10);
		Animal.consume(20);
	}
}
