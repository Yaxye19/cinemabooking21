package com.yaxye.cinemabooking.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import java.util.Objects;
import java.util.Set;

//cinema entity 

@Entity

@Table(name="cinema")
public class Cinema {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cinemaId;
	@Column(name = "cinemaName", unique=true,
			nullable = false,
			columnDefinition= "TEXT")
	@NotEmpty(message = "Cinema Name cannot be empty")
	private String cinemaName;
	@Column(name = "address", nullable = false,
			columnDefinition= "TEXT")
	@NotEmpty(message = "Cinema address cannot be empty")
	private String address;
	@Column(name = "phone", nullable = false,
			columnDefinition= "TEXT")
	@NotEmpty(message = "Cinema Phone cannot be empty")
	private String phone;
	@Column(name = "email", nullable = false,
			columnDefinition= "TEXT")
	@Email(message = "Email is not valid", regexp = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])")
	@NotEmpty(message = "Email cannot be empty")
	private String email;
	
	@OneToMany(mappedBy = "cinema")
	private Set<Venue> venues;
	
	public Cinema() {
		super();
	}
	
	
	public Cinema(Long cinemaId, String cinemaName, String address, String phone, String email, Set<Venue> venues) {
		super();
		this.cinemaId = cinemaId;
		this.cinemaName = cinemaName;
		this.address = address;
		this.phone = phone;
		this.email = email;
		this.venues = venues;
	}





	public Long getCinemaId() {
		return cinemaId;
	}





	public void setCinemaId(Long cinemaId) {
		this.cinemaId = cinemaId;
	}





	public String getCinemaName() {
		return cinemaName;
	}



	public void setCinemaName(String cinemaName) {
		this.cinemaName = cinemaName;
	}



	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	public String getPhone() {
		return phone;
	}



	public void setPhone(String phone) {
		this.phone = phone;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}





	public Set<Venue> getVenues() {
		return venues;
	}





	public void setVenues(Set<Venue> venues) {
		this.venues = venues;
	}





	@Override
	public int hashCode() {
		return Objects.hash(address, cinemaId, cinemaName, email, phone, venues);
	}





	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cinema other = (Cinema) obj;
		return Objects.equals(address, other.address) && Objects.equals(cinemaId, other.cinemaId)
				&& Objects.equals(cinemaName, other.cinemaName) && Objects.equals(email, other.email)
				&& Objects.equals(phone, other.phone) && Objects.equals(venues, other.venues);
	}





	@Override
	public String toString() {
		return "Cinema [cinemaId=" + cinemaId + ", cinemaName=" + cinemaName + ", address=" + address + ", phone=" + phone
				+ ", email=" + email + ", venues=" + venues + "]";
	}



	

	



	
}
