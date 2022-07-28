package com.yaxye.cinemabooking.service;
import com.yaxye.cinemabooking.entity.Film;
import com.yaxye.cinemabooking.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@Service
public class FilmService {
	  @Autowired
	    private final FilmRepository filmRepository;

	  @Autowired
	    public FilmService(FilmRepository filmRepository) {
	        this.filmRepository = filmRepository;
	    }

	    public List<Film> getAllFilms() {  
	        return filmRepository.findAll();
	    }

	    public Optional<Film> getFilmById(Long id) {  
	    	Optional <Film> filmId = filmRepository.findById(id);
	    		
	    	if(filmId == null) {
	    		throw new IllegalStateException(
	  					filmId +	 
	  				"  Does not exist."); 
	    	}else
	        return filmRepository.findById(id);
	    }

	    //create a film title
	    public Film addFilm(Film film) {
	    	//check if the file data exist.
	    	Optional<Film> filmTitle = filmRepository.findFilmByTitle(film.getTitle());
	    	
			 if(filmTitle.isPresent()) {
	    		throw new IllegalStateException(film.getTitle() +
	    				 "  The film title is already exist please use another title."); 
	    	}
	        return filmRepository.save(film);
	    }

	    //Update film details.
		public Film updateFilm(@RequestBody Film film) {
			
				film.setFilmId(film.getFilmId());
				film.setTitle(film.getTitle());
				film.setDescription(film.getDescription());
				film.setDuration(film.getDuration());
				film.setReleaseDate(film.getReleaseDate());
				
				return filmRepository.saveAndFlush(film);
			
		}
	    public void deleteFilmById(Long id) {
	        if (getFilmById(id) != null) {
	            filmRepository.deleteById(id);
	        }
	    }

		public Film findtFilmById(Long filmId) {
			
			return filmRepository.getById(filmId);
		}


	   
		
}
