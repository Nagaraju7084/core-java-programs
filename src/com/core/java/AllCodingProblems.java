package com.core.java;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.IntStream;

public class AllCodingProblems {

	public static void main(String[] args) {
//		HospitalComposition.composition();
//		Patient.aggregation();
//		Nurse.isARelation();
//		Record.immutableClass();
//		attachMessageToRandomNumberAndReturn();
		
//		findLongestSubString();
	}
	
	private static void findLongestSubString() {
		//String s = "abcabcbb";
		String s = "pwwkew";
		System.out.println("length of longest substring without repeating characters : " + lengthOfLongestSubstring(s));
	}

	private static int lengthOfLongestSubstring(String s) {
		int maxLength = 0;
		int left = 0;
		Set<Character> window = new HashSet<>();
		for(int right = 0; right < s.length(); right++) {
			//shrink the window if duplicate character is found
			while(window.contains(s.charAt(right))) {
				window.remove(s.charAt(left));
				left++;
			}
			//expand the window and update the result
			window.add(s.charAt(right));
			maxLength = Math.max(maxLength, right - left + 1);
		}
		System.out.println("window : " + window);
		return maxLength;
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

	private static void linkedListOperations() {
		
		LinkedList linkedList = new AllCodingProblems().new LinkedList();
		
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

static class HospitalComposition{
	
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
	public void aggregation(){
		System.out.println("aggregation");
	}
	
}

static class Nurse extends HospitalComposition{
	
	//Nurse extends HospitaComposition, is a relation
	public static void isARelation() {
		System.out.println("is a relation");
	}
}

final static class Record{
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
}