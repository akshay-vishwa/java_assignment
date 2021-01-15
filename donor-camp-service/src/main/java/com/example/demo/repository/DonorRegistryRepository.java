package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.DonorRegistry;

public interface DonorRegistryRepository extends JpaRepository<DonorRegistry,Integer> {

	//expose query method
	List<DonorRegistry> findByCampId(int id);
	
}
