package com.core.java;

import java.util.Arrays;

public class Testing {

	public static void main(String[] args) {
		int arr1[] = {1 ,3, 5, 7} ;
		int arr2[] = {0, 2, 6, 8, 9};
		System.out.println("after swaping");
		arrangeArrayInascendingOrder(arr1, arr2);
	}

	private static void arrangeArrayInascendingOrder(int[] arr1, int[] arr2) {
		for(int i=0; i<arr1.length; i++) {
			for(int j=0; j<arr2.length; j++) {
				if(arr1[i]>arr2[j]) {
					int temp = arr1[i];
					arr1[i] = arr2[j];
					arr2[j] = temp;
				}
			}
		}
		System.out.println(Arrays.toString(arr1));
		//Arrays.sort(arr2);
		System.out.println(Arrays.toString(arr2));
	}

}
