package com.example.day2;

import com.example.day2.Professor;

public class EqualsAndHashCode {

	public static void main(String[] args) {

		Professor manish=new Professor(3838,"Suresh","ECE","phd");
		
		Professor otherSuresh =manish;
		
		System.out.println("Is sureshand otherSuresh Equal:="+manish.equals(otherSuresh));
		
Professor manish1=new Professor(3838,"Suresh","ECE","phd");
		
		System.out.println("Is sureshand otherSuresh Equal:="+manish.equals(manish1));
		

	}

}
