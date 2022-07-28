package com.yaxye.cinemabooking.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yaxye.cinemabooking.entity.Cinema;

@Repository
public interface CinemaRepository extends JpaRepository<Cinema, Long> {
	
	
	Optional<Cinema> findById(Long id);
	
	Optional<Cinema> findByCinemaName(String cinemaName);
	

	
}
