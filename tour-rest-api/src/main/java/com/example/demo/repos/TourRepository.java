package com.example.demo.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Tour;

@Repository
public interface TourRepository extends JpaRepository<Tour, Integer> {

	List<Tour> findByDurationGreaterThan(double duration);
	
	@Query(value="from Tour where cost>=:srchCondition",nativeQuery=false)
	List<Tour> findToursByCost(@Param("srchCondition") double cost);
	
	@Query(value="update lumen_tours set cost=:revised where tourId=:id",nativeQuery=true)
	@Modifying
	@Transactional
	List<Tour> updateTours(@Param("id") int tourId,@Param("revised") double cost);
	
}
