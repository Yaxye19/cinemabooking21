package com.yaxye.cinemabooking.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.yaxye.cinemabooking.entity.Cinema;
import com.yaxye.cinemabooking.entity.Film;
import com.yaxye.cinemabooking.service.CinemaService;

@Controller
@RequestMapping("cinema")
public class CinemaController {
	
	 @Autowired
	private final CinemaService cinemaService;
	
	
	
   public CinemaController(CinemaService cinemaService) {
       this.cinemaService = cinemaService;
   }
	
	
	// get cinema
    @RequestMapping(value = "cinemas", method = RequestMethod.GET)
    public ModelAndView allCinemas() {
		ModelAndView mav = new ModelAndView("Cinema/cinema");
        mav.addObject("cinema", cinemaService.getAllCinema());
        return mav;
    }
    
 // Show cinema form before creating one.
	
 	@RequestMapping(value = "showcinemas", method = RequestMethod.GET)
 	public ModelAndView showCinemas() {
 		ModelAndView mav = new ModelAndView("Cinema/new_cinema");
 		Cinema cinema = new Cinema();
 		mav.addObject("cinema",cinema);
 		
 		return mav;
 	
 	}
 	
 	//add cinema
 		@RequestMapping(value = "addcinema", method = RequestMethod.POST)
 		public String saveCinema(@Valid @ModelAttribute("cinema") Cinema cinema,BindingResult bindingResult, Model model) {
 			//cinemaService.saveCinema(cinema);
 			 boolean thereAreErrors = bindingResult.hasErrors(); 
			  if (thereAreErrors) { 
				  model.addAttribute("cinema",cinema);
			  return "Cinema/new_cinema"; 
			  } else
			 
				  cinemaService.addCinema(cinema);
			
				 return "redirect:cinemas";	
 		}
 	
 		//get update form
 		@GetMapping("editCinema/{id}")
 		public ModelAndView editCinForm(@PathVariable("id") Long cinemaId, Model model) {
			Cinema cinema = this.cinemaService.getCinemaById(cinemaId);
			ModelAndView mav = new ModelAndView("Cinema/update-cinema");
			model.addAttribute("cinema", cinema);
			
			return mav;
 			
 		}
 	// update cinema.
 	
 		@RequestMapping(value ="updatecinema/{id}", method= {RequestMethod.PUT, RequestMethod.GET})
 		//@PutMapping(value ="updatecinema/{id}")
 		public String updateCinema(Cinema cinema) {
 			cinemaService.updateCinema(cinema);	
 			
 			return "redirect:/cinema/cinemas";
 			
 		}
 	// handler method to handle delete cinema request
 		
 				@GetMapping("cinemas/{cinemaId}")
 				public String deleteCinema(@PathVariable Long cinemaId) {
 					cinemaService.deleteCinemaById(cinemaId);
 					
 					return "redirect:/cinema";
 				}
 	
 	
 	
}
