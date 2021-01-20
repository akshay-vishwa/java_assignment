package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entity.Donor;

@Controller
public class ClientController {

	@Autowired
	private RestTemplate template;
	
	@Autowired
	private ModelAndView mdlView;
	
	@Autowired
	private Donor donor;
	
	
	@GetMapping(path="/")
	public ModelAndView init() {
		
		String logs=template.getForObject("http://localhost:2020/donor-service/log/", String.class); 
		mdlView.addObject("log", logs);
		System.out.println(logs);
		mdlView.setViewName("home");
		
		return mdlView;
		
	}
	
}
