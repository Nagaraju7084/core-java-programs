package com.core.dsalgothroughjava;

public class NFactorial {

	public static void main(String[] args) {
		int n = 5;
		int res = calculateFactorial(n); //5x4x3x2x1
		System.out.println(res);
	}

	private static int calculateFactorial(int n) {
		if(n == 1 || n == 0) {
			return 1;
		}
		int nm1_factorial = calculateFactorial(n-1);
		int n_factorial = n * nm1_factorial;
		return n_factorial;
	}
	

}
