package com.core.java;

import java.util.HashSet;
import java.util.Set;

public class TestNew {

	public static void main(String[] args) {
		String str = "how are you doing today";
		char[] ch = str.toCharArray();

		// Map<Character, Integer> map = new HashMap<>();
		Set set = new HashSet();
		for (char c : ch) {
			if (set.contains(c)) {
				set.add(c);
			}
			System.out.println(set);

		}
	}
}