package com.java8.streams.completestreamapi;

public class Article {

	private String title;
	private String tagName;
	private String author;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getTagName() {
		return tagName;
	}
	public void setTagName(String tagName) {
		this.tagName = tagName;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public Article(String title, String tagName, String author) {
		super();
		this.title = title;
		this.tagName = tagName;
		this.author = author;
	}
	
	@Override
	public String toString() {
		return "Article [title=" + title + ", tagName=" + tagName + ", author=" + author + "]";
	}
	
}
