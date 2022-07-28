package com.yaxye.cinemabooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.yaxye.cinemabooking.entity.Film;

@Repository
public interface FilmRepository extends JpaRepository<Film, Long> {
	
	Page<Film> findByTitleContaining(String title, Pageable pageable);
	Optional<Film> findFilmByTitle(String title);
	
	
}
