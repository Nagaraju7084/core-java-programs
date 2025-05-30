package com.java8.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class CustomSortingUsingJava8 {

	public static void main(String[] args) {
		
		Employee emp1 = new Employee();
		emp1.setName("bhumi");
		emp1.setSalary(2000);
		
		Employee emp2 = new Employee();
		emp2.setName("james");
		emp2.setSalary(4000);
		
		Employee emp3 = new Employee();
		emp3.setName("akash");
		emp3.setSalary(4000);
		
		List<Employee> empList = new ArrayList<Employee>();
		
		empList.add(emp1);
		empList.add(emp2);
		empList.add(emp3);
		
		System.out.println("empList before sorting:\t "+empList);
		
		
		//
		List<Employee> sortedList = empList
			.stream()
			.sorted(Comparator.comparing(Employee::getSalary)//comparing salary first if two employees having same salary then
					.thenComparing(Comparator.comparing(Employee::getName)))//comparing by names
			.collect(Collectors.toList());
	
		System.out.println("sorted list:\t "+sortedList);
		sortedList.forEach(System.out::println);
		
		Set set = new HashSet<>();
		List<Employee> distinctNames = empList.stream().filter(e -> set.add(e.getName()))
										.collect(Collectors.toList());
		System.out.println("distinctNames = "+distinctNames);//distinct / unique names
		Employee emp = empList.stream().max(Comparator.comparing(Employee::getSalary)).get();//max salary
		System.out.println(emp.getSalary() +":"+ emp.getName());
		
		Map<Integer, Employee2> empMap = new HashMap<>();
		empMap.put(1, new Employee2(1, "bhumi", 20000));
		empMap.put(1, new Employee2(1, "akash", 60000));
		
		Map<Integer, Employee2> result = empMap.entrySet().stream().filter(map -> map.getValue().getSalary() > 50000)
		.collect(Collectors.toMap(map -> map.getKey(), map -> map.getValue()));
		
		System.out.println("result from map :\t"+result);
		
		List<Integer> intList = Arrays.asList(1,2,1,3,3,2,4);
		intList.stream().filter(i -> i%2 == 0).distinct().forEach(System.out::println);

	}
	

}
