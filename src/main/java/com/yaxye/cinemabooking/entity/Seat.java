package com.yaxye.cinemabooking.entity;

import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
@Table(name="seat")
public class Seat {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long seatId;
	private int seatNumber;
	
	//A seat has one row, but a row has many seats
	@JsonManagedReference
	//@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "row_id", referencedColumnName = "rowId")
	private Row row;
	
	@Enumerated(EnumType.STRING)
	private SeatType seatType;
	
	public Seat() {
		super();
	}


	public Seat(Long seatId,int seatNumber, SeatType seatType, Row row) {
			//, Set<Ticket> ticket) {
		super();
		this.seatId = seatId;
		this.row = row;
		this.seatType = seatType;
		this.seatNumber = seatNumber;
		//this.ticket = ticket;
	}
	public Long getSeatId() {
		return seatId;
	}

	public void setSeatId(Long seatId) {
		this.seatId = seatId;
	}
	
	public int getSeatNumber() {
		return seatNumber;
	}


	public void setSeatNumber(int seatNumber) {
		this.seatNumber = seatNumber;
	}


	public Row getRow() {
		return row;
	}


	public void setRow(Row row) {
		this.row = row;
	}


	public SeatType getSeatType() {
		return seatType;
	}


	public void setSeatType(SeatType seatType) {
		this.seatType = seatType;
	}


	/*
	 * public Set<Ticket> getTicket() { return ticket; }
	 * 
	 * 
	 * public void setTicket(Set<Ticket> ticket) { this.ticket = ticket; }
	 */

	@Override
	public int hashCode() {
		return Objects.hash(row, seatId, seatNumber, seatType);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Seat other = (Seat) obj;
		return Objects.equals(row, other.row) && Objects.equals(seatId, other.seatId) && seatNumber == other.seatNumber
				&& seatType == other.seatType;
	}


	@Override
	public String toString() {
		return "Seat [seatId=" + seatId + ", seatNumber=" + seatNumber + ", row=" + row + ", seatType=" + seatType
				+ "]";
	}

	
	  

	
	
	
	
	
}
