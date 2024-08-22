package com.core.dsalgothroughjava;

public class LinearSearch {

	public static void main(String[] args) {
		int[] intArr = {1,5,7,9,11,12,13,14,15};
		int searchKey = 7;
		int index = linearSerach(intArr, searchKey);
		System.out.println("element found at the index : "+index);
	}

	private static int linearSerach(int[] intArr, int searchKey) {
		for(int i=0; i<intArr.length; i++) {
			if(intArr[i] == searchKey) {
				return i;
			}
		}
		return -1;
	}

}
