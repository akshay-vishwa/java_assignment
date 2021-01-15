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
@Table(name="donor_camp")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DonorCamp {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
	int id;
	String name;
	LocalDate startDate;
	LocalDate endDate;
	String location;
	String city;
	
	public DonorCamp(String name, LocalDate startDate, LocalDate endDate, String location, String city) {
		super();
		this.name = name;
		this.startDate = startDate;
		this.endDate = endDate;
		this.location = location;
		this.city = city;
	}
	
	
		
}
