package com.assignment.services;

import java.util.ArrayList;
import java.util.List;

import com.training.model.Check;



public class LoginService {

	private List<Check> list;
	private Check check;

	public LoginService() {
		super();
		this.list = new ArrayList<>();
		this.setPasswords();
	}

	public List<Check> getList() {
		return list;
	}
	
	private void setPasswords() {
		check =new Check(1000,"pass");
		list.add(check);
		check =new Check(1001,"pass");
		list.add(check);
	}
	
	public boolean checkPassword(int id,String pass) {
		boolean flag=false;
		for(Check check:list ) {
			if(check.getUserId()==id && check.getPassword().equals(pass)) {
				flag=true;
			}
		}
		return flag;
	}
	
	

	
	
}
