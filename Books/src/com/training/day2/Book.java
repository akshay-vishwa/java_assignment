package com.training.day2;

public class Book {
	
	public Book() {
	}

	private int id;
	private String bookName;
	private  String author;
	private double price;
	
	public Book(int id, String bookName, String author, double price) {
		super();
		this.id = id;
		this.bookName = bookName;
		this.author = author;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public String getBookName() {
		return bookName;
	}

	public String getAuthor() {
		return author;
	}

	public double getPrice() {
		return price;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	
	
	

}
