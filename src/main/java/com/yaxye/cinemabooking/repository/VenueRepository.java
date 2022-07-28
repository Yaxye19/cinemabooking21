package com.yaxye.cinemabooking.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yaxye.cinemabooking.entity.Venue;

@Repository
public interface VenueRepository  extends JpaRepository<Venue, Long> {
	
	//List<Venue> findAllVenue();
	
	void deleteById(Long id);
	
    Optional<Venue> findById(Long id);

	Optional<Venue> findByVenueLocation(String venueLocation);
    


	
}
