package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.DonorRegistry;
import com.example.demo.service.DonorRegistryService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path="/registry")
public class DonorRegistryController {

	@Autowired
	private DonorRegistryService service;
	
	@GetMapping(path="/")
	@ResponseStatus(value=HttpStatus.OK)
	public List<DonorRegistry> findAll(){
		return this.service.findAll();
	}
	
	@GetMapping(path="/{id}")
	@ResponseStatus(value=HttpStatus.OK)
	public List<DonorRegistry> findByCampId(@PathVariable int id){
		return this.service.findByCampId(id);
	}
	
	@PostMapping(path="/")
	@ResponseStatus(value=HttpStatus.CREATED)
	public DonorRegistry addEntry(@RequestBody DonorRegistry entity) {
		return this.service.addUpdateRegistry(entity);
	}
	
}
