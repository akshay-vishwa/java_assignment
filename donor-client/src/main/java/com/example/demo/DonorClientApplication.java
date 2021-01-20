package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entity.Donor;
import com.example.demo.entity.DonorCamp;
import com.example.demo.entity.DonorRegistry;
import com.example.demo.entity.LastDonated;
import com.example.demo.entity.Logging;

@SpringBootApplication
public class DonorClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(DonorClientApplication.class, args);
	}

	@Bean
	public RestTemplate template() {
		
		return new RestTemplate();
		
	}
	
	@Bean
	public ModelAndView modelAndView() {
		
		return new ModelAndView();
		
	}
	
	@Bean
	public Donor donor() {
		return new Donor();
	}
	
	@Bean
	public DonorCamp donorCamp() {
		return new DonorCamp();
	}
	
	@Bean
	public DonorRegistry donorRegistry() {
		return new DonorRegistry();
	}
	
	@Bean
	public LastDonated lastDonated() {
		return new LastDonated();
	}
	
	@Bean
	public Logging logging() {
		return new Logging();
	}
}
