package com.example.demo.entity;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Logging {

	int slNo;
	int id;
	LocalDate donatedDate;
	int campId;
	String location;
	String city;
}
