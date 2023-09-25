package com.java8.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RemovingDuplicates {

	public static void main(String[] args) {
		List<Integer> intList = Arrays.asList(1,2,3,3,2,5,6);
		
		intList = intList.stream().distinct().collect(Collectors.toList());
		System.out.println(intList);
	}

}
