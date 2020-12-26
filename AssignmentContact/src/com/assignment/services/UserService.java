package com.assignment.services;

import java.util.Scanner;

import com.assignment.model.ContactDetails;

public class UserService {

	public static UserService service =new UserService();
	UserSqlService sqlService;
    Scanner sc;
    boolean flag=true;
    
    

     public UserService() {
		super();
		this.sc=new Scanner(System.in);
		this.sqlService=new UserSqlService();
	}
	
	public void execute() {
		System.out.println("*********************Welcome User********************");
		flag=true;
    	do {
    		System.out.println("");
			System.out.println("What kind of operations do you like to perform:");
			System.out.println("1)Birthdays of a month\n"
					           + "2)Contacts by group\n"
					           + "3)Display names and Email Id"
					           + "\n4)Display name and phone number\n5)Display Perticular contact"
					           + "\n6)Accending order of group\n7)Back");
			int ans = sc.nextInt();
			flag=true;
			if (ans == 1) {
				
				service.birthday();
				
			} else if (ans == 2) {
				
				service.group();
				
			} else if (ans == 3) {
				
				sqlService.nameMail();
				
			} else if (ans == 4) {
				
				sqlService.nameNumber();
				
			}else if(ans==5) {
				
				service.displayPerticular();
				
			}else if(ans==6) {
				
				sqlService.ascending();;
				
			}else if(ans==7) {
				
				return;
				
			}else {
				System.out.println("Invalid entry ....would you like to try again(y/n)");
				String retry = sc.next();
				if (retry.equals("n"))
					flag = false;
			} 
		} while (flag);
    }
    
	public void birthday() {
		do {
    		flag=true;
			System.out.println("Enter the Month number to display contact with birthday in that month:");
			int number = sc.nextInt();
			if (number<=12) {
				sqlService.birthday(number);
			} else {
				System.out.println("Wrong option");
			} 
			
			System.out.println("would you like to enter different month(y/n)");
			String retry = sc.next();
			if (retry.equals("n"))
				flag = false;
		} while (flag);
    }
		
	
	public void group() {
		do {
    		flag=true;
			System.out.println("Enter A)Relative\n      B)Personl friends\n      C)Professional friends:");
			String group = sc.next();
			if (group.equals("A")||group.equals("B")||group.equals("C")) {
				sqlService.groupContact(group);
			} else {
				System.out.println("Wrong option");
			} 
			
			System.out.println("would you like to enter different entry(y/n)");
			String retry = sc.next();
			if (retry.equals("n"))
				flag = false;
		} while (flag);
    
	}
	

	public void displayPerticular() {
		boolean flag=true;
		do {
			flag=true;
			System.out.println("Enter the number of the person whos data you would like to view:");
			long number = sc.nextLong();
			SqlServices sqlService1 =new SqlServices();
			ContactDetails contact = sqlService1.findByNumber(number);
			if (contact == null) {
				System.out.println("Nothing found");
			} else
				System.out.println(contact);
			System.out.println("would you like to add again(y/n)");
		    String ans=sc.next();
		    if(ans.equals("n"))
		    	flag=false;
		} while (flag);
	}
	
	
}
