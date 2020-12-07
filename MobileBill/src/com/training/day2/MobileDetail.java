package com.training.day2;

public class MobileDetail {
	
	public String userName;
	public int userNumber;
	public int balance;
	public static String serviceProvider;
	
	public MobileDetail() {
		
	}
	
	public MobileDetail(String userName, int userNumber, int balance) {
		super();
		this.userName = userName;
		this.userNumber = userNumber;
		this.balance = balance;
	}

	

	public MobileDetail(String userName, int userNumber) {
		this(userName,userNumber,10);
		this.userName = userName;
		this.userNumber = userNumber;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setUserNumber(int userNumber) {
		this.userNumber = userNumber;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public static void setServiceProvider(String serviceProvider) {
		MobileDetail.serviceProvider = serviceProvider;
	}
	
	public String getUserName() {
		return userName;
	}

	public int getUserNumber() {
		return userNumber;
	}

	public int getBalance() {
		return balance;
	}

	public static String getServiceProvider() {
		return serviceProvider;
	}
	
	
	
	
	
}

