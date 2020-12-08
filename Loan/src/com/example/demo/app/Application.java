package com.example.demo.app;

import java.util.Scanner;

import com.example.demo.data.sub.HousingLoan;

public class Application {

	public static void main(String[] args) {
		
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter the principle amount:");
		long amount=sc.nextLong();
		System.out.println("Enter the Duration:");
		int time=sc.nextInt();
		System.out.println("Enter the cibilScore:");
		int score=sc.nextInt();
		
		HousingLoan ravi =new HousingLoan(amount,time,score);
		
		double intrest =ravi.findRateOfInterest();
		System.out.println("Your intrest is:"+intrest);
		
		
		

	}

}
