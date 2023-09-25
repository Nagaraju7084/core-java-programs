package com.core.java;

public class countString1InString2 {

	public static void main(String[] args) {
		String str = "abdskfabcdkfabcakldjabc";
		String findStr = "abc";
		
		int lastIndex = 0;
		int count = 0;
		
		while(lastIndex != -1) {
			lastIndex = str.indexOf(findStr,lastIndex);
			if(lastIndex != -1) {
				count++;
				lastIndex = lastIndex + findStr.length();
			}	
		}
		System.out.println(count);
	}
	//System.out.println(StringUtils.countMatches(str, findStr));

}
