package com.example.demo.apps;

import java.util.Scanner;

import com.example.day2.Professor;
import com.example.day2.services.PaymentServices;


public class FlowControlApplication {
	
	public static void main(String[] args) {
		Professor prof =new Professor(101,"remash","CS","PG");
		
		PaymentServices service =new PaymentServices();
		
		Scanner sc =new Scanner(System.in);
		System.out.println("Enter qualification");
		String qual=sc.next();
		
		double salary = service.calculateSalary(qual);
		
		System.out.println("Phd salary :="+ salary);
		
		double salary1 = service.calculateSalary(prof);
		
		System.out.println("Phd salary :="+ salary1);
		
	}

}
