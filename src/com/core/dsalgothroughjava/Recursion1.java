package com.core.dsalgothroughjava;

public class Recursion1 {

	public static void main(String[] args) {
		int n = 5;
		printNumber(n);
	}

	private static void printNumber(int i) {
		if(i==0)
			return;
		System.out.println(i);
		printNumber(i-1);
	}

}
