package com.psystem;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ListOfProducts {

	public static void main(String[] args) {
		List<Product> productList = Arrays.asList(new Product(1, "iphone", 20000.00, "Mobile"),
				new Product(1, "java", 8000.00, "Books"),
				new Product(1, "cd", 18000.00, "Audio"),
				new Product(1, "kid", 12000.00, "Toys"));
		
		List<Double> pirceList = productList.stream().filter(product -> product.getProductPrice() > 10000)
				.map(product -> product.getProductPrice()).collect(Collectors.toList());
		
		System.out.println(pirceList);
		
		Double summingPrice = productList.stream().collect(Collectors.summarizingDouble(product -> product.getProductPrice())).getSum();
		
		System.out.println("summingPrice = "+summingPrice);
		
		List<Product> resultList = productList.stream().filter(product -> product.getCategory().equalsIgnoreCase("Books")
				&& product.getProductPrice() > 100).collect(Collectors.toList());
		System.out.println(resultList);
		
		 List<Double> priceAfterDis = productList.stream()
				.map(product -> {
					if(product.getCategory().equalsIgnoreCase("Toys")) {
						double pricewithDiscount = (product.getProductPrice()*10/100);
						double priceAfterDiscount = product.getProductPrice() - pricewithDiscount;
						return priceAfterDiscount;
					}
					return product.getProductPrice();
				}).collect(Collectors.toList());
		System.out.println(priceAfterDis);
		
	}
}

class Books {
	
	private int bookId;
	private String bookName;
	private double bookPrice;
	
	public Books(int bookId, String bookName, double bookPrice) {
		this.bookId = bookId;
		this.bookName = bookName;
		this.bookPrice = bookPrice;
	}
	
}

class Product {
	
	private int productId;
	private String productName;
	private double productPrice;
	private String category;
	
	public Product(int productId, String productName, double productPrice, String category) {
		this.productId = productId;
		this.productName = productName;
		this.productPrice = productPrice;
		this.category = category;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", productPrice=" + productPrice
				+ ", category=" + category + "]";
	}
	
}
