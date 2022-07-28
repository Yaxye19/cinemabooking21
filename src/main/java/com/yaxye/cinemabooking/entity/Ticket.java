package com.yaxye.cinemabooking.entity;

import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
@Table(name="ticket")
public class Ticket {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ticketId;
	@JsonManagedReference
	@OneToOne
	@JoinColumn(name = "seat_id", referencedColumnName = "seatId")
	private Seat seat;
	@JsonManagedReference
	@ManyToOne
	@JoinColumn(name = "film_session_id")
    private FilmSession filmSession;
	@JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "user_id") 
    private User user;

	public Ticket() {
		super();
	}

	public Ticket(Long ticketId, Seat seat, User user, FilmSession filmSession) {
		super();
		this.ticketId = ticketId;
		this.seat = seat;
		this.filmSession = filmSession;
		this.user = user;
	}

	public Long getTicketId() {
		return ticketId;
	}

	public void setTicketId(Long ticketId) {
		this.ticketId = ticketId;
	}

	public Seat getSeat() {
		return seat;
	}

	public void setSeat(Seat seat) {
		this.seat = seat;
	}

	public FilmSession getFilmSession() {
		return filmSession;
	}

	public void setFilmSession(FilmSession filmSession) {
		this.filmSession = filmSession;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public int hashCode() {
		return Objects.hash(filmSession, seat, ticketId, user);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ticket other = (Ticket) obj;
		return Objects.equals(filmSession, other.filmSession) && Objects.equals(seat, other.seat)
				&& Objects.equals(ticketId, other.ticketId) && Objects.equals(user, other.user);
	}

	@Override
	public String toString() {
		return "Ticket [ticketId=" + ticketId + ", rowVenue=" + seat + ", filmSession=" + filmSession + ", user="
				+ user + "]";
	}

	public void setUser(Long user) {
		this.getUser().getUserId();
		
	}

	

	
	
	
	
	
}
