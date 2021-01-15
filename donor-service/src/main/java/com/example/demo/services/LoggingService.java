package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Logging;
import com.example.demo.repos.LoggingRepository;

@Service
public class LoggingService {
 
	@Autowired
	private LoggingRepository repo;
	
	    //finds all the entry or log of the donated
		public List<Logging> findAll(){
			return this.repo.findAll();
		}
		
		//add or update a entry of LLogging table tabe
	    public Logging addEntry(Logging entity){	
	    	
			return this.repo.save(entity);
		}
	
}
