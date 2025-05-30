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

	private static int binarySearch(int[] numbers, int searchElement) {
		int start = 0;
		int end = numbers.length-1;
		while(start <= end) {
			int mid = (start + end) / 2;
			if(searchElement == numbers[mid]) {
				System.out.println("middle");
				return mid;
			}
			if(searchElement < mid) {
				end = mid-1;
			}
			else if(searchElement > mid) {
				start = mid + 1;
			}else {
				return mid;
			}
		}
		return -1;
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
