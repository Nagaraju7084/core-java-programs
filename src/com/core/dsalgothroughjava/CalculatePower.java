package com.core.dsalgothroughjava;

public class CalculatePower {

	public static void main(String[] args) {
		int x = 2, n = 5;
		int res = calculatePower(x, n);
		System.out.println(res);
	}

	private static int calculatePower(int x, int n) {
		if(n == 0) { //base case 1
			return 1;
		}
		if(x == 0) { //base case 2
			return 0;
		}
		int xPowernm1 = calculatePower(x, n-1); // kaam
		int xPowern = x * xPowernm1;
		return xPowern;
	}

}
