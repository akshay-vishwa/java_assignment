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
@Table(name="donation_log")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Logging {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "slNo", updatable = false, nullable = false)
	int slNo;
	int id;
	LocalDate donatedDate;
	int campId;
	String location;
	String city;
}
