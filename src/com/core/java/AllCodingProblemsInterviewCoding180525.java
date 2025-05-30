package com.core.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AllCodingProblemsInterviewCoding180525 {

	public static void main(String[] args) {
//		findMinAndMaxElementFromArray();
//		findMissingNumberInArrayUsingBinarySearch();
//		findMissingNumberInArrayUsingSumOfNaturalNumbers();
//		findFibonacciNumber();
//		returnListOfStringFromNestedListUsingStreams();
//		linkedListOperations();
//		countOccurrencesOfASubstringInAGivenString();
//		findFirstUniqueCharFromString(); // or findNonRepeatedCharacterInAString();
//		findProfitOfStocks();
//		extractingPartOfStringFromAGivenString();
//		findNumberStartwithOneInGivenIntList();
//		reverseStringWords();
//		reverseCharactersInAString();
//		lenghtOfStringWithoutUsingPredefinedMethod();
//		findMissingCharacterInString();
//		evenMultiplyOddDivide();
//		findNegativeDominanceInArray();
//		findNoneZeroNumbersInArray();
//		missingLetterAndMissingNumber();
//		oddFirstThenEvenFromArray();
//		isPalindromeNumberOrisPalindromeString();
//		primeOrNotFromArray();
//		reverseCharArray();
//		findFactorialOfNumber();
//		primeFactorsOfNumber();
//		findEvenNumbersAndAddFromList();
//		findAverageFromArray();
//		joiningStringsInList();
//		summingNnumbers();
//		sortListInAscendingAndDescendingOrderAndFindMaxNumber();
//		findSecondElementWhoseSumEqualToM();
//		testingIntegersRange();
//		findLongestSubString();
//		averageMarksOfStudentFrom2dArray();
//		searchGivenStringBasedOnCharactersGivenInTheDropdown();
//		filteredItemDetailsMapOrItemDetailsProcessor();
//
//		programs used Collectors.groupingBy
//		findMaxOccurenceOfCharInStringAndPrintLeastCount();
//		findNumberOfOccurencesOfElementInArray();
//		findUniqueWords();
//		findUniqueCharsFromString();
//		countingZeorsInArray();
//		findeSecondRepeatedCharacterInGivenString();
//		findDuplicateWordInGivenString();
//		findDuplicateNumberInList();
//		findTheMostBookedRooms();
//		test();
	}

	public static void test() {
		String str = "ababcc";
		Map<Character, Long> maps = str.chars().mapToObj(is -> (char) is)
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println(maps);
	}

	private static void findTheMostBookedRooms() {
		List<Booking> bookings = Arrays.asList(new Booking("Room1", "2023-07-01"), new Booking("Room2", "2023-07-01"),
				new Booking("Room1", "2023-07-02"), new Booking("Room3", "2023-07-02"),
				new Booking("Room1", "2023-07-03"), new Booking("Room2", "2023-07-03"),
				new Booking("Room3", "2023-07-04"), new Booking("Room1", "2023-07-04"));
		String mostBookedRooms = bookings.stream().collect(Collectors.groupingBy(Booking::getRoomId, Collectors.counting()))
		.entrySet().stream().max(Map.Entry.comparingByValue()).map(Map.Entry::getKey).orElse("no bookings");
		System.out.println("mostBookedRooms:\t" + mostBookedRooms);
	}

	private static void findDuplicateNumberInList() {
		List<Integer> intList = Arrays.asList(1, 1, 2, 2, 3, 4, 5, 6);
		List<Integer> duplicateNumbersInList = intList.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
		.entrySet().stream().filter(entry -> entry.getValue() > 1).map(Map.Entry::getKey).collect(Collectors.toList());
		System.out.println("duplicateNumbersInList:\t" + duplicateNumbersInList);

	}

	private static void findDuplicateWordInGivenString() {
		String str = "i am am string string class";
		String[] strArr = str.split(" ");
		String duplicateWordsList = Arrays.stream(str.split(" ")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
		.entrySet().stream().filter(entry -> entry.getValue() > 1).map(Map.Entry::getKey).map(Object::toString).collect(Collectors.joining(" "));
		System.out.println("duplicateWordsList:\t" + duplicateWordsList);
	}

	private static void findeSecondRepeatedCharacterInGivenString() {
		String str = "how are you doing today";
		// Use LinkedHashMap to maintain order
		Character secondRepeatedCharacter = str.chars().mapToObj(is -> (char)is).collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
		.entrySet().stream().filter(entry -> entry.getValue() > 1).map(Map.Entry::getKey).findFirst().get();
		System.out.println("secondRepeatedCharacter:\t" + secondRepeatedCharacter);
	}

	private static void countingZeorsInArray() {
		int[] intArray = { 9, 6, 0, 0, 5, 0, -1, 0, 0 };
		Map<Integer, Long> zerosCount = Arrays.stream(intArray).filter(i -> i == 0).mapToObj(Integer::valueOf).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println("zerosCount:\t" + zerosCount);
	}

	private static void findUniqueCharsFromString() {
		String str = "aabbcdef";
		
		String uniqueChars = str.chars().mapToObj(is -> (char)is).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
		.entrySet().stream().filter(entry -> entry.getValue() == 1).map(Map.Entry::getKey).map(Object::toString).collect(Collectors.joining());
		System.out.println("uniqueChars:\t" + uniqueChars);
	}

	private static void findUniqueWords() {
		String[] duplicateWordsArray = { "xyz", "lmn", "xyz", "aaa", "xyz" };
		String uniqueWords = Arrays.stream(duplicateWordsArray).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
		.entrySet().stream().filter(entry -> entry.getValue() == 1).map(Map.Entry::getKey).map(Object::toString).collect(Collectors.joining(" "));
		System.out.println("uniqueWords:\t" + uniqueWords);
	}

	private static void findNumberOfOccurencesOfElementInArray() {

		int[] intArr = { 7, 3, 6, 2, 2, 2, 1, 8 };

		Map<Integer, Long> resultMap = Arrays.stream(intArr).boxed()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println(resultMap); // number and its count
		// if a number present in the array more than once, print that number along with
		// its occurences in the array
		Map<Integer, Long> respondMap = resultMap.entrySet().stream().filter(entry -> entry.getValue() > 1)
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
		System.out.println("respondMap:\t" + respondMap);
		respondMap.entrySet().forEach((entry -> System.out.println("the number appears in the array more than once:\t"
				+ entry.getKey() + "\nCount:\t" + entry.getValue())));

	}

	private static void findMaxOccurenceOfCharInStringAndPrintLeastCount() {
		String str = "nagarajun";

		// to print character and its count
		// str.chars().mapToObj(is -> (char)is)
		// .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
		// .forEach((key, value) -> System.out.println(key + " : " +value));

		// to print least count character occurences
		long leastCount = str.chars().mapToObj(is -> (char)is).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
		.entrySet().stream().min(Map.Entry.comparingByValue()).map(Map.Entry::getValue).get();
		System.out.println("leastCount:\t" + leastCount);
		
		Map<Character, Long> leastCountMap = str.chars().mapToObj(is -> (char)is).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
		.entrySet().stream().filter(entry -> entry.getValue() == leastCount).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
		System.out.println("leastCountMap:\t" + leastCountMap);
	}

	private static void testingIntegersRange() {
		Integer num1 = 100;
		Integer num2 = 100;
		Integer num3 = 500;
		Integer num4 = 500;

		if (num1 == num2) {
			System.out.println("num1 == num2");
		} else {
			System.out.println("num1 != num2");
		}
		if (num3 == num4) {
			System.out.println("num3 == num4");
		} else {
			System.out.println("num3 != num4");
		}
	}

	private static void findSecondElementWhoseSumEqualToM() {
		// int[] arr = {1, 3, 2, 7, 9};
		int[] arr = { 1, 2, 3, 7, 9 };
		int n = 1, m = 2;
		List<Integer> listOfNumbers = Arrays.stream(arr).boxed().collect(Collectors.toList());

//		 Set<Integer[]> sumPair = listOfNumbers.stream()
//		            .flatMap(i -> listOfNumbers.stream()
//		                    .filter(p -> (i + p) == m && listOfNumbers.indexOf(p) != listOfNumbers.indexOf(i))
//		                    .map(p -> new Integer[] { i, p }))
//		            .collect(Collectors.toSet());
//		    for (Integer[] integers : sumPair) {
//		        for (Integer val : integers) {
//		            System.out.print(val + " ");
//		        }
//		        System.out.println("");
//		    }

		int secondElement = listOfNumbers.stream().filter(num -> num + n == m) // Check sum condition
				.findFirst().get();

		System.out.println("secondElement:\t" + secondElement);

	}

	private static void sortListInAscendingAndDescendingOrderAndFindMaxNumber() {
		List<Integer> intList = Arrays.asList(6, 8, 2, 5, 4, 1);
		List<Integer> sortedListInAscendingOrder = intList.stream().sorted().collect(Collectors.toList());
		System.out.println("sortedListInAscendingOrder:\t" + sortedListInAscendingOrder);
		List<Integer> sortedListInDescendingOrder = intList.stream().sorted(Comparator.reverseOrder())
				.collect(Collectors.toList());
		System.out.println("sortedListInDescendingOrder:\t" + sortedListInDescendingOrder);
		int maxNumber = sortedListInAscendingOrder.stream().max(Comparator.comparingInt(Integer::intValue)).get();
		// max(Integer::compareTo) or max(Comparator.comparingInt(Integer::intValue))
		System.out.println("maxNumber:\t" + maxNumber);
		int minNumber = sortedListInAscendingOrder.stream().min(Integer::compareTo).get();
		System.out.println("minNumber:\t" + minNumber);

		// findSecondHighestElementFromList
		// list should be in descending order
		// int secondHighestElementFromList =
		// sortedListInDescendingOrder.stream().skip(1).findFirst().get();
		int secondHighestElementFromList = intList.stream().sorted(Comparator.reverseOrder()).skip(1).findFirst().get();
		// or this way : int secondHighestElementFromList =
		// intList.stream().sorted((a,b) -> b.compareTo(a)).skip(1).findFirst().get();
		System.out.println("secondHighestElementFromList:\t" + secondHighestElementFromList);

	}

	private static void summingNnumbers() {
		int n = 5; // 5+4+3+2+1
		int summ = IntStream.rangeClosed(1, n).sum();
		System.out.println("summ:\t" + summ);
	}

	private static void joiningStringsInList() {
		List<String> listOfStrings = Arrays.asList("apple", "banana", "mango");
		String stringAfterjoining = listOfStrings.stream().collect(Collectors.joining(","));
		System.out.println("stringAfterjoining:\t" + stringAfterjoining);
	}

	private static void findAverageFromArray() {
		int[] intArr = { 7, 3, 6, 2, 1, 8 };
		int average = IntStream.of(intArr).sum() / intArr.length;
		System.out.println("average:\t" + average);

	}

	private static void findEvenNumbersAndAddFromList() {
		List<Integer> intList = Arrays.asList(1, 2, 3, 4, 5, 6);
		int sumOfEvenNumbers = intList.stream().filter(i -> i % 2 == 0).mapToInt(Integer::intValue).sum();
		System.out.println("sumOfEvenNumbers:\t" + sumOfEvenNumbers);
	}

	private static void primeFactorsOfNumber() {
		int num = 315;
		// write the logic here using stream api
		// Compute prime factors using Streams
		AtomicInteger number = new AtomicInteger(num); // Use AtomicInteger for mutability

		// Compute prime factors using Streams
		List<Integer> primeFactors = new ArrayList<>();
		IntStream.iterate(2, i -> i + 1).limit((int) Math.sqrt(number.get()) + 1) // Limit to sqrt(number)
				.filter(i -> number.get() % i == 0) // Check divisibility
				.filter(AllCodingProblemsInterviewCoding180525::isPrime) // Ensure it's a prime factor
				.forEach(i -> {
					while (number.get() % i == 0) { // Reduce number for repeated factors
						primeFactors.add(i);
						number.set(number.get() / i); // Modify AtomicInteger correctly
					}
				});

		System.out.println("Prime Factors: " + primeFactors);
	}

	private static void findFactorialOfNumber() {
		int number = 4;
		// write the logic here using stream api
		int factorial = IntStream.rangeClosed(1, number).reduce(1, (a, b) -> a * b);
		System.out.println("factorial:\t" + factorial);
	}

	private static void reverseCharArray() {
		char[] charArr = { 'a', 'b', 'c', 'd' };
		// write the logic here using stream api
		char[] reversedArray = IntStream.range(0, charArr.length).map(i -> charArr.length - 1 - i)
				.mapToObj(is -> charArr[is]).collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
				.toString().toCharArray();
		System.out.println("reversedArray:\t" + Arrays.toString(reversedArray));
	}

	private static void primeOrNotFromArray() {
		int[] intArr = { 1, 3, 5, 7, 9, 10 };
		// write the logic here using stream api
		Map<Integer, Boolean> primeMap = Arrays.stream(intArr).boxed()
				.collect(Collectors.toMap(n -> n, AllCodingProblemsInterviewCoding180525::isPrime));
		primeMap.forEach((num, isPrime) -> System.out.println(num + " is " + (isPrime ? "prime" : "not prime")));

	}

	private static boolean isPrime(int num) {
		if (num < 2)
			return false;
		return IntStream.rangeClosed(2, (int) Math.sqrt(num)).allMatch(i -> num % i != 0);
	}

	private static void isPalindromeNumberOrisPalindromeString() {
		// int number = 121;
		// String numStr = Integer.toString(number);
		// for palindrome string
		String numStr = "aba";

		String reversed = IntStream.range(0, numStr.length()).mapToObj(i -> numStr.charAt(numStr.length() - 1 - i))
				.map(String::valueOf).collect(Collectors.joining());
		if (numStr.equals(reversed)) {
			System.out.println("palindrome:\t" + reversed);
		}
	}

	private static void oddFirstThenEvenFromArray() {
		int[] intArr = { 1, 2, 7, 10, 6, 3, 12, 5 };
		Map<Boolean, List<Integer>> resultMap = Arrays.stream(intArr).mapToObj(is -> (int)is).collect(Collectors.partitioningBy(n -> n % 2 == 0));
		System.out.println("resultMap:\t" + resultMap);
	}

	private static void missingLetterAndMissingNumber() {
		// find missing character
		char[] charArr = { 'a', 'b', 'c', 'e' };
		char missingLetter = IntStream.range(0, charArr.length - 1)
				.mapToObj(i -> new char[] { charArr[i], charArr[i + 1] }) // Pair consecutive characters
				.filter(pair -> pair[1] - pair[0] > 1) // Identify the missing character
				.map(pair -> (char) (pair[0] + 1)).findFirst().orElse('\0'); // Default to empty character if none found

		System.out.println("Missing Letter:\t " + missingLetter);

		// find missing number
		int[] intArr = { 1, 2, 3, 5 };

		int missingNumber = IntStream.range(0, intArr.length - 1).mapToObj(i -> new int[] { intArr[i], intArr[i + 1] })
				.filter(pair -> pair[1] - pair[0] > 1).map(pair -> (int) (pair[0] + 1)).findFirst().orElse(0);
		System.out.println("missing number:\t" + missingNumber);

	}

	private static void findNoneZeroNumbersInArray() {
		int[] intArray = { 9, 6, 0, 0, 5, 0, -1, 0, 0 };
		List<Integer> nonZeroNumbers = Arrays.stream(intArray).filter(i -> i != 0).boxed().collect(Collectors.toList());
		System.out.println("nonZeroNumbers:\t" + nonZeroNumbers);
	}

	private static void findNegativeDominanceInArray() {
		int[] intArray = { 1, -2, -5, -4, 3, -6 };
		List<Integer> negativeDominance = Arrays.stream(intArray).filter(i -> i < 0).boxed()
				.collect(Collectors.toList());
		System.out.println("negativeDominance:\t" + negativeDominance);
	}

	private static void evenMultiplyOddDivide() {
		List<Integer> intList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		List<Integer> evenMultiply = intList.stream().filter(i -> i % 2 == 0).map(i -> i * i)
				.collect(Collectors.toList());
		System.out.println("evenMultiply:\t" + evenMultiply);
		List<Integer> oddDevide = intList.stream().filter(i -> i % 2 != 0).map(i -> i / i).collect(Collectors.toList());
		System.out.println("oddDevide:\t" + oddDevide);

		Map<Boolean, List<Integer>> resultMap = intList.stream().collect(Collectors.partitioningBy(i -> i % 2 == 0,
				Collectors.mapping(i -> (i % 2 == 0) ? (i * i) : (i / i), Collectors.toList())));
		System.out.println("even:\t" + resultMap.get(true));
		System.out.println("odd:\t" + resultMap.get(false));

	}

	private static void findMissingCharacterInString() {
		String actual = "apple";
		String check = "appe";
		List<Character> actualString = actual.chars().mapToObj(is -> (char) is).collect(Collectors.toList());
		check.chars().mapToObj(is -> (char) is).forEach(actualString::remove);
		String missingLetter = actualString.stream().map(Object::toString).collect(Collectors.joining());
		System.out.println("missingLetter:\t" + missingLetter);

		// or

		String missingLetter2 = actual.chars().mapToObj(is -> (char) is).filter(c -> check.indexOf(c) == -1)
				.map(Object::toString).collect(Collectors.joining());
		System.out.println("missingLetter2:\t" + missingLetter2);
	}

	private static void lenghtOfStringWithoutUsingPredefinedMethod() {
		String str = "hai";
		long lengthOfString = str.chars().mapToObj(is -> (char) is).map(Object::toString)
				.collect(Collectors.counting());
		System.out.println(lengthOfString);
	}

	private static void reverseCharactersInAString() {
		String str = "hai";
		String reverseString = str.chars().mapToObj(is -> (char) is).sorted((a, b) -> -1).map(Object::toString)
				.collect(Collectors.joining());
		System.out.println(reverseString);
	}

	private static void reverseStringWords() {
		String str = "How Are You?";
		String result = Arrays.stream(str.split("\\s")).sorted((a, b) -> -1).collect(Collectors.joining(" "));
		System.out.println(result);
	}

	private static void findNumberStartwithOneInGivenIntList() {
		List<Integer> myList = Arrays.asList(10, 15, 8, 49, 25, 98, 32, 17);
		List<Integer> numbersStartsWithOne = myList.stream().filter(number -> number.toString().startsWith("1"))
				.collect(Collectors.toList());
		// List<String> numbersStartsWithOne =
		// myList.stream().map(Object::toString).filter(number ->
		// number.startsWith("1")).collect(Collectors.toList());
		System.out.println(numbersStartsWithOne);
	}

	private static void extractingPartOfStringFromAGivenString() {
		String original = "Nagaraju Kailasa"; // Given string
		String searchString = "Kail"; // Part of the string to extract

		int startIndex = original.indexOf(searchString);

		if (startIndex != -1) {
			int endIndex = startIndex + searchString.length();
			String extractedString = original.substring(startIndex, endIndex);
			System.out.println("extracted string:\t" + extractedString);
		}
	}

	private static void findProfitOfStocks() {
		int[] arr = { 6, 4, 2, 4, 3, 20, 1 };
		int minPrice = Integer.MAX_VALUE;
		int maxProfit = 0;
		int minIndex = 0, buyDay = 0, sellDay = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] < minPrice) {
				minPrice = arr[i];
				minIndex = i;
			}
			int potentialProfit = arr[i] - minPrice;
			if (potentialProfit > maxProfit) {
				maxProfit = potentialProfit;
				buyDay = minIndex + 1;
				sellDay = i + 1;
			}
		}
		System.out.println("Max Profit: " + maxProfit);
		System.out.println("Buy on Day-" + buyDay);
		System.out.println("Sell on Day-" + sellDay);

		// another way
		findProfitOfStocksAnotherWay();

	}

	private static void findProfitOfStocksAnotherWay() {
		int[] prices = { 6, 4, 2, 4, 3, 20, 1 };
		int minIndex = 0, maxProfit = 0, buyDay = 0, sellDay = 0;
		for (int i = 1; i < prices.length; i++) {
			if (prices[i] < prices[minIndex]) {
				minIndex = i;
			}
			int profit = prices[i] - prices[minIndex];
			if (profit > maxProfit) {
				maxProfit = profit;
				buyDay = minIndex + 1;
				sellDay = i + 1;
			}
		}
		System.out.println("buyDay- " + buyDay + " sellDay- " + sellDay + " maxProfit:\t" + maxProfit);
	}

	private static void findFirstUniqueCharFromString() {
		// oneWayOfFindingNonRepeatedCharacterInAString();
		// secondWayOfFindingNonRepeatedCharacterInAString();
		// findFirstNonRepeatedCharacterInStringUsingStreamFirstWay(); //recommended
		// findFirstNonRepeatedCharacterInStringUsingStreamSecondWay();
	}

	private static void findFirstNonRepeatedCharacterInStringUsingStreamSecondWay() {

		String str = "zzzzzbbbccccddehhhhiii";

		Map<Character, Long> charCount = str.chars().mapToObj(c -> (char) c).collect(LinkedHashMap::new,
				(map, c) -> map.merge(c, 1L, Long::sum), LinkedHashMap::putAll);

		Optional<Character> firstNonRepeating = charCount.entrySet().stream().filter(entry -> entry.getValue() == 1)
				.map(Map.Entry::getKey).findFirst();
		firstNonRepeating.ifPresent(character -> System.out.println("first non repeating character : " + character));
		firstNonRepeating.orElse(null);
	}

	private static void findFirstNonRepeatedCharacterInStringUsingStreamFirstWay() {
		String str = "aabbbccd";
		Character uniqueChar = str.chars().mapToObj(is -> (char) is)
				.filter(ch -> str.indexOf(ch) == str.lastIndexOf(ch)).findFirst().get();
		System.out.println("using stream:\t" + uniqueChar);
	}

	private static void secondWayOfFindingNonRepeatedCharacterInAString() {
		String str = "zzzzzbbbccccddehhhhiii";
		int[] charCount = new int[256];

		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			charCount[ch]++;
		}
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (charCount[ch] == 1) {
				System.out.println(ch);
			}
		}
	}

	private static void oneWayOfFindingNonRepeatedCharacterInAString() {
		String str = "aabbccddefg";
		// using for loop
		for (int i = 0; i < str.length() - 1; i++) {
			if (str.indexOf(str.charAt(i)) == str.lastIndexOf(str.charAt(i))) {
				System.out.println(str.charAt(i));
				break;
			}
		}
		// using for each loop
		for (char c : str.toCharArray()) {
			if (str.indexOf(c) == str.lastIndexOf(c)) {
				System.out.println(c);
			}
		}
	}

	private static void countOccurrencesOfASubstringInAGivenString() {
		String str = "indians indian india";
		String subString = "ind";
		int index = 0;
		int count = 0;
		while ((index = str.indexOf(subString, index)) != -1) {
			count++;
			index += subString.length();
		}
		System.out.println("count of substring:\t" + count);

	}

	private static void returnListOfStringFromNestedListUsingStreams() {
		List<List<String>> nestedList = Arrays.asList(Arrays.asList("Saket", "sreekar"),
				Arrays.asList("sani", "manish"), Arrays.asList("Shawn", "Franklin"), Arrays.asList("Johnty", "Sean"));
		List<String> listOfStrings = nestedList.stream().flatMap(List::stream).collect(Collectors.toList());
		System.out.println("listOfStrings from nested list:\t" + listOfStrings);
	}

	private static void findFibonacciNumber() {
		// using iteration - O(n)
		int n = 10; // number of terms
		int first = 0;
		int second = 1;

		System.out.print(first + " " + second + " ");

		for (int i = 2; i < n; i++) {
			int next = first + second;
			System.out.print(next + " ");
			first = second;
			second = next;
		}

	}

	private static void findMissingNumberInArrayUsingBinarySearch() {
		// note : if you want to use binary search array should be sorted
		int missingNumber = missingNumberInArrayUsingBinarySearch();
		System.out.println("missing number using binary search o(log n):\t" + missingNumber);
	}

	private static int missingNumberInArrayUsingBinarySearch() {
		// O(log n)
		// note : if you want to use binary search array should be sorted
		int[] arr = { 1, 2, 3, 4, 6, 7, 8, 9, 10 };// here missing number is 5
		// here array is sorted
		int left = 0;
		int right = arr.length - 1;
		while (left <= right) {
			int mid = (left + right) / 2;
			if (arr[mid] == mid + 1) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return left + 1;

		/*
		 * Why use left + (right - left) / 2 instead of (left + right) / 2? If left +
		 * right is too large, it may cause integer overflow in languages like C and
		 * older Java versions.
		 */

	}

	private static void findMissingNumberInArrayUsingSumOfNaturalNumbers() {
		// find missing number using summation formula O(1)
		int[] arr = { 1, 2, 3, 4, 6, 7, 8, 9, 10 };// here missing number is 5
		int n = arr.length + 1; // including missing number
		int expectedSum = (n * (n + 1)) / 2; // sum of natural numbers
		// int actualSum = Arrays.stream(arr).sum();
		int actualSum = 0;
		for (int num : arr) {
			actualSum = actualSum + num;
		}
		int missingNumber = expectedSum - actualSum;

		System.out.println("missing number using summation formula o(1):\t" + missingNumber);

	}

	private static void findMinAndMaxElementFromArray() {
		int[] arr = { 4, 3, 5, 7, 2, 1 };
		int minElementFromArray = Arrays.stream(arr).min().getAsInt();
		System.out.println("minElementFromArray:\t" + minElementFromArray);
		int maxElementFromArray = Arrays.stream(arr).max().getAsInt();
		System.out.println("maxElementFromArray:\t" + maxElementFromArray);
	}

}
