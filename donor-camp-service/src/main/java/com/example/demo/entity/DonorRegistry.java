package com.example.demo.entity;

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
@Table(name="donor_registry")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DonorRegistry {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "slno", updatable = false, nullable = false)
	int slno;
	int campId;
	int donorId;
	
	public DonorRegistry(int campId, int donorId) {
		super();
		this.campId = campId;
		this.donorId = donorId;
	}
	
	
	
}
