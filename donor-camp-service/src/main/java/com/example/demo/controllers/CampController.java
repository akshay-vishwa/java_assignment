package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.DonorCamp;
import com.example.demo.service.CampService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path="/campservice")
public class CampController {

	@Autowired
	private CampService service;
	
	@GetMapping(path="/")
	@ResponseStatus(value=HttpStatus.OK)
	public List<DonorCamp> findAll(){
		return this.service.findAll();
	}
	
	@PostMapping(path="/")
	@ResponseStatus(value=HttpStatus.CREATED)
	public DonorCamp addCamp(@RequestBody DonorCamp entity) {
		return this.service.addUpdateDonorCamp(entity);
	}
	
	@GetMapping(path ="/srchId/{id}")
    public ResponseEntity<DonorCamp> findById(@PathVariable int id){
		
		DonorCamp resp =this.service.findById(id).orElseThrow( () -> new RuntimeException("ID Not Found"));
		
		 return ResponseEntity.ok().body(resp);
			
	}
	
	@GetMapping(path ="/srchcity/{city}")
    public List<DonorCamp> findById(@PathVariable String city){
		return this.service.findByCity(city);	
	}
	
	@GetMapping(path ="/srchname/{name}")
    public List<DonorCamp> findByName(@PathVariable String name){
		return this.service.findByName(name);	
	}

	@GetMapping(path ="/activecamp")
    public List<DonorCamp> findActiveCamp(){
		return this.service.findActiveCamp();	
	}
	
	@GetMapping(path ="/endedcamp")
    public List<DonorCamp> findEndedCamp(){
		return this.service.findEndedCamp();	
	}
	
	@GetMapping(path ="/distcity")
    public List<String> findCitys(){
		return this.service.findCitys();	
	}
	
}

