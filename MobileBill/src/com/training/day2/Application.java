package com.training.day2;

public class Application {

	public static void main(String[] args) {
	
		MobileDetail ravi=new MobileDetail();
		
		System.out.println(ravi.getBalance());
		System.out.println(ravi.getUserNumber());
		System.out.println(ravi.getUserName());
		System.out.println(MobileDetail.getServiceProvider());
		
		MobileDetail karthik=new MobileDetail("karthik",9232,11);
		MobileDetail.setServiceProvider("jio");
		
		System.out.println(karthik.getBalance());
		System.out.println(karthik.getUserNumber());
		System.out.println(karthik.getUserName());
		System.out.println(MobileDetail.getServiceProvider());
		
		MobileDetail adarsh=new MobileDetail("adarsh",9232);
		
		System.out.println(adarsh.getBalance());
		System.out.println(adarsh.getUserNumber());
		System.out.println(adarsh.getUserName());
		
		System.out.println("Total users is:"+MobileDetail.count);
		int number=Integer.parseInt(args[0]);
		int balance=Integer.parseInt(args[2]);
		
		MobileDetail kart1=new MobileDetail(args[1],number,balance);
		


	}

}
