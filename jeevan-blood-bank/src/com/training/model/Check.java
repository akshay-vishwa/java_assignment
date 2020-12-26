package com.training.model;

public class Check {

	private int userId;
	private String password;
	
	public Check(int userId, String password) {
		super();
		this.userId = userId;
		this.password = password;
	}
	public int getUserId() {
		return userId;
	}
	public String getPassword() {
		return password;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Check [userId=" + userId + ", password=" + password + "]";
	}
	
	
	
}
