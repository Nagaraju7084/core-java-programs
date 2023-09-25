package com.java8.streams.completestreamapi;

public class Book {

	private String bookName;
	private Author author;
	private double price;
	
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public Author getAuthor() {
		return author;
	}
	public void setAuthor(Author author) {
		this.author = author;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	public Book(String bookName, Author author, double price) {
		super();
		this.bookName = bookName;
		this.author = author;
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "Book [bookName=" + bookName + ", author=" + author + ", price=" + price + "]";
	}
	
}
