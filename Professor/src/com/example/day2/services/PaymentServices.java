package com.example.day2.services;

import com.example.day2.Professor;

public class PaymentServices {

	public double calculateSalary(Professor prof) {
		
		double salary =50000.00;
		
		if(prof.getQualifications().equals("PG"))
		     salary =60000.00;
		else if (prof.getQualifications().equalsIgnoreCase("phd")){
			salary=75000.00;
		}
		return salary;
		
	}
   
	
	public double calculateSalary(String qualification ) {
		
		String key =qualification.toUpperCase();
		switch(key) {
		case "PG":
		   return 60000.00;
		case "UG":
			return 75000.00;
		default:
			return 50000.00;
		}
		
	}
}
