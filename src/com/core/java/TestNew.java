package com.core.java;

public class TestNew {

	public static void main(String[] args) {
		int[] intArr = { 7, 1, 4, 6, 3 };
		
		int minPrice = Integer.MAX_VALUE;
		int maxProfit = 0;
		
		for(int i=0; i<intArr.length; i++) {
			if(minPrice > intArr[i]) {
				minPrice = intArr[i];  
			}
			int potentialProfit = intArr[i] - minPrice; 
			if(potentialProfit > maxProfit) {
				maxProfit = potentialProfit;
			}
		}
		System.out.println(maxProfit);
	}

}