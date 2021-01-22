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
	
	String userId="null";
	
	
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
	
	@GetMapping(path="/searchDonor/")
	public ModelAndView searchDonor() {
		mdlView.setViewName("searchDonor");
		
		return mdlView;		
	}
	
	@GetMapping(path="/login/{userid}")
	public ModelAndView login(@PathVariable String userid) {


		if(userid.equals("null") && userId.equals("null")) {
			mdlView.setViewName("login");
	
		}else if(!userid.equals("null") && userId.equals("null")) {
			userId=userid;
			Donor[] list =template.getForObject("http://localhost:2020/donor-service/donorservice/", Donor[].class);
			DonorCamp[] active =template.getForObject("http://localhost:2020/donor-camp-service/campservice/activecamp", DonorCamp[].class);
			for(Donor donorEntry:list) {
				if(donorEntry.getUserId().equals(userId)) {
					donor=donorEntry;
				}
			}
			mdlView.addObject("avtive", active);
			mdlView.addObject("donor", donor);
			mdlView.setViewName("myaccount");
		}else {
			Donor[] list =template.getForObject("http://localhost:2020/donor-service/donorservice/", Donor[].class);
			DonorCamp[] active =template.getForObject("http://localhost:2020/donor-camp-service/campservice/activecamp", DonorCamp[].class);
			for(Donor donorEntry:list) {
				if(donorEntry.getUserId().equals(userId)) {
					donor=donorEntry;
				}
			}
			mdlView.addObject("active", active);
			mdlView.addObject("donor", donor);
			mdlView.setViewName("myaccount");
		}
		return mdlView;		
	}
	
	@GetMapping(path="/registerDonor/")
	public ModelAndView registerDonor() {
		
		mdlView.setViewName("register");
		return mdlView;		
	}
	
	
}
