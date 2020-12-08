package com.example.demo;

public class Application {

	public static void main(String[] args) {
	 
		SoftwareEnginner praveen=new SoftwareEnginner("Praveen", 212, "java", 10000);
		praveen.calculate();
		praveen.display();
		
		SoftwareEnginner ravi=new SoftwareEnginner("ravi", 212, "c++", 10000);
		ravi.calculate();
		ravi.display();
		
		Service ckeck =new Service();
		ckeck.PrintSalary(ravi);
		
		CivilEnginner rahul=new CivilEnginner("rahul", 212, "java", 10000);
		rahul.calculate();
		rahul.display();
		
		CivilEnginner raju=new CivilEnginner("raju", 212, "c++", 10000);
		raju.calculate();
		raju.display();
		
		Service ckeck1 =new Service();
		ckeck1.PrintSalary(raju);

	}

}
