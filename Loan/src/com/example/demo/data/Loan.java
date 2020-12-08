package com.example.demo.data;

public class Loan {
	
	private int cibilScore;
	private long principalAmount;
	private int time;

	public Loan() {
		super();
	}
	public Loan(int cibilScore,long principalAmount, int time) {
		super();
		this.cibilScore = cibilScore;
		this.principalAmount = principalAmount;
		this.time = time;
	}

	public long getPrincipalAmount() {
		return principalAmount;
	}

	public void setPrincipalAmount(long principalAmount) {
		this.principalAmount = principalAmount;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	

	public void setCibilScore(int cibilScore) {
		this.cibilScore = cibilScore;
	}

	public int getCibilScore() {
		return cibilScore;
	}
	
	public double findRateOfInterest() {
		double rate;
		if(this.getCibilScore()>500) 
			rate=7.5;
		else
		  rate=8.2;
		return rate;
		
	}
	
	

}
