package com.core.java;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
		 List<Integer> list = Arrays.asList(1,2,3,4,5,6);
	        
	        List<Integer> evenNumbers = list.stream().filter(n -> n%2== 0).collect(Collectors.toList());
	        
	        System.out.println(evenNumbers);
	        List<Integer> oddNumbers = list.stream().filter(n -> n%2 != 0).collect(Collectors.toList());
	        System.out.println(oddNumbers);
	        
	        Logger logger = (s)-> System.out.println("log message \t" + s);
	        Logger logger2= s -> System.out.println(s);
	        logger.log("hello world");
	        logger2.log("no paranthesis");
	        
	        
	}

}

@FunctionalInterface
interface Logger{
	
	void log(String message);
	
	default void m1() {}
	public static void m2() {}
	
}












