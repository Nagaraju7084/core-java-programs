package com.core.java;

//Java implementation of the approach
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class FrequencyCounterDescendingOrderUsingMap {

//Function to print the characters
//of the given String in decreasing
//order of their frequencies
	static void printChar(char[] arr, int len) {

		// To store the
		HashMap<Character, Integer> occ = new HashMap<Character, Integer>();
		for (int i = 0; i < len; i++)
			if (occ.containsKey(arr[i])) {
				occ.put(arr[i], occ.get(arr[i]) + 1);
			} else {
				occ.put(arr[i], 1);
			}

		// Map's size
		int size = occ.size();
		
		// While there are elements in the map
		while (size-- > 0) {

			// Finding the maximum value
			// from the map
			/*
			 * int currentMax = 0; char arg_max = 0; for (Map.Entry<Character, Integer> it :
			 * occ.entrySet()) { if (it.getValue() > currentMax || (it.getValue() ==
			 * currentMax && it.getKey() > arg_max)) { arg_max = it.getKey(); currentMax =
			 * it.getValue(); } }
			 */
			Entry<Character, Integer> min = null;
		    for (Entry<Character, Integer> entry : occ.entrySet()) {
		        if (min == null || min.getValue() > entry.getValue()) {
		            min = entry;
		        }
		    }
			// Print the character
			// alongwith its frequency
			//System.out.print(arg_max + " - " + currentMax + "\n");
		    System.out.print(min.getKey() + " - " + min.getValue() + "\n");

			// Delete the maximum value
			//occ.remove(arg_max);
		    occ.remove(min.getKey());
		}
	}

//Driver code
	public static void main(String[] args) {
		String str = "abbbccddddefffff";
		int len = str.length();

		printChar(str.toCharArray(), len);
	}
}

//This code is contributed by gauravrajput1
