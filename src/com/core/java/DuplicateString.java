package com.core.java;

public class DuplicateString {

	public static void main(String[] args) {

		String str = "i am am string class";
		String[] strArr = str.split(" ");
		
		for(int i=0; i<strArr.length-1; i++) {
			if(strArr[i].equals(strArr[i+1])) {
				System.out.println("duplicate string : "+strArr[i]);
			}
		}
		
	}

}
