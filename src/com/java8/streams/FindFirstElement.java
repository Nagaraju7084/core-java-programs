package com.java8.streams;

import java.util.Arrays;
import java.util.List;

public class FindFirstElement {

	public static void main(String[] args) {

		List<Integer> myIntList = Arrays.asList(10,15,8,49,25,98,98,32,15);
		
		myIntList.stream().findFirst().ifPresent(System.out::println);
		
	}

}
