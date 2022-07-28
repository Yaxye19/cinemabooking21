package com.yaxye.cinemabooking.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.yaxye.cinemabooking.entity.Cinema;
import com.yaxye.cinemabooking.entity.Venue;
import com.yaxye.cinemabooking.service.CinemaService;
import com.yaxye.cinemabooking.service.VenueService;

@Controller
@RequestMapping("venue")
public class VenueController {
	
	private final CinemaService cinemaService;
	
	private final VenueService venueService;
	
	@Autowired
	public VenueController(CinemaService cinemaService, VenueService venueService) {
        this.cinemaService = cinemaService;
        this.venueService = venueService;
    }
	
	//get venue    
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public ModelAndView allVenues() {
    	
		ModelAndView mav = new ModelAndView("Venue/venue");
		
        mav.addObject("venue", venueService.getAllVenue());
        return mav;
    }
    
 // Show film form before creating one.
	
 	@RequestMapping(value = "showvenues", method = RequestMethod.GET)
 	public ModelAndView showFilms() {
 		List<Cinema> cinema = cinemaService.getAllCinema();
 		ModelAndView mav = new ModelAndView("Venue/new_venue");
 		Venue venue = new Venue();
 		mav.addObject("cinemaList",cinema); 
 		mav.addObject("venue",venue);
 		
 		return mav;
 	}
 	
 	@RequestMapping(value = "saveVenue", method = RequestMethod.POST)
	  public String  saveVenu(@Valid @ModelAttribute("venue") Venue venue , BindingResult bindingResult, Model model) {
 		boolean thereAreErrors = bindingResult.hasErrors(); 
		  if (thereAreErrors) { 
			  model.addAttribute("venue",venue);
		  return "Venue/new_venue"; 
		  } else
 		 
 		 venueService.addVenue(venue);
		
		  return "redirect:list";	
		  
	  }

 	 //Delete method for the venue
 	 @GetMapping("deleteVenue/{venueId}")
		public String deleteVenue(@PathVariable ("venueId") Long veneuId, Model model) {
			venueService.deleteVenue(veneuId);
		
			model.addAttribute("veneu", this.allVenues()); 
			return "redirect:/list";
			
		}
 	
}
