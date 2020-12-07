package com.training.day2.app;

import com.training.day2.discount.Discount;

import java.util.Scanner;

import com.training.day2.Book;

public class Application {
	

	public static void main(String[] args) {
		
		System.out.print("DO YOU WANT TO ENTER NEW BOOK VALUE?(YES or NO)");
		Scanner sc=new Scanner(System.in);
		String type;
		
		String answer=sc.next().toUpperCase();
		if(answer.equals("YES")) {
			System.out.println("YOU HAVE ENTERED "+answer);
			Book books =new Book();
			System.out.println("enter id:");	
			books.setId(sc.nextInt());
			System.out.println("enter book name:");	
			books.setBookName(sc.next());
			System.out.println("enter author:");	
			books.setAuthor(sc.next());
			System.out.println("enter price:");
			books.setPrice(sc.nextInt());
			System.out.println("enter type:");
			type=sc.next();
			Discount discount = new Discount();
			System.out.println(discount.discount(books));				
			System.out.println(discount.discount2(books,type));
			}
		else {
			Book books =new Book(200,"The END","Alexandra Bracken",300.00);
			System.out.println("enter type:");
			type=sc.next();
			
			Discount discount = new Discount();
			System.out.println(discount.discount(books));
			System.out.println(discount.discount2(books,type));
		}
		sc.close();
		
		
	}

}
