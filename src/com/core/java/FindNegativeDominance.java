package com.core.java;

import java.util.Arrays;

public class FindNegativeDominance {

	public static void main(String[] args) {
		int[] intArray = {1, -2, -5, -4, 3, -6};
		
		//boolean result = checkArrayIsNegativeDominance(intArray);
		boolean result = checkArrayIsNegativeDominanceUsingStream(intArray);
		if(result) {
			System.out.println("is the given array Negative Dominance : "+result);
		}else {
			System.out.println("is the given array Positive Dominance : "+result);
		}
		
	}

	private static boolean checkArrayIsNegativeDominanceUsingStream(int[] intArray) {
		//using java8 stream api
		intArray = Arrays.stream(intArray).distinct().toArray();
		long negativeCount, positiveCount;
		negativeCount = Arrays.stream(intArray).filter(n -> n < 0).count();
		positiveCount = Arrays.stream(intArray).filter(n -> n > 0).count();
		
		return negativeCount > positiveCount;
	}

	private static boolean checkArrayIsNegativeDominance(int[] intArray) {
		int negativeCount = 0;
		int positiveCount = 0;
		/*
		 * for(int i=0; i<intArray.length; i++) { if(intArray[i] < 0) { negativeCount++;
		 * }else if(intArray[i] > 0) { positiveCount++; } }
		 */
		//using for each loop
		for(int num : intArray) {
			if(num < 0) {
				negativeCount++;
			}else if(num > 0) {
				positiveCount++;
			}
		}
		return negativeCount > positiveCount;
	}
	
}
