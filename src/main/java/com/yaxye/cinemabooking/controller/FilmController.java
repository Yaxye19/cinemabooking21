package com.yaxye.cinemabooking.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import com.yaxye.cinemabooking.entity.Film;
import org.springframework.validation.BindingResult;
import com.yaxye.cinemabooking.service.FilmService;


@Controller
@RequestMapping("film")
public class FilmController {

    private final FilmService filmService;

    @Autowired
    public FilmController(FilmService filmService) {
        this.filmService = filmService;
    }
    
	//gets films
	
    @RequestMapping(value = "films", method = RequestMethod.GET)
    public ModelAndView allFilms() {
		ModelAndView mav = new ModelAndView("Film/Film");
        mav.addObject("film", filmService.getAllFilms());
        return mav;
    }
    
 // Show film form before creating one.
	
	@RequestMapping(value = "showfilms", method = RequestMethod.GET)
	public ModelAndView showFilms() {
		ModelAndView mav = new ModelAndView("Film/new_film");
		Film film = new Film();
		mav.addObject("film",film);
		
		return mav;
	
	}
	
	//add film
	@RequestMapping(value = "addfilm", method = RequestMethod.POST)
	public String saveFilm(@Valid @ModelAttribute("film") Film film , BindingResult bindingResult, Model model){
		
		  boolean thereAreErrors = bindingResult.hasErrors(); 
		  if (thereAreErrors) { 
			  model.addAttribute("film",film);
		  return "Film/new_film"; 
		  } else
		 
        	filmService.addFilm(film);
		
			 return "redirect:films";	
		
	}
    
	@RequestMapping(value = "film", method = RequestMethod.GET, params = {"filmId"})

    public String getEditEdit(@RequestBody Long filmId, Model model) {
        model.addAttribute("film", filmService.getFilmById(filmId));
        return "films";
    }
	
	//get film form for editing it
	
		@GetMapping("editFilm/{id}")
		public ModelAndView editFilmForm(@PathVariable("id") Long filmId, Model model) {
			Film film = this.filmService.findtFilmById(filmId);
		ModelAndView mav = new ModelAndView("Film/update-film");
		model.addAttribute("film", film);
		
		return mav;
			
		}
		//update film.
		
		@RequestMapping(value = "updatefilm/{id}",  method = {RequestMethod.GET, RequestMethod.PUT})
		public RedirectView updateFilm(Film film) {
			
			filmService.updateFilm(film);
			RedirectView redirectView = new RedirectView("films", true);
			return redirectView;	
			
		}
	        // handler method to handle delete film request
	
			@GetMapping("films/{filmId}")
			public String deleteOrg(@PathVariable Long filmId) {
				filmService.deleteFilmById(filmId);
				
				return "redirect:/films";
			}
		


}