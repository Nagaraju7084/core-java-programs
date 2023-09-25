package com.core.java;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortListStringLength {

	public static void main(String[] args) {

		List<String> stringList = Arrays.asList("abcd","ab","abc");
		String[] strArr = {"abcd","ab","abc"};
		
		sortStringListByLength(stringList);
		sortStringArrayByLength(strArr);

	}

	private static void sortStringArrayByLength(String[] strArr) {
		System.out.println("sorting array of strings");
		Arrays.sort(strArr, Comparator.comparing(String::length));
		Arrays.stream(strArr).forEach(System.out::println);
	}

	private static void sortStringListByLength(List<String> stringList) {
		System.out.println("sorting list of strings");
		Collections.sort(stringList, Comparator.comparing(String::length));
		stringList.forEach(System.out::println);
	}

}
