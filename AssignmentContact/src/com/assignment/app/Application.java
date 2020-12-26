package com.assignment.app;

import java.util.Scanner;


import com.assignment.services.AuthorityServices;
import com.assignment.services.UserService;


public class Application {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		UserService user =new UserService();
		AuthorityServices authority=new AuthorityServices(); 
		
		do {
			//login as user or authority
			System.out.println("*************************Telephone Book************************");
			System.out.println("Access as 1)Authority: \n          2)User:\n          3)Exit:");
			int check = sc.nextInt();
			if (check == 1) {
				//gives assecc to CRUD operations on sql 
				authority.execute();

			} else if (check == 2) {
				//no access to CRUD operations on sql
				user.execute();

			} else if (check == 3) {
				sc.close();
				System.exit(0);
			} else
				System.out.println("Wrong option");
		} while (true);
		

	}

}
