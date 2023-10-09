package com.core.java;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetWithStringStringBufferStringBuilder {

	public static void main(String[] args) {
		Set<String> setOfStrings = new TreeSet<String>();
		setOfStrings.add("c");
		setOfStrings.add("b");
		setOfStrings.add("a");
		//System.out.println(setOfStrings); //upto java 10 version, only String allowed but not StringBuffer, StringBuilder
		
		//StringBuffer, StringBuilder
		
		/*
			we will not get any compile time error but we will get runtime exception i.e. ClassCastException
			because TreeSet and TreeMap will allow only homogenous comparable objects but here
			StringBuffer and StringBuilder are homogenous but not comparable
			any object is said to comparable if and only if the corresponding class should implements
			Comparable interface
		*/
		Set<StringBuffer> setOfStringBuffers = new TreeSet<>(new SBufferComarator());
		setOfStringBuffers.add(new StringBuffer("b")); 
		setOfStringBuffers.add(new StringBuffer("a")); 
		setOfStringBuffers.add(new StringBuffer("c")); 
		//System.out.println(setOfStringBuffers);
		
		Set<StringBuilder> setOfStringBuilders = new TreeSet<>(new SBuilderComparator());
		setOfStringBuilders.add(new StringBuilder("b"));
		setOfStringBuilders.add(new StringBuilder("a"));
		setOfStringBuilders.add(new StringBuilder("c"));
		//System.out.println(setOfStringBuilders);
		
		//to over come runtime exception i.e. ClassCastException, we have to implement our own sorting
		//i.e. customized sorting by using Comparator interface
		
		//using java1.1 anonymous inner class
		Set<StringBuilder> setOfStringBuildersUsingAnony = new TreeSet<StringBuilder>(new Comparator<StringBuilder>() {
			@Override
			public int compare(StringBuilder obj1, StringBuilder obj2) {
				return obj1.toString().compareTo(obj2.toString()); //ascending order
			}
		});
		
		setOfStringBuildersUsingAnony.add(new StringBuilder("b"));
		setOfStringBuildersUsingAnony.add(new StringBuilder("c"));
		setOfStringBuildersUsingAnony.add(new StringBuilder("a"));
		//System.out.println(setOfStringBuildersUsingAnony);
		
		//using java8 lambda
		Set<StringBuilder> setOfStringBuilderUsingLambda = new TreeSet<StringBuilder>((obj1,obj2) -> obj1.toString().compareTo(obj2.toString()));
		setOfStringBuilderUsingLambda.add(new StringBuilder("c"));
		setOfStringBuilderUsingLambda.add(new StringBuilder("b"));
		setOfStringBuilderUsingLambda.add(new StringBuilder("a"));
		//System.out.println(setOfStringBuilderUsingLambda);
		
		//using java8 method reference
		Set<StringBuilder> setOfStringBuilderUsingMethodRef = new TreeSet<StringBuilder>(MethodRef::methodRef);
		setOfStringBuilderUsingMethodRef.add(new StringBuilder("c"));
		setOfStringBuilderUsingMethodRef.add(new StringBuilder("b"));
		setOfStringBuilderUsingMethodRef.add(new StringBuilder("a"));
		System.out.println(setOfStringBuilderUsingMethodRef);
		
		//note : java 11 onwords, we can add directly StringBuffer, StringBuilder are implents Comparable
		//no need of explicitly implements Comparator
		
 		
	}
}
class SBufferComarator implements Comparator<StringBuffer>{
	@Override
	public int compare(StringBuffer obj1, StringBuffer obj2) {
		return obj1.toString().compareTo(obj2.toString()); //ascending order
	}
}

class SBuilderComparator implements Comparator<StringBuilder>{
	@Override
	public int compare(StringBuilder obj1, StringBuilder obj2) {
		return obj1.toString().compareTo(obj2.toString()); //ascending order
	}
}

class MethodRef{
	static int methodRef(StringBuilder obj1, StringBuilder obj2) {
		return obj1.toString().compareTo(obj2.toString());
	}
}
