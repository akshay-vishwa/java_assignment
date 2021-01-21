package com.example.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entity.Donor;
import com.example.demo.entity.DonorCamp;
import com.example.demo.entity.Logging;

@CrossOrigin(origins = "*")
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
		
		Logging[] logs =template.getForObject("http://localhost:2020/donor-service/log/", Logging[].class);
		int count=logs.length;
		mdlView.addObject("log", logs);
		mdlView.addObject("count", count);
		mdlView.setViewName("home");
		
		return mdlView;		
	}
	
	@GetMapping(path="/donorcamp/")
	public ModelAndView donorcamp() {
		DonorCamp[] active =template.getForObject("http://localhost:2020/donor-camp-service/campservice/activecamp", DonorCamp[].class);
		DonorCamp[] ended =template.getForObject("http://localhost:2020/donor-camp-service/campservice/endedcamp", DonorCamp[].class);
		int count=active.length;
		mdlView.addObject("active", active);
		mdlView.addObject("ended", ended);
		mdlView.addObject("count", count);
		mdlView.setViewName("donorCamp");
		
		return mdlView;		
	}
	
//	@PostMapping(path="/")
//	public ModelAndView onSubmit(@ModelAttribute("command") int id) {
//		
//		//Tour added=this.template.postForObject("http://localhost:8080/api/v1/tours",tour, Tour.class);
//		
//		mdlView.setViewName("success");
//		mdlView.addObject("added",id);
//		mdlView.addObject("a",12);
//		
//		return mdlView;
//		
//	}
	
}
