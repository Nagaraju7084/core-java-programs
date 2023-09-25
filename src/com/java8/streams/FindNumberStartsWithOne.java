package com.java8.streams;

import java.util.Arrays;
import java.util.List;

public class FindNumberStartsWithOne {

	public static void main(String[] args) {

		//integer values
		List<Integer> myIntList = Arrays.asList(10,15,20,25);
		myIntList.stream()
				.map(s->s+"")//convert integer to string
				.filter(s->s.startsWith("1"))
				.forEach(System.out::println);
		System.out.println("====================");
		
		//string value
		
		List<String> myStringList = Arrays.asList("naga","raju","naga");
		myStringList.stream()
				//.map(s->s+"")//convert integer to string
				.filter(s->s.startsWith("n"))
				.forEach(System.out::println);
	}

}
