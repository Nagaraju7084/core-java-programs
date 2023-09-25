package com.java8.streams;

import java.util.Arrays;
import java.util.stream.IntStream;

public class SummingArrays {

	public static void main(String[] args) {
		int[] arr1 = {1,2,3,4,5,6};
		int[] arr2 = {4,5,6};
		int[] arr3 = {7,8,9,10,1,2};
		
		System.out.println(
				Arrays.toString (
								    IntStream.range(0,arr1.length)
								             .flatMap(x -> IntStream.range(0,arr2.length)
								            		 .flatMap(y -> IntStream.range(0,arr2.length).map(z -> arr1[x]+arr2[y]+arr3[z])
								            		 )
								             )
								             .toArray ()
			                   )
						);
		
	}

}
