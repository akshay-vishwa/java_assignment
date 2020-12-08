package com.example.demo;

public class SoftwareEnginner implements Billable {

	private String name;
	private int id;
	private String type;
	private double salary;
	
	
	
	public SoftwareEnginner(String name, int id, String type, double salary) {
		super();
		this.name = name;
		this.id = id;
		this.type = type;
		this.salary = salary;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public int getId() {
		return id;
	}

	public String getType() {
		return type;
	}

	public double getSalary() {
		return salary;
	}

	@Override
	public double calculate() {
		if(type.equals("java"))
			this.salary+=1000;
		else if(type.equals("c++"))
			this.salary+=2000;
		else
			this.salary+=500;
		System.out.println("The salary is :"+salary);
		return salary;
	}

	@Override
	public double display() {
		
		return salary;
	}
	
	
	
	

}
