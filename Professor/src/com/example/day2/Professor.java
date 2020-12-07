package com.example.day2;

public class Professor {
	
	private int id;
	private String firstName;
	private String department;
	private String qualifications;
	
	public Professor() {

		
		
	}
	
	public Professor(int id, String firstName, String department, String qualifications) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.department = department;
		this.qualifications = qualifications;
	}

	public int getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getDepartment() {
		return department;
	}

	public String getQualifications() {
		return qualifications;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public void setQualifications(String qualifications) {
		this.qualifications = qualifications;
	}

	
	
	

}
