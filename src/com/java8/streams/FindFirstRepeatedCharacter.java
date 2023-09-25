package com.java8.streams;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindFirstRepeatedCharacter {

	public static void main(String[] args) {
		
		String input = "Java Hungry Blog Alive is Awesome";
		
		Map<Character, Long> map = input.chars()
				.mapToObj(s->Character.toLowerCase(Character.valueOf((char)s)))
				.collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));
		Character ch = map.entrySet()
			.stream()
			.filter(entry->entry.getValue() > 1L)
			.map(entry->entry.getKey())
			.findFirst()
			.get();
		System.out.println(ch);
	}

}
