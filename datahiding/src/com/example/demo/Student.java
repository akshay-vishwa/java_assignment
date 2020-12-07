package com.example.demo;

public class Student {
	
	/*
	 * the lines before define instance variable
	 * instance variable have a default value
	*/
	
	private int rollNumber;
	private String studentNumber;
	private double markScored;
	
	public static String trainerName="traingal";
	
	public Student() {
		
	}

	public Student(int rollNumber, String studentNumber, double markScored) {
		super();
		this.rollNumber = rollNumber;
		this.studentNumber = studentNumber;
		this.markScored = markScored;
	}
	
	public Student(int rollNumber, String studentNumber) {
		//over loaded constructor
		this(rollNumber,studentNumber,99);
		this.rollNumber = rollNumber;
		this.studentNumber = studentNumber;
	}

	public void setRollNumber(int rollNumber) {
		this.rollNumber = rollNumber;
	}

	public void setStudentNumber(String studentNumber) {
		this.studentNumber = studentNumber;
	}

	public void setMarkScored(double markScored) {
		this.markScored = markScored;
	}

	public int getRollNumber() {
		return rollNumber;
	}

	public String getStudentNumber() {
		return studentNumber;
	}

	public double getMarkScored() {
		return markScored;
	}
	
	public String assignGrade(){
		
		String grade="o";
		
		if(this.markScored<80) {
			grade="A";
		}
		return grade;
	}
	
	//constructors can be overloaded
	
}	