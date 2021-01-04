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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Tour;
import com.example.demo.services.TourService;

@RestController
@RequestMapping(path="/api/v1/")
public class TourController {

	@Autowired
	private TourService service;
	
	@GetMapping(path="tours")
    public List<Tour> findAll(){
		
		return this.service.findAll();
		
	}
	
	@PostMapping(path ="tours")
	@ResponseStatus(value=HttpStatus.CREATED)
    public Tour addTour(@RequestBody Tour entity){
		
		return this.service.addTour(entity);
		
	}
	
	@GetMapping(path ="tours/{id}")
    public Optional<Tour> findById(@PathVariable int id){

			return this.service.findById(id);

		
	}
	@GetMapping(path ="tours/name={name}")
    public Optional<Tour> findByName(@PathVariable String name){

			return this.service.findByName(name);
		
	}
	
	@DeleteMapping(path ="tours/{id}")
	@ResponseStatus(value=HttpStatus.CREATED)
	public int delete(@PathVariable Integer id) {
		Optional<Tour> tour=this.service.findById(id);
		if(tour.isPresent()) {
			return this.service.delete(id);
		}
		else
			return 0;
		
	}
	
	@PutMapping(path ="tours")
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
	
	@GetMapping("tour/duration/{days}")
	public List<Tour> findByDuration(@PathVariable("days") double duration){
		return this.service.greaterThanDuration(duration);
	}
	
	@GetMapping("tours/cost/{inr}")
	public List<Tour> findCost(@PathVariable("inr") double cost){
		return this.service.findByCost(cost);
	}
	
	@PutMapping("tours/cost/{tourId}/{revised}")
	public List<Tour> updateCost(@PathVariable("tourId") int id,@PathVariable("revised") double revised){
		return this.service.updateTour(id, revised);
	}
	
}
