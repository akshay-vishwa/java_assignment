package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.DonorCamp;

@Repository
public interface CampRepository extends JpaRepository<DonorCamp, Integer>{

	//expose query method
	List<DonorCamp> findByCity(String city);
	
	//expose query method
	List<DonorCamp> findByName(String name);
	
	@Query(value="select * from donor_camp where datediff(CURDATE(),endDate)<1;",nativeQuery=true)
	List<DonorCamp> findActiveCamps();
	
	@Query(value="select * from donor_camp where datediff(CURDATE(),endDate)>1;",nativeQuery=true)
	List<DonorCamp> findEndedCamps();
	
	@Query(value="select distinct(city) from donor_camp;",nativeQuery=true)
	List<String> findCitys();
	
	
}
