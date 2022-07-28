package com.yaxye.cinemabooking.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.yaxye.cinemabooking.entity.Ticket;
import com.yaxye.cinemabooking.repository.FilmSessionRepository;
import com.yaxye.cinemabooking.repository.TicketRepository;
import com.yaxye.cinemabooking.repository.UserRepository;

@Service
public class TicketService {
	
    private final TicketRepository ticketRepository;
    private FilmSessionRepository sessionRepo;
    private UserRepository userRepo;
		
    @Autowired	
	 public TicketService(TicketRepository ticketRepository, FilmSessionRepository sessionRepo,
			 UserRepository userRepo) {
		super();
		this.ticketRepository = ticketRepository;
		this.sessionRepo = sessionRepo;
		this.userRepo = userRepo;
	}

		public Optional<Ticket> findTicketById(Long id) {
	        return ticketRepository.findById(id);
	    }

	    public Ticket update(Ticket ticket) {
	    	//validation and check
	        return ticketRepository.save(ticket);
	    }
	    
	    public List<Ticket> getAllTicket() {
	        return ticketRepository.findAll();
	    }
	    
	    public Ticket saveTicket(Ticket ticket) {
	    	
	        return ticketRepository.save(ticket);
			
		}
	    
	    public void deleteTicketById(Long ticketId) {
			ticketRepository.deleteById(ticketId);
			
		}

}