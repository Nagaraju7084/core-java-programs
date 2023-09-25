package com.core.java;

public class PolyndromeNumber {

	public static void main(String[] args) {
		boolean flag = isPolyndrome(121);
		if(flag)
			System.out.println("given number is polyndrome number");
		else
			System.out.println("given number is not polyndrome number");
	}
	
	private static boolean isPolyndrome(int num) {
		int originalNum = num;
		int reversedNum = 0;
		int remainder;
		
		while(num != 0) {
			remainder = num%10;
			reversedNum = reversedNum * 10 + remainder;
			num = num/10;
		}
		
		if(originalNum == reversedNum) {
			return true;
		}else {
			return false;
		}
	}

}
