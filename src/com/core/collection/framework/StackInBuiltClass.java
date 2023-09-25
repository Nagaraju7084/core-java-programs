package com.core.collection.framework;

import java.util.Iterator;
import java.util.Stack;

public class StackInBuiltClass {

	public static void main(String[] args) {

		
		Stack<Integer> stackEx = new Stack<>();
		
		if(stackEx.isEmpty()) {
			stackEx.push(2);
			stackEx.push(9);
			stackEx.push(4);
		}
		
		System.out.println(stackEx);
		
		if(!stackEx.isEmpty()) {
			System.out.println(stackEx.peek());
		}
		if(!stackEx.isEmpty()) {
			//stackEx.pop();
			System.out.println(stackEx);
			System.out.println(stackEx.peek());
		}
		
		boolean status = stackEx.empty();
		System.out.println(status);
		
		int indexFound = stackEx.search(5);
		System.out.println(indexFound);
		
		Iterator itr = stackEx.iterator();
		if(itr.hasNext()) {
			Object value = itr.next();
			System.out.print(value);
		}
		System.out.println();
		System.out.println(stackEx.size());
		
		stackEx.sort(null);
		System.out.println(stackEx);
		
	}

}
