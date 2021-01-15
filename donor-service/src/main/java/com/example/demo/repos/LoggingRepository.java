package com.example.demo.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Logging;

@Repository
public interface LoggingRepository extends JpaRepository<Logging, Integer>{

	
}
