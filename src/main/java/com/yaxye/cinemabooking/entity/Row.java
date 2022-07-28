package com.yaxye.cinemabooking.entity;



import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="venueRows")
public class Row{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long rowId;
	@Enumerated(EnumType.STRING)
	private RowIndex rowIndex;
	
	@JsonManagedReference
	//@JsonIgnore
	@OneToMany(mappedBy = "row")
	private Set<Seat> seats;
	@JsonManagedReference
	@ManyToOne
	@JoinColumn(name = "venue_id")
	private Venue venue;

	public Row() {
		super();
	}

	public Row(Long rowId, RowIndex rowIndex, Set<Seat> seats, Venue venue) {
		super();
		this.rowId = rowId;
		this.rowIndex = rowIndex;
		this.seats = seats;
		this.venue = venue;
	}
	
	public Long getRowId() {
		return rowId;
	}

	public void setRowId(Long rowId) {
		this.rowId = rowId;
	}

	public RowIndex getRowIndex() {
		return rowIndex;
	}

	public void setRowIndex(RowIndex rowIndex) {
		this.rowIndex = rowIndex;
	}
	
	
	public Set<Seat> getSeats() {
		return seats;
	}

	public void setSeats(Set<Seat> seats) {
		this.seats = seats;
	}

	public Venue getVenue() {
		return venue;
	}

	public void setVenue(Venue venue) {
		this.venue = venue;
	}

	
}
