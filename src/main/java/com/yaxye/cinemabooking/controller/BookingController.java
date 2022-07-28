package com.yaxye.cinemabooking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.yaxye.cinemabooking.entity.Booking;
import com.yaxye.cinemabooking.entity.FilmSession;
import com.yaxye.cinemabooking.entity.Seat;
import com.yaxye.cinemabooking.entity.Ticket;
import com.yaxye.cinemabooking.entity.User;
import com.yaxye.cinemabooking.repository.TicketRepository;
import com.yaxye.cinemabooking.repository.UserRepository;
import com.yaxye.cinemabooking.service.BookingService;
import com.yaxye.cinemabooking.service.FilmSessionService;
import com.yaxye.cinemabooking.service.SeatService;
import com.yaxye.cinemabooking.service.TicketService;

@Controller
@RequestMapping("booking")
public class BookingController {
	private final TicketService ticketService;
	   // private  UserService userService;
	    private FilmSessionService filmSessionService;
	    private SeatService seatService;
	    private UserRepository userRepo;
	    private TicketRepository ticketRepository;
	   
	    @Autowired
	    public BookingController(TicketService ticketService, 
	    		SeatService seatService, FilmSessionService filmSessionService, UserRepository userRepo) {
			super();
			this.ticketService = ticketService;
			//this.userService = userService;
			this.filmSessionService = filmSessionService;
			this.seatService = seatService;
			this.userRepo = userRepo;
		}
	    
	
	// Show ticket form before creating on
		
	    @GetMapping(value = "book") 
	    public ModelAndView showFilms(
	    		//@AuthenticationPrincipal UserDetails currentUser 
	    		) { 
	    	ModelAndView mav = new
	    	ModelAndView("Booking/bookbatman"); 
	    	List <Seat> seats = seatService.getAllSeats();
	    	List<FilmSession> filmSession = filmSessionService.getAllFilmSession();
	    	Ticket ticket = new Ticket(); 
	    	mav.addObject("seatList",seats); 
	    	mav.addObject("filmSessionList",filmSession);
	    	mav.addObject("ticket",ticket);
	    	
		  return mav;
		  
		  }
	   
	   @RequestMapping(value = "addticket", method = RequestMethod.POST)
	    public RedirectView  addTicket(@ModelAttribute Ticket ticket) {
	    	//get the currently logged in user and add to the ticket when saving it.
		   String username =  SecurityContextHolder.getContext().getAuthentication().getName();
		    User user = this.userRepo.findByUsername(username);
	        ticket.setUser(user);
	        ticket.setFilmSession(ticket.getFilmSession());
	        ticket.setSeat(ticket.getSeat());
	         
	        ticketService.saveTicket(ticket);
	        RedirectView redirectView = new RedirectView("/", true);
			return redirectView;		
			
	    }
		
}
