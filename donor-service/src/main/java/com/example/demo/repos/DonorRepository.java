package com.example.demo.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Donor;


@Repository
public interface DonorRepository extends JpaRepository<Donor, Integer>{

	//expose query method
	List<Donor> findByBloodGroup(String bloodGroup);

	//coustom query method
	@Query(value="select * from donor_service where readyToDonate=true",nativeQuery=true)
	List<Donor> findReadyToDonate();
	
	//coustom query method
	@Query(value="select d.* from donor_service as d left join last_donated as l on d.id=l.id where (datediff(CURDATE(),l.lastDonated)>180 or l.lastDonated is null)and readyToDonate=1;",nativeQuery=true)
	List<Donor> findEligible();
	
	
}
