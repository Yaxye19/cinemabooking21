package com.yaxye.cinemabooking.repository;


import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yaxye.cinemabooking.entity.FilmSession;
import com.yaxye.cinemabooking.entity.Seat;
import com.yaxye.cinemabooking.entity.Ticket;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {
	
	 List<Ticket> findAll();

	  // Ticket findTicketById(Long id);

	    Collection<Ticket> findTicketsByUser(com.yaxye.cinemabooking.entity.User user);

	   // Collection<Ticket> findTicketsBySession(FilmSession filmSession);

	    Collection<Ticket> findTicketsBySeat(Seat seat);
}
