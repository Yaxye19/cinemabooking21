package com.yaxye.cinemabooking.repository;





import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.yaxye.cinemabooking.entity.Row;
import com.yaxye.cinemabooking.entity.Venue;



@Repository
public interface RowRepository extends JpaRepository<Row, Long> {

	//Optional<Row> getVenue(int rowIndex);

	//Optional<Row> findByLocation(Venue venue);

	//Optional<Row> findByLocation(String venueLocation);

	
	

}
