package com.core.java;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PrimeOrNot {

	public static void main(String[] args) {
		List<Integer> intList = Arrays.asList(1,3,5,7,9,10);
		//System.out.println(intList.stream().filter(PrimeOrNot::isPrime).collect(Collectors.toList()));
		
		List<Integer> resList = intList.stream().filter(PrimeOrNot::isPrime).collect(Collectors.toList());
		resList.forEach(System.out::println);
	}
	
	public static boolean isPrime(int num) {
		for(int i=2; i<=num/2; i++) {
			if(num%i == 0) {
				return false;
			}
		}
		return true;
	}

}
