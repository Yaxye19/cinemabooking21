package com.yaxye.cinemabooking.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yaxye.cinemabooking.entity.Cinema;
import com.yaxye.cinemabooking.repository.CinemaRepository;

@Service
public class CinemaService {
	
    private final CinemaRepository cinemaRepository;
    
    @Autowired
    public CinemaService(CinemaRepository cinemaRepository) {
        this.cinemaRepository = cinemaRepository;
    }
    //get list of cinema
    public List<Cinema> getAllCinema() {
        return cinemaRepository.findAll();
    }
    //finds cenima by id
    public Optional<Cinema> findById(Long id) {
        return cinemaRepository.findById(id);
    }
  //Create new Organisation
  	public Cinema addCinema(Cinema cinema) {
  		//check if the data exist
  		Optional <Cinema> cinName = cinemaRepository.findByCinemaName(cinema.getCinemaName());
		 if(cinName.isPresent()) { 
			throw new IllegalStateException(cinema.getCinemaName() +
		 "  This cinema name is already exist please use another name."); 
		  }
		else 
		 
		return cinemaRepository.save(cinema);
		  
  	}

    //Update Cenima details.
  	public void updateCinema(Cinema cinema) {
  		if(cinema.getCinemaId() != null) {
  		cinema.setCinemaId(cinema.getCinemaId());
  		cinema.setAddress(cinema.getAddress());
  		cinema.setCinemaName(cinema.getCinemaName());
  		cinema.setEmail(cinema.getEmail());
  		cinema.setPhone(cinema.getPhone());
  		
  		cinemaRepository.save(cinema);
  		}else {
  			throw new IllegalStateException("The Id does not exist." + cinema.getCinemaId());
  		}
  	}
    public void deleteCinemaById(Long id) {
        if (findById(id) != null) {
            cinemaRepository.deleteById(id);
        }
    }
	public Cinema getCinemaById(Long cinemaId) {
		
		return cinemaRepository.getById(cinemaId);
	}
}
