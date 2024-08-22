package com.core.dsalgothroughjava;

public class BinarySearchEx {

	static int[] intArr = {1,5,7,9,11,12,13,14,15};
	static int searchKey = 15;
	
	public static void main(String[] args) {
		
		int start = 0;
		int end = intArr.length-1;
		
		int index = binarySearch(intArr, searchKey, start, end);
		System.out.println("element found at the index : "+index);
		
		//without recursion
		int index2 = binarySearch(intArr, searchKey);
		System.out.println("element found at the index : "+index);
		
	}

	private static int binarySearch(int[] intArr, int searchKey) {
		
		int start = 0;
		int end = intArr.length-1;
		
		while(start <= end) {
			int middle = start + (end - start) / 2;
			int value = intArr[middle];
			System.out.println("middle : " + value);
			if(value < searchKey) 
				start = middle + 1;
			else if(value > searchKey) 
				end = middle - 1;
			else return middle; //target found
		}
		return -1; //target not found
	}

	private static int binarySearch(int[] intArr, int searchKey, int start, int end) {
		
		int mid = 0;
		 
		 if(start <= end) {
			 mid = (start+end)/2;
		 }
		 if(searchKey == intArr[mid]) {
			 return mid;
		 }else if(searchKey < intArr[mid]) {
			 return binarySearch(intArr, searchKey, start, mid-1);
		 }else {
			 return binarySearch(intArr, searchKey, mid+1, end);
		 }
	}
}
