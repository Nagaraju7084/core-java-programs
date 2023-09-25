package com.core.java;

import java.util.Arrays;

public class OddAndEvenArray {

	public static void main(String[] args) {
		int[] arr = {6,7,1,3,10,2};
		oddFirstThenEven(arr);
	}

	private static void oddFirstThenEven(int[] arr) {
		int begin = 0;
		int last = arr.length-1;
		for(int i=0; i<arr.length; i++) {
			/*
			 * if(arr[i]%2==0) { begin = arr[i]; }else { last = arr[i]; }
			 */
			if(arr[begin]>arr[last]) {
				int temp = arr[begin];
				arr[begin] = arr[last];
				arr[last] = temp;
			}
		}
		System.out.println(Arrays.toString(arr));
	}

}
