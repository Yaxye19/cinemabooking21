package com.yaxye.cinemabooking.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.sql.Date;

import java.util.Objects;



@Entity
@Table(name="film")
public class Film{
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long filmId;
	@Column(name = "title", unique=true,
			nullable = false,
			columnDefinition= "TEXT")
	@NotEmpty(message = "Film title cannot be empty")
	private String title;
	@Column(name = "duration", nullable = false)
	private int duration;
	@Column(name = "description",
			nullable = false,
			columnDefinition= "TEXT")
	@NotEmpty(message = "Film Description cannot be empty")
	private String description;
	@JsonFormat(pattern="dd-MM-yyyy")
	
	private Date releasDate;
	
	public Film() {
		super();
	}


	public Film(Long filmId, String title, int duration, String description, Date releasDate) {
		super();
		this.filmId = filmId;
		this.title = title;  
		this.duration = duration;
		this.description = description;
		this.releasDate = releasDate;
		
	}


	public Long getFilmId() {
		return filmId;
	}


	public void setFilmId(Long filmId) {
		this.filmId = filmId;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public int getDuration() {
		return duration;
	}


	public void setDuration(int duration) {
		this.duration = duration;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public Date getReleaseDate() {
		return releasDate;
	}


	public void setReleaseDate(Date releasDate) {
		this.releasDate = releasDate;
	}

	public Date getReleasDate() {
		return releasDate;
	}


	public void setReleasDate(Date releasDate) {
		this.releasDate = releasDate;
	}


	@Override
	public int hashCode() {
		return Objects.hash(description, duration, filmId, releasDate, title);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Film other = (Film) obj;
		return Objects.equals(description, other.description) && duration == other.duration
				&& Objects.equals(filmId, other.filmId)
				&& Objects.equals(releasDate, other.releasDate) && Objects.equals(title, other.title);
	}


	@Override
	public String toString() {
		return "Film [filmId=" + filmId + ", title=" + title + ", duration=" + duration + ", description=" + description
				+ ", releasDate=" + releasDate +  "]";
	}
	
	
	
	
	
	
}
