package com.yaxye.cinemabooking.entity;



import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.Objects;
import java.util.Set;

@Entity
@Table(name="venue")

public class Venue{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long venuId;
	@Column(name="venueLocation", unique=true,
			nullable = false,
			columnDefinition= "TEXT")
	@NotEmpty(message = "Venue Name cannot be empty")
	private String venueLocation;
	
	@ManyToOne(optional = false, fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
	@JoinColumn(name = "cinema_id")
	private Cinema cinema;
	@JsonManagedReference
	@OneToMany(mappedBy = "venue")
	private Set<Row> rows;
	@JsonManagedReference
	@OneToMany(mappedBy = "venue")
	private Set<FilmSession> filmSessions;  
	
	public Venue() {
		super();
	}
	
	public Venue(Long venuId, String venueLocation, Cinema cinema,
			Set<FilmSession> filmSessions,  Set<Row> rows) {
		super();
		this.venuId = venuId;
		this.venueLocation = venueLocation;
		this.cinema = cinema;
		this.rows = rows;
		this.filmSessions = filmSessions;
		
	}



	public Long getVenuId() {
		return venuId;
	}



	public void setVenuId(Long venuId) {
		this.venuId = venuId;
	}


	public String getVenueLocation() {
		return venueLocation;
	}



	public void setVenueLocation(String venueLocation) {
		this.venueLocation = venueLocation;
	}



	public Cinema getCinema() {
		return cinema;
	}



	public void setCinema(Cinema cinema) {
		this.cinema = cinema;
	}	
	

	public Set<Row> getRows() {
		return rows;
	}



	public void setRows(Set<Row> rows) {
		this.rows = rows;
	}


	
	public Set<FilmSession> getFilmSessions() {
		return filmSessions;
	}



	public void setFilmSessions(Set<FilmSession> filmSessions) {
		this.filmSessions = filmSessions;
	}


	@Override
	public int hashCode() {
		return Objects.hash(cinema, filmSessions, rows, venuId, venueLocation);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Venue other = (Venue) obj;
		return Objects.equals(cinema, other.cinema) && Objects.equals(filmSessions, other.filmSessions)
				&& Objects.equals(rows, other.rows) && Objects.equals(venuId, other.venuId)
				&& Objects.equals(venueLocation, other.venueLocation);
	}



	@Override
	public String toString() {
		return "Venue [venuId=" + venuId + ", venueLocation=" + venueLocation + ", cinema=" + cinema + ", rows=" + rows
				+ ", filmSessions=" + filmSessions + "]";
	}

	

	

	
	

	
	



	
	
}
