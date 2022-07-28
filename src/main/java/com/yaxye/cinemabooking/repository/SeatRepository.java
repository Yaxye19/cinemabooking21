package com.yaxye.cinemabooking.repository;



import java.util.Optional;



import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.yaxye.cinemabooking.entity.Seat;

@Repository
public interface SeatRepository extends JpaRepository<Seat, Long>{
	
	Optional<Seat> findBySeatNumber(int i);

	//Object findById(Seat seat);

	

	

	

	
	
}
