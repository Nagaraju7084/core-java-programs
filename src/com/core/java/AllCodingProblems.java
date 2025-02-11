package com.core.java;

import java.lang.reflect.Field;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AllCodingProblems {

	public static void main(String[] args) {
		//findSecondElementWhoseSumEqualToM();
		//swapArrayElementsWithoutUsing3rdOrTempVariable();
		//isArrayAlternatePositiveNegative();
		//HospitalComposition.composition();
		//Patient.aggregation();
		//Nurse.isARelation();
		//Record.immutableClass();
		//findMissingNumberInArrayUsingBinarySearch();
		//findMissingNumberInArrayUsingSumOfNaturalNumbers();
		//findFibonacciNumber();
		//returnListOfStringUsingStreams();
		//linkedListOperations();
		//countSubStringInAGivenStringOrCheckString1InString2();
		//findTheLeaderElementIntheArray();
		//findNonRepeatedCharacterInAString();
		//findNumberStartwithOneInGivenIntList();
		//attachMessageToRandomNumberAndReturn();
		//testingIntegersRange();
		//cosecutiveElementsInArray76();
		//findGapInArrayIntegerElements75();
		//findMaxOccurenceOfCharInString();
		//extractingPartOfStringFromAGivenString();
		//reverseStringWords();
		//reverseCharactersInAString();
		//lenghtOfStringWithoutUsingPredefinedMethod();
		//findUniqueWords();
		//findFirstUniqueCharFromString();
		//findUniqueCharsFromString();
		//findMissingCharacterInString();
		//countingZeorsInArray();
		//findeSecondRepeatedCharacterInGivenString();
		//findDuplicateWordInGivenString();
		//evenMultiplyOddDivide();
		//findNegativeDominanceInArray();
		//findNoneZeroNumbersInArray();
		//missingLetterAndMissingNumber();
		//oddFirstThenEvenFromArray();
		//isPalindromeNumber();
		//isPalindromeString();
		//primeOrNotFromArray();
		//reverseCharArray();
		//findFactorialOfNumber();
		//primeFactorsOfNumber();
		//findDuplicateNumberInList();
		//findEvenNumbersAndAddFromList();
		//findTheMostBookedRooms();
		//findMinElementFromArray();
		//findMaxElementFromArray();
		//findAverageFromArray();
		//findNumberOfOccurencesOfElementInArray();
		//findProfitOfStocks();
		//joiningStringsInList();
		//summingNnumbers();
		//sortListInAscendingAndDescendingOrderAndFindMaxNumber();
		//averageMarksOfStudentFrom2dArray();
		//searchGivenStringBasedOnCharactersGivenInTheDropdown();
		findSecondHighestElementFromList();
		
	}
	
	private static void findSecondHighestElementFromList() {
		List<Integer> list = Arrays.asList(1,4,7,3,8,2);
		int second = list.stream().sorted((a,b) -> b.compareTo(a)).skip(1).findAny().get();
		System.out.println("second highest element = "+ second);
		
	}

	private static void searchGivenStringBasedOnCharactersGivenInTheDropdown() {
		//camera, mobile, charger, laptop, keyboard, mouse, computer, coocker, calculator
		//if type c in dropdown only at most 3 products start with c will come and those are in lexicographical order
		//lexicographical order means for example
		//camera, charger, computer => these three products 
	}

	private static void averageMarksOfStudentFrom2dArray() {
		String[][] grades = { 
				{ "Rohit", "85" },
				{ "Rahul", "80" },
				{ "Amit", "85" },
				{ "Rohit", "90" } 
			};
		
		String[] students = new String[grades.length];
		int[] totalMarks = new int[grades.length];
		int[] count = new int[grades.length];
		int studentCount = 0;
		
		for(int i=0; i<grades.length; i++) {
			
			String name = "";
			int marks = 0;
			
			//dynamically access the elements
			for(int j=0; j<grades[i].length; j++) {
				if(j==0) {
					name = grades[i][j];
				}else {
					marks = Integer.parseInt(grades[i][j]);
				}
			}
			
			//check if the student already exists in our array
			boolean studentExists = false;
			for(int k=0; k<studentCount; k++) {
				if(students[k].equals(name)) {
					totalMarks[k] += marks;
					count[k]++;
					studentExists = true;
					break;
				}
			}
			
			//if the student doesn't exist, add them to the array
			if(!studentExists) {
				students[studentCount] = name;
				totalMarks[studentCount] = marks;
				count[studentCount] = 1;
				studentCount++;
			}
			
		}// end of outer for loop
		
		//calculate and print the average marks only for those students with more than one entry
		for(int i=0; i<studentCount; i++) {
			if(count[i] > 1) {
				double averageMarks = totalMarks[i] / count[i];
				System.out.println("student : " + students[i] + "\naverage marks : " + averageMarks);
			}
		}
	}

	private static void sortListInAscendingAndDescendingOrderAndFindMaxNumber() {
		List<Integer> intList = Arrays.asList(6,8,2,5,4,1);
		//default => ascending order
		List<Integer> sortedNumbers = intList.stream().sorted().collect(Collectors.toList());
		System.out.println(sortedNumbers);
		
		//descending order
		List<Integer> descendinOrderNumbers = intList.stream().sorted((a,b) -> b.compareTo(a)).collect(Collectors.toList());
		System.out.println(descendinOrderNumbers);
		
		int maxNumber = intList.stream().max(Integer::compareTo).get();
		System.out.println(maxNumber);
	}

	private static void summingNnumbers() {
		int n = 5; //5+4+3+2+1
		int sum = IntStream.rangeClosed(1, n).sum();
		System.out.println(sum);
	}

	private static void joiningStringsInList() {
		List<String> listOfStrings = Arrays.asList("apple", "banana", "mango");
		String resultString = listOfStrings.stream().collect(Collectors.joining(","));
		System.out.println(resultString);
	}

	private static void findProfitOfStocks() {
		int[] intArr = { 7, 1, 4, 6, 3 }; // price array of stock day wise => future and current price
		// find maximum profit to get the buying price should be low(lesser value from
		// all values)
		// selling price should be highest(greater value from all values)
		// sell - buying = profit
		// to get the buying price should be low(lesser value from all values)
		int minPrice = Integer.MAX_VALUE;
		int maxProfit = 0;
		
		for(int i=0; i<intArr.length; i++) {
			if(minPrice > intArr[i]) {
				minPrice = intArr[i];
			}
			
			int potentialProfit = intArr[i] - minPrice;
			
			if(potentialProfit > maxProfit) {
				maxProfit = potentialProfit;
			}
		}
		
		System.out.println(maxProfit);
	}

	private static void findNumberOfOccurencesOfElementInArray() {
		//if a number present in the array more than once, print that number along with its occurences in the array
		int[] intArr = {7, 3, 6, 2, 2, 2, 1, 8};
		int count = 0;
		int repeatedNumber = 0;
		for(int i=0; i<intArr.length; i++) {
			for(int j=i+1; j<intArr.length; j++) {
				if(intArr[i] == intArr[j]) {
					repeatedNumber = intArr[i];
					count++;
				}
			}
		}
		System.out.println("repeatedNumber = " + repeatedNumber);
		System.out.println("count = " + count);
		
		//java8
		Map<Integer, Long> frequencyMap = Arrays.stream(intArr).boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		frequencyMap.entrySet().stream().filter(entry -> entry.getValue() > 1)
		.forEach(entry -> System.out.println("repeated number = " + entry.getKey() + "\tcount = " + entry.getValue()));
	}

	private static void findAverageFromArray() {
		int[] intArr = {7, 3, 6, 2, 1, 8};
		int sum = 0;
		int i=0;
		while(i<intArr.length) {
			sum += intArr[i];
			i++;
		}
		System.out.println("sum of elements : " + sum);
		System.out.println("count of elements : " + intArr.length);
		int average = sum / intArr.length;
		System.out.println("average of elements : " + average);
		
		//java8
		List<Integer> listOfints = Arrays.asList(7, 3, 6, 2, 1, 8);
		int sumV = listOfints.stream().collect(Collectors.summingInt(Integer::intValue));
		Long countV = listOfints.stream().collect(Collectors.counting());
		Long avgV = sumV / countV;
		System.out.println("avgV using java8 = " + avgV);
	}

	private static void findMaxElementFromArray() {
		int[] intArr = {7, 3, 6, 2, 1, 8};
		int max = Integer.MIN_VALUE;
		int i = 0;
		while(i<intArr.length){
			if(intArr[i] > max) {
				max = intArr[i];
			}
			i++;
		}
		System.out.println("max element : " + max);
	}

	private static void findMinElementFromArray() {
		int[] intArr = {7, 3, 6, 2, 1, 8};
		int min = Integer.MAX_VALUE;
		int i=0;
		while(i < intArr.length) {
			if(intArr[i] < min) {
				min = intArr[i];
			}
			i++;
		}
		System.out.println("min element : " + min);
	}

	private static void findFirstUniqueCharFromString() {
		//using char arr
		String convertCharArr = "affdgdem";
		char[] charArr = convertCharArr.toCharArray(); // { 'a', 'f', 'f', 'd', 'g', 'd', 'e', 'm' };
		int n = charArr.length;

		char[] originalCharArr = new char[n];
		System.arraycopy(charArr, 0, originalCharArr, 0, n);

		for (int i = 0; i < n; i++) {
			if (charArr[i] != '\0') {
				for (int j = i + 1; j < n; j++) {
					if (charArr[i] == charArr[j]) {
						charArr[j] = '\0';
						charArr[i] = '\0';
					}
				}
			}
		}

		StringBuilder finalResult = new StringBuilder();
		for (char ch : charArr) {
			if (ch != '\0') {
				finalResult.append(ch);
			}
		}

		System.out.println("original array : " + new String(originalCharArr));
		System.out.println("after skipping duplicate character : " + finalResult.toString());
		System.out.println("original array : " + new String(originalCharArr));
		
		String str = "aabbccddefg";
		
		//using java7
		for(int i=0; i<str.length()-1; i++) {
			if(str.indexOf(str.charAt(i)) == str.lastIndexOf(str.charAt(i))) {
				System.out.println(str.charAt(i)); //after printing first unique character the loop will break
				break;
			}
		}
		
		//usingLinkedHashMap
		String strLetters = "AFFDGED"; //
		char[] chars = strLetters.toCharArray();
		Map<Character, Integer> map = new LinkedHashMap<Character, Integer>();
		for (Character c : chars) {
			if (map.containsKey(c)) {
				map.put(c, map.get(c) + 1);
				map.remove(c);
			} else {
				map.put(c, 1);
			}
		}
		
		//using HashSet
		String strGiven = "AFFDGED";
		char[] convertedCharArr = strGiven.toCharArray();

		Set<Character> uniqueChars = new HashSet<>();
		StringBuilder result = new StringBuilder();

		for (char ch : convertedCharArr) {
			if (!uniqueChars.contains(ch)) {
				uniqueChars.add(ch);
			} else {
				result.append(ch);
			}
		}

		StringBuilder finalResult2 = new StringBuilder();
		for (char c : charArr) {
			if (!result.toString().contains(String.valueOf(c))) {
				finalResult2.append(c);
			}
		}

		System.out.println("original array : " + new String(charArr));
		System.out.println("after skipping duplicate character : " + finalResult2);
		
		System.out.println(map.keySet());
		//using java8
		//using filter() and findFirst()
		Character firstUniqueChar = str.chars()
				.filter(c -> str.indexOf((char)c) == str.lastIndexOf((char)c))
				.mapToObj(c -> (char)c)
				.findFirst()
				.get();
		System.out.println(firstUniqueChar);
	}

	private static void findUniqueCharsFromString() {
		String str = "aabbccddefg";
		
		List<Character> uniqueChars = str.chars().filter(c -> str.indexOf((char)c) == str.lastIndexOf((char)c))
				.mapToObj(c -> (char)c)
				.collect(Collectors.toList());
		System.out.println(uniqueChars);
		
		//using java7
		//String str = "abcddeff";
		
		Set<Character> charSet = new LinkedHashSet<>();
		List<Character> duplicate = new ArrayList<>();
		for(char c : str.toCharArray()) {
			if(!charSet.add(c)) {
				duplicate.add(c);
			}
		}
		
		System.out.println(charSet);
		System.out.println(duplicate);
		
		for(char ch : duplicate) {
			if(charSet.contains(ch)) {
				charSet.remove(ch);
			}
		}
		System.out.println(charSet);
		
		//using java8
		Set<Character> setOfChars = str.chars().mapToObj(i -> (char)i).collect(Collectors.toSet());
		System.out.println("========using java8===========");
		
		Set<Character> duplicateChars = str.chars().mapToObj(i -> (char)i).filter(e -> str.indexOf(e) != str.lastIndexOf(e)).collect(Collectors.toSet());
		System.out.println(setOfChars);
		System.out.println(duplicateChars);

		duplicateChars.forEach(setOfChars::remove);
		System.out.println(setOfChars);
	}

	public static void findTheMostBookedRooms() {
		List<Booking> bookings = Arrays.asList(
				new Booking("Room1", "2023-07-01"),
	            new Booking("Room2", "2023-07-01"),
	            new Booking("Room1", "2023-07-02"),
	            new Booking("Room3", "2023-07-02"),
	            new Booking("Room1", "2023-07-03"),
	            new Booking("Room2", "2023-07-03"),
	            new Booking("Room3", "2023-07-04"),
	            new Booking("Room1", "2023-07-04")
				);
		//classifier meaning by which property will you use to group / grouping has been done based on which property 
		//and
		//on selected property again counting
		String mostBookedRooms = bookings.stream().collect(Collectors.groupingBy(Booking::getRoomId, Collectors.counting()))
				.entrySet()
				.stream()
				.max(Map.Entry.comparingByValue()) //max method will take comparator
				.map(Map.Entry::getKey)
				.orElse("no bookings");
		System.out.println(mostBookedRooms);
	}

	private static void findEvenNumbersAndAddFromList() {
		//using java7
		List<Integer> intList = Arrays.asList(1,2,3,4,5,6);
		List<Integer> evenList = new ArrayList<>();
		for(Integer num : intList) {
			if(num % 2 == 0) {
				evenList.add(num);
			}
		}
		int sum = 0;
		for(Integer n : evenList) {
			sum = sum + n;
		}
		System.out.println(sum);
		//using java8 sum() funtion of IntStream
		long summation = intList.stream().filter(n -> n % 2 == 0).mapToInt(Integer::intValue).sum();
		System.out.println(summation);
		
		//using Collectors.summingInt(mapper)
		//where mapper = parsing to integer just like Integer.parseInt()
		long sums = intList.stream().filter(i -> i % 2 == 0).collect(Collectors.summingInt(Integer::intValue));
		System.out.println(sums);
		//using reduce method
		int sumOfEvenNumbers = intList.stream().filter(n -> n % 2 == 0).mapToInt(Integer::intValue)
		.reduce(0, (a, b) -> a + b );
		System.out.println(sumOfEvenNumbers);
	}

	private static void findDuplicateNumberInList() {
		List<Integer> intList = Arrays.asList(1,1,2,2,3,4,5,6);
		List<Integer> duplicates = intList.stream().collect(Collectors.groupingBy(num -> num, Collectors.counting()))
		.entrySet().stream()
		.filter(entry -> entry.getValue() > 1)
		.map(Map.Entry::getKey)
		.collect(Collectors.toList());
		System.out.println(duplicates);
		
		//using java7
		Set<Integer> set = new HashSet<>();
		for(Integer num : intList) {
			if(!set.add(num)) {
				System.out.println("duplicate number : " + num);
			}
		}
	}

	private static void primeFactorsOfNumber() {
		int number = 315;
		int i;
		for(i = 3; i <= Math.sqrt(number); i += 2) {
			// while i devides number, print i and devide number
			while(number % i == 0) {
				System.out.println(i);
				number /= i;
			}
		}
		System.out.println(i);
	}

	private static void findFactorialOfNumber() {
		int number = 4;
		int fact = 1;
		for(int i = number; i>=1; i--) {
			fact = fact * i;
		}
		System.out.println("factorial of given number is \t" + fact);
		
		//using recursion
		System.out.println(calculateFactorial(number));
		
	}
	private static int calculateFactorial(int n) {
		if(n == 1 || n == 0) {
			return 1;
		}
		int nm1_factorial = calculateFactorial(n-1);
		int n_factorial = n * nm1_factorial;
		return n_factorial;
	}

	private static void reverseCharArray() {
		char[] charArr = {'a', 'b', 'c', 'd'};
		char[] reversedCharArr = new char[charArr.length];
		int j = charArr.length;
		for(int i = 0; i < charArr.length; i++ ) {
			reversedCharArr[j - 1] = charArr[i];
			j--;
		}
		
		System.out.println(Arrays.toString(reversedCharArr));
		
	}

	private static void primeOrNotFromArray() {
		int[] intArr = {1, 3, 5, 7, 9, 10};
		
		for(int num : intArr) {
			boolean isPrime = true;
			for(int i = 2; i * i <= num; i++) {
				if(num % i == 0) {
					isPrime = false;
					break;
				}
			}
			if(isPrime) {
				System.out.println("prime number \t: " + num);
			}
		}
	}

	private static void isPalindromeString() {
		String str = "aba";
		
		String reverseString = "";
		
		for(int i = str.length()-1; i >= 0; i--) {
			reverseString = reverseString + str.charAt(i);
		}
		if(reverseString.equalsIgnoreCase(str)) {
			System.out.println("given string is palindrome : " + str);
		}else {
			System.out.println("given string is not palindrome : " + str);
		}
	}

	private static void isPalindromeNumber() {
		int number = 121;
		
		int originalNumber = number;
		int reversedNumber = 0;
		int remainder;
		
		while(number != 0) {
			remainder = number % 10;
			reversedNumber = (reversedNumber * 10) + remainder;
			number = number / 10;
		}
		
		if(reversedNumber == originalNumber) {
			System.out.println("palindrome number");
		}else {
			System.out.println("not palindrome number");
		}
	}

	private static void oddFirstThenEvenFromArray() {
		int[] intArr = {1,2,7,10,6,3,12,5};
		List<Integer> oddThenEvenList = IntStream.of(intArr).boxed()
				.sorted((a,b) -> {
					if((a % 2 == 0) && (b % 2 != 0)) {
						return 1;
					}else if((a % 2 != 0) && (b % 2 == 0)) {
						return -1;
					}else {
						return 0;
					}
				}).collect(Collectors.toList());
		System.out.println(oddThenEvenList);
		//without using new array instead, using existing array
		int[] intArr3 = {1,2,7,10,6,3,12,5};
		int oddCount = 0;
		for(int i=0; i<intArr3.length; i++) {
			if(intArr3[i] % 2 != 0) {
				int temp = intArr3[oddCount];
				intArr3[oddCount] = intArr3[i];
				intArr3[i] = temp;
				oddCount++;
			}
		}
		System.out.println("odd first follwed by even \t" + Arrays.toString(intArr3));
		//using java 1.7
		int[] intArr2 = {1,2,7,10,6,3,12,5};
		int intArr2Length = intArr2.length;
		int[] resultArr = new int[intArr2Length];
		int oddIndex = 0;
		int evenIndex = intArr2Length - 1;
		for(int i=0; i<intArr2.length; i++) {
			if(intArr2[i] % 2 != 0) {
				resultArr[oddIndex++] = intArr2[i];
				//oddIndex++;
			}else {
				resultArr[evenIndex--] = intArr2[i];
				//evenIndex--;
			}
		}
		System.out.println("array is \t" + Arrays.toString(resultArr));
	}

	private static void missingLetterAndMissingNumber() {
		char[] charArr = {'a','b','c','e'};
		char missingCharacter = findMissingCharFromCharArray(charArr);
		System.out.println("missing character from char array : " + missingCharacter);
		
		int[] intArr = {1,2,3,5};
		int missingNumber = findMissingNumberFromIntArray(intArr);
		System.out.println("missing number from int array : " + missingNumber);
		
		String[] strArr = {"a","b","c","e"};
		String missingLetter = findMissingLetterFromStringArray(strArr);
		System.out.println("missing letter from string array : " + missingLetter);
		
	}

	private static String findMissingLetterFromStringArray(String[] strArr) {
		for(int i=0; i<strArr.length-1; i++) {
			char currentLetter = strArr[i].charAt(0);
			char nextLetter = strArr[i+1].charAt(0);
			if(nextLetter - currentLetter != 1) {
				char missingLetter = (char)(currentLetter + 1);
				return String.valueOf(missingLetter);
			}
		}
		return null;
	}

	private static int findMissingNumberFromIntArray(int[] intArr) {
		int arrLength = intArr.length + 1;
		int sumOfNumbers = (arrLength * (arrLength + 1)) / 2;
		int sumOfArrElements = 0;
		for(int num : intArr) {
			sumOfArrElements = sumOfArrElements + num;
		}
		return sumOfNumbers - sumOfArrElements;
	}

	private static char findMissingCharFromCharArray(char[] charArr) {
		char missingChar = '\0';
		for(int i=0; i<charArr.length-1; i++) {
			if(charArr[i+1] - charArr[i] != 1) {
				missingChar = (char) (charArr[i] + 1);
			}
		}
		return missingChar;
	}

	private static void findNoneZeroNumbersInArray() {
		int[] intArray  = {9, 6, 0, 0, 5, 0, -1, 0, 0};
		
		List<Integer> numList = new ArrayList<>();
		//using for each loop
		for(int num : intArray) {
			if(num != 0) {
				numList.add(num);
			}
		}
		System.out.println(numList);
		
		//using stream api
		int[] nonZeroNumbers = Arrays.stream(intArray).filter(n -> n != 0).toArray();
		System.out.println(Arrays.toString(nonZeroNumbers));
	}

	private static void findNegativeDominanceInArray() {
		int[] intArray = {1, -2, -5, -4, 3, -6};
		
		long positiveCount, negativeCount;
		
		positiveCount = Arrays.stream(intArray).filter(n -> n > 0).count();
		negativeCount = Arrays.stream(intArray).filter(n -> n < 0).count();
		System.out.println("positive count : " + positiveCount);
		System.out.println("negative count : " + negativeCount);
		if(positiveCount > negativeCount) {
			System.out.println("positive Dominance");
		}else {
			System.out.println("negatitive Dominance");
		}
		
		//without stream
		
		for(int n : intArray) {
			if(n > 0) {
				positiveCount++;
			}else if(n < 0) {
				negativeCount++;
			}
		}
		System.out.println("positive count : " + positiveCount);
		System.out.println("negative count : " + negativeCount);
		if(negativeCount > positiveCount) {
			System.out.println("negatitive Dominance");
		}
	}

	private static void evenMultiplyOddDivide() {
		List<Integer> intList = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		BigInteger result = intList.stream().filter(i -> i % 2 == 0).map(BigInteger::valueOf)
				.reduce(BigInteger.TEN, BigInteger::multiply).or(intList.stream().filter(i -> i % 2 != 0)
						.map(BigInteger::valueOf).reduce(BigInteger.TEN, BigInteger::divide));
		System.out.println(result);
	}

	private static void findDuplicateWordInGivenString() {
		String str = "i am am string class";
		String[] strArr = str.split(" ");
		
		for(int i=0; i<strArr.length-1; i++) {
			if(strArr[i].equalsIgnoreCase(strArr[i+1])) {
				System.out.println("found duplicate word : "+strArr[i]);
			}
		}
	}

	private static void findeSecondRepeatedCharacterInGivenString() {
		String str = "how are you doing today";
		char ch = findSecondRepeatedCharacter(str);
		System.out.println("second repeated character : " + ch);
	}

	private static char findSecondRepeatedCharacter(String str) {
		str = str.toLowerCase().replace(" ", "");
		Map<Character, Integer> charCountMap = new LinkedHashMap<>();
		
		for(char ch : str.toCharArray()) {
			charCountMap.put(ch, charCountMap.getOrDefault(ch, 0) + 1);
		}
		
		//find the second character with count greater than one
		boolean foundFirstRepeatedCharacter = false;
		for(Map.Entry<Character, Integer> entry : charCountMap.entrySet()) {
			if(entry.getValue() > 1) {
				if(foundFirstRepeatedCharacter) {
					return entry.getKey();
				}else {
					foundFirstRepeatedCharacter = true;
				}
			}
		}
		return '\0';
	}

	private static void countingZeorsInArray() {
		int[] intArray  = {9, 6, 0, 0, 5, 0, -1, 0, 0};
		long zerosCount = Arrays.stream(intArray).filter(e -> e == 0).count();
		System.out.println(zerosCount);
	}

	private static void findMissingCharacterInString() {
		String actual = "apple";
		String check = "appe";
		
		findMissingCharacterFromGivenStrings(actual, check);
		
	}

	private static void findMissingCharacterFromGivenStrings(String actual, String check) {
		for(int i=0; i<actual.length(); i++) {
			if(actual.charAt(i) != check.charAt(i)) {
				System.out.println("missing character is : "+actual.charAt(i));
				break;
			}
		}
	}

	private static void findUniqueWords() {
		String[] duplicateWordsArray = {"xyz","lmn","xyz","aaa", "xyz"};
		List<String> listOfStrings = Arrays.asList("Pen", "Eraser", "Note Book", "Pen", "Pencil", "Pen", "Note Book",
				"Pencil"); 
		
		Set<String> setOfStrings = new HashSet<>();
		List<String> duplicates = new ArrayList<>();
		int count=1;
		for(String str : duplicateWordsArray) {
			if(!setOfStrings.add(str)) {
				duplicates.add(str);
				count++;
			}
		}
		
		System.out.println(setOfStrings);
		System.out.println(duplicates.get(0) + " : " + count);
		
		for(int i=0; i<duplicates.size(); i++) {
			if(setOfStrings.contains(duplicates.get(i))) {
				setOfStrings.remove(duplicates.get(i));
			}
		}
		
		System.out.println(setOfStrings);
		
		//using java8 stream api
		Map.Entry<String, Long> maxOccurencWord = Arrays.stream(duplicateWordsArray).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
		.entrySet()
		.stream()
		.max(Map.Entry.comparingByValue())
		.orElse(null);
		System.out.println(maxOccurencWord);
		
		Map.Entry<String, Long> maxRepeatedWordCount = listOfStrings.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
		.entrySet()
		.stream()
		.max(Map.Entry.comparingByValue())
		.orElse(null);
		
		System.out.println(maxRepeatedWordCount);
		 
	}
	
	private static void lenghtOfStringWithoutUsingPredefinedMethod() {
		String str = "abc";
		int numberOfCharacters = 0;
		//char[] chArr = str.toCharArray();
		
		/*
		 * for(int i=0; i<3; i++) { if(str.charAt(i) != 0) { numberOfCharacters++; } } or
		 */
		/*
		 * for(char c : chArr) { numberOfCharacters++; } or
		 */
		/*
		 * try { for(int i=0; true; i++) { str.charAt(i); numberOfCharacters++; } or
		 * }catch(Exception e) {}
		 
		try {
			while(true) {
				str.charAt(numberOfCharacters);
				numberOfCharacters++;
			}
		}catch(Exception e) {}
		System.out.println(numberOfCharacters);
		*/
		//using reflection api
		Class<?> cls = str.getClass();
		try {
			Field field = cls.getDeclaredField("value");
			field.setAccessible(true);
			//byte[] byteArr = (byte[])field.get(str); //we will get re : classcastexception because
			//from java 9 version onwords byte[] but upto 8 version its char[]
			char[] byteArr = (char[])field.get(str);//upto java8 version char[], from 9 version its byte[]
			System.out.println(byteArr.length);
		} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void reverseCharactersInAString() {
		String str = "hai"; //output : iah
		String result = "";
		for(int i=str.length()-1; i>=0; i--) {
			result = result + str.charAt(i);
		}
		System.out.println(result);
		
		//using while loop
		int length = str.length();
		while(length > 0) {
			System.out.print(str.charAt(length -1));
			length--;
		}
		System.out.println();
		
		//second way
		StringBuilder sb = new StringBuilder();
		for(int i = str.length()-1; i>=0; i--) {
			sb.append(str.charAt(i));
		}
		System.out.println("reversing string using StringBuilder object : " + sb.toString());
		
		//using java8
		String reversedString = IntStream.range(0, str.length())
				.mapToObj(i -> str.charAt(str.length() - i - 1))
				.map(Object::toString)
				.collect(Collectors.joining());
		System.out.println(reversedString);
	}

	private static void reverseStringWords() {
		String str = "How Are You?";
		String[] words = str.split(" ");
		System.out.println(words.length);
		//String newStr = "";
		//StringBuffer, if we use stringbuffer, every method is synchronized so lock and unlock will be occur, again
		//performance issue, simply go with stringbuilder
		StringBuilder newStr = new StringBuilder(); //construct empty stringbuilder object
		for(int i=words.length -1; i>=0; i--) {
			//newStr = newStr.concat(words[i] + " ");//for every concat operation, object is created
			//performance issue, so use the below
			//newStr = newStr + words[i] + " "; or
			newStr.append(words[i]);
			newStr.append(" ");
			
		}
		//newStr.toString().trim(); //removing the space added after last word
		//System.out.println(newStr.toString().trim());
		
		//using java8 streams
		String reverseWord = Arrays.stream(str.split("\\s+")).sorted((a,b) -> -1).collect(Collectors.joining(" "));
		System.out.println(reverseWord);
	}

	private static void extractingPartOfStringFromAGivenString() {
		String original = "Nagaraju Kailasa";
		String searchString = "Kail";
		String originalLowerCase = original.toLowerCase();
		String searStringLowerCase = searchString.toLowerCase();
		int start = originalLowerCase.indexOf(searStringLowerCase);
		System.out.println(start);
		int end = originalLowerCase.lastIndexOf('l');
		System.out.println(end);
		
		//if(originalLowerCase.contains(searStringLowerCase)) { // contains internally called indexOf(--), so
		//calling indexOf(--) two times, two times execution takes place and hence we will get performance issue
		if(start != -1) {
			System.out.println(original.substring(start, end + 1));
		}
	}

	private static void findMaxOccurenceOfCharInString() {
		String str = "nagaraju";
		str.chars() //returns int stream
		.mapToObj(ch -> (char)ch) //map each int stream to its character and finally it returns stream of characters
		.collect(Collectors.groupingBy(Function.identity(), Collectors.counting())) //group characters by their identity and frequency and it will return Map<Character, Long>
		.entrySet() //convert into Map.Entry and it will returns set of entries
		.stream() // convert set of entries to stream of entries
		.filter(entry -> entry.getValue() > 1) //filter the stream of entries and hold only those values where the value > 1 
		.forEach(entry ->{ //for each entry that will execute repeated character
			System.out.println("repeated character is " + entry.getKey());
			System.out.println("repeated value is " + entry.getValue());
		});
	}

	private static void findGapInArrayIntegerElements75() {
		int[] array = {23, -2, 45, 38, 12, 4, 6};
		sortArray(array);
		//findGapUsingVariables(array);
		//findGapUsingMath(array);
		findGapUsingUsingJava8(array);
	}

	private static void findGapUsingUsingJava8(int[] array) {
		// Find the largest gap among the given array elements using Java 8 stream
		// Initialize the largest gap to a default value.
		int largestGap = IntStream.range(0, array.length -1)
				.map(i -> Math.abs(array[i+1] - array[i]))
				.max()
				.getAsInt();
        System.out.println("The largest gap in the given array is: " + largestGap);
	}

	private static void findGapUsingMath(int[] array) {
		int maxGap = 0;
		for(int i=0; i<array.length-1; i++) {
			maxGap = Math.max(array[i+1] - array[i], maxGap);
		}
		System.out.println("maxGap using Math " + maxGap);
	}

	private static void findGapUsingVariables(int[] array) {
		int difference = 0;
		int maxGap = 0;
		for(int i=0; i<array.length-1; i++) {
			difference = array[i+1] - array[i];
			if(difference > maxGap) {
				maxGap = difference;
			}
		}
		System.out.println("maxGap " + maxGap);
	}

	private static void cosecutiveElementsInArray76() {
		int[] array = {1, 2 ,5, 0, 3, 6, 7};
		//Arrays.sort(array);
		System.out.println("before sorting elements in array : " + Arrays.toString(array));
		sortArray(array);
		System.out.println("after sorting elements in array : " + Arrays.toString(array));
		isConsecutiveArrayOneWay(array);
		//isConsecutiveArraySecondWay(array);
		//usingJava8Stream(array);
	}

	private static void usingJava8Stream(int[] array) {
		
		boolean consecutive = Arrays.stream(array)
									.boxed()
									.sorted()
									.allMatch(i -> i.equals(array[i - array[0]]));
		if(consecutive) {
			System.out.println("elements are consecutive elements in array! " + consecutive);
		}else {
			System.out.println("elements are not consecutive elements in array! " + consecutive);
		}
	}

	private static void isConsecutiveArraySecondWay(int[] array) {
		boolean flag = false;
		for(int i=0; i<array.length-1; i++) {
			int firstElement = array[i];
			int secondElement = array[i+1];
			if((secondElement - firstElement) != 1) {
				flag = false;
			}
		}
		if(flag) {
			System.out.println("elements are consecutive elements in array! " + flag);
		}else {
			System.out.println("elements are not consecutive elements in array! " + flag);
		}
	}
	//bubble sort
	private static void sortArray(int[] array) {
		for(int i=0; i<array.length -1; i++) { //outer for loop is for passes
			int flag = 0;
			for(int j=0; j<array.length-i-1; j++) { // inner for loop is for comparisions and for each iteration the passes will be decreased so here we taken -i
				if(array[j] > array[j+1]) {
					int temp = array[j];
					array[j] = array[j+1];
					array[j+1] = temp;
					flag = 1;
				}
			}
			if(flag == 0) {
				break;
			}
		}
	}
	
	private static void isConsecutiveArrayOneWay(int[] array) {
		boolean flag = false;
		for(int i=0; i<array.length-1; i++) {
			if(array[i]+1 != array[i+1]) {
				flag = false;
			}
		}
		
		if(flag) {
			System.out.println("elements are consecutive in array! " + flag);
		}else {
			System.out.println("elements are not consecutive in array! " + flag);
		}
	}

	private static void findFirstNonRepeatedCharacterInStringUsingStreamFirstWay() {
		String str = "aabbbccd";
		Character firstNonRepeatedChar = str.chars().mapToObj(ch -> (char)ch)
				.filter(ch -> str.indexOf(ch) == str.lastIndexOf(ch)).findFirst().get();
		System.out.println(firstNonRepeatedChar);
	}

	private static void testingIntegersRange() {
		Integer num1 = 100;
		Integer num2 = 100;
		Integer num3 = 500;
		Integer num4 = 500;
		
		if(num1 == num2) {
			System.out.println("num1 == num2");
		}else {
			System.out.println("num1 != num2");
		}
		if(num3 == num4) {
			System.out.println("num3 == num4");
		}else {
			System.out.println("num3 != num4");
		}
	}

	private static void attachMessageToRandomNumberAndReturn() {
		String message = "hello world";
		int secreteCode = generateSecreteCode();
		System.out.println(secreteCode);
		String encryptedMessage = encryptMessage(secreteCode, message);
		System.out.println(encryptedMessage);
		String decryptedMessage = decryptMessage(encryptedMessage);
		System.out.println(decryptedMessage);
		String decryptedMessageUsingJava8 = decryptMessageUsingJava8Stream(encryptedMessage);
		System.out.println(decryptedMessageUsingJava8);
		
	}

	private static String decryptMessageUsingJava8Stream(String encryptedMessage) {
		return IntStream.range(0, encryptedMessage.length())
				.filter(i -> encryptedMessage.charAt(i) == ':')
				.mapToObj(i -> encryptedMessage.substring(i+1))
				.findFirst()
				.orElse("");
	}

	private static String decryptMessage(String encryptedMessage) {
		return encryptedMessage.substring(encryptedMessage.indexOf(":")+1);
	}

	private static String encryptMessage(int secreteCode, String message) {
		return secreteCode + ":" + message;
	}

	private static int generateSecreteCode() {
		return new Random().nextInt(999)+1;
	}

	private static void findNumberStartwithOneInGivenIntList() {
		List<Integer> myList = Arrays.asList(10,15,8,49,25,98,32,17);
		List<String> stringList = myList.stream().map(Object::toString).filter(s -> s.startsWith("1")).collect(Collectors.toList());
		System.out.println(stringList);
	}

	private static void findFibonacciNumber() {
		int n = 10;
		for(int i = 0; i<=n; i++) {
			int fibNumber = findFiboNumber(i);
			System.out.print(fibNumber + " ");
		}
	}

	private static int findFiboNumber(int i) {
		if(i <= 1) {
			return i;
		}else {
			return findFiboNumber(i-1) + findFiboNumber(i - 2);
		}
	}

	private static void findNonRepeatedCharacterInAString() {
		
		oneWayOfFindingNonRepeatedCharacterInAString();
		//secondWayOfFindingNonRepeatedCharacterInAString();
		//findFirstNonRepeatedCharacterInStringUsingStreamFirstWay();
		//findFirstNonRepeatedCharacterInStringUsingStreamSecondWay();
		
	}
	
	private static void findFirstNonRepeatedCharacterInStringUsingStreamSecondWay() {
		String str="zzzzzbbbccccddehhhhiii";
		
		Map<Character, Long> charCount = str.chars()
		.mapToObj(c -> (char)c)
		.collect(LinkedHashMap::new,
				(map, c) -> map.merge(c, 1L, Long::sum),
				LinkedHashMap::putAll);
		
		Optional<Character> firstNonRepeating = charCount.entrySet().stream()
													.filter(entry -> entry.getValue() == 1)
													.map(Map.Entry::getKey)
													.findFirst();
		firstNonRepeating.ifPresent(
				character -> System.out.println("first non repeating character : "+character)
				);
		firstNonRepeating.orElse(null);
		
		
	}

	private static void secondWayOfFindingNonRepeatedCharacterInAString() {

		String str="zzzzzbbbccccddehhhhiii";
		int[] charCount = new int[256];
		
		for(int i=0; i<str.length(); i++) {
			char ch = str.charAt(i);
			charCount[ch]++;
		}
		
		for(int i=0; i<str.length(); i++) {
			char ch = str.charAt(i);
			if(charCount[ch] == 1)
				System.out.println(ch);
		}
		
	}

	private static void oneWayOfFindingNonRepeatedCharacterInAString() {

		String str="zzzzzbbbccccddehhhhiii";
		
		for(int i=0; i<str.length() -1; i++) {
			char ch = str.charAt(i);
			if(str.indexOf(ch) == str.lastIndexOf(ch)) {
				System.out.println(ch);
			}
		}
		
		//using for each loop
		for(char ch : str.toCharArray()) {
			if(str.indexOf(ch) == str.lastIndexOf(ch)) {
				System.out.println(ch);
			}
		}
		
	}

	private static void findTheLeaderElementIntheArray() {
		//oneWayUsingArrayOnly();
		secondWayUsingListAndReversingList();
	}

	private static void secondWayUsingListAndReversingList() {
		int[] arr = {10, 5, 100, 40, 50, 20};
		findLeadersUsingList(arr);
	}

	private static void findLeadersUsingList(int[] arr) {
		int arrLength = arr.length;
		int maxRight = arr[arrLength-1]; //the last element is always a leader
		List<Integer> intList = new ArrayList<>();
		//intList.add(maxRight);
		for(int i = arrLength - 2; i >= 0; i--) {
			if(arr[i] >= maxRight) {
				maxRight = arr[i];
				intList.add(maxRight);
				//System.out.println(maxRight);
			}
		}
		//System.out.println(intList);
		//Object[] objArr = intList.toArray();
		//System.out.println(Arrays.toString(objArr));
		
		//reverse the list to get the leaders in their original order
		List<Integer> reverseList = new ArrayList<>();
		for(int i = intList.size() - 1; i >= 0; i--) {
			reverseList.add(intList.get(i));
		}
		reverseList.add(arr[arrLength-1]);
		System.out.println(reverseList);
	}

	private static void oneWayUsingArrayOnly() {
		int[] arr = {10, 5, 100, 40, 50, 20};
		findLeadersUsingArray(arr);
	}

	private static void findLeadersUsingArray(int[] arr) {
		int arrLength = arr.length;
		int maxRight = arr[arrLength-1]; //the last element is always a leader
		System.out.println(maxRight);
		for(int i = arrLength - 2; i >= 0; i--) {
			if(arr[i] >= maxRight) {
				maxRight = arr[i];
				System.out.println(maxRight);
			}
		}
	}

	private static void countSubStringInAGivenStringOrCheckString1InString2() {
		String str = "indians indian india";
		String subString = "ind";
		
		int count = 0, f = 0;
		
		int strLength = str.length();
		int subStringLength = subString.length();
		
		for(int i=0; i<strLength - subStringLength; i++) {
			if(str.charAt(i) == subString.charAt(0)) {
				f = 0;
				for(int j=1; j<subStringLength; j++) {
					if(str.charAt(i+j) != subString.charAt(j)) {
						f = 1;
						break;
					}
				}
				
				if(f==0)
					count++;
			}
		}
		
		if(count==0)
			System.out.println("substring not found");
		else
			System.out.println("the frequency or substring count is : "+count);
		
		//another way
		int count2 = 0;
		while(f != -1) {
			f = str.indexOf(subString, f);
			
			if(f != -1) {
				count2 ++;
				f = f + subString.length();
			}
		}
		System.out.println("using while loop " + count);
		
		//another way
		int count3 = 0;
		int index = str.indexOf(subString);
		
		while(index != -1) {
			count3++;
			//index = index + str.indexOf(subString, index);
			index = str.indexOf(subString, index + 1);
		}
		System.out.println(subString + " using 3rd way : "+ count3);
	}

	private static void linkedListOperations() {
		
		LinkedList linkedList = new LinkedList();
		
		linkedList.insertAtEnd(10);
		linkedList.insertAtEnd(5);
		linkedList.insertAtEnd(15);
		linkedList.insertAtEnd(20);
		linkedList.insertAtEnd(25);
		
		linkedList.insertAtFirst(22);
		
		//linkedList.insertAtPosition(2, 55);
		
		linkedList.insertAtPosition(0, 55);
		
		linkedList.deleteAtPosition(2);
		
		linkedList.show();
	}

	private static void returnListOfStringUsingStreams() {
		List<String> listOfStrings = returnListOfStringUsingStreamApi();
		System.out.println("listOfStrings : " + listOfStrings);
		
	}

	private static List<String> returnListOfStringUsingStreamApi() {
		List<List<String>> nestedList = Arrays.asList(
				Arrays.asList("Saket", "sreekar"), Arrays.asList("sani", "manish"),
                Arrays.asList("Shawn", "Franklin"), Arrays.asList("Johnty", "Sean")
                );
		List<String> listOfStrings = nestedList.stream().flatMap(List::stream).collect(Collectors.toList());
		return listOfStrings;
	}

	

	private static void findMissingNumberInArrayUsingSumOfNaturalNumbers() {
		int missingNumber = missingNumberInArrayUsingSumOfNaturalNumbers();
		System.out.println(missingNumber);
	}

	private static int missingNumberInArrayUsingSumOfNaturalNumbers() {
		int[] arr = {1, 2, 3, 4, 6, 7, 8, 9, 10};// here missing number is 5
		int n = arr.length + 1; //array length = number of elements,
		//if including missing number then array length =  number of elements + missing number
		//or
		//the array has n-1 elements so the length of the missing number sequence is n
		
		int totalSum = n * (n+1) / 2; //sum of first n natural numbers
		int actualSum = 0;
		
		for(int num : arr) {
			actualSum = actualSum + num;
		}
		
		return totalSum - actualSum;
	}

	private static void findMissingNumberInArrayUsingBinarySearch() {
		int missingNumber = missingNumberInArrayUsingBinarySearch();
		System.out.println(missingNumber);
	}

	private static int missingNumberInArrayUsingBinarySearch() {
		int[] arr = {1, 2, 3, 4, 6, 7, 8, 9, 10};// here missing number is 5
		//here array is sorted
		//if you want to use binary search array should be sorted
		int left = 0;
		int right = arr.length-1;
		while(left <= right) {
			int mid = left + (right - left) / 2;
			if(arr[mid] == mid + 1) {
				left = mid + 1;
			}else {
				right = mid - 1;
			}
		}
		return left + 1;
	}

	private static void isArrayAlternatePositiveNegative() {
		boolean value = false;
		int[] intArray = {1, -2, 5, -4, 3, -6};
		for(int i=0; i<intArray.length-2; i++) {
			if(intArray[i] >= 0 && intArray[i+2] >= 0 ) {
				value = true;
			}
		}
		System.out.println("boolean value : " + value);
		//storing negative elements into new array and trim
		storingNegativeAndTrimArray();
		//creating and using positive array
		createPositiveArray();
		
	}

	private static void storingNegativeAndTrimArray() {
		int[] intArray = {1, -2, 5, -4, 3, -6};
		int[] newArray = new int[intArray.length];
		int count = 0;
		for(int i=0; i<intArray.length; i++) {
				if(intArray[i] <= 0) {
					newArray[count] = intArray[i];
					count++;
				}
		}
		System.out.println("this is newArray : " + Arrays.toString(newArray));
		System.out.println("this is newArray and count variable value : " + Arrays.toString(newArray) + " : " + count);
		int[] trimmedArray = new int[count];
		System.arraycopy(newArray, 0, trimmedArray, 0, count);
		System.out.println("this is trimmedArray : " + Arrays.toString(trimmedArray));
	}

	private static void createPositiveArray() {
		
		int[] intArray = {1, -2, 5, -4, 3, -6};
		
		int[] positiveArray = new int[intArray.length];
		
		int positiveCount = 0;
		
		for(int num : intArray) {
			if(num >= 0) {
				positiveArray[positiveCount] = num;
				positiveCount++;
			}
		}
		
		int[] trimmedArray = new int[positiveCount];
		System.arraycopy(positiveArray, 0, trimmedArray, 0, positiveCount);
		
		System.out.println(Arrays.toString(trimmedArray));
	}

	private static void swapArrayElementsWithoutUsing3rdOrTempVariable() {
		int[] binaryArray = {0,1,0,1,0,1,0,1,0,1};
		
		for(int i=0; i<binaryArray.length-1; i++) {
			for(int j=i+1; j<binaryArray.length-1; j++) {
				if(binaryArray[i] > binaryArray[j]) {
					binaryArray[i] = binaryArray[i] + binaryArray[j];
					binaryArray[j] = binaryArray[i] - binaryArray[j];
					binaryArray[i] = binaryArray[i] - binaryArray[j];
				}
			}
		}
		
		System.out.println(Arrays.toString(binaryArray));
	}

	private static void findSecondElementWhoseSumEqualToM() {
		int[] arr = {1,3,2,7,9};
		int n = 2, m = 5;
		
		for(int i=0; i <arr.length -1; i++) {
			if(arr[i] + n == m) {
				System.out.println("second element : " + arr[i]);
			}
		}
	}

}

class HospitalComposition{
	
	private List<Doctor> doctors;
	
	HospitalComposition(){
		doctors = new ArrayList<>();
	}
	
	public void addDoctor(Doctor doctor) {
		doctors.add(doctor);
	}
	
	//Doctor component is strongly association with Hospital, without existing of Hospital object,
	//there is no chance of existing Doctor object
	public static void composition() {
		System.out.println("compostion");
	}
}

class Doctor{
	private String name;
	private String specialization;
}
class Patient{
	private String patientName;
	private Doctor primaryDoctor;
	
	//Patient having Doctor association is a week association,
	//without existing Doctor object, there Patient object exist
	public static void aggregation(){
		System.out.println("aggregation");
	}
	
}

class Nurse extends HospitalComposition{
	
	//Nurse extends HospitaComposition, is a relation
	public static void isARelation() {
		System.out.println("is a relation");
	}
}

final class Record{
	private final int i;
	
	Record(int i){
		this.i = i;
	}
	
	public Record modify(int i) {
		if(this.i == i) {
			return this;
		}else {
			return new Record(i);
		}
	}
	
	public static boolean isImmutableClass() {
		Record r1 = new Record(10);
		Record r2 = r1.modify(20);
		
		if(r1 == r2) {
			return true;
		}else {
			return false;
		}
	}	
	public static void immutableClass() {
		System.out.println(isImmutableClass());
	}
	
}

class Node{
	int data;
	Node next;
}

class LinkedList{
	
	Node head;
	
	public void insertAtEnd(int data) {
		Node node = new Node();
		node.data = data;
		node.next = null;
		
		if(head==null) {
			head = node;
		}else {
			Node tempNode = head;
			while(tempNode.next != null) {
				tempNode = tempNode.next;
			}
			tempNode.next = node;
		}
	}
	
	public void insertAtFirst(int data) {
		Node node = new Node();
		node.data = data;
		node.next = null;
		node.next = head;
		head = node;
	}
	
	public void insertAtPosition(int index, int data) {
		Node node = new Node();
		node.data = data;
		node.next = null;
		
		if(index == 0) {
			insertAtFirst(data);
		}else {
			Node tempNode = head;
			for(int i=0; i<index-1; i++) {
				tempNode = tempNode.next;
			}
			node.next = tempNode.next;
			tempNode.next = node;
		}
		
	}
	
	public void deleteAtPosition(int index) {
		if(index == 0) {
			head = head.next;
		}else {
			Node tempNode = head;
			Node deletingNode = null;
			for(int i=0; i<index-1; i++) {
				tempNode = tempNode.next;
			}
			deletingNode = tempNode.next;
			tempNode.next = deletingNode.next;
			deletingNode = null;
		}
	}
	
	public void show() {
		Node tempNode = head;
		while(tempNode.next != null) {
			System.out.println(tempNode.data);
			tempNode = tempNode.next;
		}
		System.out.println(tempNode.data);
	}
	
}