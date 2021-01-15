package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Donor;
import com.example.demo.repos.DonorRepository;
import com.google.common.base.Optional;

@Service
public class DonorService {

	@Autowired
	private DonorRepository repo;
	
	
	//returns All the data in the donor_service table
    public List<Donor> findAll(){
		return this.repo.findAll();
	}
    
    //Add or Update a Entry into the donor_service table
    public Donor addUpdateDonor(Donor entity){	
    	
		return this.repo.save(entity);
	}
    
    //FindByID is to search a donor by his unique id
    public java.util.Optional<Donor> findById(int id) {
		
		return this.repo.findById(id);
	}
    
    //FindByBlooGroup is to search all the donor wiith a perticular group  
    public List<Donor> findByBloodGroup(String bloodGroup) {
    	  
    	  return this.repo.findByBloodGroup(bloodGroup);
      }
    
    //finds all the donor who are ready to donate
    public List<Donor> findReadyToDonate(){
    	return this.repo.findReadyToDonate();
    }
    
    //find all the cantidated are willing to donate and not donated last 6 months
    public List<Donor> findEligibleDonor(){
		return this.repo.findEligible();
	}
    
    //delete a donor details based on their id
    public Optional<Donor>  removeDonor(Donor entity) {	  
  	  Donor donor = null; 
  	   if(this.repo.existsById(entity.getId())) {   
  		   this.repo.delete(entity);   
  		   donor = entity;
  	   } 
  	  Optional<Donor> optional = Optional.of(donor);  
  	   return optional;
    }


}
