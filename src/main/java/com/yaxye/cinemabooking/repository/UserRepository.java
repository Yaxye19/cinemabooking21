package com.yaxye.cinemabooking.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yaxye.cinemabooking.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	List<User> findAll();

    User findByUsername(String username);

    User findByEmail(String email);

    User findByPhone(String telephone);  

    Optional<User> findById(Long id);

    void deleteById(Long id);
    

    //void update(User user);

    //void add(User user);;
    
    
}
