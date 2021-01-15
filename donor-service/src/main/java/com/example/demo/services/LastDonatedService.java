package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.LastDonated;
import com.example.demo.repos.LastDonatedRepository;

@Service
public class LastDonatedService {

	
	@Autowired
	private LastDonatedRepository repo;
	
    
	//finds all the last donated dates of the donor
	public List<LastDonated> findAllDonatedDates(){
		return this.repo.findAll();
	}
	
	//add or update a entry of LastDonated tabe
    public LastDonated addUpdateDonatedDate(LastDonated entity){	
    	
		return this.repo.save(entity);
	}
}
