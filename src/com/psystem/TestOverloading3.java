package com.psystem;

class Adder {
	
	public static int add(int a, int b) {
		return a+b;
	}
	
	float add1(int c, int d) {
		return c+d;
	}
}

public class TestOverloading3{
	public static void main(String[] args) {
		System.out.println(Adder.add(11,11));
	}
}

