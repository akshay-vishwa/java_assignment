package com.assignment.model;

import java.time.LocalDate;


public class ContactDetails {

	private String name;
	private String address;
	private long number;
	private String imgRef;
	private LocalDate dateOfBirth;
	private String mailId;
	private String groupId;

	
	
	public ContactDetails() {
		super();
		// TODO Auto-generated constructor stub
	}


	public ContactDetails(String name, String address, long number, String imgRef, LocalDate dateOfBirth, String mailId,
			String group) {
		super();
		this.name = name;
		this.address = address;
		this.number = number;
		this.imgRef = imgRef;
		this.dateOfBirth = dateOfBirth;
		this.mailId = mailId;
		this.groupId = group;	
	}


	public String getName() {
		return name;
	}


	public String getAddress() {
		return address;
	}


	public long getNumber() {
		return number;
	}


	public String getImgRef() {
		return imgRef;
	}


	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}


	public String getMailId() {
		return mailId;
	}


	public String getGroup() {
		return groupId;
	}


	public void setName(String name) {
		this.name = name;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public void setNumber(long number) {
		this.number = number;
	}


	public void setImgRef(String imgRef) {
		this.imgRef = imgRef;
	}


	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}


	public void setMailId(String mailId) {
		this.mailId = mailId;
	}


	public void setGroup(String group) {
		this.groupId = group;
	}


	@Override
	public String toString() {
		return "ContactDetails [name=" + name + ", address=" + address + ", number=" + number + ", imgRef=" + imgRef
				+ ", dateOfBirth=" + dateOfBirth + ", mailId=" + mailId + ", group=" + groupId + "]";
	}
	
	public String toStringSave() {
		return  name + "," + address.replaceAll(",", "/") + "," + number + "," + imgRef
				+ "," + dateOfBirth + "," + mailId + "," + groupId+"\n";
	}
	


	public String getGroupId() {
		return groupId;
	}


	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}
	
}
