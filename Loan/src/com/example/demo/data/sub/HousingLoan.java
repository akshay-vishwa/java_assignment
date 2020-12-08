package com.example.demo.data.sub;

import com.example.demo.data.Loan;

public class HousingLoan extends Loan {
	
	public long principalAmount;
	public int time;
	
	public HousingLoan() {
		super();
	}

	public HousingLoan(int cibilScore) {
		super(cibilScore);
	}

	public HousingLoan(long principalAmount, int time ,int score) {
		super(score);
		this.principalAmount = principalAmount;
		this.time = time;
	}

	@Override
	public double findRateOfInterest() {
		double rate=super.findRateOfInterest();
		System.out.println("Your rate is:"+rate);
		double intrest;
		intrest=(rate*this.principalAmount*this.time)/100;
		return intrest;
	}
	
	
	

}
