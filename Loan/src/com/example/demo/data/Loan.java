package com.example.demo.data;

public class Loan {
	
	private int cibilScore;

	public Loan() {
		super();
	}

	public Loan(int cibilScore) {
		super();
		this.cibilScore = cibilScore;
	}

	public void setCibilScore(int cibilScore) {
		this.cibilScore = cibilScore;
	}

	public int getCibilScore() {
		return cibilScore;
	}
	
	public double findRateOfInterest() {
		double rate;
		if(cibilScore>500) 
			rate=7.5;
		rate=8.2;
		return rate;
		
	}
	
	

}
