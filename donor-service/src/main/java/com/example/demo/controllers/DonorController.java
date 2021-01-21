package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Donor;
import com.example.demo.services.DonorService;
import com.google.common.base.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path="/donorservice")
public class DonorController {

	@Autowired
	private DonorService service;
	
	@GetMapping(path="/")
	@ResponseStatus(value=HttpStatus.OK)
	public List<Donor> findAll(){
		return this.service.findAll();
	}
	
	@PostMapping(path="/")
	@ResponseStatus(value=HttpStatus.CREATED)
	public Donor addDonor(@RequestBody Donor entity) {
		return this.service.addUpdateDonor(entity);
	}
	
	@GetMapping(path ="/srchId/{id}")
    public ResponseEntity<Donor> findById(@PathVariable int id){
		
         Donor resp =this.service.findById(id).orElseThrow( () -> new RuntimeException("ID Not Found"));
		
		 return ResponseEntity.ok().body(resp);
			
	}
	
	@GetMapping(path ="/srchGrp/{group}")
	@ResponseStatus(value=HttpStatus.OK)
    public List<Donor> getByBloodGroup(@PathVariable String group){
		
		return this.service.findByBloodGroup(group);
		
	}
	
	@GetMapping(path ="/rdydonate")
	@ResponseStatus(value=HttpStatus.OK)
    public List<Donor> getReadyToDonate(){
		
		return this.service.findReadyToDonate();
		
	}
	
	@GetMapping(path ="/eligible")
	@ResponseStatus(value=HttpStatus.OK)
	public List<Donor> findEligible(){
		return this.service.findEligibleDonor();
	}
	
	@DeleteMapping(path = "/delete/{id}")
	public Optional<Donor> removeDonor(@PathVariable int id) {	
		Donor resp =this.service.findById(id).orElseThrow( () -> new RuntimeException("ID Not Found"));		
		 return this.service.removeDonor(resp);
	}
	
	
}
