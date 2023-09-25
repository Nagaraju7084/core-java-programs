package com.java8.streams;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindFirstNonRepeatedCharacter {

	public static void main(String[] args) {
		
		String input = "Java Hungry Blog Alive is Awesome";
		
		Map<Character, Long> map = input.chars()
				.mapToObj(s -> Character.toLowerCase(Character.valueOf((char)s)))
				.collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));
		Character ch = map.entrySet()
			.stream()
			.filter(entry->entry.getValue()==1L)
			.map(entry->entry.getKey())
			.findFirst()
			.get();
		System.out.println(ch);
		
		//second approach
		
		for(char i : input.toCharArray()) {
			if(input.indexOf(i) == input.lastIndexOf(i)) {
				System.out.println("first non repeated character:\t"+i);
				break;
			}
		}
		
		char nonRepeatedCharacter = firstNonRepeatedCharacter(input);
		char nonRepeatedCharacter2 = firstNonRepeatedCharacter2(input);
		char nonRepeatedCharacter3 = firstNonRepeatedCharacter3(input);
		//System.out.println("nonRepeatedCharacter:\t" +nonRepeatedCharacter);
		//System.out.println("nonRepeatedCharacter2:\t" +nonRepeatedCharacter2);
		System.out.println("nonRepeatedCharacter3:\t" +nonRepeatedCharacter3);
	}

	//third approach
	private static Character firstNonRepeatedCharacter(String input) {
		Map<Character, Integer> characterMap = new LinkedHashMap<>();
		//scan the string and build hashmap
		for(int i=0; i<input.length(); i++) {
			Character ch = input.charAt(i);
			if(characterMap.containsKey(ch)) {
				//increment count corresponding to ch
				characterMap.put(ch, characterMap.get(ch)+1);
			}else {
				characterMap.put(ch, 1);
			}
		}
		for(Entry<Character, Integer> entry : characterMap.entrySet()) {
			if(entry.getValue() == 1) {
				return entry.getKey();
			}
		}
		return null;
	}
	
	//fourth approach
	private static char firstNonRepeatedCharacter2(String input) {
		List<Character> charList = new ArrayList<>();
		for(int i=0; i<input.length(); i++) {
			char letter = input.charAt(i);
			if(charList.contains(letter)) {
				charList.remove((Character)letter);
				charList.add(letter);
			}else {
				charList.add(letter);
			}
		}
		return charList.get(0);
	}
	
	//fifth approach
	private static char firstNonRepeatedCharacter3(String input) {
		Map<Character, Integer> map = new LinkedHashMap<>();
		for(Character character : input.toCharArray()) {
			map.put(character, map.containsKey(character) ? map.get(character)+1 : 1);
		}
		return map.entrySet().stream().filter(ele -> ele.getValue() == 1).findFirst().get().getKey();
	}
}
