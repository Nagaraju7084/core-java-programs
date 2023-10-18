package com.core.java;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//triplets meaning 3 elements whose sum is equal to given number
public class TripletsOfSumElementsArray74 {

	public static void main(String[] args) {
		//int[] arr = {1, 2 ,5, 0, 4, 3, 6};
		//int[] arr = {1, 2 ,5, 0, 3, 6, 7};
		//int[] arr = {23, -2, 45, 38, 12, 4, 6};
		int[] arr = {1, 6, 3, 0, 8, 4, 1, 7};
		int[] sortedArray = sortArray(arr);
		//boolean result = isConsecutiveArray(sortedArray);
		//boolean result = test(sortedArray);
		//boolean result = findGap(sortedArray);
		//boolean result = findTripletsForGivenSum(sortedArray);
		boolean result = findTripletsForGivenSumUsingPointers(sortedArray);
		if(result) {
			System.out.println("gap found"+result);
		}else {
			System.out.println("gap not found"+result);
		}
	}

	private static boolean findTripletsForGivenSumUsingPointers(int[] sortedArray) {
		int givenSum = 7;
		for(int i=0; i<=sortedArray.length-3; i++) {
			int k = givenSum - sortedArray[i];
			int lindex = i+1;
			int hindex = sortedArray.length - 1;
			while(lindex < hindex) {
				if(sortedArray[lindex] + sortedArray[hindex] < k) {
					lindex++;
				}else if(sortedArray[lindex] + sortedArray[hindex] > k){
					hindex--;
				}else {
					//print triplet
					System.out.println("("+sortedArray[i]+" "+sortedArray[lindex]+" "+sortedArray[hindex]+")");
					lindex++;
					hindex--;
				}
			}
		}
		return false;
	}

	private static boolean findTripletsForGivenSum(int[] sortedArray) {
		int givenSum = 7;
		int length = sortedArray.length;
		boolean foundDuplicate = false;
		for(int i=0; i<length-2; i++) {
			for(int j=i+1; j<length-1; j++) {
				for(int k=j+1; k<length; k++) {
					if(sortedArray[i]+sortedArray[j]+sortedArray[k] == givenSum) {
						int[] triplet = {sortedArray[i], sortedArray[j], sortedArray[k]};
						Arrays.sort(triplet);
						if(!foundDuplicate || !isDuplicate(triplet)) {
							System.out.println("(" + triplet[0] + " " + triplet[1] + " " + triplet[2] + ")");
						}
						foundDuplicate = true;
					}
				}
			}
		}
		if(!foundDuplicate) {
			System.out.println("no triplets found");
		}
		return true;
	}

	private static boolean isDuplicate(int[] triplet) {
		return triplet[0] == triplet[1] || triplet[1] == triplet[2];
	}

	private static boolean findGapUsingMath(int[] sortedArray) {
		int largestGap = 0;
		for(int i=0; i<sortedArray.length-1; i++) {
			largestGap = Math.max(sortedArray[i+1] - sortedArray[i], largestGap);
			System.out.println("largestGap = "+largestGap);
		}
		return false;
	}

	private static boolean findGap(int[] sortedArray) {
		int gap = 0;
		int largestGap = 0;
		for(int i=0; i<sortedArray.length-1; i++) {
				gap = sortedArray[i+1] - sortedArray[i];
				if(gap > largestGap) {
					largestGap = gap;
				}
				
		}
		System.out.println("the largest gap between the elements : "+largestGap);
		return true;
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
