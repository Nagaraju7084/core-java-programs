package com.java8.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindDuplicateNumber {

	public static void main(String[] args) {
		
		List<Integer> myIntList = Arrays.asList(10,15,20,15,70,70);
		
		Set<Integer> myIntSet = new HashSet<>();
		myIntList.stream()
				.filter(i->!myIntSet.add(i))
				.forEach(System.out::println);
		
		System.out.println("============");
		convertListToArrayAndFindDuplicateNumber(myIntList);
		summingArrayElements();

	}
	
	private static void summingArrayElements() {
		int[] arr = {10,15,20};
		int sum = 0;
		for(int i=0; i<arr.length; i++) {
			sum = sum + arr[i];
		}
		System.out.println("sum of array elements:\t"+sum);
	}

	private static void convertListToArrayAndFindDuplicateNumber(List<Integer> li) {
		
		int[] arr = new int[li.size()];
		
		for(int i=0; i<li.size(); i++) {
			arr[i] = li.get(i);
		}
		
		Set<Integer> set = new HashSet<>();
		List<Integer> duplicates = new ArrayList<>();
		for(int i=0; i<arr.length; i++) {
			if(!set.add(arr[i])) {
				System.out.println(arr[i]);
				duplicates.add(arr[i]);
			}
		}
		System.out.println("elements in set:\t"+set);
		System.out.println("elements in arr:\t"+Arrays.toString(arr));
		System.out.println("duplicate elements in list:\t"+duplicates);
	}

}
