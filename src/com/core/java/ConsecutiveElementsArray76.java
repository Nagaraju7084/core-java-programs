package com.core.java;

import java.util.Arrays;

public class ConsecutiveElementsArray76 {

	public static void main(String[] args) {
		//int[] arr = {1, 2 ,5, 0, 4, 3, 6};
		int[] arr = {1, 2 ,5, 0, 3, 6, 7};
		int[] sortedArray = sortArray(arr);
		//boolean result = isConsecutiveArray(sortedArray);
		boolean result = test(sortedArray);
		if(result) {
			System.out.println("consecutive numbers in the said array!"+result);
		}else {
			System.out.println("consecutive numbers in the said array!"+result);
		}
	}

	//we have to get 2nd index value by adding 1 to the 1st index value i.e. arr[0]+1 == arr[0+1], if not that is not consecutive array with difference 1
	private static boolean test(int[] sortedArray) {
		for(int i=0; i<sortedArray.length-1; i++) {
			if(sortedArray[i]+1 != sortedArray[i+1]) {
				return false;
			}
		}
		return true;
	}

	private static boolean isConsecutiveArray(int[] sortedArray) {
		
		for(int i=0; i<sortedArray.length-1; i++) {
			int firstElement = sortedArray[i];
			int secondElement = sortedArray[i+1];
			if((secondElement - firstElement) != 1) {
				return false;
			}
		}
		return true;
	}

	private static int[] sortArray(int[] arr) {
		for(int i=0; i<arr.length-1; i++) {
			for(int j=0; j<arr.length -i -1; j++) {
				if(arr[j]>arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
		System.out.println("sorted array is : "+Arrays.toString(arr));
		return arr;
	}

}
