package com.psystem;

import java.util.HashMap;
import java.util.Map;

public class Employee {
	
	String empName = "xyz";
	int empAge = 24;
	
	Employee(String empName, int empAge){
		this.empName = empName;
		this.empAge = empAge;
	}
	
	/*
	 * @Override public String toString() { return empName; }
	 */
	
	public static void main(String[] args) {
		Employee obj1 = new Employee("xyz",24);
		Employee obj2 = new Employee("xyz",25);
		
		Map<Object, Employee> employeeMap = new HashMap<>();
		
		employeeMap.put(obj1, obj1);
		employeeMap.put(obj2, obj2);
		System.out.println(employeeMap);
		
	}
}
