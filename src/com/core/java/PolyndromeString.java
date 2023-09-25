package com.core.java;

public class PolyndromeString {

	public static void main(String[] args) {

		String str = "ab";
		System.out.println(isPolyndrome(str));
	}

	private static boolean isPolyndrome(String str) {
		String reverse = "";
		boolean flag = false;
		for(int i = str.length()-1; i>=0; i--) {
			reverse = reverse + str.charAt(i);
			if(reverse.equals(str)) {
				flag = true;
			}
		}
		if(flag) {
			return true;
		}else {
			return false;
		}
		
	}

}
