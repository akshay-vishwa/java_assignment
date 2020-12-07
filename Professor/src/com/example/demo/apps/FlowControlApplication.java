package com.example.demo.apps;

import com.example.day2.Professor;
import com.example.day2.services.PaymentServices;


public class FlowControlApplication {
	
	public static void main(String[] args) {
		Professor prof =new Professor(101,"remash","CS","PG");
		
		PaymentServices service =new PaymentServices();
		
		double salary = service.calculateSalary("phd");
		
		System.out.println("Phd salary :="+ salary);
		
		double salary1 = service.calculateSalary(prof);
		
		System.out.println("Phd salary :="+ salary1);
		
	}

}
