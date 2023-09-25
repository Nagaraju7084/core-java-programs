package com.core.java;

//Java implementation of above approach
import java.util.ArrayList;
import java.util.List;

public class FrequencyCounterDescendingOrderUsingArray {
	// Driver Code
	public static void main(String[] args)
	{
		String str = "geeksforgeeks";
		printChar(str);
	}
	@SuppressWarnings("unchecked")
	// Function to print the characters
	// of the given string in decreasing
	// order of their frequencies
	public static void printChar(String str)
	{
		// Initializing array of List type.
		List<Character>[] arr = new List[str.length() + 1];
		for (int i = 0; i <= str.length(); i++) {
			// Initializing List of type Character.
			arr[i] = new ArrayList<>();
		}
		int[] freq = new int[256];
		// Mapking frequency map
		for (int i = 0; i < str.length(); i++) {
			freq[(char)str.charAt(i)]++;
		}
		// Traversing frequency array
		for (int i = 0; i < 256; i++) {
			if (freq[i] > 0) {
				// If frequency array is greater than zero
				// then storing its character on
				// i-th(frequency of that character) index
				// of arr
				arr[freq[i]].add(0, (char)(i));
			}
		}
		// Traversing arr from backwards as we need greater
		// frequency character first
		for (int i = 0; i < arr.length - 1; i++) {
			if (!arr[i].isEmpty()) {
				for (char ch : arr[i]) {
					System.out.println(ch + "-" + i);
				}
			}
		}
	}
}

