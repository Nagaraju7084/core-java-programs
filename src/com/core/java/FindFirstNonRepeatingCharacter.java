package com.core.java;

public class FindFirstNonRepeatingCharacter {

	public static void main(String[] args) {
		
		String str = "teeter";
		
		for(char ch : str.toCharArray()) {
			if(str.indexOf(ch) == str.lastIndexOf(ch)) {
				System.out.println(ch);
			}
		}

	}

}
