package com.example.demo.data.sub;

import com.example.demo.data.Loan;

public class HousingLoan extends Loan {
	
	
	
	public HousingLoan() {
		super();
	}


	public HousingLoan(long principalAmount, int time ,int score) {
		super(score,principalAmount,time);
	}

	@Override
	public double findRateOfInterest() {
		double rate=super.findRateOfInterest();
		System.out.println("Your rate is:"+rate);
		double intrest;
		intrest=(rate*this.getPrincipalAmount()*this.getTime())/100;
		return intrest;
	}
	
	
	

}
