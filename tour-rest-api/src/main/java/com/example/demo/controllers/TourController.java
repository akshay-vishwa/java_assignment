package com.example.demo.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Tour;
import com.example.demo.services.TourService;

@RestController
public class TourController {

	@Autowired
	private TourService service;
	
	@GetMapping(path="/api/v1/tours")
    public List<Tour> findAll(){
		
		return this.service.findAll();
		
	}
	
	@PostMapping(path ="/api/v1/tours")
	@ResponseStatus(value=HttpStatus.CREATED)
    public Tour addTour(@RequestBody Tour entity){
		
		return this.service.addTour(entity);
		
	}
	
	@GetMapping(path ="/api/v1/tours/{id}")
    public Optional<Tour> findById(@PathVariable int id){

			return this.service.findById(id);

		
	}
	@GetMapping(path ="/api/v1/tours/name={name}")
    public Optional<Tour> findByName(@PathVariable String name){

			return this.service.findByName(name);
		
	}
	
	@DeleteMapping(path ="/api/v1/tours/{id}")
	@ResponseStatus(value=HttpStatus.CREATED)
	public int delete(@PathVariable Integer id) {
		Optional<Tour> tour=this.service.findById(id);
		if(tour.isPresent()) {
			return this.service.delete(id);
		}
		else
			return 0;
		
	}
	
	@PutMapping(path ="/api/v1/tours")
	@ResponseStatus(value=HttpStatus.CREATED)
	public int update(@RequestBody Tour entity) {
		Optional<Tour> tour=this.service.findById(entity.getTourId());
		if(tour.isPresent()) {
			this.service.addTour(entity);
			return 1;
		}
		else
			return 0;
	}
	
}
