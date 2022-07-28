package com.yaxye.cinemabooking.controller;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;


import com.yaxye.cinemabooking.entity.Row;
import com.yaxye.cinemabooking.entity.Seat;
import com.yaxye.cinemabooking.entity.Venue;

import com.yaxye.cinemabooking.service.RowService;
import com.yaxye.cinemabooking.service.SeatService;
import com.yaxye.cinemabooking.service.VenueService;

@RestController
@RequestMapping("row")
public class RowController {
	
	private final RowService rowService;
	private final SeatService seatService;
	private final VenueService venueService;
	
	
	@Autowired
    public RowController(RowService rowService, VenueService venueService, SeatService seatService) {
        this.rowService = rowService;
		this.seatService = seatService;
        this.venueService = venueService;
    }
	//get rows associated with the rows    
    @RequestMapping(value = "venueRows", method = RequestMethod.GET)
    public ModelAndView allVenuesRows() {
    	
		ModelAndView mav = new ModelAndView("Seats/venue_rows");
		
        mav.addObject("venueRows", rowService.getAllVenueRows());
        return mav;
    }
 // Show rows form before creating one.
	
  	@RequestMapping(value = "showrows", method = RequestMethod.GET)
  	public ModelAndView showRows() {
  		List <Seat> seat = seatService.getAllSeats();
		List<Venue> venue = venueService.getAllVenue();
  		ModelAndView mav = new ModelAndView("Seats/new_rows");
  		Row venuerows = new Row();
  		mav.addObject("seatList",seat); 
  		mav.addObject("venueList",venue);
  		mav.addObject("venuerow",venuerows);
  		
  		return mav;
  	}
  	
  //add Seats
		@RequestMapping(value = "addrows", method = RequestMethod.POST)
		public RedirectView saveRows(@ModelAttribute("venuerow") Row venueRows) {
			rowService.addrows(venueRows);
			//seatService.addSeat(seat);
			RedirectView redirectView = new RedirectView("venueRows", true);
			return redirectView;		
			
		}
		// handler method to handle delete seat request
 		
			@GetMapping("venuerows/{rowId}")
			public String deleteVenuRows(@PathVariable Long rowId) {
				//seatService.deleteSeatById(seatId);
				rowService.deleteVeneuRowById(rowId);
				
				return "redirect:/venueRows";
			}
			//update

}
