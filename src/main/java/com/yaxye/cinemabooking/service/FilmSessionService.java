package com.yaxye.cinemabooking.service;

import com.yaxye.cinemabooking.entity.FilmSession;

import com.yaxye.cinemabooking.repository.FilmSessionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FilmSessionService {
	
	 private final FilmSessionRepository filmSessionRepository;
	 
	 @Autowired
	    public FilmSessionService(FilmSessionRepository filmSessionRepository) {
	        this.filmSessionRepository = filmSessionRepository;
			
	    }
	    //list all film session.
	    public List<FilmSession> getAllFilmSession() {
	    	
	        return filmSessionRepository.findAll();
	    }
	    //Save film session.
	    public FilmSession addFilmSession(FilmSession filmSession) {
	    	Optional<FilmSession> sessionDate = filmSessionRepository.findByStartDate(filmSession.getStartDate());
	    	Optional<FilmSession> sessionTime = filmSessionRepository.findByStartTime(filmSession.getStartTime());
	    	Optional<FilmSession> sessionVenue = filmSessionRepository.findByVenue(filmSession.getVenue());
	    	if(sessionDate.isPresent() 
	    			&& sessionTime.isPresent() && sessionVenue.isPresent()
	    			) {
	    		throw new IllegalStateException(
	  				"The Session already exist"); 
	  		}else
	    	
	        return filmSessionRepository.save(filmSession);
	    }
	    public Optional<FilmSession> findSessionById(Long filmSessionId) {
	    	 return filmSessionRepository.findById(filmSessionId);
	    }
	    public Optional<FilmSession> findFilmSessionById(Long id) {
	    	Optional<FilmSession> sessionId = filmSessionRepository.findById(id);
	    	if(sessionId == null) {
	    		throw new IllegalStateException("The Session  " + id + " Deos not exist.");
	    	}else
	        return filmSessionRepository.findById(id);
	    }
	    
	    // delete film session if the ID exist
	    public void deletFilmeSessionById(Long id) {
	    	//Long ticket = ticketRepository.getTicketId();
	        if (findFilmSessionById(id) != null) {
	            filmSessionRepository.deleteById(id);
			} 
	    }
	    
	    //Update FilmSession.
		public void Update(FilmSession filmSession) {
			FilmSession existingFilmSession = filmSession;
			 if (existingFilmSession.getFilmSessionId() == filmSession.getFilmSessionId()) {
				 existingFilmSession.setFilm(existingFilmSession.getFilm());
				 existingFilmSession.setStartDate(existingFilmSession.getStartDate());
				 existingFilmSession.setStartTime(existingFilmSession.getStartTime());
				 existingFilmSession.setVenue(existingFilmSession.getVenue());
				 existingFilmSession.setPrice(existingFilmSession.getPrice());
			filmSessionRepository.save(filmSession);
			
			 }	

		}
		public void capacity() {
			this.capacity();
		}
		public FilmSession getFilmSessionById(Long filmSessionId) {
			
			return filmSessionRepository.getById(filmSessionId);
		}
		
}
