package com.core.java;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

public class EvenOrOddThenDevide {

	public static void main(String[] args) {
		List<Integer> intList = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		
		//intList.stream().collect(Collectors.partitioningBy((i -> i%2 == 0) * 20))
		//List<Integer> listnew = intList.stream().filter(i -> i%2 ==0 * 20).filter(i -> i%2 != 0).collect(Collectors.toList());
		
		BigInteger result = intList.stream().filter(i -> i%2 == 0)
	    .map(BigInteger::valueOf)
	    .reduce(BigInteger.TEN, BigInteger::multiply).or(intList.stream().filter(i -> i%2 != 0).map(BigInteger::valueOf)
	    		.reduce(BigInteger.TEN, BigInteger::multiply));
		System.out.println(result);
		
	}

}
