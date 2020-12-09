package com.demo.model;

import studentException.RangeCheckException;

public class Student {

	/*
	 *  The lines below define instance variables -rollnumber,studentname,markscored
	 *  Instance variables have a default value - 0,0.0,null,false
	 *  They can be used without assigning
	 */
	private int rollNumber;
	private String studentName;
	private double markScored;
	
	// Class Variable - with static key word - they have a default value
	public static final String trainerName  = "Javgal";
	
	// Zero Argument Constructor - Constructor can be overloaded
	public Student() {
		}
	
	
	// Constructors can be overloaded / 2 parameter constructor


	public Student(int rollNumber, String studentName) {
		
		// Calling the overloaded 3 argument constructor by passing the values

		
		this.rollNumber = rollNumber;
		this.studentName = studentName;
	}



	// Constructors can be overloaded / 3 parameter constructor

	public Student(int rollNumber, String studentName, double markScored) throws RangeCheckException {
		super();
		// this()  => Cant have both this() and super() 
		// instance variable = parameter variable
		this.rollNumber = rollNumber;
		this.studentName = studentName;
	   
		if(markScored>=0 &&markScored<=100) {
			this.markScored = markScored;
		}
		else {
			throw new RangeCheckException("Out of range!!!!");
		}
		
	}

	public int getRollNumber() {
		return rollNumber;
	}


	public void setRollNumber(int rollNumber) {
		this.rollNumber = rollNumber;
	}


	public String getStudentName() {
		return studentName;
	}


	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}


	public double getMarkScored() {
		return markScored;
	}


	public void setMark(double mark) {
		try {
			if(mark>=0 && mark<=100)
			{
				this.markScored = mark;
			}
			else {
				throw new RangeCheckException("Out of range!!!!");
			}
		} catch (RangeCheckException e) {
			// TODO: handle exception
		   System.out.println(e.getMessage());
		   System.out.println("Mark must be in the range 0-100");
			
		}
	
	}


	public String assignGrade() {
		
		// local Variable
		String grade = "O";
		
		/*
		 * Local Variable has to be initlized before use
		 * They cannot have any modifier like private,protected
		 */
		
		//String grade ;
		
		//System.out.println(grade);
		
		if(this.markScored <80) {
			grade ="A";
		}
		
		return grade;
	}
	
	
	
}