package com.yaxye.cinemabooking.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yaxye.cinemabooking.entity.Booking;
import com.yaxye.cinemabooking.entity.FilmSession;
import com.yaxye.cinemabooking.entity.Seat;
import com.yaxye.cinemabooking.entity.User;
import com.yaxye.cinemabooking.repository.BookingRepository;

@Service
public class BookingService {
	/*
	private BookingRepository bookingRepo;
	private FilmSessionService filmSessionService;
	private SeatService seatService;
	private UserService userService;
	@Autowired
	public BookingService(BookingRepository bookingRepo, FilmSessionService filmSessionService, SeatService seatService, UserService userService) {
		super();
		this.filmSessionService = filmSessionService;
		this.seatService = seatService;
		this.userService = userService;
		this.bookingRepo = bookingRepo;
	}
	public Optional<User> getUsers(Long userId) {
		return userService.findById(userId);
	}
	public FilmSession getFilSession(Long filmSessionId) {
		return filmSessionService.getFilmSessionById(filmSessionId);
	}
	public Optional<Seat> getSeatId(Long seatId) {
		return seatService.findSeatById(seatId);
		
	}
	public void bookSession(Booking booking, FilmSessionService filmSessionService, 
			SeatService seatService, UserService userService) {
		bookingRepo.save(booking);
		
	}
	*/
	
	
}
