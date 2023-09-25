package com.core.java;

public class CheckStrings {

	public static void main(String[] args) {
		String actual = "apple";
		String check1 = "aple";
		
		boolean status = checkStrings(actual, check1);
		System.out.println(status);
		
	}

	private static boolean checkStrings(String actual, String check1) {
		int i = 0;
		int j = 0;
		while(actual.length() > check1.length()){
			
			if(actual.charAt(i) == check1.charAt(j)) {
				i++;
				j++;
			}else if(actual.charAt(i) != check1.charAt(j)) {
				System.out.println("missing character : "+check1.charAt(j));
				i++;
			}
			return true;
		}
		return false;
	}

}
