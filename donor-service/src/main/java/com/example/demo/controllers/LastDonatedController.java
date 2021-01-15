package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.LastDonated;
import com.example.demo.services.LastDonatedService;

@RestController
@RequestMapping(path="/lastdonated")
public class LastDonatedController {

	@Autowired
	private LastDonatedService service;
	
	@GetMapping(path="/")
	@ResponseStatus(value=HttpStatus.OK)
	public List<LastDonated> findAll(){
		return this.service.findAllDonatedDates();
	}
	
	@PostMapping(path="/")
	@ResponseStatus(value=HttpStatus.CREATED)
	public LastDonated addEnter(@RequestBody LastDonated entity) {
		return this.service.addUpdateDonatedDate(entity);
	}
	
}
