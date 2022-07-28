package com.yaxye.cinemabooking.service;

import java.util.ArrayList;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yaxye.cinemabooking.entity.Seat;
import com.yaxye.cinemabooking.repository.SeatRepository;

@Service
public class SeatService{
	
	private SeatRepository seatRepo;
	//private List<Seat> seats = Arrays.asList();	
	@Autowired
	public SeatService(SeatRepository seatRepo) {
		super();
		this.seatRepo = seatRepo;
	
	}
	

	//get all seats
    public List<Seat> getAllSeats() {
    	
        List<Seat> seats = new ArrayList<>();
    	
        seatRepo.findAll()
        .forEach(seats::add);
    	
        return seats;		
    }
    // find a single seat by id
    public Optional<Seat> findSeatById(Long id) {
    	Optional<Seat> SeatByid = seatRepo.findById(id);
    	if(SeatByid.equals(null)) {
    		throw new IllegalStateException("Seat does not exist" + SeatByid.get());
    	}else
		return SeatByid;
    	
    }
   
  //Create new Seat
  	public Seat addSeat(Seat seat) {
  		Optional <Seat> seatNumber = seatRepo.findBySeatNumber(seat.getSeatNumber());
  	
  		if(seatNumber.isPresent()) {
  			throw new IllegalStateException(
  					
  				"  Seat Number: " + seat.getSeatNumber() +	 " already exist, please choose another one."); 
  		}else
		return seatRepo.save(seat);
		  
  	}

    public void deleteSeatById(Long id) {
    	if (id != null) {
            seatRepo.deleteById(id);
        }
    }
	
	
	
	
}
