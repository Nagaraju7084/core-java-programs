package com.core.java;

public class ReverseString {

	public static void main(String[] args) {
		String str = "hai";
		int length = str.length();
		
		while(length > 0) {
			System.out.print(str.charAt(length-1));
			length--;
		}
	}

}
