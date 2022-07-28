package com.yaxye.cinemabooking.service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.yaxye.cinemabooking.entity.Film;
import com.yaxye.cinemabooking.entity.Venue;
import com.yaxye.cinemabooking.repository.VenueRepository;

@Service
public class VenueService {
	
	private VenueRepository venueRepository;
	
	
	 @Autowired
	    public VenueService(VenueRepository venueRepository) {
	        this.venueRepository = venueRepository;
	    }
	 
	  public Optional<Venue> findById(Long id) {
	        return venueRepository.findById(id);
	    } 
	  
	  public void deleteById(Long id) {
	        venueRepository.deleteById(id);

	    }
	  
	  public List<Venue> getAllVenue() {
	        return venueRepository.findAll();
	    }

	  //create a venue
	    public Venue addVenue(Venue venue) {
	    	//check if the file data exist.
	    	Optional<Venue> vLocation = venueRepository.findByVenueLocation(venue.getVenueLocation());
	    		
	    	 if(vLocation.isPresent()) {
	    		throw new IllegalStateException(venue.getVenueLocation() +
	    				 "  The Location for this Venue is already exist please use another One."); 
	    	}else 
	        return venueRepository.save(venue);
	        		
	    }
	  //Delete Venue by id.
		public void deleteVenue(Long venueId ) {
			venueRepository.deleteById(venueId);
		}

}
