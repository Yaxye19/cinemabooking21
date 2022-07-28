package com.yaxye.cinemabooking.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

//booking entity 

@Entity
@Table(name="booking")
public class Booking {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long bookingId;
	
	@OneToOne
	@JoinColumn(name = "seat_id", referencedColumnName = "seatId")
	private Seat seat;
	
	@ManyToOne
	@JoinColumn(name = "film_session_id")
    private FilmSession filmSession;

    @ManyToOne
    @JoinColumn(name = "user_id") 
    private User user;

}
