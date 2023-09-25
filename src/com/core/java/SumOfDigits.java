package com.core.java;

public class SumOfDigits {

	public static void main(String[] args) {
		int number = 84271;
		int sum = calSumOfDigits(number);
		System.out.println(sum);
	}

	private static int calSumOfDigits(int number) {
		int sum = 0;
		while(number != 0) {
			int digit = number%10;
			sum = sum + digit;
			number = number/10;
		}
		return sum;
	}

}
