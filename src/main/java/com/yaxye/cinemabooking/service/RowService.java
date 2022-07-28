package com.yaxye.cinemabooking.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yaxye.cinemabooking.entity.Cinema;
import com.yaxye.cinemabooking.entity.Row;
import com.yaxye.cinemabooking.entity.Seat;
import com.yaxye.cinemabooking.repository.RowRepository;
import com.yaxye.cinemabooking.repository.SeatRepository;

@Service
public class RowService  {
	
    private final RowRepository rowRepository;
    private final SeatRepository seatRepository;
    @Autowired
    public RowService(RowRepository rowRepository, SeatRepository seatRepository) {
        this.rowRepository = rowRepository;
		this.seatRepository = seatRepository;
    }
    //List all rows associated with the venue
    public List<Row> getAllVenueRows() {
        return rowRepository.findAll();
    }
    
    //Create new Rows
  	@SuppressWarnings("unlikely-arg-type")
	public Row addrows(Row venueRows) {
  		//check if the data exist
  	
  		//Optional <Row> rowIndex = rowRepository.getVenue(venueRows.getRowIndex());
  	  	//Optional <Row> venueLoc = rowRepository.findByLocation(venueRows.getVenue().getVenueLocation());
  		if(venueRows.equals(venueRows.getRowIndex()) && venueRows.equals(venueRows.getVenue().getVenueLocation()) ) {
  			throw new IllegalStateException(
  				"Row Index of: "  +
  				"With the " +	// venueRows.getVenue().getVenueLocation() +
  				"  does exist."); 
  		}else
		 
		return rowRepository.save(venueRows);
		  
  	}
  	 public void deleteVeneuRowById(Long id) {
  		 
            rowRepository.deleteById(id);
         
     }
}
