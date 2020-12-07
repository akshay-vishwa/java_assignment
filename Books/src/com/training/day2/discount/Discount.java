package com.training.day2.discount;

import com.training.day2.Book;

public class Discount {

	public Discount() {
		super();
	}

	public double discount(Book books) {
		double discountValue =50.00;
		if(books.getPrice()>1000)
			discountValue=100.00;
		return discountValue;
	}
	
	public double discount2(Book books,String type) {
		double discountValue =50.00;
		if(books.getPrice()<1000 && type.toLowerCase().equals("retailer"))
			discountValue=100.00;
		return discountValue;
	}
}
