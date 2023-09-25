package com.core.java;

public class OneDimensionalArrayAndTwoDimensionalArrayEx {

	public static void main(String[] args) {
		
		int[] arr = new int[8];
		
		int count = 1;
		
		//testing
		//int iin = 09;
		//one dimensional array intialization
		for(int i=0; i<arr.length; i++) {
			
			arr[i] = count;
			count++;
		}
		
		for(int i=0; i<arr.length; i++) {
			//System.out.print(arr[i]+" ");
		}
		
		count = 1;
		
		int[][] twoArr = new int[3][4];
		
		//two dimensional array intialization
		for(int i=0; i<twoArr.length; i++){
			for(int j=0; j<twoArr[i].length; j++) {
				twoArr[i][j] = count;
				count++;
			}
		}
		
		//display two dimensional array intialization
		for(int i=0; i<twoArr.length; i++) {
			for(int j=0; j<twoArr[i].length; j++) {
				System.out.print(twoArr[i][j]+" ");
			}
		}
		
	}
	
}
