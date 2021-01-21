package com.example.demo.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="donor_service")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Donor {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
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
	
	public Donor(String name, LocalDate dateOfBirth, String bloodGroup, String address, String city, String mailId,
			Long phoneNumber, Boolean plasmaDonor, Boolean readyToDonate, String userId, String password) {
		super();
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.bloodGroup = bloodGroup;
		this.address = address;
		this.city = city;
		this.mailId = mailId;
		this.phoneNumber = phoneNumber;
		this.plasmaDonor = plasmaDonor;
		this.readyToDonate = readyToDonate;
		this.userId = userId;
		this.Password = password;
	}
	
}


