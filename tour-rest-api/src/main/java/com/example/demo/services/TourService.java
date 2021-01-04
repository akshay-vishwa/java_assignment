package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Tour;
import com.example.demo.repos.TourRepository;

@Service
public class TourService {

	@Autowired
	private TourRepository repo;
	
	public List<Tour> findAll(){
		
		return this.repo.findAll();
		
	}
	
    public Tour addTour(Tour entity){
		
		return this.repo.save(entity);
		
	}
    
    public Optional<Tour> findById(int i) {
    	Optional<Tour> tour=this.repo.findById(i);
		if(tour.isPresent()) {
			return this.repo.findById(i);
		}
		else
			return null;
    }
    
    public Tour updateTour(Tour tour) {
    	
    	return this.addTour(tour);    	
    }
    
    public int delete( int id) {

    	Tour entity=this.repo.getOne(id);
    	int i=0;
    	if(this.repo.findById(id).isPresent()) {
    		this.repo.delete(entity);
    		i=1;
    	}
    	return i;
    }
     
    public Optional<Tour> findByName(String name) {
    	List<Tour> list=findAll();
    	int id=01;
    	for(Tour tour :list) {
    		System.out.println(tour.getTourName());
    		if(tour.getTourName()==name) {
    			id=tour.getTourId();
    		}
    	}
    	return findById(id);
    }
    
    //coustom query method-1 using findByxxx
    public List<Tour> greaterThanDuration(double duration){
    	return this.repo.findByDurationGreaterThan(duration);
    }
    
    //coustom query method -2 Using Sql with @query,@modifying @Transactional
    public List<Tour> updateTour(int id ,double revisedCost){
    	return this.repo.updateTours(id, revisedCost);
    }
    
    //Couston Query method-3 using @Query with JPQL
    public List<Tour> findByCost(Double cost){
    	return this.repo.findToursByCost(cost);
    }
}
