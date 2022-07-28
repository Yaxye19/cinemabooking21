/*
 * package com.yaxye.cinemabooking.service;
 * 
 * import java.util.List; import java.util.Optional;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.stereotype.Service;
 * 
 * import com.yaxye.cinemabooking.entity.Film; import
 * com.yaxye.cinemabooking.entity.Movie; import
 * com.yaxye.cinemabooking.repository.MovieRepository;
 * 
 * @Service public class MovieService {
 * 
 * private final MovieRepository movieRepo;
 * 
 * @Autowired public MovieService(MovieRepository movieRepo) {
 * 
 * this.movieRepo = movieRepo; }
 * 
 * public List<Movie> getAllMovies() { return movieRepo.findAll(); }
 * 
 * public Optional<Film> getFilmById(Long id) { Optional <Film> filmId =
 * filmRepository.findById(id);
 * 
 * if(filmId == null) { throw new IllegalStateException( filmId +
 * "  Does not exist."); }else return filmRepository.findById(id); }
 * 
 * //create a film title public Film addFilm(Film film) { //check if the file
 * data exist. Optional<Film> filmTitle =
 * filmRepository.findFilmByTitle(film.getTitle()); if(film.getTitle().isBlank()
 * || film.getDescription().isBlank()) { throw new
 * IllegalStateException("Fields must not be empty."); }else
 * if(filmTitle.isPresent()) { throw new IllegalStateException(film.getTitle() +
 * "  The film title is already exist please use another title."); } return
 * filmRepository.save(film); }
 * 
 * //Update film details. public void updateFilm(Film film) {
 * if(film.getFilmId() != null) { film.setTitle(film.getTitle());
 * film.setDescription(film.getDescription());
 * film.setDuration(film.getDuration());
 * film.setReleaseDate(film.getReleaseDate());
 * 
 * filmRepository.save(film); }else { throw new
 * IllegalStateException("The Id does not exist." + film.getFilmId()); }
 * 
 * } public void deleteFilmById(Long id) { if (getFilmById(id) != null) {
 * filmRepository.deleteById(id); } }
 * 
 * public Film findtFilmById(Long filmId) {
 * 
 * return filmRepository.getById(filmId); }
 * 
 * 
 * }
 */