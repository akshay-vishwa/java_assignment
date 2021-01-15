package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.DonorRegistry;
import com.example.demo.repository.DonorRegistryRepository;

@Service
public class DonorRegistryService {

	@Autowired
	private DonorRegistryRepository repo;
	
	//returns All the data in the donor_camp table
    public List<DonorRegistry> findAll(){
		return this.repo.findAll();
	}
    
    //Add or Update a Entry into the donor_camp table
    public DonorRegistry addUpdateRegistry(DonorRegistry entity){	
    	
		return this.repo.save(entity);
	}
	
    //return all the donor registered for a perticular camp
    public List<DonorRegistry> findByCampId(int id){
    	return this.repo.findByCampId(id);
    }
}
