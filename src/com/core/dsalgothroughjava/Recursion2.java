package com.core.dsalgothroughjava;

public class Recursion2 {

	public static void main(String[] args) {
		int n = 1;
		printNumber(n);
	}

	private static void printNumber(int n) {
		if(n == 6)
			return;
		System.out.println(n);
		printNumber(n+1);
	}


}
