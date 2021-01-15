package com.example.demo.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.LastDonated;

@Repository
public interface LastDonatedRepository extends JpaRepository<LastDonated, Integer>{

}
