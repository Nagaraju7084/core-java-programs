package com.java8.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class SecondHighestSalary {

	public static void main(String[] args) {
		
		
		List<Employee2> empList = Arrays.asList(new Employee2(1, "abc1", 10000),
												new Employee2(1, "abc2", 20000),
												new Employee2(1, "abc3", 30000),
												new Employee2(1, "abc4", 40000),
												new Employee2(1, "abc5", 50000),
												new Employee2(1, "abc6", 60000),
												new Employee2(1, "abc7", 70000),
												new Employee2(1, "abc8", 80000),
												new Employee2(1, "abc9", 90000),
												new Employee2(1, "abc10", 120000)
												);
		
		Optional<Employee2> empHighestSalary = empList.stream()
				.sorted(
						Comparator.comparingDouble(Employee2::getSalary).reversed()
						).skip(1).findFirst();
		
		System.out.println(empHighestSalary.get());
		
		double sumOfSalaries = 		empList.stream().collect(Collectors.summingDouble(Employee2::getSalary));
		System.out.println("summing :\t"+sumOfSalaries);
		
	}
	
}

class Employee2{
	
	private int id;
	private String name;
	private double salary;
	
	
	public Employee2(int id, String name, double salary) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Employee2 [name=" + name + ", salary=" + salary + "]";
	}
	
}
