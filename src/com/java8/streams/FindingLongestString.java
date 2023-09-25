package com.java8.streams;

import java.util.Arrays;

public class FindingLongestString {

	public static void main(String[] args) {
		String[] words = {"apple", "banana", "carrot", "dragonfruit"};
		
		String longestString = Arrays.stream(words).max(
				(s1, s2) -> Integer.compare(s1.length(), s2.length())).orElse("");
		System.out.println(longestString);
	}

}
