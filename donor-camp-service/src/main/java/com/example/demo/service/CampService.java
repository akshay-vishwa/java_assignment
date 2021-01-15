package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.DonorCamp;
import com.example.demo.repository.CampRepository;

@Service
public class CampService {

	@Autowired
	private CampRepository repo;
	
	//returns All the data in the donor_camp table
    public List<DonorCamp> findAll(){
		return this.repo.findAll();
	}
    
    //Add or Update a Entry into the donor_camp table
    public DonorCamp addUpdateDonorCamp(DonorCamp entity){	
    	
		return this.repo.save(entity);
	}
	
    //search and return camps on a perticular city
	public List<DonorCamp> findByCity(String city){
		return this.repo.findByCity(city);
	}
	
	//search and return camps on a perticular city
	public List<DonorCamp> findByName(String name){
		return this.repo.findByName(name);
	}
	
	//search active and upcoming camps camp 
	public List<DonorCamp> findActiveCamp(){
		return this.repo.findActiveCamps();
	}
	
	//distinct city names
	public List<String> findCitys(){
		return this.repo.findCitys();
	}
	
	//serarch by id
    public java.util.Optional<DonorCamp> findById(int id) {
		
		return this.repo.findById(id);
	}
	
}
