package com.example.demo.entity;

import java.time.LocalDate;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DonorCamp {

	int id;
	String name;
	LocalDate startDate;
	LocalDate endDate;
	String location;
	String city;
		
}
