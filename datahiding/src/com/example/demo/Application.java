package com.example.demo;

public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Student ram =new Student();
		
		System.out.println(ram.getMarkScored());
		System.out.println(ram.getRollNumber());
		System.out.println(ram.getStudentNumber());
		
		Student.trainerName="hello";
		
		System.out.println(Student.trainerName);
		
		Student ramesh = new Student(101,"ramesh",67);
		System.out.println(ramesh.getMarkScored());
		System.out.println(ramesh.getRollNumber());
		System.out.println(ramesh.getStudentNumber());
		
		
		
	}

}
