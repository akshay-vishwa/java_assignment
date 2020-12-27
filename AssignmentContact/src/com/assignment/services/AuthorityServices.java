package com.assignment.services;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.assignment.model.ContactDetails;

public class AuthorityServices {
	
	    public static AuthorityServices service =new AuthorityServices();;
	    SqlServices sqlService;
	    Scanner sc;
	    boolean flag=true;
	    boolean back=true;
	    
	
	public AuthorityServices() {
			super();
			this.sc=new Scanner(System.in);
			this.sqlService=new SqlServices();
		}

	//runns all the authority command lines
	    public void execute() {
	    	System.out.println("*********************Welcome Authority********************");
	    	do {
	    		flag=true;
	    	    if(service.passwordCheck()) {
	    	    	service.valid();
	    	    	return;
	    	    }else {
	    		    System.out.println("Invalid authentication ....would you like to try again(y/n)");
	    		    String ans=sc.next();
	    		    if(ans.equals("n")) 
	    		       flag=false;
	    		    
	    	    }
	    	}while(flag);
	    }
	    
	//valid User 
	    public void valid() {

	    	do {
				System.out.println("What kind of operations do you like to perform:");
				System.out.println("1)Add\n2)Update\n3)Remove\n4)Display\n5)Perticular contact\n6)logout");
				int ans = sc.nextInt();
				back=true;
				if (ans == 1) {
					
					service.add();
					
				} else if (ans == 2) {
					
					service.update();
					
				} else if (ans == 3) {
					
					service.remove();
					
				} else if (ans == 4) {
					
					service.displaySqlData();
					
				}else if(ans==5) {
					
					service.displayPerticular();
					
				}else if(ans==6) {
					
					return;
					
				}else {
					System.out.println("Invalid entry ....would you like to try again(y/n)");
					String retry = sc.next();
					if (retry.equals("n"))
						back = false;
				} 
			} while (back);
	    }
	 
	//update value in table
	    public void update() {
	    	do {
	    		flag=true;
				System.out.println("Enter the number of the person whos data you would like to update:");
				long number = sc.nextLong();
				int row = 0;
				if (sqlService.check(number)) {
					System.out.println("Entry present:");
					ContactDetails contact = service.getDetails();
					row = sqlService.update( contact,number);
					System.out.println("Number of rows updated is:" + row);
				} else {
					System.out.println("No entry found:");
				} 
				
				System.out.println("would you like to update entries again(y/n)");
				String retry = sc.next();
				if (retry.equals("n"))
					flag = false;
			} while (flag);
	    	
	    }
	    
	    public void remove() {
	    	do {
	    		flag=true;
				System.out.println("Enter the number of the person whos data you would like to delete:");
				long number = sc.nextLong();
				int row = 0;
				if (sqlService.check(number)) {
					System.out.println("Entry present:");
					row=sqlService.remove(number);
					System.out.println("Number of rows updated is:" + row);
				} else {
					System.out.println("No entry found:");
				} 
				
				System.out.println("would you like to delete entries again(y/n)");
				String retry = sc.next();
				if (retry.equals("n"))
					flag = false;
			} while (flag);
	    }
	    
    //checks for valid authentication
	    public boolean passwordCheck() {
	    	int id;
	    	String password;
			try {
				System.out.println("Enter user id:");
				sc.nextLine();
				id = sc.nextInt();
				System.out.println("Enter user password:");
				password = sc.next();
			}catch(ClassCastException | InputMismatchException  ime){
		        System.out.println("Your input is invalid, please try again");
		        id=0;
		        password="wrong";

			}
	    	return (id==1000 && password.equals("login")) ;
	    	     
	    }
	    
	    
	//Displays all the details of the contact table in the database
		public void displaySqlData() {
			
			List<ContactDetails> list=new ArrayList<>();
			
		    list=sqlService.findAll();
		    for(ContactDetails contact:list) {
		    	System.out.println(contact);
		    }
		    System.out.println("Do you want to save the file:(n/y)");
			String save=sc.next();
		    if(save.equals("y")) {
				
				String data="";
				System.out.println("Enter file name:");
				String name=sc.next();
				name="data/"+name+".csv";
				FileService csvWrite = new FileService(name);
				
				for(ContactDetails contact:list) {
					
					data+=contact.toStringSave();		
				}
				csvWrite.addData(data);
			}
		}
	
	//Adding data to sql Database
		public void add() {
			boolean flag=true;
			do {
				flag=true;
				ContactDetails contact = service.getDetails();
				if(contact==null) {
					System.out.println("Rows updated is:0");
				}
				else {
				    System.out.println("Rows updated is:" + sqlService.addContact(contact));
				}
				System.out.println("would you like to add again(y/n)");
    		    sc.nextLine();
    		    String ans=sc.nextLine();
    		    if(ans.equals("n"))
    		    	flag=false;
			} while (flag);
			
		}
		
	//gets in data entries for contactbook
		public ContactDetails getDetails() {
			String name="";
			String address="";
			long number=0;
			String imgRef="";
			LocalDate ldate=null;
			String email="";
			String group="";
			ContactDetails contact=null;
			boolean catchCheck=true;
			try {
				System.out.println("Enter Name:");
				name = sc.next();
				System.out.println("Enter Address:");
				address = sc.next();
				System.out.println("Enter Ph Number:");
				number = sc.nextLong();
				imgRef = "./images/" + name + ".jpg";
				System.out.println("Enter date of birth:year month date");//after every ntry hit enter
				int year = sc.nextInt();
				int month = sc.nextInt();
				int date = sc.nextInt();
				ldate = LocalDate.of(year, Month.of(month), date);
				System.out.println("Enter email Id:");
				email = sc.next();
				System.out.println(
						"Enter Group:A)Relative:\n            B)Presonal Friend:\n            C)Professional Friend:");
				group = sc.next();
			} catch (ClassCastException | InputMismatchException  e) {

				System.out.println("Your input is invalid, please try again");
				catchCheck=false;
				
			}
			if(catchCheck==true)
				 contact = new ContactDetails(name, address, number, imgRef, ldate, email, group);
			
			return contact;
		}
		
	//display a perticular contact detail
		public void displayPerticular() {
			boolean flag=true;
			do {
				flag=true;
				System.out.println("Enter the number of the person whos data you would like to view:");
				long number = sc.nextLong();
				ContactDetails contact = sqlService.findByNumber(number);
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
