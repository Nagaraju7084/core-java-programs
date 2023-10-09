package com.core.java;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashMap;
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
		//usingLinkedHashMap();
		//usingHashSet();
		//usingCharArray();
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
		//countSubStringInAGivenString();
		//findSumOfIntsInArrayUsingStream();
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
		lenghtOfStringWithoutUsingPredefinedMethod();
		
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
		System.out.println(newStr.toString().trim());
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

	private static void findSumOfIntsInArrayUsingStream() {
		
		int a[] = {4, 11, 9, 12, 10, 7};

		Integer sumInts = Arrays.stream(a).filter(i -> i % 2 == 0).sum();
		
		System.out.println(sumInts);
	}

	private static void countSubStringInAGivenString() {
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

	private static void usingCharArray() {
		char[] charArr = {'a', 'f', 'f', 'd', 'g', 'd', 'e'};
		int n = charArr.length;
		
		char[] originalCharArr = new char[n];
		System.arraycopy(charArr, 0, originalCharArr, 0, n);
		
		for(int i=0; i<n; i++) {
			if(charArr[i] != '\0') {
				for(int j=i+1; j<n; j++) {
					if(charArr[i] == charArr[j]) {
						charArr[j] = '\0';
						charArr[i] = '\0';
					}
				}
			}
		}
		
		StringBuilder finalResult = new StringBuilder();
		for(char ch : charArr) {
			if(ch != '\0') {
				finalResult.append(ch);
			}
		}
		
		System.out.println("original array : " + new String(originalCharArr));
		System.out.println("after skipping duplicate character : " + finalResult.toString());
	}

	private static void usingHashSet() {
		String str = "AFFDGED";
		char[] charArr = str.toCharArray();
		
		Set<Character> uniqueChars = new HashSet<>();
		StringBuilder result = new StringBuilder();
		
		for(char ch : charArr) {
			if(!uniqueChars.contains(ch)) {
				uniqueChars.add(ch);
			}else {
				result.append(ch);
			}
		}
		
		StringBuilder finalResult = new StringBuilder();
		for(char c : charArr) {
			if(!result.toString().contains(String.valueOf(c))) {
				finalResult.append(c);
			}
		}
		
		System.out.println("original array : " + new String(charArr));
		System.out.println("after skipping duplicate character : " + finalResult);
	}

	private static void usingLinkedHashMap() {
		String str = "AFFDGED"; //

		char[] chars = str.toCharArray();
		Map<Character, Integer> map = new LinkedHashMap<Character, Integer>();
		for (Character c : chars) {
		    if(map.containsKey(c)) {
		    	map.put(c, map.get(c)+1);
		    	map.remove(c);
		    }else {
		    	map.put(c, 1);
		    }
		}

		System.out.println(map.keySet());
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