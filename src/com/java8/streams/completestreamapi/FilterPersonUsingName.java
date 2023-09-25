package com.java8.streams.completestreamapi;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IntSummaryStatistics;
import java.util.Iterator;
import java.util.List;
import java.util.LongSummaryStatistics;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Predicate;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FilterPersonUsingName {

	public static void main(String[] args) {
		
		//different ways to create a stream
		//waysToCreateStream();
	
		//sequentialstream operations
	
		//personOperations();
		//productPriceOperations();
		bookAndAuthorOperations();
		//stringArrayOperations();
		//intArrayOperations();
		//generalOperations();
		//generalOperationsTow();
		//terminalOperations();
		//shortCircuiteOperations();
		//calculateSumWithoutStream();
		//conversionOperations();
	
		//parallelstream operations
	
		//parallelStreamOperations(); //parallelstream used in multi threaded environment
		
	}

	private static void conversionOperations() {
		
		List<Student2> studentList = new ArrayList<>();
		
		Set<String> johnBooksSet = new HashSet<>();
			johnBooksSet.add("Core Java");
			johnBooksSet.add("Advanced Java");
			johnBooksSet.add("Spring");
			
		Set<String> leninBooksSet = new HashSet<>();
			leninBooksSet.add("Core Java");
			leninBooksSet.add("Hibernate");
			leninBooksSet.add("Spring MVC");	
		
		Student2 John = new Student2(10, "John", "john@gmail.com", johnBooksSet);
		Student2 Lenin = new Student2(20, "Lenin", "lenin@gmail.com", leninBooksSet);
			studentList.add(John);
			studentList.add(Lenin);
		
		/*Student Sarli = new Student(30, "Sarli", "sarli@gmail.com");
		Student Dev = new Student(40, "Dev", "dev@gmail.com");
		Student Len = new Student(50, "Len", "len@gmail.com");*/
		
		//converting studen object to employee object
		
		List<Employee> empList = studentList.stream()
				.map(s ->{
					Employee employee = new Employee();
						employee.setId(s.getId());
						employee.setName(s.getName());
						employee.setEmail(s.getEmail());
					return employee;
				}).collect(Collectors.toList());
		
		empList.forEach(System.out::println);
		
		Map<Integer, String> fruitsMap = new HashMap<>();
		
		fruitsMap.put(1, "Apple");
		fruitsMap.put(2, "Banana");
		fruitsMap.put(3, "Orange");
		
		String result = "";
		
		for(Map.Entry<Integer, String> entry : fruitsMap.entrySet()) {
			
			if(entry.getKey() == 2) {
				result = entry.getValue();
			}
		}
		
		System.out.println("result without stream : " + result);
		
		result = fruitsMap.entrySet().stream().filter(k -> k.getKey() == 2)
				.map(f -> f.getValue()).collect(Collectors.joining());
		
		System.out.println("result using stream : " + result);
		
		Map<Integer, String> requiredKeyValue = fruitsMap.entrySet().stream().filter(k -> k.getKey() == 2)
				.collect(Collectors.toMap(k -> k.getKey(), k -> k.getValue()));
		
		System.out.println("required key and value is : " + requiredKeyValue);
		
		String[][] stringTwoDArr = {{"a", "b"}, {"c", "d"}, {"e", "f"}};
		
		Stream<String[]> streamOneDArr = Arrays.stream(stringTwoDArr);
		Stream<String> streamOfString = streamOneDArr.flatMap(s -> Arrays.stream(s));
		Stream<String> filteredString = streamOfString.filter(s -> "a".equals(s.toString()));
		filteredString.forEach(System.out::println);
		
		Stream<Set<String>> setOfString = studentList.stream().map(std -> std.getBookSet());
		
		Stream<String> stringStream = setOfString.flatMap(st -> st.stream());
		
		List<String> resultString = stringStream.distinct().collect(Collectors.toList());
		System.out.println("unique books from both std1 list and std2 list : " + resultString);
		
		int[][] intTowDArr = {{1, 2, 3},{4, 5, 6}};
		Stream<int[]> streamArr = Stream.of(intTowDArr);
		IntStream intStream = streamArr.flatMapToInt(e -> Arrays.stream(e));
		intStream.forEach(e -> System.out.println(e));
		
	}

	private static void generalOperationsTow() {
		
		//return the list of student ids which are present in the string[]
		List<Student> studentList = Arrays.asList(
				new Student(10, "John", "john@gmail.com"),
				new Student(20, "Lenin", "lenin@gmail.com"),
				new Student(30, "Sarli", "sarli@gmail.com"),
				new Student(40, "Dev", "dev@gmail.com"),
				new Student(50, "Len", "len@gmail.com")
				);
		
		int[] arr = {10,20,30};
		
		Arrays.stream(arr).forEach(e -> System.out.println(e));
		
		List<Student> stdListNamesStart = studentList.stream().filter(s -> s.getName().startsWith("J")).collect(Collectors.toList());
		System.out.println("student names starts with 'J' : "+stdListNamesStart);
		List<String> namesStart = studentList.stream().map(Student::getName).filter(n -> n.startsWith("J")).collect(Collectors.toList());
		System.out.println("names starts with 'J' : "+namesStart);
		
		List<Integer> numList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
		
		numList.stream().reduce((n1, n2) -> n1 > n2 ? n1 : n2).ifPresent(n -> System.out.println("max : "+n));
		
		Integer total = numList.stream().reduce(0, (n1, n2) -> n1 + n2);
		System.out.println("total : "+total);
		
		OptionalInt optIntMin = IntStream.of(1, 2, 3).min();
		System.out.println("optInt : "+optIntMin);
		System.out.println("min : "+optIntMin.getAsInt());
		
		OptionalInt optIntMax = IntStream.of(1, 2, 3).max();
		System.out.println("optIntMax : "+optIntMax);
		System.out.println("max : "+optIntMax.getAsInt());
		
		Predicate<Integer> p = num -> num % 2 == 0;
		
		System.out.println("allMatch : "+ numList.stream().allMatch(p));
		System.out.println("anyMatch : "+ numList.stream().anyMatch(p));
		System.out.println("noneMatch : "+ numList.stream().noneMatch(p));
		
		Integer sumOfInts = numList.stream().collect(Collectors.summingInt(i -> i));
		System.out.println("sum of all integers : "+sumOfInts);
		
		List<Integer> listContains1To3Numbers = Arrays.asList(1, 2, 3);
		List<Integer> listContains4To6Numbers = Arrays.asList(4, 5, 6);
		List<Integer> listContains1To3NumbersWithDuplicates = Arrays.asList(1, 1, 2, 2, 3, 3, 4);
		
		Stream<Integer> concatedResultOfTwoLists = Stream.concat(listContains1To3Numbers.stream(), listContains4To6Numbers.stream());
		System.out.println("concatedResultOfTwoLists : ");
		concatedResultOfTwoLists.forEach(n -> System.out.print(n + " "));
		
		System.out.println("without filter, count : " + listContains4To6Numbers.stream().count());
		
		Predicate<Integer> evenNums = num -> num % 2 == 0;
		System.out.println("with filter, count : " + listContains4To6Numbers.stream().filter(evenNums).count());
		
		System.out.println("Distinct count : " + listContains1To3NumbersWithDuplicates.stream().distinct().count());
		
		System.out.println("even numbers listContains4To6Numbers : ");
		listContains4To6Numbers.stream().filter(evenNums).forEach(e -> System.out.println(e));
		
		List<String> letterList = Arrays.asList("G","B","F","E");
		
		String any = letterList.stream().findAny().get();
		System.out.println("findAny : " + any);
		
		String findFirst = letterList.stream().findFirst().get();
		System.out.println("findFirst : " + findFirst);
		
		Integer[][] twoDArray = {
				
				{1, 2}, {3, 4}, {5, 6}
		};
	
		System.out.println("complete two dim array elements are : ");
		Arrays.stream(twoDArray).flatMap(row -> Arrays.stream(row)).forEach(e -> System.out.print(e + " "));
		
		System.out.println();
		System.out.println("stream");
		System.out.println("multiplying the numbers with the same number or square of each number in  listContains1To3Numbers: ");
		listContains1To3Numbers.stream().map(n -> n * n).forEach(n -> System.out.print(n + " "));
		
		System.out.println();
		System.out.println("double stream");
		listContains1To3Numbers.stream().mapToDouble(n -> n * n).forEach(n -> System.out.println(n));
		
		String max = letterList.stream().max(Comparator.comparing(String::valueOf)).get();
		System.out.println("max : "+max);
		
		String min = letterList.stream().min(Comparator.comparing(String::valueOf)).get();
		System.out.println("min : "+min);
		
		Stream.of("one", "two", "three", "four").filter(s -> s.length() > 3)
		.peek(s -> System.out.println("filtered value : "+s))
		.map(s -> s.toUpperCase())
		.peek(s -> System.out.println("mapped value : "+s))
		.collect(Collectors.toList());
		
		int sum = listContains1To3Numbers.stream().reduce(0, (n1, n2) -> n1 + n2);
		System.out.println("sum : "+sum);
		
		List<Integer> listContains4Numbers = Arrays.asList(5, 10, 15, 20);
		Integer secondHighestMaxNumber = listContains4Numbers.stream()
				.distinct().sorted(Comparator.reverseOrder()).skip(1).findFirst().orElse(null);
		System.out.println("maxNumber : "+secondHighestMaxNumber);
		
		List<Integer> intNums = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
		
		//summation using stream
		int summation = intNums.stream().mapToInt(n -> n).sum();
		System.out.println("summation using stream : "+summation);
		
		convertToLowerCaseWithoutStream(letterList);
		
		//using stream to converting lowercase letters
		List<String> lowerCaseLetters = letterList.stream().map(s -> s.toLowerCase()).collect(Collectors.toList());
		System.out.println("using stream, converting uppercase to lower case : " + lowerCaseLetters);
		
		//sum = 6 (1 + 2 +3)
		OptionalInt optInt = IntStream.range(1, 4).reduce((a, b) -> a + b);
		System.out.println(optInt.getAsInt());
		
		//sum = 16 (10 + 1 + 2 +3)
		int sum2 = IntStream.range(1,  4).reduce(10, (a, b) -> a + b);
		System.out.println(sum2);
		
		
		
	}

	private static void calculateSumWithoutStream() {
		
		List<Integer> intNums = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
		calculateSumWithoutStream(intNums);
		
	}

	private static void convertToLowerCaseWithoutStream(List<String> letterList) {
		List<String> lowerCaseLetters = new ArrayList<String>();
		Iterator<String> itr = letterList.iterator();
		while(itr.hasNext()) {
			lowerCaseLetters.add(itr.next().toLowerCase());
		}
		System.out.println("letters in the list after convertion : " + lowerCaseLetters);
	}

	private static void calculateSumWithoutStream(List<Integer> numbers) {
		
		int sum = 0;
		
		Iterator<Integer> itr = numbers.iterator();
		
		while(itr.hasNext()) {
			sum = sum + itr.next();
		}
		
		System.out.println("summation of numbers in list : " + sum);
	}

	private static void waysToCreateStream() {
		
		//1.stream() and parallelStream() from collection objects
		List<String> names = Arrays.asList("Peter", "Ram", "Pradeep", "Stev");
		Stream<String> sequentialStream = names.stream();
		Stream<String> parallelStream = names.parallelStream();
		
		//2.Arrays.stream() from an array
		int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		IntStream intStream = Arrays.stream(numbers);
		
		//3.from static factory methods of stream classes : Stream.of(--), IntStream.range(--),
		//Stream.iterate(--), Stream.empty(), Stream.generate(--), ...
		Stream<String> streamOf = Stream.of("java", "sample", "approach", ".com");
		IntStream streamRange = IntStream.range(0, 10);
		Stream<Integer> streamItr = Stream.iterate(0, n -> n + 3).limit(10);
		Stream<String> emptyStream = Stream.empty();
		Stream<Double> streamGenereate = Stream.generate(Math::random).limit(10);
		
		//4.from methods in java.nio.file.Files
		
		try {
			long numberWords = java.nio.file.Files
					.lines(Paths.get("file.txt"),
							Charset.defaultCharset())
					.flatMap(line -> Arrays.stream(line.split(" .")))
					.distinct().count();
		}catch(IOException e) {
			System.out.println("IOException when reading or getting data from file");
		}
	}

	private static void parallelStreamOperations() {
		
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		
		//creating a parallelstream here
		Integer[] evenNumbersArray = numbers.parallelStream().filter(num -> num % 2 == 0).toArray(Integer[]::new);
		System.out.println("storing even numbers in integer array : "+Arrays.toString(evenNumbersArray));
		
	}

	private static void shortCircuiteOperations() {
		
		List<String> names = Arrays.asList("Amitab", "Shekar", "Aman","Rahul","Sharukh","Salman","Yana","Lokesh");
		
		//any match is short circuite operation which will return true when first match found in the list, it won't check
		//remaining elements once match found and it is a terminal operation alos
		boolean anyMatch = names.stream().anyMatch(s -> s.startsWith("S"));
		System.out.println("anyMatch : "+anyMatch);
		
		//findfirst won't process remaining elements after first match found
		//findfirst returns optional<datatype> element of first match,
		//once first match found, it won't process remaining elements
		String firstMatchedName = names.stream().filter(s -> s.startsWith("S")).findFirst().get();
		System.out.println("first match : "+firstMatchedName);
		
	}

	private static void productPriceOperations() {
		
		//product service
				List<Product> productList = Arrays.asList(new Product(101, "Sony Mobile", 25000),
						new Product(102, "Lenovo Mobile", 15000),
						new Product(103, "Nokia Mobile", 10000),
						new Product(104, "Samsung Mobile", 40000),
						new Product(103, "Micromax Mobile", 10000));
				
				System.out.println("========Operations on Product and Price Here===================");
				
				//get products which are < 20000
				FilterPersonUsingName filterPersonUsingName = new FilterPersonUsingName();
				List<Product> productListByPrice = filterPersonUsingName.getProductsByPrice(productList);
				System.out.println(productListByPrice);
				
				//using java8
				List<Product> productListByPricing = productList.stream().filter(pro -> pro.getPrice() < 20000).collect(Collectors.toList());
				productListByPricing.forEach(product -> System.out.println(product));
				
				//get only product names which are having the price < 20000
				List<String> productNames = productList.stream().filter(prod -> prod.getPrice() < 20000)
						.map(Product::getProductName)
						.collect(Collectors.toList());
				productNames.forEach(System.out::println);
				
				//get only single product name is Sony Mobile
				String mobileName = productList.stream().filter(pro -> pro.getProductName().equals("Sony Mobile")).
						map(Product::getProductName).findAny().orElse(null);
						System.out.println(mobileName);
						
				//count number of products
				long productsCount = productList.stream().filter(pro -> pro.getPrice() < 20000).count();
				System.out.println(productsCount);
				
				//get total price using reduce method
				//using reduce method we can do sum, min, max, avg and string concatenation
				
				int totalPrice = productList.stream().map(Product::getPrice).reduce(0, (sum, price) -> sum+price);
				System.out.println(totalPrice);
				
				int totalPrice2 = productList.stream().map(Product::getPrice)
						.reduce(0, Integer::sum); //accumulating price by method reference of Integer class
				System.out.println(totalPrice2);
				
				//using collector's method to sum the prices
				
				LongSummaryStatistics longSummaryStatistics = productList.stream().collect(Collectors.summarizingLong(Product::getPrice));
				System.out.println(longSummaryStatistics);
				
				//max price product
				Product maxPriceProduct = productList.stream().max((p1, p2) ->
				p1.getPrice() > p2.getPrice() ? 1: -1).get();
				System.out.println(maxPriceProduct);
				
				//min price product
				Product minPriceProduct = productList.stream().min((p1, p2) ->
				p1.getPrice() > p2.getPrice() ? 1: -1).get();
				System.out.println(minPriceProduct);
				
				//filtered result stored into set by removing duplicates
				Set<Integer> productPriceSet = productList.stream().filter(product -> product.getPrice() < 20000) //filter product based on the price
				.map(Product::getPrice)
				.collect(Collectors.toSet()); //collect as a set by removing duplicate elements
				System.out.println(productPriceSet);
				
				//converting product list to map
				Map<String, Integer> productMap = productList.stream().collect(Collectors.toMap(Product::getProductName, Product::getPrice));
				System.out.println(productMap);
				
				//fetchin only product names
				List<String> allProductNames = productList.stream().map(Product::getProductName).collect(Collectors.toList());
				System.out.println(allProductNames);
				
				//fetching product names which are having the price > 20000
				Map<String, Integer> productNamesGtTwentyK = productList.stream().filter(p -> p.getPrice() > 20000)
						.collect(Collectors.toMap(Product::getProductName, Product::getPrice));
				System.out.println(productNamesGtTwentyK);
				
				Integer sonyPrice = productList.stream().filter(p -> p.getProductName().equals("Sony Mobile"))
						.map(Product::getPrice).findAny().get();
				System.out.println(sonyPrice);
				
				//sort based on product name
				List<Product> sortedProductList = productList.stream().sorted(Comparator.comparing(Product::getProductName)).collect(Collectors.toList());
				System.out.println(sortedProductList);
				
				//finding second highest price product
				Integer secondPriceProduct = productList.stream().sorted((Comparator.comparing(Product::getPrice).reversed()))
						.map(Product::getPrice).skip(1).findFirst().get();
				System.out.println(secondPriceProduct);
				
				//get max price product and second highest price product and group the result
				 productList.stream()
						 .collect(
								 Collectors.groupingBy(
								 p -> p.getPrice() == productList.stream()
								 .mapToInt(Product::getPrice)
								 .max()
								 .orElse(0)
								 ? "Max Price" : "Second Highest Price",
										 Collectors.mapping(Product::getPrice, Collectors.maxBy(Comparator.naturalOrder()))
						 )).forEach((group, price) -> 
						 System.out.println(group + " : "+ price.orElse(0)));
				 
				 List<String> productNamesOnlyWithoutStream = new ArrayList<String>();
				 
				 for(Product prod : productList) {
					 productNamesOnlyWithoutStream.add(prod.getProductName());
				 }
				 
				 System.out.println("productNamesOnlyWithoutStream : " + productNamesOnlyWithoutStream);
				 
				 //displaying product names only using stream
				 List<String> productNamesOnlyUsingStream = productList.stream().map(Product::getProductName).collect(Collectors.toList());
				 System.out.println("productNamesOnlyUsingStream : " + productNamesOnlyUsingStream);
				 
		List<String> stringList = productList.stream().map(p -> p.getProductName()).collect(Collectors.toList());
		System.out.println("stringList : " + stringList);
		String listToString = productList.stream().map(p -> p.getProductName())
				.collect(Collectors.joining(",","[","]"));
		System.out.println("listToString : " + listToString);
		
		double avgPrice = productList.stream().collect(Collectors.averagingInt(Product::getPrice));
		System.out.println("avgPrice : " + avgPrice);
		
		Integer intSum = productList.stream().collect(Collectors.summingInt(p -> p.getPrice()));
		System.out.println("intSum : " + intSum);
		
		IntSummaryStatistics summaryStats = productList.stream().collect(Collectors.summarizingInt(p -> p.getPrice()));
		System.out.println("summaryStats : " + summaryStats);
		System.out.println("count => summaryStats : " + summaryStats.getCount());
		System.out.println("avg => summaryStats : " + summaryStats.getAverage());
		System.out.println("max => summaryStats : " + summaryStats.getMax());
		System.out.println("min => summaryStats : " + summaryStats.getMin());
		System.out.println("sum => summaryStats : " + summaryStats.getSum());
		
		Map<Integer, List<Product>> groupMap = productList.stream().collect(Collectors.groupingBy(p -> p.getPrice()));
		Set<Entry<Integer, List<Product>>> entrySet = groupMap.entrySet();
		for(Entry<Integer, List<Product>> entry : entrySet) {
			System.out.println(entry.getKey() + " = " + entry.getValue());
		}
		
		System.out.println("------------------");
		
		Map<Boolean, List<Product>> partitionedMap = productList.stream().collect(Collectors.partitioningBy(p -> p.getPrice() > 15000));
		Set<Entry<Boolean, List<Product>>> entrySetPrice = partitionedMap.entrySet();
		for(Entry<Boolean, List<Product>> oneEntry : entrySetPrice) {
			System.out.println(oneEntry.getKey() + " = " + oneEntry.getValue());
		}
		
		Set<Product> productSet = productList.stream().collect(Collectors.collectingAndThen(Collectors.toSet(), Collections::unmodifiableSet));
		System.out.println("unmodifiable set : " + productSet);
		
		Stream<Product> streamsP = productList.parallelStream();
		boolean isParallelStream = streamsP.isParallel();
		System.out.println("isParallelStream : " + isParallelStream);
		boolean isBigPrice = streamsP.map(p -> p.getPrice())
				.anyMatch(p -> p > 10000);
		System.out.println("isBigPrice : " + isBigPrice);
		
		List<Student3> studentLists = new ArrayList<>();
		studentLists.add(new Student3("Alice", 82));
		studentLists.add(new Student3("Bob", 90));
		studentLists.add(new Student3("Carol", 67));
		studentLists.add(new Student3("David", 80));
		studentLists.add(new Student3("Aric", 55));
		studentLists.add(new Student3("Frack", 49));
		studentLists.add(new Student3("Gary", 88));
		studentLists.add(new Student3("Henry", 98));
		studentLists.add(new Student3("Ivan", 66));
		studentLists.add(new Student3("John", 52));
		
		//find the students whose score is > 80
		//without stream
		calculateScore(studentLists);
		
		//using stream
		
		List<Student3> goodStudents = studentLists.stream().filter(s -> s.getScore() > 80).collect(Collectors.toList());
		System.out.println("goodStudents : " + goodStudents);
		
		//find top 3 students
		List<Student3> top3Students = studentLists.stream().filter(s -> s.getScore() >= 80).sorted().limit(3).collect(Collectors.toList());
		System.out.println("top3Studnets : " + top3Students);
		studentLists.stream().filter(s -> s.getScore() >= 80).map(s -> s.getName()).sorted().forEach(System.out::println);
		
		List<Article> articleList = getArticleList();
		Article article = getFirstArticleUsingForLoop(articleList);
		System.out.println("first article : " + article);
		getFirstArticleUsingStream(articleList);
		
		groupByAuthorUsingForLoop(articleList);
		//using stream
		groupByAuthorUsingStream(articleList);
		getDistinctTagNamesUsingForLoop(articleList);
		//using stream
		getDistinctTagNamesUsingStream(articleList);
		//group by using stream
		getStudentGroupByTeacher(getStudentList());
		getStudentGroupByTeacherCounting(getStudentList());
	}

	private static void getStudentGroupByTeacherCounting(List<Student4> studentList) {
		 Map<String, Long> groupByAndCounting = studentList.stream().collect(Collectors.groupingBy(Student4::getTeacherName, Collectors.counting()));
		 groupByAndCounting.entrySet().stream().forEach(System.out::println);
	}

	private static void getStudentGroupByTeacher(List<Student4> studentList) {
		Map<String, List<Student4>> groupByMap = studentList.stream().collect(Collectors.groupingBy(Student4::getTeacherName));
		groupByMap.entrySet().stream().forEach(System.out::println);
	}

	private static List<Student4> getStudentList() {
		List<Student4> studentList = new ArrayList<>();
		studentList.add(new Student4("Peter", "Mr.John", 1, "Java Basics"));
		studentList.add(new Student4("Ram", "Mr.John", 1, "Web Service Basics"));
		studentList.add(new Student4("Juli", "Mr.John", 2, "Advance Java"));
		studentList.add(new Student4("Dave", "Mr.Kumar", 1, "Ruby Basics"));
		studentList.add(new Student4("Raja", "Mr.Kumar", 2, "Advance Ruby"));
		return studentList;
	}

	private static void getDistinctTagNamesUsingStream(List<Article> articleList) {
		articleList.stream().map(Article::getTagName).distinct().forEach(System.out::println);
	}

	private static void getDistinctTagNamesUsingForLoop(List<Article> articleList) {
		Set<String> distinctTagNames = new HashSet<>();
		for(Article article : articleList) {
			distinctTagNames.add(article.getTagName());
		}
		System.out.println("distinctTagNames : " + distinctTagNames);
		System.out.println("------------------");
	}

	private static void groupByAuthorUsingStream(List<Article> articleList) {
		Map<String, List<Article>> groupByMap = articleList.stream()
		.collect(Collectors.groupingBy(Article::getAuthor));
		System.out.println("groupby using stream");
		groupByMap.entrySet().stream().forEach(System.out::println);
	}

	private static void groupByAuthorUsingForLoop(List<Article> articleList) {
		
		Map<String, List<Article>> groupByAuthorMap = new HashMap<>();
		
		for(Article article : articleList) {
			if(groupByAuthorMap.containsKey(article.getAuthor())) {
				groupByAuthorMap.get(article.getAuthor()).add(article);
			}else {
				List<Article> articleList2 = new ArrayList<>();
				articleList2.add(article);
				groupByAuthorMap.put(article.getAuthor(), articleList2);
			}
		}
		
		for(String key : groupByAuthorMap.keySet()) {
			System.out.println(key + " = " + groupByAuthorMap.get(key));
		}
		groupByAuthorMap = null;
		System.out.println("----------");
	}

	private static void getFirstArticleUsingStream(List<Article> articleList) {
		Article firstArticle = articleList.stream().filter(a -> a.getTagName().contains("John")).findFirst().get();
		System.out.println("firstArticle : " + firstArticle);
	}

	private static Article getFirstArticleUsingForLoop(List<Article> articleList) {
		for(Article art : articleList) {
			if(art.getTagName().contains("Java")) {
				return art;
			}
		}
		return null;
	}

	private static List<Article> getArticleList() {
		List<Article> artcalList = Arrays.asList(
				new Article("Java Complete Reference", "John", "Java"),
				new Article("Java Programming", "John", "Java"),
				new Article("Restfull Web Services", "John", "Web Services"),
				new Article("Programming Ruby", "John", "Ruby")
				);
		return artcalList;
	}

	private static void calculateScore(List<Student3> studentLists) {
		List<Student3> goodStudents = new ArrayList<>();
		for(Student3 std : studentLists) {
			if(std.getScore() > 80) {
				goodStudents.add(std);
			}
		}
		
		System.out.println("stduents whose score is > 80 : " + goodStudents);
		
		double sum = 0.0;
		for(Student3 stdd : studentLists) {
			sum = sum + stdd.getScore();
		}
		double average = sum / studentLists.size();
		System.out.println("average : " + average);
	}

	private static void personOperations() {
		
		List<Person> listOfPersons = Arrays.asList(new Person(10, "Ram", 25),
				new Person(11, "Steven", 35),
				new Person(12, "Peter", 27),
				new Person(13, "Martin", 19),
				new Person(14, "John", 19));
		
		FilterPersonUsingName filterPersonUsingName = new FilterPersonUsingName(); 
		Person person = filterPersonUsingName.getPersonByName(listOfPersons, "Steven");
		System.out.println(person);
		
		//using java8
		Person person2 = listOfPersons.stream().filter(pers -> pers.getName().equals("Steven") 
				&& pers.getAge() == 35).findAny().orElse(null);
		System.out.println(person2);

		//Convert Stream<Person> to Stream<String> using Map
		String personName = listOfPersons.stream().filter(pers -> pers.getName().equals("Steven")).
				map(Person::getName).findAny().orElse(null);
		System.out.println(personName);
		//sort the person based on age in ascending order(by default order)
		listOfPersons.stream().sorted(Comparator.comparing(Person::getAge)).forEach(System.out::println);
		//sort the person based on age in descending order
		System.out.println();
		listOfPersons.stream().sorted(Comparator.comparing(Person::getAge).reversed()).forEach(System.out::println);
		//sort the person based on name in ascending order(by default order)
		System.out.println();
		//listOfPersons.stream().sorted(Comparator.comparing(Person::getName)).forEach(System.out::println);
		//or
		//sort the person based on name in ascending or alphabatical order
		listOfPersons.stream().sorted((p1, p2) -> p1.getName().compareTo(p2.getName())).forEach(System.out::println);
		//sort the person based on name in descending or reverse of alphabatical order
		listOfPersons.stream().sorted((p1, p2) -> p2.getName().compareTo(p1.getName())).forEach(System.out::println);
		//sort based on age using sort and by eleminatin duplicate age using distinct
		System.out.println();
		List<Integer> agesList = listOfPersons.stream().map(Person::getAge).distinct().sorted().collect(Collectors.toList());
		System.out.println("agestList : "+ agesList);
		agesList.stream().limit(2).forEach(System.out::println);
		System.out.println();
		agesList.stream().skip(3).forEach(System.out::println);
		System.out.println(listOfPersons.stream().anyMatch(p -> p.getName().startsWith("Ali")));
		System.out.println(listOfPersons.stream().anyMatch(p -> p.getAge() > 40 ));
		System.out.println(listOfPersons.stream().noneMatch(p -> p.getName().endsWith("yahoo")));
		List<String> onlyNames = listOfPersons.stream().map(Person::getName).collect(Collectors.toList());
		System.out.println("onlyNmaes : " + onlyNames);
		TreeSet<Integer> personIds = listOfPersons.stream().map(Person::getPersonId).collect(Collectors.toCollection(TreeSet::new));
		System.out.println("personIds : " + personIds);
		Map<String, List<Person>> groupingByName = listOfPersons.stream().collect(Collectors.groupingBy(Person::getName));
		System.out.println("groupingByName : " + groupingByName);
		String names = listOfPersons.stream().map(Person::getName).collect(Collectors.joining(", "));
		System.out.println("names : " + names);
		
	}

	private static void bookAndAuthorOperations() {
		
		List<Book> bookList = Arrays.asList(
				new Book("Java Basics",   new Author("James Gosling", "james@gmail.com", 20, 'M'), 1000.0),
				new Book("Mysql Basics",  new Author("Steven", "steven@gmail.com", 30, 'M'), 	   500.0),
				new Book("Oracel Basics", new Author("John", "john@gmail.com", 40, 'M'), 		   750.0),
				new Book("Angular Basics",new Author("Juli", "dev@gmail.com", 25, 'F'), 		   1220.0),
				new Book("React Basics",  new Author("Peter", "peter@gmail.com", 60, 'M'), 		   1500.0),
				new Book("JQuery Basics", new Author("Peter", "peter@gmail.com", 65, 'M'), 		   1500.0)
				);
				
		System.out.println("========Operations on Book and Author Here===================" + bookList);
		 List<String> filteredAuthorNames = bookList.stream() //stream of book
				 							.map(Book::getAuthor) //stream<Book> to stream<Author>
											.filter(a -> a.getAge() >= 30) //filter author who's age is >= 30
											.map(Author::getName) //stream<Author> to steam<Name>
											.map(String::toUpperCase) //convert name as upper case
											.distinct() //get the unique elements meaning without duplicates
											.limit(2) // grab the first two records
											.collect(Collectors.toList()); //collect the result as list
		 System.out.println(filteredAuthorNames);
		 
		 //sum of ages of all male authors younger than 50
		 Integer sumOfMaleAuthorAges = 
				 bookList.stream() //stream<Book>
				 .map(Book::getAuthor) //stream<Book> to stream<Author>
				 .filter(a -> a.getGender() == 'M') //filter the male author
				 .map(Author::getAge) //stream<Author> to stream<Age>
				 .filter(age -> age < 50) //filter the age < 50
				 .reduce(0, Integer::sum); //calculate the sum of ages
		 System.out.println("--------------");
		 List<Author> authorList = bookList.stream().map(Book::getAuthor).filter(a -> 'M' == a.getGender()).collect(Collectors.toList());
		 System.out.println("authorList : " + authorList);
		 bookList.stream().map(Book::getAuthor).filter(a -> a.getAge() <= 25 && 
				 'F' == a.getGender()).forEach(System.out::println);
		 
		 bookList.stream().map(Book::getAuthor).map(Author::getEmail).limit(2).forEach(System.out::println);
		 bookList.stream().map(Book::getAuthor).map(Author::getAge).forEach(System.out::println);
		 long maleGenders = bookList.stream().map(Book::getAuthor).filter(a -> 'F' == a.getGender()).count();
		 System.out.println("maleGenders : " + maleGenders);
		 Author youngestAuthorUsingMin = bookList.stream().map(Book::getAuthor)
				 .filter(a -> 'M' == a.getGender()).min((p1, p2) -> p1.getAge() - p2.getAge()).get();
		 System.out.println("youngestAuthorUsingMin : " + youngestAuthorUsingMin);
		 Author oldestAuthorUsingMaxValue = bookList.stream().map(Book::getAuthor)
				 .filter(a -> 'M' == a.getGender()).max((p1, p2) -> p1.getAge() - p2.getAge()).get();
		 System.out.println("oldestAuthorUsingMaxValue : " + oldestAuthorUsingMaxValue);
		 String allNames = bookList.stream().map(Book::getAuthor).map(Author::getName).reduce((n1, n2) -> n1 + ", " + n2).get();
		 System.out.println("allNames : " + allNames);
		 String str = "Welcome,to,India";
		 Pattern.compile(",").splitAsStream(str).forEach(System.out::println);
		 List<String> animals = Arrays.asList("Ball", "Cat", "Dog", "Apple");
		 animals.stream().filter(ele -> !ele.startsWith("D")).map(String::toUpperCase).forEach(System.out::println);
		 
		 //creating map in which key is author age, and value is author object
		 Map<Integer, Author> authorMap = new HashMap<>();

		 authorMap.put(20, new Author("James Gosling", "james@gmail.com", 20, 'M'));
		 authorMap.put(30, new Author("Steven", "steven@gmail.com", 30, 'M'));
		 authorMap.put(40, new Author("John", "john@gmail.com", 40, 'M'));
		 authorMap.put(25, new Author("Juli", "dev@gmail.com", 25, 'F'));
		 authorMap.put(60, new Author("Peter", "peter@gmail.com", 60, 'M'));
		//printing format as authorname:age
		 authorMap.forEach((key, value) -> System.out.println(value.getAge()+ " : "+value.getName()));
		 System.out.println("using forEach");
		 bookList.stream().map(Book::getAuthor).forEach(author ->{
			 if(author.getAge() >= 30) {
				 System.out.println(author.getAge());
			 }
		 });
		 System.out.println("using lamda");
		 bookList.stream().map(Book::getAuthor).filter(author -> author.getAge() >= 30)
		 			.forEach(author -> System.out.println(author.getAge()));
		 
	}

	private static void stringArrayOperations() {
		
		System.out.println("======================String Array Here===========");
		 String[] personNmaes = {"Peeter", "Stev", "Paul", "Ram"};
		 
		 //convert the names into uppercase
		 String[] personNamesInUppercase = Arrays.stream(personNmaes).map(n -> n.toUpperCase()).toArray(String[]::new);
		 Arrays.stream(personNamesInUppercase).forEach(n -> System.out.println(n));
		 
		 //filter the names whose length is > 4
		 String[] filteredNamesGtLF = Arrays.stream(personNmaes).filter(n -> n.length() > 4).toArray(String[]::new);
		 System.out.println(Arrays.toString(filteredNamesGtLF));
		 
		 String[] words = {"Welcome ", "to ", "India ", "Peter"};
		 //concatenate all the words using reduce method
		 String sentence = Arrays.stream(words).reduce("", (a, b) -> a + b);
		 System.out.println(sentence);
		
	}

	private static void intArrayOperations() {
		
		System.out.println("======================int Array Here===========");
		 int[] numbers = {2, 6, 8};
		 
		 //sum
		 int sum = Arrays.stream(numbers).sum();
		 System.out.println(sum);
		 //count
		 long count = Arrays.stream(numbers).count();
		 System.out.println(count);
		 //average
		 OptionalDouble average = Arrays.stream(numbers).average();
		 System.out.println(average.getAsDouble());
		
	}

	private static void generalOperations() {
		
		 System.out.println("======================general here===========");
			//print numbers using iterate method of stream
				Stream.iterate(1, num -> num + 1)
				.filter(num -> num%2 ==0).limit(5).forEach(System.out::println);
				
			Stream<Integer> streamOfInt = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
			streamOfInt.forEach(n -> System.out.println(n));
			
			Stream<Date> stream = Stream.generate(() -> {
										return new Date();
									});
			//stream.forEach(d -> System.out.println(d));
			
			IntStream intStream = "12345_abcdefg".chars();
			intStream.forEach(c -> System.out.print((char)c));
			
			System.out.println();
			Stream<String> resultStream = Stream.of("A$B$C".split("\\$"));
			resultStream.forEach(s -> System.out.println(s));
			
			List<Integer> numbersList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
			List<Integer> evenNumbers = numbersList.stream().filter(n -> n%2 == 0).collect(Collectors.toList());
			System.out.println(evenNumbers);
			Integer[] evenNumbersArray = numbersList.stream().filter(n -> n%2 == 0).toArray(Integer[]::new);
			System.out.println(Arrays.toString(evenNumbersArray));
		
	}

	private static void terminalOperations() {
		
		System.out.println("============list of strings here===========");
		List<String> namesList = Arrays.asList("Amitab", "Shekar", "Aman", "Rahul", "Shahrukh", "Salman", "Yana", "Lokesh");
		
		//filter the names starts with A and convert to uppercase if mathc found
		namesList.stream().filter(s -> s.startsWith("A"))
		.map(String::toUpperCase).forEach(System.out::println);
		
		//convert all names to uppercase and sort all the names as ascending order
		namesList.stream().sorted().map(String::toUpperCase).forEach(System.out::println);
		
		System.out.println("=======terminal operations============");
		namesList.forEach(System.out::println);
		
		//convert string to uppercase letters 
		List<String> uppercaseNames = namesList.stream().sorted().map(String::toUpperCase).collect(Collectors.toList());
		System.out.println(uppercaseNames);
		
		//anymatch returns true if it found at least one match with the given boolean check
		boolean anyMatch = namesList.stream().anyMatch(s -> s.startsWith("A"));
		System.out.println("anyMatch : "+anyMatch);
		
		//allmatch returns true if it found all the elements match with the given boolean check
		boolean allMatch = namesList.stream().allMatch(s -> s.startsWith("A"));
		System.out.println("allMatch : "+allMatch);
		
		//nonematch returns true if it found all the elements should not match with the given boolean check
		boolean noneMatch = namesList.stream().noneMatch(s -> s.startsWith("A"));
		System.out.println("noneMatch : "+noneMatch);
		
		
		//count will return number of values as per the given condition
		long totalMatched = namesList.stream().filter(s -> s.startsWith("A")).count();
		System.out.println("count : "+totalMatched);
		
		//concatenating the strings with # using reduce method of stream
		Optional<String> concatenatedWordsWithHash = namesList.stream().reduce((s1, s2) -> s1+"#"+s2);
		System.out.println("words after concatenating with # : "+concatenatedWordsWithHash);
		concatenatedWordsWithHash.ifPresent(w -> System.out.println("words with # : "+ w));
		
	}

	//before java8
	private List<Product> getProductsByPrice(List<Product> productList) {
		List<Product> resultList = new ArrayList<Product>();
		for(Product product : productList) {
			if(product.getPrice() < 20000) {
				resultList.add(product);
			}
		}
		return resultList;
	}

	//before java8
	private Person getPersonByName(List<Person> listOfPersons, String name) {
		Person tempPerson = null;
		for(Person person : listOfPersons) {
			if(name.equals(person.getName())) {
				tempPerson = person;
			}
		}
		return tempPerson;
	}

}
