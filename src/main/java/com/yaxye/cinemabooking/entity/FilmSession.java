package com.yaxye.cinemabooking.entity;


import java.sql.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

//filmsession entity 

@Entity
@Table(name="filmSession")

public class FilmSession{
	
	   @Id
	   @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long filmSessionId;
	  	
	    @ManyToOne
	    @JoinColumn(name = "film_id")
	    private Film film;
	    private Date startDate;
	    private double price;
	    private String startTime;
	    @JsonManagedReference
	    @ManyToOne
	    @JoinColumn(name = "venue_id")
	    private Venue venue;
	    @JsonManagedReference
	    @OneToMany( mappedBy = "filmSession", cascade =  CascadeType.ALL , orphanRemoval=true)
	    private Set<Ticket> tickets = new HashSet<>();

		public FilmSession() {
			super();
		}

		public FilmSession(Long filmSessionId,  Film film, Date startDate, double price,
			 String startTime, Venue venue, Set<Ticket> tickets) {
			super();
			this.filmSessionId = filmSessionId;
			this.film = film;
			this.startDate = startDate;
			this.price = price;
			this.startTime = startTime;
			this.venue = venue;
			this.tickets = tickets;
			
		}

		public Long getFilmSessionId() {
			return filmSessionId;
		}

		public void setFilmSessionId(Long filmSessionId) {
			this.filmSessionId = filmSessionId;
		}

		public Film getFilm() {
			return film;
		}

		public void setFilm(Film film) {
			this.film = film;
		}

		public Date getStartDate() {
			return startDate;
		}

		public void setStartDate(Date startDate) {
			this.startDate = startDate;
		}

		public double getPrice() {
			return price;
		}

		public void setPrice(double price) {
			this.price = price;
		}

		public String getStartTime() {
			return startTime;
		}

		public void setStartTime(String startTime) {
			this.startTime = startTime;
		}

		public Venue getVenue() {
			return venue;
		}

		public void setVenue(Venue venue) {
			this.venue = venue;
		}

		public Set<Ticket> getTickets() {
			return tickets;
		}

		public void setTickets(Set<Ticket> tickets) {
			this.tickets = tickets;
		}

		@Override
		public int hashCode() {
			return Objects.hash(film, filmSessionId, price, startDate, startTime, tickets, venue);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			FilmSession other = (FilmSession) obj;
			return Objects.equals(film, other.film) && Objects.equals(filmSessionId, other.filmSessionId)
					&& Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price)
					&& Objects.equals(startDate, other.startDate) && Objects.equals(startTime, other.startTime)
					&& Objects.equals(tickets, other.tickets)
					&& Objects.equals(venue, other.venue);
		}

		@Override
		public String toString() {
			return "FilmSession [filmSessionId=" + filmSessionId + ", film=" + film + ", startDate="
					+ startDate + ", price=" + price + ", startTime=" + startTime + ", venue=" + venue + ", tickets="
					+ tickets + "]";
		}
		
}
