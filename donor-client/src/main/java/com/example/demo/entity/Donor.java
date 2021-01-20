package com.example.demo.entity;

import java.time.LocalDate;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Donor {

	int id;
	String name;
	LocalDate dateOfBirth;
	String bloodGroup;
	String address;
	String city;
	String mailId;
	Long phoneNumber;
	Boolean plasmaDonor;
	Boolean readyToDonate;
	String userId;
	String Password;
	
	
	
}


