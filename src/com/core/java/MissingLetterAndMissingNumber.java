package com.core.java;

public class MissingLetterAndMissingNumber {

	public static void main(String[] args) {
		char[] charArray = {'a','b','d','e'};
		char missingLetter = findMissingLetter(charArray);
		System.out.println("missing letter in the given array is : "+missingLetter);
		
		int[] intArray = {1,2,4,5};
		//int missingNumber = findMissingNumber(intArray);
		//System.out.println("missin number in the given array is : "+missingNumber);
		
		String[] strArray = {"p", "r", "s", "t"};
		//String missingLetter = findMissingLetterFromStringArray(strArray);
		//System.out.println("missing letter in the given string array is : "+missingLetter);
	}

	private static String findMissingLetterFromStringArray(String[] strArray) {
		for(int i=0; i<strArray.length - 1; i++) {
			char currentLetter = strArray[i].charAt(0);
			char nextLetter = strArray[i+1].charAt(0);
			
			if(nextLetter - currentLetter != 1) {
				char missingLetter = (char) (currentLetter + 1);
				return String.valueOf(missingLetter);
			}
		}
		return null;
	}

	/*
	we should use int n = nums.length + 1 to represent the expected range of numbers. The length of the array nums.length represents the count of numbers actually present in the array, and adding 1 accounts for the missing number.
	For example, if we have an array of length 4, it means that the expected range of numbers should be from 1 to 5 (including the missing number). Therefore, we set n = 4 + 1 = 5 to represent the expected range.
	Once we have the expected range, we can calculate the total sum of numbers using the formula (n * (n + 1)) / 2. This ensures that we consider the missing number in the sum calculation.
	*/
	private static int findMissingNumber(int[] intArray) {
		int lengthOfArray = intArray.length + 1;
		int sumOfNumbers = (lengthOfArray * (lengthOfArray + 1)) / 2; 
		int sumOfArrayElements = 0;
		for(int num : intArray) {
			sumOfArrayElements = sumOfArrayElements + num;
		}
		return sumOfNumbers - sumOfArrayElements;
	}

	/*
	In Java, characters are represented internally as Unicode values. The subtraction of characters in Java returns the difference between their Unicode values, not the difference in their positions in the alphabet.
	To clarify, the difference between 'b' and 'a' is actually 1 in terms of their Unicode values, not their alphabetical positions. The Unicode value for 'b' is 98, and the Unicode value for 'a' is 97. So, 'b' - 'a' = 98 - 97 = 1.
	
	Inside the loop, we check if the difference between the next letter (letters[i+1]) and the current letter (letters[i]) is not equal to 1. If the difference is greater than 1, it indicates that a letter is missing.
	If a missing letter is found, we assign the missing letter to the missingLetter variable. We calculate the missing letter by adding 1 to the current letter.
	*/
	private static char findMissingLetter(char[] charArray) {
		char missingLetter = '\0';
		for(int i=0; i<charArray.length-1;i++) {
			if(charArray[i+1] - charArray[i] != 1) {
				missingLetter = (char) (charArray[i] + 1); //We calculate the missing letter by adding 1 to the current letter and converting to character
				break;
			}
		}
		return missingLetter;
	}

}
