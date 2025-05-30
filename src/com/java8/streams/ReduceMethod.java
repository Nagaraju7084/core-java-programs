package com.java8.streams;

import java.util.Arrays;
import java.util.List;

public class ReduceMethod {

	public static void main(String[] args) {
		List<String> stringColletion = Arrays.asList("one", "two", "three");
		String result = stringColletion.stream().sorted().reduce((s1, s2) -> s1+"#"+s2).get();
		System.out.println(result);
	}

}
