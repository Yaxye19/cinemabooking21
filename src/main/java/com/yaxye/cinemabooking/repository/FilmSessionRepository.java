package com.yaxye.cinemabooking.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yaxye.cinemabooking.entity.FilmSession;
import com.yaxye.cinemabooking.entity.Venue;

import java.sql.Date;


@Repository
public interface FilmSessionRepository extends JpaRepository<FilmSession, Long>{
		
	Optional<FilmSession> findById(Long id);

	Optional<FilmSession> findByStartDate(Date startDate);

	Optional<FilmSession> findByStartTime(String startTime);

	Optional<FilmSession> findByVenue(Venue venue);

	//Optional<FilmSession> getFilmSessionById(Long filmSessionId);

	

	
}
