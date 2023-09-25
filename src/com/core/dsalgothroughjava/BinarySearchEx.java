package com.core.dsalgothroughjava;

public class BinarySearchEx {

	public static void main(String[] args) {
		int[] intArr = {1,5,7,9,11,12,13,14,15};
		int searchKey = 15;
		int start = 0;
		int end = intArr.length-1;
		int index = binarySearch(intArr, searchKey, start, end);
		System.out.println("element found at the index : "+index);
		
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
