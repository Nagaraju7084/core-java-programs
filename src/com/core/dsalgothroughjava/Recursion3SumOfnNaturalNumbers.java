package com.core.dsalgothroughjava;

public class Recursion3SumOfnNaturalNumbers {

	public static void main(String[] args) {
		printSumNatural(1, 5, 0);
	}

	//sum of n natural number
	private static void printSumNatural(int i, int n, int sum) {
		if(i == n) {
			sum += i;
			System.out.println(sum);
			return;
		}
		sum += i;
		printSumNatural(i+1, n, sum);
	}


}
