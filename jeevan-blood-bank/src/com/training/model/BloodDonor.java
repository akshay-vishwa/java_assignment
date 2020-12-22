
package com.training.model;

import java.time.LocalDate;

public class BloodDonor {

	private String name;
	private int age;
	private String gender;
	private String bloodGroup;
	private int phoneNumber;
	private String email;
	private LocalDate dateOfBirth;
	
	public BloodDonor(String name, int age, String gender, String bloodGroup, int phoneNumber, String email,
			LocalDate dateOfBirth) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.bloodGroup = bloodGroup;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.dateOfBirth = dateOfBirth;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public String getGender() {
		return gender;
	}

	public String getBloodGroup() {
		return bloodGroup;
	}

	public int getPhoneNumber() {
		return phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	@Override
	public String toString() {
		return "BloodDonor [name=" + name + ", age=" + age + ", gender=" + gender + ", bloodGroup=" + bloodGroup
				+ ", phoneNumber=" + phoneNumber + ", email=" + email + ", dateOfBirth=" + dateOfBirth + "]";
	}
	
	
	
	
	
	
}
