package com.core.java;

public class ArraySortAndSearch {

	private static int searchArray(int[] arr, int key) {
		
		for(int i=0; i<arr.length; i++) {
			if(arr[i] == key) {
				return i;
			}
		}
		
		return -1;
	}
	
	public static void main(String[] args) {
		
		int[] arr = {2,3,7,1,5,9,4};
		
		System.out.println("before sorting");
		System.out.println("array elements are ");
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
		//before search array elements should be sort
		//bubble sort
		for(int i=0; i<arr.length -1; i++) {
			for(int j=0; j<arr.length -i -1; j++) {
				if(arr[j]>arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
		//Arrays.sort(arr);
		
		System.out.println("after sorting");
		System.out.println("array elements are ");
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
		System.out.println("length of an array is : "+arr.length);
		int valueAtIndex = searchArray(arr, 5);
		
		if(valueAtIndex == -1) {
			System.out.print("element not found");
		}else {
			System.out.print("element found at the index: "+valueAtIndex);
		}

	}
	
}
