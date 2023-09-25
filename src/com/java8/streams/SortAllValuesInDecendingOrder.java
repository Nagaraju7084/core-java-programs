package com.java8.streams;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SortAllValuesInDecendingOrder {

	public static void main(String[] args) {
		
		 List<Integer> myIntList = Arrays.asList(10,15,8,49,25,98,98,32,15);
		 
		 myIntList.stream().sorted(Collections.reverseOrder()).forEach(System.out::println);

	}

}
