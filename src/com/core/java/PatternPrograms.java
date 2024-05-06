package com.core.java;

public class PatternPrograms {

	public static void main(String[] args) {
		for(int i=0; i<5; i++) {
			for(int j=0; j<=i; j++) {
				System.out.print(" * ");
			}
			System.out.println();
		}
		System.out.println("=====2nd========");
		for(int i=5; i>0; i--) {
			for(int j=0; j<=i; j++) {
				System.out.print(" * ");
			}
			System.out.println();
		}
		System.out.println("=====3rd========");
		for(int i=0; i<5; i++) {
			for(int j=0; j<5-i-1; j++) {
				System.out.print("  ");
			}
			for(int k=0; k<=i; k++) {
				System.out.print("* ");
			}
			System.out.println();
		}
		
	}

}
