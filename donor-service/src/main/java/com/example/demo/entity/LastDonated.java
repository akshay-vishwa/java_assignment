package com.example.demo.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="last_donated")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LastDonated {

	@Id
	int id;
    LocalDate lastDonated;
}
