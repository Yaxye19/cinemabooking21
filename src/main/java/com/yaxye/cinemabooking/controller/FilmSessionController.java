package com.yaxye.cinemabooking.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.yaxye.cinemabooking.entity.Film;
import com.yaxye.cinemabooking.entity.FilmSession;
import com.yaxye.cinemabooking.entity.Venue;

import com.yaxye.cinemabooking.service.FilmService;
import com.yaxye.cinemabooking.service.FilmSessionService;

import com.yaxye.cinemabooking.service.VenueService;


@RestController
@RequestMapping("session")
public class FilmSessionController {
	
	private final FilmSessionService filmSessionService;
	
    private final FilmService filmService; 
    private final VenueService venueService;
	 
	
	@Autowired
    public FilmSessionController(FilmSessionService filmSessionService, FilmService filmService,
                             VenueService venueService) {
         this.filmSessionService = filmSessionService;
		 this.filmService = filmService; 
		 this.venueService = venueService;
		 
       
    }
//gets film sessions
	
    @GetMapping(value = "filmsession")
    public ModelAndView allFilmSessions() {
		ModelAndView mav = new ModelAndView("FilmSession/filmsession");
        mav.addObject("filmSession", filmSessionService.getAllFilmSession());
        return mav;
    }
    
 // Show Film session with the list of venue and films, before creating one.
	
 	@GetMapping(value = "showfilmsession")
 	public ModelAndView showFilmSession() {
 		List<Film> films =filmService.getAllFilms(); 
 		List<Venue> venue = venueService.getAllVenue();
 		ModelAndView mav = new ModelAndView("FilmSession/new_filmsession");
 		FilmSession filmSession = new FilmSession();
 		mav.addObject("filmList",films); 
 		mav.addObject("venueList",venue);
 		mav.addObject("filmSession",filmSession);
 		return mav;
 	}
    
    @PostMapping(value = "saveFilmSession")
    public RedirectView addSession(@ModelAttribute("filmSession") FilmSession filmSession) {
    	filmSessionService.addFilmSession(filmSession);
    	 RedirectView redirectView = new RedirectView("showfilmsession", true);
			return redirectView;	
    }
    //Delete film session by id.
 		
		@GetMapping("filmSession/{filmSessionId}")
		public String deleteFilmSession(@PathVariable Long filmSessionId) {
			//cinemaService.deleteCinemaById(cinemaId);
			filmSessionService.deletFilmeSessionById(filmSessionId);
			return "redirect:/filmsession";
		}
		//get filmSession form for updating.
		//get film form for editing it
		
			@GetMapping("editFilmSession/{id}")
			public ModelAndView editFilmSessionForm(@PathVariable("id") Long FilmSessionId, Model model) {
				
			FilmSession filmSession = this.filmSessionService.getFilmSessionById(FilmSessionId);
				
			ModelAndView mav = new ModelAndView("FilmSession/update-filmSession");
			List<Film> films =filmService.getAllFilms(); 
	 		List<Venue> venue = venueService.getAllVenue();
			mav.addObject("filmList",films); 
	 		mav.addObject("venueList",venue);
			mav.addObject("filmSession", filmSession);
			
			return mav;
				
			}
		//creating update that updates the FilmSession detail   
			@RequestMapping(value ="updatefilmsession/{id}", method= {RequestMethod.PUT, RequestMethod.GET})
		public FilmSession update(@RequestBody FilmSession filmSession){  
			filmSessionService.Update(filmSession);  
		   return filmSession;  
		}  
		     
}
